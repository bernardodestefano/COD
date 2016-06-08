/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Cartellaostetricadigitale;
import bean.Storiamestruale;
import controller.CartellaostetricadigitaleJpaController;
import controller.StoriamestrualeJpaController;
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
public class inserisciStoriaMestruale extends HttpServlet {
   
  /**
*Servlet inseriscistoriaMestruale
*Descrizione: in questa servlet avremo la possibità conoscere tutte le info sulla storia mestruale del paziente
*Parametri di input:
*@param menarca:
*<li> formato: int
*<li> descrizione: indica l'età del primo ciclo mestruale del paziente
*@param ritmo :
*<li> formato: int
*<li> descrizione: indica il ritmo del ciclo del paziente
*@param durata:
*<li> formato: int
*<li> descrizione: indica la media della durata del ciclo
*@param quantità:
*<li> formato: stringa(1-45)
*<li> descrizione: indica la quantità delle perdite mestruali
*@param dismorrea:
*<li> formato: stringa(1-45)
*<li> descrizione: indica la dismorrea o mestruazione dolorosa del paziente
*Logica di  controllo:
*dopo aver inserito i dati, controllando i possibili errori avremo una tabella che permetterà di avere
*info più precise sulla storia mestruale del paziente
*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            //avvio la sessione
            HttpSession sessione = request.getSession();

            //importo i parametri di input
            String menarca=request.getParameter("menarca");
            String ritmo=request.getParameter("ritmo");
            String durata=request.getParameter("durata");
            String quantita=request.getParameter("quantita");
            String dismerronea=request.getParameter("dismerronea");

            //Eseguire controllo dati in input

            //creo il bean dedicato e setto i campi
            Storiamestruale storia=new Storiamestruale();

            try{
                if(!menarca.equals(""))
             storia.setMenarca(Integer.parseInt(menarca));
            }catch(Exception e)
                    {storia.setMenarca(0);
                     }
            

           try{
           if(!ritmo.equals(""))
             storia.setRitmo(Integer.parseInt(ritmo));
             }
           catch(Exception e)
           {
                storia.setRitmo(0);
           }

            try{
            if(!durata.equals(""))
                storia.setDurata(Integer.parseInt(durata));
            }catch(Exception e)
                    {
                storia.setDurata(0);
            }
            
            storia.setQuantita(quantita);
            storia.setDismorrea(dismerronea);

             //creo il controller e inserisco la tupla
            StoriamestrualeJpaController controller=new StoriamestrualeJpaController();
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
         ultima.setStoriamestruale(storia);
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
            }finally {
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
