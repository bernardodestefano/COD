/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.amministratore;

import bean.Dottore;
import controller.DottoreJpaController;
import controller.exceptions.PreexistingEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bernardo
 */
public class inserisciDottore extends HttpServlet {
   
    /**
    *Servlet inserisciDottore
    *Descrizione: Questa servlet serve per inserire un nuovo dottore
    *Parametri di input:
     *
    *@param codicefiscale :
    *<li> formato: (Stringa 16)
    *<li> descrizione:(Codice fiscale del Dottore)
     *
    *@param nome :
    *<li> formato: (Stringa, min 1 max 45 caratteri)
    *<li> descrizione: (Nome del Dottore)
     *
    *@param cognome :
    *<li> formato: (Stringa, min 1 max 45 caratteri)
    *<li> descrizione:(Cognome del Dottore)
     *
    *@param indirizzo :
    *<li> formato: (Stringa, min 1 max 45 caratteri)
    *<li> descrizione: (Indirizzo del Dottore)
     *
    *@param cellulare :
    *<li> formato: (Stringa, min 1 max 10 caratteri)
    *<li> descrizione:(Numero di cellulare del Dottore)
     *
    *@param email :
    *<li> formato: (Stringa, min 1 max 45 caratteri)
    *<li> descrizione: (Email del Dottore)
     *
    *@param comune :
    *<li> formato: (Stringa, min 1 max 45 caratteri)
    *<li> descrizione:(Comune di residenza del Dottore)
     *
    *@param provincia :
    *<li> formato: (Stringa, min 1 max 45 caratteri)
    *<li> descrizione: (Provincia di residenza del Dottore)
     *
    *Logica di  controllo:
    *Dopo aver prelevato tutti i parametri relativi al nuovo dottore, questi verranno utilizzati
    *per inserire il nuovo dottore nella tabella Dottore
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet inserisciDottore</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet inserisciDottore at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */

             //prendo la sessione corrente
             HttpSession sessione = request.getSession();

             //prelevo tutti i parametri
             String codiceFiscale = request.getParameter("codicefiscale");
             String nome = request.getParameter("nome");
             String cognome = request.getParameter("cognome");
             String indirizzo = request.getParameter("indirizzo");
             String cellulare = request.getParameter("cellulare");
             String email = request.getParameter("email");
             String comune = request.getParameter("comune");
             String provincia = request.getParameter("provincia");

             //creo un id generando un numero casuale
             //ATTENZIONE fare un controllo su eventuali ripetizioni
             Random generator = new Random();
             int id=generator.nextInt(999999999);
             
             //creo il bean Dottore
             Dottore dottore = new Dottore(codiceFiscale,nome,cognome,cellulare);

             //uso il controller per lavorare sul database
            DottoreJpaController controller = new DottoreJpaController();
            try {
                controller.create(dottore);
                response.sendRedirect("/cod/paziente/homepage.jsp");
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(inserisciDottore.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(inserisciDottore.class.getName()).log(Level.SEVERE, null, ex);
            }








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
