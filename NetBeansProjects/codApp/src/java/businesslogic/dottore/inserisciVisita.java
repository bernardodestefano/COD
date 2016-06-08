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
public class inserisciVisita extends HttpServlet {
   
   /**
*Servlet inserisciVisita
*Descrizione: in questa servlet verranno inseriti le info riguardanti le visite
*Parametri di input:
*@param data:
*<li> formato: date
*<li> descrizione: indica la data della visita
*@param settimana:
*<li> formato: int
*<li> descrizione: indica la settimana della visita
*@param peso:
*<li> formato: double
*<li> descrizione: indica il peso della donna
*@param PA:
*<li> formato: stringa(1-45)
*<li> descrizione:.....
*@param BCF:
*<li> formato: stringa
*<li> descrizione:....
*@param edemi:
*<li> formato: stringa(1-45)
*<li> descrizione:....
*@param movimentiFetaliPercepitiDallaMadre:
*<li> formato: stringa(1-60)
*<li> descrizione:indica i movimenti del bambino nella pancia
*@param movimentiFetaliPercepitiAllaVisita:
*<li> formato: stringa(1-45)
*<li> descrizione:indica i movimenti del bambino nella pancia percepiti durante la visita
*Logica di  controllo:
*dopo aver inserito i dati, controllando i possibili errori avremo una tabella che permetterà di avere
*info più precise sulla storia ginecologica
*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet inserisciVisita</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet inserisciVisita at " + request.getContextPath () + "</h1>");
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
