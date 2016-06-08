/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Storiaostretricamadredelladonna;
import controller.StoriaostretricamadredelladonnaJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giuseppe
 */
public class inserisciStoriaOstetricaMadreDellaDonna extends HttpServlet {
   
   /**
*Servlet InseriscistoriaOstetricaMadreDellaDonna
*Descrizione: Questa servlet serve per gestire i dati riguardanti le anamnesi personali dei familiari di ogni singolo
paziente.
*Parametri di input:
*@param nFigla:
*<li> formato: int
*<li> descrizione:indica il numero di figli che la madre della donna ha
*@param nParti:
*<li> formato: int
*<li> descrizione:indica il numero di parti che la madre della donna ha avuto
*@param etaparto:
*<li> formato: int
*<li> descrizione:indica l' età del parto che la madre della donna ha avuto
*@param naborti:
*<li> formato: int
*<li> descrizione:indica il numero di aborti che la madre della donna ha avuto
*@param pesoBambino:
*<li> formato: double
*<li> descrizione:indica il peso dei figli che la madre della donna ha avuto
*@param allattamento:
*<li> formato: enumerazione
*<li> descrizione:indica le modalità di allattamento dei figli che la madre della donna ha avuto
*@param atteggiamento:
*<li> formato: stringa (1-45)
*<li> descrizione:indica l'atteggiamento che la madre donna ha assunto nei parti
*@param luogoParto:
*<li> formato: stringa
*<li> descrizione:indica il luogo dove sono avvenuti i parti da parte della madre della donna
*@param durataGravidanze:
*<li> formato: stringa(1-45)
*<li> descrizione:indica la durata della gravidanza
*@param complicazioni:
*<li> formato: text
*<li> descrizione:indica se ci sono state, le complicazioni avute dalla donna nei parti,
*precedenti
*@param osservazioni:
*<li> formato: text
*<li> descrizione:indica le osservazioni effettuate data la storia ostetrica della donna
*Logica di  controllo:
*dopo aver inserito controllando i possibili errori,la sotria ostetrica della madre dalla donna
*verrà inserita all'interno  cartella ostetrica,
*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            //avvio la sessione
            HttpSession sessione = request.getSession();

           //prelevo i parametri in input
            String nfiglia=request.getParameter("nfiglia");
            String etaparto=request.getParameter("etaparto");
            String naborti=request.getParameter("naborti");
            String nparti=request.getParameter("nparti");
            String pesobambino=request.getParameter("pesobambino");
            String allattamento=request.getParameter("allattamento");
            String atteggiamento=request.getParameter("atteggiamento");
            String luogoparto=request.getParameter("luogoparto");
            String duratagravidanze=request.getParameter("duratagravidanze");
            String complicazioni=request.getParameter("complicazioni");
            String osservazioni=request.getParameter("osservazioni");

            //Eseguire controllo dati in input

            

          //creo il bean

            Storiaostretricamadredelladonna storia=new Storiaostretricamadredelladonna();
            storia.setNumeroFiglia(Integer.parseInt(nfiglia));
            storia.setEtaParto(Integer.parseInt(etaparto));
            storia.setNumeriAborti(Integer.parseInt(naborti));
            storia.setNumeriParti(Integer.parseInt(nparti));
            storia.setPesoBambini(Double.parseDouble(pesobambino));
            storia.setAllattamentoModalita(allattamento);
            storia.setAtteggiamentoNeiConfrontiDelParto(atteggiamento);
            storia.setLuogoParto(luogoparto);
            storia.setDurataGravidanza(duratagravidanze);
            storia.setComplicazioniPartoGravidanza(complicazioni);
            storia.setOsservazioni(osservazioni);

            //creo il controller e inserisco la tupla

            StoriaostretricamadredelladonnaJpaController controller=new StoriaostretricamadredelladonnaJpaController();
            controller.create(storia);
             
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet inserisciStoriaOstetricaMadreDellaDonna</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet inserisciStoriaOstetricaMadreDellaDonna at " + request.getContextPath () + "</h1>");
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
