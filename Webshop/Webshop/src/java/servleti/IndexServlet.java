package servleti;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeli.*;

@WebServlet(name = "IndexServlet", urlPatterns = {"/IndexServlet"})
public class IndexServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idkat = request.getParameter("idkat");
        Baza db = new Baza();
        try { 
            db.connect();
            ResultSet rs = db.selectupit("SELECT * FROM kategorije");
            ArrayList<Kategorija> kategorije = new ArrayList<Kategorija>();
            while (rs.next()) {
                kategorije.add(new Kategorija(rs.getInt("id"), rs.getString("ime")));
            }
            request.setAttribute("kategorije", kategorije);

            if (idkat == null) {
                rs = db.selectupit("SELECT * FROM proizvodi");
            } else {
                rs = db.selectupit("SELECT * FROM proizvodi WHERE idkat=" + idkat);
            }
            ArrayList<Proizvod> proizvodi = new ArrayList<Proizvod>();
            while (rs.next()) {
                proizvodi.add(new Proizvod(rs.getInt("id"), rs.getString("ime"),
                        rs.getInt("idkat"), rs.getInt("kolicina"),
                        rs.getDouble("cijena"),
                        rs.getString("proizvodac"), rs.getString("model"),
                        String.format("%.2f", rs.getDouble("cijena"))));
            }

            request.setAttribute("proizvodi", proizvodi);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
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
