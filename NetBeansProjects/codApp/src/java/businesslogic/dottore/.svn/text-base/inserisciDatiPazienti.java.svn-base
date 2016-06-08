/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Abitudinidivita;
import bean.Anamnesifamiliare;
import bean.Anamnesipartner;
import bean.Anamnesipersonale;
import bean.Anticoncezionali;
import bean.Bambino;
import bean.Cartellaostetricadigitale;
import bean.Controllogravidanza;
import bean.Datiautenticazione;
import bean.Decorsodellagravidanza;
import bean.Dottore;
import bean.Ecografie;
import bean.Esameematochimici;
import bean.Esamesierologico;
import bean.Paziente;
import bean.Storiaginecologica;
import bean.Storiamestruale;
import bean.Storiaostetrica;
import bean.Storiaostretricamadredelladonna;
import bean.Storiapreconcezionale;
import bean.Visitaostetrica;
import bean.Visite;
import controller.AbitudinidivitaJpaController;
import controller.AnamnesifamiliareJpaController;
import controller.AnamnesipartnerJpaController;
import controller.AnamnesipersonaleJpaController;
import controller.AnticoncezionaliJpaController;
import controller.BambinoJpaController;
import controller.CartellaostetricadigitaleJpaController;
import controller.ControllogravidanzaJpaController;
import controller.DatiautenticazioneJpaController;
import controller.DecorsodellagravidanzaJpaController;
import controller.DottoreJpaController;
import controller.EcografieJpaController;
import controller.EsameematochimiciJpaController;
import controller.EsamesierologicoJpaController;
import controller.PazienteJpaController;
import controller.StoriaginecologicaJpaController;
import controller.StoriamestrualeJpaController;
import controller.StoriaostetricaJpaController;
import controller.StoriaostretricamadredelladonnaJpaController;
import controller.StoriapreconcezionaleJpaController;
import controller.VisitaostetricaJpaController;
import controller.VisiteJpaController;
import controller.exceptions.PreexistingEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
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
public class inserisciDatiPazienti extends HttpServlet {
   
