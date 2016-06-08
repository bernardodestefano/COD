/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giuseppe
 */
public class inserisciEcografia extends HttpServlet {
   
  /**
*Servlet inserisciEcografia
*Descrizione: Questa servlet serve a gestire le ecografie effettuate dal paziente
*Parametri di input:
*@param esamiPrenatali:
*<li> formato: text
*<li> descrizione:.....
*@param data:
*<li> formato: date
*<li> descrizione:consente di controllare la data di ogni ecografie effettuata
*@param datazione:
*<li> formato: date
*<li> descrizione:consente di controllare la data di ogni ecografie effettuata
*@param morfologia:
*<li> formato: stringa(1-45)
*<li> descrizione:serve per valutare l’anatomia e la crescita corretta del feto
*@param altre:
*<li> formato: stringa(1-45)
*<li> descrizione:consente di aggingere le altre ecografie che sono state effettuate
*Logica di  controllo:
*dopo aver inserito i dati controllando i possibili errori, avremo un quadro completo e costante
*delle ecografie effettuate durante la crescita del feto.
*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet inserisciEcografia</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet inserisciEcografia at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
