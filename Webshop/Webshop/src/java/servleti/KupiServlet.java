package servleti;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import modeli.Prijavljen;
import modeli.StavkaKosarice;

@WebServlet(name = "KupiServlet", urlPatterns = {"/KupiServlet"})
public class KupiServlet extends HttpServlet {

      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nacinkupnje = request.getParameter("nacinkupnje");
        HttpSession session = request.getSession();
        ArrayList<StavkaKosarice> 
                stavke = (ArrayList<StavkaKosarice>) session.getAttribute("stavke");
        Baza db = new Baza();
        try {
            db.connect();
            ResultSet rs;
            for (StavkaKosarice sk:stavke) {
                rs = db.selectupit("SELECT * FROM proizvodi WHERE id="+sk.getPid() );
                rs.next();
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                String datum = formatter.format(date);
                Prijavljen pr = (Prijavljen)session.getAttribute("prijavljen");
                db.upit("INSERT INTO povijest (idkup,idpro,cijena,kolicina,datum,nacin) "
                        + "VALUES ('"+pr.getId()+"','"+sk.getPid()+"',"
                        + "'"+rs.getDouble("cijena")+"','"+sk.getKol()+"',"
                        + "'"+datum+"','"+nacinkupnje+"')");
            }
            session.removeAttribute("stavke");
            session.removeAttribute("bsuk");
            response.sendRedirect("IndexServlet");
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
