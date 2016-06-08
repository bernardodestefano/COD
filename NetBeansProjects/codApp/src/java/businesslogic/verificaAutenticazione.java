/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import bean.Datiautenticazione;
import controller.DatiautenticazioneJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lodato
 */
public class verificaAutenticazione extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * Servlet VerificaAutenticazione
     * Descrizione: Questa servlet controlla il login dell'utente
     * @param Utente:
     * <li> String(1-45)
     * <li> Nome utente di un account
     * @param Password:
     * <li> String(1-45)
     * <li> Password di un account
     * LOGICA DI CONTROLLO:
     * Dopo aver verificato che i dati sono formalmente corretti,
     * verifica se l'utente esiste nel sistema e, se esiste,
     * lo rimanda alla homepage associata al suo ruolo
     *
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            //prendo la sessione corrente
            HttpSession sessione = request.getSession();

            //prelevo tutti i parametri
            String username = request.getParameter("Utente");
            String password = request.getParameter("Password");

            //uso i controller per lavorare sul database
            DatiautenticazioneJpaController controller = new DatiautenticazioneJpaController();
            Datiautenticazione datiAutenticazioneTupla = controller.findDatiautenticazione(username);

            //eventualmente mi lavoro e memorizzo i dati
            //qui non devo memorizzare niente(ma in genere ci dovrebbe essere codice)

            //redirigo alla pagina dove mostro qualcosa (es. i dati che ho inserito)
            //oppure in questo caso nella home page (in base al tipo utente)
            if (!(username != null && password != null && username.matches("\\w{1,45}") && password.matches("\\w{1,45}"))) {
                response.sendRedirect("/cod/autenticazione/errore.jsp");
                return;
            }
            if (datiAutenticazioneTupla == null) {
                response.sendRedirect("/cod/autenticazione/credenzialiNonValide.jsp");
                return;
            }
            if (datiAutenticazioneTupla.getTipoUtente().equals(Datiautenticazione.TIPOUTENTE_AMMINISTRATORE)) {
                sessione.setAttribute("amministratore", datiAutenticazioneTupla.getAmministratoreList().get(0));
                response.sendRedirect("/cod/amministratore/CartellaOstetricaDigitale.html");
                return;
            }
            if (datiAutenticazioneTupla.getTipoUtente().equals(Datiautenticazione.TIPOUTENTE_PAZIENTE)) {
                sessione.setAttribute("paziente", datiAutenticazioneTupla.getPazienteList().get(0));
                response.sendRedirect("/cod/paziente/index.html");
                return;
            }
            if (datiAutenticazioneTupla.getTipoUtente().equals(Datiautenticazione.TIPOUTENTE_DOTTORE)) {
                sessione.setAttribute("dottore", datiAutenticazioneTupla.getDottoreList().get(0));
                response.sendRedirect("/cod/dottore/homepage.html");
                return;
            }
            response.sendRedirect("/cod/autenticazione/credenzialiNonValide.jsp");
            return;

        } finally {
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
