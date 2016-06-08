/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Abitudinidivita;
import bean.Cartellaostetricadigitale;
import controller.AbitudinidivitaJpaController;
import controller.CartellaostetricadigitaleJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giuseppe
 */
public class inserisciAbitudiniDiVita extends HttpServlet {
   
 /**
*Servlet inserisciabitudiniDiVita
*Descrizione: in questa servlet verranno inseriti i dati riguardanti le abutudini di vita del paziente
*Parametri di input:
*@param lavoro:
*<li> formato: stringa(1-45)
*<li> descrizione: indica il lavoro del paziente
*@param attivitaDomestica:
*<li> formato: stringa(1-45)
*<li> descrizione: indica l'attività domestica del paziente
*@param attivitaCorporea:
*<li> formato: stringa(1-45)
*<li> descrizione: indica l'attività corporea del paziente
*@param abitazione:
*<li> formato: stringa(1-90)
*<li> descrizione: indica leinfo riguardanti l'abitazione del paziente
*@param viaggi:
*<li> formato: stringa(1-45)
*<li> descrizione: indica le info riguardanti i viaggi del paziente
*@param alimentazione:
*<li> formato: enumerazione
*<li> descrizione: indica l'alimentazione della donna
*@param metododiCura:
*<li> formato: stringa(1-45)
*<li> descrizione:.....
*@param fumo:
*<li> formato: boolean
*<li> descrizione: indica se la donna fuma o no
*@param qtaGiornalieraSigarettePrimaGravidanza:
*<li> formato: int
*<li> descrizione:indica il numero di sigarette fumate prima della gravidanza
*@param qtaGiornalieraSigaretteDuranteGravidanza:
*<li> formato: int
*<li> descrizione: indica il numero di sigarette fumate  durante la gravidanza
*@param caffe:
*<li> formato: boolean
*<li> descrizione: indica se la donna beve caffe
*@param quantitaCaffeAlGiorno:
*<li> formato: int
*<li> descrizione: indica il numero di caffe bevuti al giorno dalla donna
*@param alcool:
*<li> formato: boolean
*<li> descrizione: indica se la donna assume alcool
*@param quantitaAlcoolAlMEse:
*<li> formato: int
*<li> descrizione: indica quanto alcool la donna assume mensilmente
*@param stupefacenti:
*<li> formato: boolean
*<li> descrizione: indica se la donna assume stupefacenti
*@param quantitaStupefacentAlMese:
*<li> formato: stringa(1-45)
*<li> descrizione: indica la quantità di stupefacenti assunti in un mese
*@param AltreOsservazioni:
*<li> formato: stringa(1-45)
*<li> descrizione: indica il altre osservazioni che possono essere aggiunte
*@param farmaciAbituali:
*<li> formato: stringa(1-45)
*<li> descrizione: indica i farmaci assunti abitualmente dal paziente
*Logica di  controllo:
*dopo aver inserito i dati, controllando i possibili errori avremo una tabella che permetterà di avere
*info più precise sulle abitudini di vita del paziente
*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //avvio la sessione
            HttpSession sessione = request.getSession();

            //importo i parametri di input
            String lavoro=request.getParameter("lavoro");
            String attivitacorporea=request.getParameter("attivitacorporea");
            String attivitadomestica=request.getParameter("attivitadomestica");
            String abitazione=request.getParameter("abitazione");
            String viaggi=request.getParameter("viaggi");
            String alimentazione=request.getParameter("alimentazione");
            String metododicura=request.getParameter("metododicura");
            String farmaciabituali=request.getParameter("farmaciabituali");
            String altro=request.getParameter("altro");
           


            //Eseguire controllo dati in input

            //creo il bean dedicato e setto i campi
            Abitudinidivita abitudini=new Abitudinidivita();

            abitudini.setLavoro(lavoro);
            abitudini.setAttivitaCorporea(attivitacorporea);
            abitudini.setAttivitaDomestica(attivitadomestica);
            abitudini.setAbitazione(abitazione);
            abitudini.setViaggi(viaggi);
            abitudini.setAlimentazione(alimentazione);
            abitudini.setMetodoCura(metododicura);
            abitudini.setFarmaciAbituali(farmaciabituali);
            abitudini.setAltreOsservazioni(altro);

            if(request.getParameter("fumo")!=null){
                abitudini.setFumo(Boolean.TRUE);
                String x=request.getParameter("nsigarettepregravidanza");
                if(!x.equals(""))
                    abitudini.setQtaGiornalieraSigarettePrimaGravidanza(12);
                x=request.getParameter("nsigarettedurantegravidanza");
                //if(!x.equals(""))
                  //  abitudini.setQtaGiornalieraSigaretteDuranteGravidanza(Integer.parseInt(x));
            }
            else
               abitudini.setFumo(Boolean.FALSE);

            if(request.getParameter("caffe")!=null)
                {
                    abitudini.setCaffe(Boolean.TRUE);
                    String x=request.getParameter("quantitacaffe");
                    if(!x.equals(""))
                        abitudini.setQuantitaCaffeAlGiorno(Integer.parseInt(x));
                }
            else
                abitudini.setCaffe(false);

            if(request.getParameter("alcool")!=null)
                {
                    abitudini.setAlcool(Boolean.TRUE);
                    String x=request.getParameter("quantitaalcool");
                    if(!x.equals(""))
                        abitudini.setQuantitaAlcoolAlMese(Integer.parseInt(x));
                }
            else
                abitudini.setAlcool(false);

            if(request.getParameter("stupefacenti")!=null)
                {
                    abitudini.setStupefacenti(Boolean.TRUE);
                    String x=request.getParameter("quantitastupefacenti");
                    if(!x.equals(""))
                        abitudini.setQuantitaStupefacentiAlMese(x);
            }
            else
                abitudini.setStupefacenti(false);

            AbitudinidivitaJpaController controller=new AbitudinidivitaJpaController();
            controller.create(abitudini);

            String codf=request.getParameter("codicefiscale");
            CartellaostetricadigitaleJpaController cod=new CartellaostetricadigitaleJpaController();
            List<Cartellaostetricadigitale> lista=cod.findCartellaostetricadigitaleEntities();

            List<Cartellaostetricadigitale> listafiltrata=new ArrayList<Cartellaostetricadigitale>();
            int i=0;
            while(i<lista.size())
                {

                    if(lista.get(i).getPaziente().getCodiceFiscale().equals(codf))
                        {
                            listafiltrata.add(lista.get(i));
                        }
                    i++;
                }

        Cartellaostetricadigitale ultima=ordinaLista(listafiltrata);

          out.println("<html><body>codf="+codf+" size lista="+lista.size()+" size lista filtrata= "+listafiltrata.size()+"ultima data="+ultima.getData()+"</body></html>");

          Date today=new Date();
          ultima.setAbitudinidivita(abitudini);
          ultima.setData(today);
          CartellaostetricadigitaleJpaController con=new CartellaostetricadigitaleJpaController();
          con.create(ultima);
            
response.sendRedirect("/cod/dottore/VisualizzaPaziente.jsp?codicefiscale="+codf);

            

            //creo il controller e inserisco la tupla
         

        }catch(Exception e)
                {
                out.println("<html><body>");
                e.printStackTrace(out);
                out.println("</html></body>");

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

    private Cartellaostetricadigitale ordinaLista(List<Cartellaostetricadigitale> l)
            {

        int s=l.size();
        Cartellaostetricadigitale[] cart=new Cartellaostetricadigitale[s];
        for(int i=0;i<s;i++)
            {
            cart[i]=l.get(i);
        }
        for(int j=0;j<s-1;j++)
            for(int k=j+1;k<s;k++)
                {
                if(cart[j].getData().after(cart[k].getData()))
                    {
                    Cartellaostetricadigitale app=cart[j];
                    cart[j]=cart[k];
                    cart[k]=app;
                }

            }

        for(int i=0;i<l.size();i++)
            l.remove(i);

        for(int i=0;i<cart.length;i++)
            {
                l.add(i, cart[i]);

            }

        return(cart[cart.length-1]);
        }
}
