package servleti;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeli.StavkaKosarice;

@WebServlet(name = "DodajUKosaricuServlet", urlPatterns = {"/DodajUKosaricuServlet"})
public class DodajUKosaricuServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String kol = request.getParameter("kol");
        String pid = request.getParameter("pid");
        ArrayList<StavkaKosarice> stavke = (ArrayList<StavkaKosarice>) session.getAttribute("stavke");
        if (stavke == null) {
            stavke = new ArrayList<StavkaKosarice>();
        }
        boolean nema = true;
        for (int i = 0; i < stavke.size(); i++) {
            StavkaKosarice sk = stavke.get(i);
            if (sk.getPid() == Integer.parseInt(pid)) {
                nema = false;
                break;
            }
        }
        if (nema == true) {
            stavke.add(new StavkaKosarice(Integer.parseInt(pid), Integer.parseInt(kol)));

        }  
        session.setAttribute("stavke",stavke);
        session.setAttribute("bsuk", stavke.size());
        response.sendRedirect("IndexServlet");
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
