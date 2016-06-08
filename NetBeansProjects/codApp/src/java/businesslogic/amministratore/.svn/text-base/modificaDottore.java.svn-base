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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sabato Luca 'noidhoon' Guadagno
 */
public class modificaDottore extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet modificaDottore</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet modificaDottore at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */

            //prendo la sessione corrente
             HttpSession sessione = request.getSession();

             //prelevo i parametri che mi servono
             int id = Integer.parseInt( request.getParameter("id") );

             String codiceFiscale = request.getParameter("codicefiscale");
             String nome = request.getParameter("nome");
             String cognome = request.getParameter("cognome");
             String indirizzo = request.getParameter("indirizzo");
             String cellulare = request.getParameter("cellulare");
             String email = request.getParameter("email");
             String comune = request.getParameter("comune");
             String provincia = request.getParameter("provincia");

             Dottore dottore = new Dottore(codiceFiscale,nome,cognome,cellulare);

             //uso il controller per lavorare sul database
            DottoreJpaController controller = new DottoreJpaController();
            try
            {
                controller.edit(dottore);
                response.sendRedirect("/cod/paziente/homepage.jsp");
                //eventualmente mi lavoro e memorizzo i dati
                //qui non devo memorizzare niente(ma in genere ci dovrebbe essere codice)
                //redirigo alla pagina dove mostro qualcosa (es. i dati che ho inserito)
                //oppure in questo caso nella home page (in base al tipo utente)
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
