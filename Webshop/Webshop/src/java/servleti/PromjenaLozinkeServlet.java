/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeli.Baza;
import modeli.Prijavljen;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "PromjenaLozinkeServlet", urlPatterns = {"/PromjenaLozinkeServlet"})
public class PromjenaLozinkeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("novalozinka.jsp");
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

        String lozinka = request.getParameter("lozinka");
        String novalozinka = request.getParameter("novalozinka");
        String novalozinka1 = request.getParameter("novalozinka1");
        Baza db = new Baza();
        try {
            db.connect();
            HttpSession session = request.getSession();
            int idkor = ((Prijavljen) session.getAttribute("prijavljen")).getId();
            ResultSet rs = db.selectupit("SELECT * FROM korisnici WHERE id='" + idkor + "'");
            rs.next();
            
            if (rs.getString("lozinka").equals(lozinka) && !rs.getString("lozinka").equals(novalozinka) && novalozinka.equals(novalozinka1)) {
                db.upit("UPDATE korisnici SET lozinka='" + novalozinka + "' WHERE id=" + idkor);
                response.sendRedirect("IndexServlet");
            } else {
                response.sendRedirect("novalozinka.jsp?g=2");
            }

        } catch (SQLException ex) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
