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
import modeli.Baza;
import modeli.SKZaIspis;
import modeli.StavkaKosarice;

@WebServlet(name = "KosaricaServlet", urlPatterns = {"/KosaricaServlet"})
public class KosaricaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<StavkaKosarice> stavke = (ArrayList<StavkaKosarice>) session.getAttribute("stavke");
        Baza db = new Baza();
        try {
            db.connect();
            ArrayList<SKZaIspis> lista = new ArrayList<SKZaIspis>();
            double ukupno = 0;
            if (stavke == null) {
                session.removeAttribute("bsuk");
                response.sendRedirect("IndexServlet");
            } else {
                for (StavkaKosarice sk : stavke) {

                    ResultSet rs = db.selectupit("SELECT * FROM proizvodi WHERE id=" + sk.getPid());
                    rs.next();
                    lista.add(new SKZaIspis(sk.getPid(), rs.getString("ime"),
                            rs.getInt("kolicina"),
                            String.format("%.2f", rs.getDouble("cijena") * sk.getKol()),
                            sk.getKol()));
                    ukupno = ukupno + rs.getDouble("cijena") * sk.getKol();
                }

                request.setAttribute("lista", lista);
                request.setAttribute("ukupno", String.format("%.2f", ukupno));
                request.getRequestDispatcher("kosarica.jsp").forward(request, response);
            }
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
