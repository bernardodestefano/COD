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
public class inserisciEsameSierologico extends HttpServlet {
   
  /**
*Servlet inserisciEsameSierologico
*Descrizione: in questa servlet avremo i dati riguardanti l'esame Sierologico
*Parametri di input:
*@param rosolia:
*<li> formato: stringa(1-45)
*<li> descrizione: indica se l'utente ha avuto la rosolia
*@param data:
*<li> formato: date
*<li> descrizione: indica la data in cui è stato effettuato l'esame sierologico
*@param toxoplasmosi:
*<li> formato: stringa(1-45)
*<li> descrizione:....
*@param citomegalovirus:
*<li> formato: stringa(1-45)
*<li> descrizione:....
*@param HbsAg:
*<li> formato: stringa(1-45)
*<li> descrizione:....
*@param HIV:
*<li> formato: stringa(1-45)
*<li> descrizione:....
*@param HCV:
*<li> formato: stringa(1-45)
*<li> descrizione:....
*@param VDRL:
*<li> formato: stringa(1-45)
*<li> descrizione:....
*Logica di  controllo:
*dopo aver inserito i dati, controllando i possibili errori avremo a disposizione un esame sierologico
che potrà essere inserito nel COD
*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet inserisciEsameSierologico</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet inserisciEsameSierologico at " + request.getContextPath () + "</h1>");
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
