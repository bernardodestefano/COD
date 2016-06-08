/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Anticoncezionali;
import bean.Cartellaostetricadigitale;
import bean.Storiaginecologica;
import controller.AnticoncezionaliJpaController;
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
public class inserisciAnticoncezionali extends HttpServlet {
    private Storiaginecologica storiaginecologica;
   
   /**
*Servlet anticoncezionali
*Descrizione: in questa servlet avremo la possibità conoscere tutte le info sugli anticoncezionale assunti
*Parametri di input:
*@param seleziona:
*<li> formato: array di  stringhe
*<li> descrizione:contiene i valori settati riguardanti la gli anticoncezionali assunti del paziente
*@param pillola:
*<li> formato: boolean
*<li> descrizione: indica se la la donna fa uso di anticoncezionali di tipo pillola
*@param pillolaTipo:
*<li> formato: stringa(1-45)
*<li> descrizione:indica il tipo di pillola assunto
*@param pillolaDurata:
*<li> formato: int
*<li> descrizione:indica la durata di assunzione della pillola
*@param pillolaEffetti:
*<li> formato: stinga(1-45)
*<li> descrizione: indica gli effetti che la pillola comporta
*@param diaframma:
*<li> formato: boolean(1-45)
*<li> descrizione: indica se si utilizza diaframma come anticoncezionale
*@param diaframmaTipo:
*<li> formato: stringa(1-45)
*<li> descrizione:indica il tipo di diaframma assunto
*@param diaframmaDurata:
*<li> formato: int
*<li> descrizione:indica la durata di assunzione di diaframma
*@param diaframmaEffetti:
*<li> formato: stinga(1-45)
*<li> descrizione: indica gli effetti che diaframma comporta
*@param IUD:
*<li> formato: boolean(1-45)
*<li> descrizione: indica se si utilizza IUD come anticoncezionale
*@param IUDTipo:
*<li> formato: stringa(1-45)
*<li> descrizione:indica il tipo di IUD assunto
*@param IUDDurata:
*<li> formato: int
*<li> descrizione:indica la durata di assunzione di IUD
*@param IUDEffetti:
*<li> formato: stinga(1-45)
*<li> descrizione: indica gli effetti che IUD comporta
*@param altro:
*<li> formato: boolean
*<li> descrizione: indica se si usano altri anticoncezionali
*@param altroTipo:
*<li> formato: stringa(1-45)
*<li> descrizione:indica il tipo di anticoncezionale usato
*@param altroDurata:
*<li> formato: int
*<li> descrizione:indica la durata di assunzione dell'anticoncezionale
*@param altroEffetti:
*<li> formato: stinga(1-45)
*<li> descrizione: indica gli effetti che l'anticoncezionale  ha
*Logica di  controllo:
*dopo aver inserito i dati, controllando i possibili errori avremo un quadro compleato degli,
*anticoncezionali
*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            //avvio la sessione
            HttpSession sessione = request.getSession();

            //creo il bean dedicato e setto i campi
            Anticoncezionali anticoncezionali=new Anticoncezionali();

            if(request.getParameter("pillola")!=null){
                anticoncezionali.setPillola(Boolean.TRUE);
                anticoncezionali.setPillolaTipo(request.getParameter("tipopillola"));
                String x=request.getParameter("tempopillola");
                if(!x.equals(""))
                  anticoncezionali.setPillolaDurata(Integer.parseInt(x));
                anticoncezionali.setPillolaEffetti(request.getParameter("effettipillola"));
            }
            else
                anticoncezionali.setPillola(false);

            if(request.getParameter("iud")!=null){
                anticoncezionali.setIud(Boolean.TRUE);
                anticoncezionali.setIUDTipo(request.getParameter("tipoiud"));
                String x=request.getParameter("tempoiud");
                if(!x.equals(""))
                  anticoncezionali.setIUDDurata(Integer.parseInt(x));
                anticoncezionali.setIUDEffetti(request.getParameter("effettiiud"));
            }
            else
                anticoncezionali.setIud(false);

            if(request.getParameter("diaframma")!=null){
                anticoncezionali.setDiaframma(Boolean.TRUE);
                anticoncezionali.setDiaframaTipo(request.getParameter("tipodiaframma"));
                String x=request.getParameter("tempodiaframma");
                if(!x.equals(""))
                  anticoncezionali.setDiaframmaDurata(Integer.parseInt(x));
                anticoncezionali.setDiaframmaEffetti(request.getParameter("effettidiaframma"));
            }
            else
                anticoncezionali.setDiaframma(false);


            if(request.getParameter("altro")!=null){
                anticoncezionali.setAltro(Boolean.TRUE);
                anticoncezionali.setAltroTipo(request.getParameter("tipoaltro"));
                String x=request.getParameter("tempoaltro");
                if(!x.equals(""))
                  anticoncezionali.setAltroDurata(Integer.parseInt(x));
                anticoncezionali.setAltroEffetti(request.getParameter("effettialtro"));
            }
            else
                anticoncezionali.setAltro(false);


            //creo il controller e inserisco la tupla
            AnticoncezionaliJpaController controller=new AnticoncezionaliJpaController();
            controller.create(anticoncezionali);

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
        ultima.setAnticoncezionali(anticoncezionali);
          ultima.setData(today);
          CartellaostetricadigitaleJpaController con=new CartellaostetricadigitaleJpaController();
          con.create(ultima);
          response.sendRedirect("/cod/dottore/VisualizzaPaziente.jsp?codicefiscale="+codf);

            
        }
        catch(Exception e)
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
