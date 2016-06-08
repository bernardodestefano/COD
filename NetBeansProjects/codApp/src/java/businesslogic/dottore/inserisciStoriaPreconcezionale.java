/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Cartellaostetricadigitale;
import bean.Storiapreconcezionale;
import controller.CartellaostetricadigitaleJpaController;
import controller.StoriapreconcezionaleJpaController;
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
public class inserisciStoriaPreconcezionale extends HttpServlet {
   
   /**
*Servlet inserisciStoriaPreconcezionale
*Descrizione: in questa servlet avremo la possibità conoscere tutte le info sulla storia preconcezionale del paziente
*Parametri di input:
*@param Desiderata:
*<li> formato: boolean
*<li> descrizione: indica se la la gravidanza è stata prevista
*@param ImprevistaDonna:
*<li> formato: boolean
*<li> descrizione:....
*@param ImprevistaPartner:
*<li> formato: boolean
*<li> descrizione:.....
*@param difficolta:
*<li> formato: boolean
*<li> descrizione: indica se esistono difficoltà per il concepimento
*@param accertamentiProvvedimenti:
*<li> formato: stringa(1-45)
*<li> descrizione: indica gli accertamenti fatti
*@param condizioniCoppia:
*<li> formato: stringa(1-45)
*<li> descrizione: indica la condizione della coppia
*Logica di  controllo:
*dopo aver inserito i dati, controllando i possibili errori avremo una tabella che permetterà di avere
*info più precise sulla storia Preconcezionale del paziente
*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            //avvio la sessione
             HttpSession sessione = request.getSession();

             //creo il bean e setto i parametri di input
             Storiapreconcezionale storia=new Storiapreconcezionale();
             
             if(request.getParameter("1")!=null)
                storia.setGravidanzaDesiderataPrevista(true);
             else
                storia.setGravidanzaDesiderataPrevista(false);

             if(request.getParameter("2")!=null)
                storia.setGravidanzaImprevistaAccettazioneDonna(true);
             else
                storia.setGravidanzaImprevistaAccettazioneDonna(false);

             if(request.getParameter("3")!=null)
                 storia.setGravidanzaImprevistaAccettazionePartner(true);
             else
                 storia.setGravidanzaImprevistaAccettazionePartner(false);

             if(request.getParameter("4")!=null)
                 storia.setDifficoltaConcepimento(true);
             else
                 storia.setDifficoltaConcepimento(false);
             
             String condizionicoppia=request.getParameter("condizionicoppia");
             String accertamenti=request.getParameter("accertamentiprovvedimenti");
             storia.setCondizioneCoppia(condizionicoppia);
             storia.setAccertamentiProvvedimenti(accertamenti);

             //creo il controller e inserisco la tupla
             StoriapreconcezionaleJpaController controller=new StoriapreconcezionaleJpaController();
             controller.create(storia);


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
          ultima.setStoriapreconcezionale(storia);
          ultima.setData(today);
          CartellaostetricadigitaleJpaController con=new CartellaostetricadigitaleJpaController();
          con.create(ultima);
          response.sendRedirect("/cod/dottore/VisualizzaPaziente.jsp?codicefiscale="+codf);

        }
        catch(Exception e){
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
