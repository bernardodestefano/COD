/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.amministratore;

import controller.AmministratoreJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author bernardo
 */
public class richiediAbilitazione extends HttpServlet {
   
        /**
    *Servlet richiediAbilitazione
    *Descrizione: Questa servlet serve per inviare una richiesta di abilitazione all'amministratore tramite email
    *Parametri di input:
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
    *<li> formato: (Stringa 16)
    *<li> descrizione:(Comune di residenza del Dottore)
     *
    *@param provincia :
    *<li> formato: (Stringa, min 1 max 45 caratteri)
    *<li> descrizione: (Provincia di residenza del Dottore)
     *
    *Logica di  controllo:
    *Vengono prelevati i dati relativi al dottore che fa richiesta di abilitazione, i quali
    *verranno inviati all'indirizzo email dell'amministratore per mezzo email.
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet richiediAbilitazione</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet richiediAbilitazione at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */

            String codiceFiscale = request.getParameter("codicefiscale");
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String indirizzo = request.getParameter("indirizzo");
            String cellulare = request.getParameter("cellulare");
            String mittente = request.getParameter("email");
            String comune = request.getParameter("comune");
            String provincia = request.getParameter("provincia");

            String oggetto="Richiesta abilitazione";

            AmministratoreJpaController controller = new AmministratoreJpaController();


            /*
            try
            {
              MailUtility.sendMail(dest, mitt, oggetto, testo);
              out.println("Invio messaggio OK!");
            }
            catch (MessagingException exc)
            {
              out.println("Invio non riuscito!");
              log("MessagingException: " + dest);
              log(exc.toString());
            }

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

    /*
    public static void sendMail (String dest, String mitt, String oggetto, String testoEmail)
      throws MessagingException
  {
    // Creazione di una mail session
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.mioprovider.it");
    Session session = Session.getDefaultInstance(props);

    // Creazione del messaggio da inviare
    MimeMessage message = new MimeMessage(session);
    message.setSubject(oggetto);
    message.setText(testoEmail);

    // Aggiunta degli indirizzi del mittente e del destinatario
    InternetAddress fromAddress = new InternetAddress(mitt);
    InternetAddress toAddress = new InternetAddress(dest);
    message.setFrom(fromAddress);
    message.setRecipient(Message.RecipientType.TO, toAddress);

    // Invio del messaggio
    Transport.send(message);
  }
  */
}
