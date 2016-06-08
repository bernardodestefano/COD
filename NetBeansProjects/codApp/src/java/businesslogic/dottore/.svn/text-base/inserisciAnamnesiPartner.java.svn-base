/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Anamnesipartner;
import bean.Cartellaostetricadigitale;
import controller.AnamnesipartnerJpaController;
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
public class inserisciAnamnesiPartner extends HttpServlet {
   
   /**
*Servlet anamnesiPartner
*Descrizione: Questa servlet serve per gestire i dati riguardanti le anamnesi personali dei partner di ogni singolo
paziente.
*Parametri di input:
*@param nome:
*<li> formato: stringa(1-45)
*<li> descrizione:è il nome del partnere del paziente.
*@param cognome:
*<li> formato: stringa(1-45)
*<li> descrizione:è il cognome del partnere del paziente.
*@param dataNascita:
*<li> formato: date
*<li> descrizione:è la data di nascita del partnere del paziente.
*@param gruppoSangue:
*<li> formato: enumerazione
*<li> descrizione:indica il gruppo sanguigno del partner.
*@param pesoNascita:
*<li> formato: double
*<li> descrizione:indica il peso del partner alla nascita.
*@param titoloStudi:
*<li> formato:stringa (1-45)
*<li> descrizione:è il titolo di studi riguardanti il partner.
*@param professione:
*<li> formato: stringa(1-45)
*<li> descrizione:è la professione del partner.
*@param fumo:
*<li> formato: boolean
*<li> descrizione:indica se il partner è un fumatore.
*@param alcool:
*<li> formato: boolean
*<li> descrizione:indica se il partner beve alcolici.
*@param malattieFamiliari:
*<li> formato: stringa(1-45)
*<li> descrizione:è l'elenco delle malattie presenti nella famiglia del partner.
*@param malattiePersonali:
*<li> formato: stringa(1-45)
*<li> descrizione:è l'elenco della malattie personali del partner.
*@param osservazioni:
*<li> formato: stringa(1-45)
*<li> descrizione:indica le osservazioni riguardanti il partner.
*@param seleziona:
*<li> formato: array di stringhe
*<li> descrizione:contiene tutti i valori settati a true dei campi booleani
*Logica di  controllo:
*dopo aver inserito controllando i possibili errori,i dati riguardanti l'anamensi del partner verranno inseriti
*nel COD.
*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //avvio la sessione
            HttpSession sessione = request.getSession();

            //prelevo i parametri in input
            String nome=request.getParameter("nome");
            String cognome=request.getParameter("cognome");
            String gruppo=request.getParameter("grupposanguigno");
            String nascita=request.getParameter("datanascita");
             //Controllo data
             int gg=0;
            int mm=0;
            int aa=0;

            Date datanascita;
            try{
                String g="",m="",a="";
                g=nascita.substring(0, 2);
                m=nascita.substring(3,5);
                a=nascita.substring(6,10);
                gg=Integer.parseInt(g);
                mm=Integer.parseInt(m);
                aa=Integer.parseInt(a);
                datanascita=new Date(aa,mm,gg);

            }catch(Exception e)
                    {
                    datanascita=null;
            }


            String pesonascita=request.getParameter("pesonascita");
            String titolostudio=request.getParameter("titolostudio");
            String fumo=request.getParameter("fumo");
            String malattiepers=request.getParameter("malattiepersonali");
            String malattiefam=request.getParameter("malattiefamiliari");
            String osservazioni=request.getParameter("osservazioni");

            //Eseguire controllo dati in input

            Anamnesipartner anamnesi=new Anamnesipartner();
            AnamnesipartnerJpaController controller=new AnamnesipartnerJpaController();

            anamnesi.setNome(nome);
            anamnesi.setCognome(cognome);
            if(!gruppo.equals("0"))
                 anamnesi.setGruppoSangue(gruppo);

            anamnesi.setDataNascita(datanascita);

            if(!pesonascita.equals(""))
            anamnesi.setPesoNascita(Double.parseDouble(pesonascita));

            anamnesi.setTitoloStudio(titolostudio);
            anamnesi.setMalattieFamiliari(malattiefam);
            anamnesi.setMalattiePersonali(malattiepers);
            if(fumo!=null)
                anamnesi.setFumo(Boolean.TRUE);
            else
                anamnesi.setFumo(Boolean.FALSE);

            if(request.getParameter("alcool")!=null)
                anamnesi.setAlcool(Boolean.TRUE);
            else
                anamnesi.setAlcool(false);

            if(request.getParameter("farmaci")!=null)
                anamnesi.setFarmaci(Boolean.TRUE);
            else
                anamnesi.setFarmaci(Boolean.FALSE);
            

            if(!osservazioni.equals(""))
                anamnesi.setOsservazioni(osservazioni);

            controller.create(anamnesi);

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
          ultima.setAnamnesipartner(anamnesi);
          ultima.setData(today);
          CartellaostetricadigitaleJpaController con=new CartellaostetricadigitaleJpaController();
          con.create(ultima);
            
response.sendRedirect("/cod/dottore/VisualizzaPaziente.jsp?codicefiscale="+codf);

         }catch(Exception e){
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
