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
public class inserisciEsameEmatichimico extends HttpServlet {
   
  /**
*Servlet inserisciEsameEmatochimico
*Descrizione: in questa servlet verranno inseriti i dati riguardanti gli esami ematochimici
*Parametri di input:
*@param data:
*<li> formato: date
*<li> descrizione: indica la data dell'esame
*@param settimana:
*<li> formato: int
*<li> descrizione:indica la settimana prevista per l'esame
*@param urocoltura:
*<li> formato: stringa(1-45)
*<li> descrizione: indica le info riguardanti l'arocultura
*@param GB:
*<li> formato: double
*<li> descrizione:....
*@param GR:
*<li> formato: double
*<li> descrizione:....
*@param emoglobina:
*<li> formato: double
*<li> descrizione: indica i valori dell'emoglobina
*@param ematocrito:
*<li> formato: double
*<li> descrizione: indica i valori dell'ematocrito
*@param contenutoEmoglobinaMedio:
*<li> formato: double
*<li> descrizione:....
*@param piastrine:
*<li> formato: double
*<li> descrizione:indica i valori delle piastrine
*@param glicemia:
*<li> formato: double
*<li> descrizione:indica i valori di glicemia
*@param ricercaABArteritrociti:
*<li> formato: stringa(1-45)
*<li> descrizione:....
*@param esameUrineAlbumina:
*<li> formato: double
*<li> descrizione:indica la quantità di albumina delle urine
*@param esameUrineGlucosio:
*<li> formato: double
*<li> descrizione:indica la quantità di glucosio nelle urine
*@param esameUrineSedimento:
*<li> formato: double
*<li> descrizione:indica la quantità di sedimenti prensenti nelle urine
*@param note:
*<li> formato: text
*<li> descrizione:indica le note inserite dopo la visita
*Logica di  controllo:
*dopo aver inserito i dati, controllando i possibili errori avremo una tabella che permetterà di avere
*info più precise sugli esami ematochimici del paziente
*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet inserisciEsameEmatichimico</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet inserisciEsameEmatichimico at " + request.getContextPath () + "</h1>");
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
