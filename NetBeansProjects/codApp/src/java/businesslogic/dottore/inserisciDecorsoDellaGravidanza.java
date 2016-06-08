/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Decorsodellagravidanza;
import controller.DecorsodellagravidanzaJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giuseppe
 */
public class inserisciDecorsoDellaGravidanza extends HttpServlet {
   
   /**
*Servlet inserisciDecorsoDellaGravidanzaa
*Descrizione: in questa servlet verranno inseriti i dati riguardanti il decorso della gravidanza
*Parametri di input:
*@param testGravidanza:
*<li> formato: stringa(1-45)
*<li> descrizione: indica le info riguardanti il test di gravidanza
*@param cicloPrecedente:
*<li> formato: date
*<li> descrizione:indica la data dell'ultimo ciclo
*@param DPP:
*<li> formato: stringa(1-45)
*<li> descrizione:....
*@param UMCerta
*<li> formato: boolean
*<li> descrizione:....
*@param decorsoGravidanza:
*<li> formato: stringa(1-45)
*<li> descrizione:indica le info del decorso della gravidanza dino alla prima visita
*@param minacciaAborto:
*<li> formato: stringa(1-45)
*<li> descrizione: indica se ci sono state minacce di aborto
*@param nausea:
*<li> formato: boolean
*<li> descrizione: indica se si è sofferto di nausea
*@param vomito:
*<li> formato: double
*<li> descrizione:indica se si sofferto di vomito
*@param farmaciAssunti:
*<li> formato: stringa(1-45)
*<li> descrizione:indica la lista dei farmaci assunti
*@param pesoPregravico:
*<li> formato: double
*<li> descrizione:indica il peso della donna prima della gravidanza
*@param statura:
*<li> formato: stringa(1-45)
*<li> descrizion: indica la struttura della donna
*@param colorito:
*<li> formato: stringa(1-45)
*<li> descrizione:indica il colorito della donna
*@param varici:
*<li> formato: stringa(1-45)
*<li> descrizione:.....
*@param edemi:
*<li> formato: stringa(1-45)
*<li> descrizione:.....
*@param eczemi:
*<li> formato: stringa(1-45)
*<li> descrizione:.....
*@param vista:
*<li> formato: stringa(1-45)
*<li> descrizione:indica la vista della donna
*@param seno:
*<li> formato: stringa(1-45)
*<li> descrizione:indica le caratteristiche del seno della donna
*@param funzioneIntestino:
*<li> formato: stringa(1-100)
*<li> descrizione:.....
*@param funzioneVescica:
*<li> formato: stringa(1-100)
*<li> descrizione:.....
*@param altro:
*<li> formato: text
*<li> descrizione:indica altre info riguardanti il decorso della gravidanza
*@param gruppoSanguignoMadre:
*<li> formato: enumerazione
*<li> descrizione:indica il gruppo sanguigno della madre
*@param gruppoSanguignoPadre:
*<li> formato: enumerazione
*<li> descrizione:indica il gruppo sanguigno del padre
*@param primiMovimentiFetali:
*<li> formato: stringa(1-45)
*<li> descrizione:indica i primi movimenti fetali
*@param data:
*<li> formato: date
*<li> descrizione:indica la data della visita
*Logica di  controllo:
*dopo aver inserito i dati, controllando i possibili errori avremo una tabella che permetterà di avere
*info più precise sugl decorso della gravidanza
*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

                //avvio la sessione
                HttpSession sessione = request.getSession();

                 //importo i parametri di input
                String umcerta=request.getParameter("umcerta");
                String cicloprecedente=request.getParameter("cicloprecedente");
                Date datacicloprecedente=null;//creare data per ciclo precedente
                String dpp=request.getParameter("dpp");
                String testgravidanza=request.getParameter("testgravidanza");
                String decorsogravidanza=request.getParameter("decorsogravidanza");
                String minacciaaborto=request.getParameter("minacciaaborto");
                String nausea=request.getParameter("nausea");
                String vomito=request.getParameter("vomito");
                String farmaciassunti=request.getParameter("farmaciassunti");
                String pesopregravidico=request.getParameter("pesopregravidico");
                String statura=request.getParameter("statura");
                String colorito=request.getParameter("colorito");
                String varici=request.getParameter("varici");
                String edemi=request.getParameter("edemi");
                String eczemi=request.getParameter("eczemi");
                String vista=request.getParameter("vista");
                String seno=request.getParameter("seno");
                String funzioneintestino=request.getParameter("funzioneintestino");
                String funzionevescica=request.getParameter("funzionevescica");
                String altro=request.getParameter("altro");
                String grupposanguignomadre=request.getParameter("grupposanguignomadre");
                String grupposanguignopadre=request.getParameter("grupposanguignopadre");
                String primimovimentifetali=request.getParameter("primimovimentifetali");
                String data=request.getParameter("data");
                Date datax=null;//creare la data

                 //Eseguire controllo dati in input


                //creo il bean e lo riempio
                Decorsodellagravidanza decorso=new Decorsodellagravidanza();
                if(umcerta.equals("true"))
                decorso.setUMCerta(Boolean.TRUE);
                decorso.setCicloPrecedente(datacicloprecedente);
                decorso.setColorito(colorito);
                decorso.setEdemi(edemi);
                decorso.setVarici(varici);
                decorso.setEczemi(eczemi);
                decorso.setDpp(dpp);
                decorso.setTestGravidanza(testgravidanza);
                decorso.setDecorsoGravidanzaFinoAllaPrimaVisita(decorsogravidanza);
                decorso.setMinacciaAborto(minacciaaborto);
                if(nausea.equals("true"))
                    decorso.setNausea(Boolean.TRUE);
                if(vomito.equals("true"))
                    decorso.setVomito(Boolean.TRUE);
                decorso.setFarmaciAssunti(farmaciassunti);
                decorso.setPesoPregravidico(Double.parseDouble(pesopregravidico));
                decorso.setStatura(Double.parseDouble(statura));
                decorso.setVista(vista);
                decorso.setSeno(seno);
                decorso.setFunzioneIntestino(funzioneintestino);
                decorso.setFunzioneVescica(funzionevescica);
                decorso.setAltro(altro);
                decorso.setGruppoSanguignoMadre(grupposanguignomadre);
                decorso.setGruppoSanguignoPadre(grupposanguignopadre);
                decorso.setData(datax);

                //creo il controller e inserisco la tupla
                DecorsodellagravidanzaJpaController controller=new DecorsodellagravidanzaJpaController();
                controller.create(decorso);
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet inserisciDecorsoDellaGravidanza</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet inserisciDecorsoDellaGravidanza at " + request.getContextPath () + "</h1>");
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
