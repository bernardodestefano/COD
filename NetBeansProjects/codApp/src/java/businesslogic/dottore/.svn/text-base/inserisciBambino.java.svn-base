/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Bambino;
import bean.Cartellaostetricadigitale;
import bean.Graficosinfisidelfondo;
import controller.BambinoJpaController;
import controller.CartellaostetricadigitaleJpaController;
import controller.GraficosinfisidelfondoJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giuseppe
 */
public class inserisciBambino extends HttpServlet {
   
   /**
    *Servlet <x>
    *Descrizione: Questa servlet serve per..
    *Parametri di input:
    *@param <nome campo della form che manda i dati>:
    *<li> formato: <formato del campo>(Stringa, min 1 max 25 caratteri)
    *<li> descrizione: <descrizione informale del campo> (Username dell'account...)
    *...
    *...
    *@param <nome campo della form che manda i dati>:
    *<li> formato: <formato del campo>(Stringa, min 1 max 25 caratteri)
    *<li> descrizione: <descrizione informale del campo> (Username dell'account...)
    *
    *Logica di  controllo:
    *<Inserire la logica di controllo del database>
    */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String bacino=request.getParameter("bacino");
            String corso=request.getParameter("corso");
            String luogoparto=request.getParameter("luogoparto");
            String visitaprodromica=request.getParameter("visitaprodromica");

            out.println("<html><body>"+corso+" "+bacino+"</body></html>");
            Bambino bambino=new Bambino();
            bambino.setCorsoPreparazioneParto(corso);
            bambino.setLuogoPrevistoParto(luogoparto);
            bambino.setVisitaFaseProdromica(visitaprodromica);
            bambino.setValutazioneBacino(bacino);

            Graficosinfisidelfondo grafico=new Graficosinfisidelfondo();
            grafico.setBambino(bambino);
            grafico.setSettimana(0);
            grafico.setCentimetri(0.0);

            BambinoJpaController c=new BambinoJpaController();
            c.create(bambino);
            GraficosinfisidelfondoJpaController c1=new GraficosinfisidelfondoJpaController();
            c1.create(grafico);


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
          ultima.setBambino(bambino);
          ultima.setData(today);
          CartellaostetricadigitaleJpaController con=new CartellaostetricadigitaleJpaController();
          con.create(ultima);

response.sendRedirect("/cod/dottore/VisualizzaPaziente.jsp?codicefiscale="+codf);
            
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
