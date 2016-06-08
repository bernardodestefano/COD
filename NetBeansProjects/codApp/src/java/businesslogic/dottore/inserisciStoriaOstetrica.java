/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Cartellaostetricadigitale;
import bean.Storiaostetrica;
import bean.Storiaostretricatabella;
import controller.CartellaostetricadigitaleJpaController;
import controller.StoriaostetricaJpaController;
import controller.StoriaostretricatabellaJpaController;
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
public class inserisciStoriaOstetrica extends HttpServlet {
   
  /**
*Servlet inserisciStoriaOstetrica
*Descrizione: in questa servlet avremo la possibità conoscere tutte le info sulla storia ostetrica del paziente
*Parametri di input:
*@param osservazioni:
*<li> formato: text
*<li> descrizione: indica le osservazioni sulla stora ostetrica del paziente
*Servlet storiaOstetricaTabella
*Descrizione: in questa servlet avremo la possibità conoscere tutte le info sulla storia ostetrica del paziente
*con dati più specifici
*Parametri di input:
*@param anno:
*<li> formato: int
*<li> descrizione:.....
*@param eta:
*<li> formato: int
*<li> descrizione: indica l'epoca in settimane+giorni calcolata dal primo giorno dell'ultima mestruazione.
*@param IVG :
*<li> formato: int
*<li> descrizione:.....
*@param abortoSpontaneo:
*<li> formato: boolean
*<li> descrizione: indica se la donna ha avuto o meno un aborto spontaneo
*@param tipoParto:
*<li> formato: stringa(1-45)
*<li> descrizione: indica la tipologia di parto o parti che la donna ha avuto
*@param luogoParto:
*<li> formato: stringa(1-45)
*<li> descrizione: indica il luogo del parto del bambino
*@param pesoBambino:
*<li> formato: int
*<li> descrizione: indica il peso del bambino
*@param sesso:
*<li> formato: enumerazione
*<li> descrizione: indica il sesso del bambino
*@param condizioni:
*<li> formato: stringa(1-45)
*<li> descrizione: indica tutti i dati riferiti alle condizioni del bambino
*@param tipoallattamento:
*<li> formato: stringa(1-45)
*<li> descrizione: indica la tipologia di allattamento che si è decisi ad usare
*@param durataAllattamento:
*<li> formato: time
*<li> descrizione: indica il periodo di tempo di allattamento
*@param complicazioni:
*<li> formato: stringa(1-45)
*<li> descrizione: indica le complicazioni che ci posso essere state durante la gravidanza
*Logica di  controllo:
*dopo aver inserito i dati, controllando i possibili errori avremo una tabella che permetterà di avere
*info più precise sulla storia ostetrica del paziente
*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            //avvio la sessione
            HttpSession sessione = request.getSession();

            //importo i parametri di input
            String anno=request.getParameter("anno");
            String eta=request.getParameter("eta");
            String ivg=request.getParameter("ivg");
            boolean aborto=false;

            String ab=request.getParameter("aborto");
            

            String tipoparto=request.getParameter("tipoparto");
            String luogoparto=request.getParameter("luogoparto");
            String pesobambino=request.getParameter("pesobambino");
            String sesso=request.getParameter("sesso");
            String condizioni=request.getParameter("condizioni");
            String tipoallattamento=request.getParameter("tipoallattamento");
            String durataallattamento=request.getParameter("durataallattamento");
            //creare data durataallattamento
            String complicazioni=request.getParameter("complicazioni");
            //String osservazioni=request.getParameter("osservazioni");
            
            //Eseguire controllo dati in input

            //creo i bean
            Storiaostetrica storiaostetrica=new Storiaostetrica();
            Storiaostretricatabella storiatabella=new Storiaostretricatabella();

           /* if(!osservazioni.equals(""))
                storiaostetrica.setOsservazioni(osservazioni);*/
            
            if(!anno.equals(""))
            storiatabella.setAnno(Integer.parseInt(anno));

            if(!eta.equals(""))
            storiatabella.setEtaGestionale(Integer.parseInt(eta));

            if(!ivg.equals(""))
            storiatabella.setIvg(Integer.parseInt(ivg));
 
           
            storiatabella.setTipoParto(tipoparto);
            storiatabella.setLuogoParto(luogoparto);

            if(!pesobambino.equals(""))
            storiatabella.setPesoBambino(Integer.parseInt(pesobambino));
            out.print("<html><body>ciao</body></html>");
            storiatabella.setSesso(sesso);
            storiatabella.setCondizioniBambino(condizioni);
            storiatabella.setTipoAllattamento(tipoallattamento);
            if(!durataallattamento.equals(""))
           storiatabella.setDurataAllattamento(null);
            storiatabella.setComplicazioniGravidanza(complicazioni);
            if(ab!=null)
                storiatabella.setAbortoSpontaneo(true);
            else
                storiatabella.setAbortoSpontaneo(false);

            
            
            
            

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
        StoriaostretricatabellaJpaController c1=new StoriaostretricatabellaJpaController();
        storiatabella.setStoriaostetrica(ultima.getStoriaostetrica());
        c1.create(storiatabella);

          out.println("<html><body>codf="+codf+" size lista="+lista.size()+" size lista filtrata= "+listafiltrata.size()+"ultima data="+ultima.getData()+"</body></html>");

        Date today=new Date();
        ultima.setData(today);
        CartellaostetricadigitaleJpaController con=new CartellaostetricadigitaleJpaController();
        con.create(ultima);
        response.sendRedirect("/cod/dottore/VisualizzaPaziente.jsp?codicefiscale="+codf);

       
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
