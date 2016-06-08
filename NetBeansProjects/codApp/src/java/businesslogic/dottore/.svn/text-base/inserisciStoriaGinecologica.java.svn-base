/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Cartellaostetricadigitale;
import bean.Storiaginecologica;
import bean.Storiamestruale;
import controller.CartellaostetricadigitaleJpaController;
import controller.StoriaginecologicaJpaController;
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
public class inserisciStoriaGinecologica extends HttpServlet {
    private Storiamestruale storia;
   
   /**
*Servlet storiaGinecologica
*Descrizione: in questa servlet verranno inseriti i dati riguardanti alla storia ginecologica del paziente
*Parametri di input:
*@param seleziona:
*<li> formato: array di  stringhe
*<li> descrizione:contiene i valori settati riguardanti la soria ginecologica del paziente
*@param papTest:
*<li> formato: boolean
*<li> descrizione: indica se è stato effettuato un paptest
*@param papTestDataUltimo:
*<li> formato: date
*<li> descrizione: indica la data dell'ultimopaptest
*@param colposcopia:
*<li> formato: boolean
*<li> descrizione: indica se è stata effettuata la colposcopia
*@param colposcopiaData:
*<li> formato: date
*<li> descrizione: indica la data della coloscopia
*@param patologiaMammella:
*<li> formato: boolean
*<li> descrizione: indica se si hanno patologia alle mammelle
*@param interventiChirurgici:
*<li> formato: stringa(1-45)
*<li> descrizione: indica gli interventi chirugici sostenuti
*Logica di  controllo:
*dopo aver inserito i dati, controllando i possibili errori avremo una tabella che permetterà di avere
*info più precise sulla storia ginecologica
*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            //avvio la sessione
            HttpSession sessione = request.getSession();
            
            //creo il bean dedicato e setto i campi
            Storiaginecologica storiaginecologica=new Storiaginecologica();


             //importo i parametri di input
            if(request.getParameter("paptest")!=null){
                storiaginecologica.setPapTest(Boolean.TRUE);
                String x=request.getParameter("dataultimopaptest");
                //Controllo data

                Date datapap;
                
                try{
                        int gg=0;
                        int mm=0;
                        int aa=0;
                        String g="",m="",a="";
                        g=x.substring(0, 2);
                        m=x.substring(3,5);
                        a=x.substring(6,10);
                        gg=Integer.parseInt(g);
                        mm=Integer.parseInt(m)-1;
                        aa=Integer.parseInt(a)-1000;
                        datapap=new Date(aa,mm,gg);

                }catch(Exception e)
                {
                    datapap=null;
                }

           
                storiaginecologica.setPapTestDataUltimo(datapap);
                storiaginecologica.setPapTestEsito(request.getParameter("esitopaptest"));
            }
            else
                storiaginecologica.setPapTest(false);

            if(request.getParameter("colposcopia")!=null)
                {
                storiaginecologica.setColposcopia(Boolean.TRUE);
                String x=request.getParameter("datacolposcopia");
                Date datapap;

                try{
                        int gg=0;
                        int mm=0;
                        int aa=0;
                        String g="",m="",a="";
                        g=x.substring(0, 2);
                        m=x.substring(3,5);
                        a=x.substring(6,10);
                        gg=Integer.parseInt(g);
                        mm=Integer.parseInt(m)-1;
                        aa=Integer.parseInt(a)-1000;
                        datapap=new Date(aa,mm,gg);

                }catch(Exception e)
                {
                    datapap=null;
                }
                storiaginecologica.setColposcopiaData(datapap);

            }
            else
               storiaginecologica.setColposcopia(false);

            if(request.getParameter("patologia")!=null)
                {
                storiaginecologica.setPatalogiaMammella(true);
            }
            else
                storiaginecologica.setPatalogiaMammella(false);


            String interventi=request.getParameter("interventichirurgici");
            storiaginecologica.setInterventiChirurgici(interventi);

             //creo il controller e inserisco la tupla
            StoriaginecologicaJpaController controller=new StoriaginecologicaJpaController();
            controller.create(storiaginecologica);
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
        ultima.setStoriaginecologica(storiaginecologica);
          ultima.setData(today);
          CartellaostetricadigitaleJpaController con=new CartellaostetricadigitaleJpaController();
          con.create(ultima);
            response.sendRedirect("/cod/dottore/VisualizzaPaziente.jsp?codicefiscale="+codf);
        }
        catch(Exception e)
                {
                 out.println("<html><body>");
                 e.printStackTrace();
                 out.println("</body></html");
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
