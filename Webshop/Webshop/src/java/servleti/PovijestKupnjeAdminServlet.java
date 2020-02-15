package servleti;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeli.*;

@WebServlet(name = "PovijestKupnjeAdminServlet", urlPatterns = {"/PovijestKupnjeAdminServlet"})
public class PovijestKupnjeAdminServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Prijavljen prij = (Prijavljen)session.getAttribute("prijavljen");
        if (prij==null) { response.sendRedirect("login.jsp"); return; }
        else {
            int uloga = prij.getUloga();
            if (uloga==2) { response.sendRedirect("IndexServlet"); return; }
        }    
        String dodatak = "";
        String kupac = request.getParameter("kupac");
        String datumod = request.getParameter("datumod");
        String datumdo = request.getParameter("datumdo");
        if (kupac!=null) {
            if (!kupac.equals("0")) dodatak = " WHERE idkup="+kupac;
            
          // dodatak = dodatak + " AND datum>='"+datumod+"' AND datum<='"+datumdo+"'";
        }
        
        Baza db = new Baza();
        try {
            db.connect(); 
            ResultSet rs = db.selectupit("SELECT DISTINCT idkup FROM povijest");
            HashMap<Integer,String> popiskupaca = new HashMap<Integer,String>();
            while(rs.next()) {
                ResultSet rs2 = db.selectupit("SELECT * FROM korisnici WHERE id="+rs.getInt(1));
                rs2.next();
                popiskupaca.put(rs2.getInt("id"),rs2.getString("ime"));
            }                        
            request.setAttribute("popiskupaca", popiskupaca);
            
            rs = db.selectupit("SELECT * FROM povijest "+dodatak+" ORDER BY datum DESC");
            ArrayList<PovijestAdmin> povijest = new ArrayList<PovijestAdmin>();
            double ukupno = 0;
            while (rs.next()) {
                int proizvod = rs.getInt("idpro");
                ResultSet rs2 = db.selectupit("SELECT * FROM proizvodi WHERE id="+proizvod);
                rs2.next();
                SimpleDateFormat formatter= new SimpleDateFormat("dd.MM.yyyy.");
                Date date = rs.getDate("datum");
                String datum = formatter.format(date);
                formatter= new SimpleDateFormat(" HH:mm");
                date = rs.getTime("datum");
                datum = datum+formatter.format(date);
                ukupno = ukupno + rs.getInt("kolicina")*rs.getDouble("cijena");
                povijest.add( new PovijestAdmin(rs.getInt("idkup"),
                                           popiskupaca.get(rs.getInt("idkup")),
                                           proizvod,rs2.getString("ime"),
                                           rs.getInt("kolicina"), 
                                           String.format("%.2f",rs.getDouble("cijena")),
                                           datum,rs.getString("nacin")) );
            }
            request.setAttribute("povijest",povijest);
            request.setAttribute("ukupno",String.format("%.2f",ukupno));                     
            request.getRequestDispatcher("povijestkupnjeadmin.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