   /**
*Servlet inserisciDatiPazienti
*Descrizione: Questa servlet serve per gestire i dati riguardanti le anamnesi personali dei pazienti.
*Parametri di input:
*@param nome:
*<li> formato: stringa(1-45)
*<li> descrizione:è il nome del partnere del paziente.
*@param cognome:
*<li> formato: stringa(1-45)
*<li> descrizione:è il cognome del partnere del paziente.
*@param indirizzo:
*<li> formato: stringa(1-45)
*<li> descrizione:l'indirizzo del paziente
*@param telefono:
*<li> formato: int
*<li> descrizione:indica il numero di telefono del paziente.
*@param datadinascita:
*<li> formato: date
*<li> descrizione:indica la data di nascite del .
*@param luogodinascita:
*<li> formato:stringa (1-45)
*<li> descrizione:è il luogo di nascita del paziente.
*@param statocivile:
*<li> formato: enumerazione
*<li> descrizione:è lo stato civile del paziente.
*@param codicefiscale:
*<li> formato: stringa(16)
*<li> descrizione:indica il codice fiscale del paziente.
*@param datamatrimonio:
*<li> formato: date
*<li> descrizione:indica la data del matrimonio del paziente.
*@param username:
*<li> formato: stringa(1-45)
*<li> descrizione:è l'username dato al paziente per l'accesso.
*@param password:
*<li> formato: stringa(1-45)
*<li> descrizione:è la password del paziente per accedere a COD.
*Logica di  controllo:
*dopo aver inserito controllando i possibili errori,i dati riguardanti il paziente verranno inseriti
*nel COD.
*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //avvio la sessione
            HttpSession sessione = request.getSession();

            //prelevo tutti i parametri in input
            String nome=request.getParameter("nome");
            String cognome=request.getParameter("cognome");
            String indirizzo=request.getParameter("indirizzo");
            String telefono=request.getParameter("telefono");
            String datanascita=request.getParameter("datadinascita");
            String luogonascita=request.getParameter("luogodinascita");
            String statocivile=request.getParameter("statocivile");
            String codicefiscale=request.getParameter("codicefiscale");
            String datamatrimonio=request.getParameter("datamatrimonio");
            String titolodistudio=request.getParameter("titolodistudio");
            String professione=request.getParameter("professione");
            //creare data in formato Date
            
          //Controllo data
             int gg=0;
            int mm=0;
            int aa=0;
            String g="",m="",a="";
            g=datamatrimonio.substring(0, 2);
            m=datamatrimonio.substring(3,5);
            a=datamatrimonio.substring(6,10);
            try{

                gg=Integer.parseInt(g);
                mm=Integer.parseInt(m);
                aa=Integer.parseInt(a);


            }catch(Exception e)
                    {

            }

            Date datamatrim=new Date(aa,mm,gg);
            
            //Eseguire controllo dati in input

            //creo il bean per i dati del paziente
            Paziente paziente=new Paziente(codicefiscale,cognome,nome,luogonascita,datanascita,statocivile);

            if(!indirizzo.equals(""))
                paziente.setIndirizzo(indirizzo);

            if(!telefono.equals(""))
                paziente.setTelefono(Integer.parseInt(telefono));
            
            if(datamatrim!=null)
                paziente.setDataMatrimonio(datamatrim);

            if(!titolodistudio.equals(""))
                paziente.setTitoloStudi(titolodistudio);
            if(!professione.equals(""))
                paziente.setProfessione(professione);
            

            //creo il controller per il paziente
            PazienteJpaController controller=new PazienteJpaController();
            
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            //Eseguire controllo dati in input

            //creo il bean dati autenticazione 
            Datiautenticazione autenticazione=new Datiautenticazione();
            autenticazione.setUsername(username);
            autenticazione.setPassword(password);
            autenticazione.setTipoUtente("paziente");

            paziente.setDatiautenticazione(autenticazione);
            
            
            
            Cartellaostetricadigitale cartella=new Cartellaostetricadigitale();
            CartellaostetricadigitaleJpaController cartellaContr=new CartellaostetricadigitaleJpaController();

            cartella.setPaziente(paziente);

            Abitudinidivita abitudini=new Abitudinidivita();
            AbitudinidivitaJpaController c=new AbitudinidivitaJpaController();
            c.create(abitudini);
            cartella.setAbitudinidivita(abitudini);
             

            Anamnesifamiliare anamnesi=new Anamnesifamiliare();
            AnamnesifamiliareJpaController c1=new AnamnesifamiliareJpaController();
            c1.create(anamnesi);
            cartella.setAnamnesifamiliare(anamnesi);

            Anamnesipartner anampa=new Anamnesipartner();
            AnamnesipartnerJpaController c2=new AnamnesipartnerJpaController();
            c2.create(anampa);
            cartella.setAnamnesipartner(anampa);

            Anticoncezionali anti=new Anticoncezionali();
            AnticoncezionaliJpaController c3=new AnticoncezionaliJpaController();
            c3.create(anti);
            cartella.setAnticoncezionali(anti);

            Bambino bambino=new Bambino();
            BambinoJpaController c4=new BambinoJpaController();
            c4.create(bambino);
            cartella.setBambino(bambino);

            Storiaginecologica storiag=new Storiaginecologica();
            StoriaginecologicaJpaController c5=new StoriaginecologicaJpaController();
            c5.create(storiag);
            cartella.setStoriaginecologica(storiag);

            Storiamestruale storiam=new Storiamestruale();
            StoriamestrualeJpaController c6=new StoriamestrualeJpaController();
            c6.create(storiam);
            cartella.setStoriamestruale(storiam);

            Storiaostetrica storiao=new Storiaostetrica();
            StoriaostetricaJpaController c7=new StoriaostetricaJpaController();
            c7.create(storiao);
            cartella.setStoriaostetrica(storiao);

            Storiapreconcezionale storiap=new Storiapreconcezionale();
            StoriapreconcezionaleJpaController c8=new StoriapreconcezionaleJpaController();
            c8.create(storiap);
            cartella.setStoriapreconcezionale(storiap);
              
            cartella.setData(new Date());

            Anamnesipersonale anp=new Anamnesipersonale();
            AnamnesipersonaleJpaController c9=new AnamnesipersonaleJpaController();
            c9.create(anp);
            cartella.setAnamnesipersonale(anp);

            ControllogravidanzaJpaController c10=new ControllogravidanzaJpaController();
            Controllogravidanza contrg=new Controllogravidanza();
            c10.create(contrg);
            cartella.setControllogravidanza(contrg);

            Decorsodellagravidanza decorso=new Decorsodellagravidanza();
            DecorsodellagravidanzaJpaController c11=new DecorsodellagravidanzaJpaController();
            c11.create(decorso);
            cartella.setDecorsodellagravidanza(decorso);

            Ecografie eco=new Ecografie();
            EcografieJpaController c12=new EcografieJpaController();
            c12.create(eco);
            cartella.setEcografie(eco);

            Esameematochimici esamee=new Esameematochimici();
            EsameematochimiciJpaController c13=new EsameematochimiciJpaController();
            c13.create(esamee);
            cartella.setEsameematochimici(esamee);

            Esamesierologico esames=new Esamesierologico();
            EsamesierologicoJpaController c14=new EsamesierologicoJpaController();
            c14.create(esames);
            cartella.setEsamesierologico(esames);

            Storiaostretricamadredelladonna storiaom=new Storiaostretricamadredelladonna();
            StoriaostretricamadredelladonnaJpaController c15=new StoriaostretricamadredelladonnaJpaController();
            c15.create(storiaom);
            cartella.setStoriaostretricamadredelladonna(storiaom);


           
            VisiteJpaController c16=new VisiteJpaController();
            
            cartella.setVisite(c16.findVisite(1));

            
            VisitaostetricaJpaController c17=new VisitaostetricaJpaController();
            
            cartella.setVisitaostetrica(c17.findVisitaostetrica(1));

            
           DottoreJpaController Dott=new DottoreJpaController();
            cartella.setDottore((Dottore)sessione.getAttribute("dottore"));
            

            
            
            boolean bool=false;
            DatiautenticazioneJpaController controller1=new DatiautenticazioneJpaController();
            
            try {
                controller1.create(autenticazione);
                
                bool=true;
                
            } catch (PreexistingEntityException ex) {
                out.println(ex);
                Logger.getLogger(inserisciDatiPazienti.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                out.println(ex);
                Logger.getLogger(inserisciDatiPazienti.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(bool){
            try {
                controller.create(paziente);
            } catch (PreexistingEntityException ex) {
                Logger.getLogger(inserisciDatiPazienti.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(inserisciDatiPazienti.class.getName()).log(Level.SEVERE, null, ex);
            }

           cartellaContr.create(cartella);
           
            response.sendRedirect("/cod/dottore/VisualizzaPaziente.jsp?codicefiscale="+codicefiscale);
            }



        }catch(Exception e)
                {
            out.println("<html><body>");
            e.printStackTrace(out);
            out.println("</body></html>");
        }
        finally {
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
