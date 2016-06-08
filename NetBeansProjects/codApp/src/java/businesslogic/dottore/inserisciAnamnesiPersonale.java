/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Anamnesipersonale;
import bean.Disturbi;
import controller.AnamnesipersonaleJpaController;
import controller.DisturbiJpaController;
import controller.exceptions.IllegalOrphanException;
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
 * @author Giuseppe
 */
public class inserisciAnamnesiPersonale extends HttpServlet {
   
   /**
*Servlet inseriscianamnesiPersonale
*Descrizione: Questa servlet serve per gestire i dati riguardanti le anamnesi personali di ogni paziente
*Parametri di input:
*@param arrayanamnesi:
*<li> formato: array di stringhe
*<li> descrizione:contiene tutti di dati riguardanti l'anamnesi personale settati a true
*@param arraydisturbi:
*<li> formato: array di stringhe
*<li> descrizione:contiene tutti di dati riguardanti i disturbi settati a true
*@param diabete:
*<li> formato: boolean
*<li> descrizione: consente di controllare se il paziente ha il diabete
*@param obesità:
*<li> formato: boolean
*<li> descrizione: consente di controllare se il paziente ha il obesità
*@param malattieInfettive:
*<li> formato: boolean
*<li> descrizione: consente di controllare se il paziente ha malattie infettive
*@param disturbiAlimentari:
*<li> formato: boolean
*<li> descrizione: consente di controllare se il paziente ha disturbi alimentari
*@param malattieEsantematiche:
*<li> formato: boolean
*<li> descrizione: consente di controllare se il paziente ha malattie esantematiche
*@param malattieSessualmenteTrasmesse:
*<li> formato: boolean
*<li> descrizione: consente di controllare se il paziente ha malattie che possono essere trasmesse,
*sessualmente
*@param interventiChirurgici:
*<li> formato: boolean
*<li> descrizione: consente di controllare se il paziente è stato sottoposto a interventi chirurgici
*@param allergie:
*<li> formato: boolean
*<li> descrizione: consente di controllare se il paziente soffre di allergie
*@param incidentiTraumiFratture:
*<li> formato: boolean
*<li> descrizione: consente di controllare se il paziente ha avuto incidenti traumi o fratture ,
*in passato
*@param anamnesiPersonaleAltro:
*<li> formato: stringa(1-100)
*<li> descrizione: consente di aggiungere altre patologie non presenti nei campi precedenti.
*@param cuore:
*<li> formato: boolean
*<li> descrizione: indica se il paziente ha problemi cardiaci
*@param sangue:
*<li> formato: boolean
*<li> descrizione:indica se il paziente ha problemi al sangue
*@param circolazione:
*<li> formato: boolean
*<li> descrizione:indica se il paziente ha problemi circolatori
*@param reni:
*<li> formato: boolean
*<li> descrizione:indica se il paziente ha disturbi ai reni
*@param fegato:
*<li> formato: boolean
*<li> descrizione:indica se il paziente ha disturbi al frgato
*@param polmoni:
*<li> formato: boolean
*<li> descrizione:indica se il paziente ha disturbi ai polmoni
*@param stomaco:
*<li> formato: boolean
*<li> descrizione:indica se il paziente ha disturbi allo stomaco
*@param intestino:
*<li> formato: boolean
*<li> descrizione:indica se il paziente ha disturbi all'intestino
*@param sistemaNervoso:
*<li> formato: boolean
*<li> descrizione:indica se il paziente ha disturbi al sistema nervoso
*@param sistemaEndocrino:
*<li> formato: boolean
*<li> descrizione:indica se il paziente ha disturbi al sistema endocrino
*@param trasfusioni:
*<li> formato: boolean
*<li> descrizione:indica se il paziente ha mai avuto trasfusioni
*@param ultimaTrasfusione:
*<li> formato: date
*<li> descrizione:indica quando il paziente ha avuto l'ultima trasfusione
*@param altro:
*<li> formato: stringa(1-100)
*<li> descrizione:ci permette di avere altre info su disturbi avuti dal paziente
*@param osservazioni:
*<li> formato: text
*<li> descrizione:indica le osservazioni
*Logica di  controllo:
*dopo aver inserito i dati controllando i possibili errori, sarà possibile inserire le info nel COD
*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //avvio la sessione
            HttpSession sessione = request.getSession();



            //prelevo tutti gli input booleani
            String[] arrayanamnesi=request.getParameterValues("anamnesipersonale");
            String[] arraydisturbi=request.getParameterValues("disturbi");

            String osservazioni=request.getParameter("osservazioni");

            Anamnesipersonale anamnesi=new Anamnesipersonale();
            
            //setto i campi booleani
            for(int i=0;i<arrayanamnesi.length;i++){
                String x=arrayanamnesi[i];
                if(x.equals("diabete"))
                    anamnesi.setDiabete(Boolean.TRUE);
                else
                
                if(x.equals("obesita"))
                    anamnesi.setObesita(Boolean.TRUE);
                else
                
                if(x.equals("malattieinfettive"))
                    anamnesi.setMalattieInfettive(Boolean.TRUE);
                else

                if(x.equals("disturbialimentari"))
                    anamnesi.setDisturbiAlimentari(Boolean.TRUE);
                else

                if(x.equals("malattieesantematiche"))
                    anamnesi.setMalattieEsantematiche(Boolean.TRUE);
                else

                if(x.equals("malattiesessualmentetrasmesse"))
                    anamnesi.setMalattieSessualmenteTrasmesse(Boolean.TRUE);
                else

                if(x.equals("interventichirurgici"))
                    anamnesi.setInterventiChirurgici(Boolean.TRUE);
                else
                
                if(x.equals("allergie"))
                    anamnesi.setAllergie(Boolean.TRUE);
                else
                
                if(x.equals("incidentitraumifratture"))
                    anamnesi.setIncidentiTraumiFratture(Boolean.TRUE);
                
                
            }
            String analtro=request.getParameter("anamnesipersonalealtro");
            if(!analtro.equals(""))
                anamnesi.setAltro(analtro);


            Disturbi disturbi=new Disturbi();

            //setto i campi booleani
            for(int i=0;i<arraydisturbi.length;i++)
                {
                    String x=arraydisturbi[i];
                    
                    if(x.equals("cuore"))
                        disturbi.setCuore(Boolean.TRUE);
                    else
                    if(x.equals("sangue"))
                        disturbi.setSangue(Boolean.TRUE);
                    else
                    if(x.equals("circolazione"))
                        disturbi.setCircolazione(Boolean.TRUE);
                    else
                    if(x.equals("reni"))
                        disturbi.setCircolazione(Boolean.TRUE);
                    else
                    if(x.equals("fegato"))
                        disturbi.setFegato(Boolean.TRUE);
                    else
                    if(x.equals("polmoni"))
                        disturbi.setFegato(Boolean.TRUE);
                    else
                    if(x.equals("stomaco"))
                        disturbi.setStomaco(Boolean.TRUE);
                    else
                    if(x.equals("intestino"))
                        disturbi.setIntestino(Boolean.TRUE);
                    else
                    if(x.equals("sistemanervoso"))
                        disturbi.setSistemaNervoso(Boolean.TRUE);
                    else
                    if(x.equals("sistemaendocrino"))
                        disturbi.setSistemaEndocrino(Boolean.TRUE);
                    else
                    if(x.equals("trasfusioni"))
                        disturbi.setTrasfuzioni(Boolean.TRUE);
                    
                }
            String distaltro=request.getParameter("disturbialtro");
               if(!distaltro.equals(""))
                   disturbi.setAltro(distaltro);
               if(!osservazioni.equals(""))
                   disturbi.setOsservazioni(osservazioni);
            
            disturbi.setAnamnesipersonale(anamnesi);
            disturbi.setAnamnesiPersonaleid(anamnesi.getId());
            //creo i controller per la tupla
            DisturbiJpaController dist=new DisturbiJpaController();
            AnamnesipersonaleJpaController anam=new AnamnesipersonaleJpaController();

      
               anam.create(anamnesi);

          

            try {
                dist.create(disturbi);
             
            } catch (IllegalOrphanException ex) {
                Logger.getLogger(inserisciAnamnesiPersonale.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(inserisciAnamnesiPersonale.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(inserisciAnamnesiPersonale.class.getName()).log(Level.SEVERE, null, ex);
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
