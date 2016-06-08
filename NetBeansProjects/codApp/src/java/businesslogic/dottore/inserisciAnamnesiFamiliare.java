/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesslogic.dottore;

import bean.Anamnesifamiliare;
import bean.AnamnesifamiliareHasMalattiefamiliari;
import bean.AnamnesifamiliareHasMalattiefamiliariPK;
import bean.Cartellaostetricadigitale;
import bean.Datiautenticazione;
import bean.Malattiefamiliari;
import bean.Paziente;
import controller.AnamnesifamiliareHasMalattiefamiliariJpaController;
import controller.AnamnesifamiliareJpaController;
import controller.CartellaostetricadigitaleJpaController;
import controller.DatiautenticazioneJpaController;
import controller.MalattiefamiliariJpaController;
import controller.PazienteJpaController;
import controller.exceptions.PreexistingEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
public class inserisciAnamnesiFamiliare extends HttpServlet {
   


 /**
*Servlet inserisciAnamnesiFamiliare
*Descrizione: Questa servlet serve per gestire i dati riguardanti le anamnesi personali dei familiari di ogni singolo
paziente.
*Parametri di input:
*@param osservazioni:
*<li> formato: text
*<li> descrizione:indica tutte le osservazioni riguardanti l'anamnesi di un familiare
*@param malattie:
*<li> formato: array di  stringhe
*<li> descrizione: il nome indica le malattie (allergie,cancro,cardiopatite,diabete,epilessia,gemellarità,
* ipertenzione,malattie psichiatriche,malattie renali,malformazioni congenite,varici)all'interno ci saranno
*due campi uno "nome malattia fam" che destrive il familiare e "nome malattia det" i dettagli della malattia
*Logica di  controllo:
*dopo aver inserito i dati controllando i possibili errori le malattie saranno registrate
*/


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            //avvio la sessione
             HttpSession sessione = request.getSession();
             
             
            //creo i controller
             AnamnesifamiliareHasMalattiefamiliariJpaController contr=new AnamnesifamiliareHasMalattiefamiliariJpaController();
             MalattiefamiliariJpaController controller=new MalattiefamiliariJpaController();
             AnamnesifamiliareJpaController controlleranamnesi=new AnamnesifamiliareJpaController();
            
             
            
             String osservazioni=request.getParameter("osservazioni");

             
             Anamnesifamiliare anamnesi=new Anamnesifamiliare();
             anamnesi.setOsservazioni(osservazioni);
             
             
             controlleranamnesi.create(anamnesi);
             
             AnamnesifamiliareHasMalattiefamiliari an;

             
              //prelevo tutti i parametri in input e registro le tuple
              //Eseguire controllo dati in input

             List<Malattiefamiliari> malattie= controller.findMalattiefamiliariEntities();
             int i=0;
             out.println("<html><body>"+malattie.size()+"</body></html>");
             while(i<malattie.size())
             {
               Malattiefamiliari m=malattie.get(i);
               if(m.getNome().equals("allergie"))
                   {
                        String allergiefam=request.getParameter("allergiefamiliare");
                        String allergiedett=request.getParameter("allergiedettagli");
                       
                        an=new AnamnesifamiliareHasMalattiefamiliari();
                        an.setFamiliare(allergiefam);
                        an.setInizioEDettagli(allergiedett);
                        an.setMalattiefamiliari(m);
                        an.setAnamnesifamiliare(anamnesi);
                        

                    try {
                        contr.create(an);
                    } catch (PreexistingEntityException ex) {
                        out.println("<html><body>"+ex+"</body></html>");
                        Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        out.println("<html><body>"+ex+"</body></html>");
                        Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   }
               
               else
               if(m.getNome().equals("altro"))
                   {
                         String altrofam=request.getParameter("altrofamiliare");
                         String altrodett=request.getParameter("altrodettagli");
                         an=new AnamnesifamiliareHasMalattiefamiliari();
                         an.setMalattiefamiliari(m);
                         an.setAnamnesifamiliare(anamnesi);
                         an.setFamiliare(altrofam);
                         an.setInizioEDettagli(altrodett);
                          try {
                        contr.create(an);
                          } catch (PreexistingEntityException ex) {
                               out.println("<html><body>"+ex+"</body></html>");
                        Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                        Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   }
               else
               if(m.getNome().equals("cancro"))
                   {

                         String cancrofam=request.getParameter("cancrofamiliare");
                         String cancrodett=request.getParameter("cancrodettagli");
                         an=new AnamnesifamiliareHasMalattiefamiliari();
                         an.setMalattiefamiliari(m);
                         an.setAnamnesifamiliare(anamnesi);
                         an.setFamiliare(cancrofam);
                         an.setInizioEDettagli(cancrodett);
                          try {
                        contr.create(an);
                            } catch (PreexistingEntityException ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                else
                if(m.getNome().equals("cardiopatie"))
                    {
                        String cardiopatiefam=request.getParameter("cardiopatiefamiliare");
                        String cardiopatiedett=request.getParameter("cardiopatiedettagli");
                        an=new AnamnesifamiliareHasMalattiefamiliari();
                        an.setMalattiefamiliari(m);
                        an.setAnamnesifamiliare(anamnesi);
                        an.setFamiliare(cardiopatiefam);
                        an.setInizioEDettagli(cardiopatiefam);
                         try {
                           contr.create(an);
                            } catch (PreexistingEntityException ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                else
                if(m.getNome().equals("diabete"))
                    {
                        String diabetefam=request.getParameter("diabetefamiliare");
                        String diabetedett=request.getParameter("diabetedettagli");
                        an=new AnamnesifamiliareHasMalattiefamiliari();
                        an.setMalattiefamiliari(m);
                        an.setAnamnesifamiliare(anamnesi);
                        an.setFamiliare(diabetefam);
                        an.setInizioEDettagli(diabetedett);
                         try {
                                contr.create(an);
                            } catch (PreexistingEntityException ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                else
                if(m.getNome().equals("epilessia"))
                    {
                        String epilessiafam=request.getParameter("epilessiafamiliare");
                        String epilessiadett=request.getParameter("epilessiadettagli");
                        an=new AnamnesifamiliareHasMalattiefamiliari();
                        an.setMalattiefamiliari(m);
                        an.setAnamnesifamiliare(anamnesi);
                        an.setFamiliare(epilessiafam);
                        an.setInizioEDettagli(epilessiadett);
                         try {
                                contr.create(an);
                            } catch (PreexistingEntityException ex) {

                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                             }
                    }
                else
                if(m.getNome().equals("gemellarità"))
                    {
                        String gemellaritafam=request.getParameter("gemellaritafamiliare");
                        String gemellaritadett=request.getParameter("gemellaritadettagli");
                        an=new AnamnesifamiliareHasMalattiefamiliari();
                        
                        an.setMalattiefamiliari(m);
                        an.setAnamnesifamiliare(anamnesi);
                        an.setFamiliare(gemellaritafam);
                        an.setInizioEDettagli(gemellaritadett);
                         try {
                                contr.create(an);
                            } catch (PreexistingEntityException ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                else
                if(m.getNome().equals("ipertensione"))
                    {
                        String ipertensionefam=request.getParameter("ipertensionefamiliare");
                        String ipertensionedett=request.getParameter("ipertensionedettagli");
                        an=new AnamnesifamiliareHasMalattiefamiliari();
                        an.setMalattiefamiliari(m);
                        an.setAnamnesifamiliare(anamnesi);
                        an.setFamiliare(ipertensionefam);
                        an.setInizioEDettagli(ipertensionedett);
                         try {
                                contr.create(an);
                            } catch (PreexistingEntityException ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                else
                if(m.getNome().equals("malattie psichiatriche"))
                    {
                        String malattiepsichiatrichefam=request.getParameter("malattiepsichiatrichefamiliare");
                        String malattiepsichiatrichedett=request.getParameter("malattiepsichiatrichedettagli");
                        an=new AnamnesifamiliareHasMalattiefamiliari();
                        an.setMalattiefamiliari(m);
                        an.setAnamnesifamiliare(anamnesi);
                        an.setFamiliare(malattiepsichiatrichefam);
                        an.setInizioEDettagli(malattiepsichiatrichedett);
                         try {
                                contr.create(an);
                            } catch (PreexistingEntityException ex) {
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                else
                if(m.getNome().equals("malattie renali"))
                    {
                        String malattierenalifam=request.getParameter("malattierenalifamiliare");
                        String malattierenalidett=request.getParameter("malattierenalidettagli");
                        an=new AnamnesifamiliareHasMalattiefamiliari();
                        an.setMalattiefamiliari(m);
                        an.setAnamnesifamiliare(anamnesi);
                        an.setFamiliare(malattierenalifam);
                        an.setInizioEDettagli(malattierenalidett);
                         try {
                                contr.create(an);
                            } catch (PreexistingEntityException ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                else
                if(m.getNome().equals("malformazioni congenite"))
                    {
                        String malformazionifam=request.getParameter("malformazionifamiliare");
                        String malformazionidett=request.getParameter("malformazionidettagli");
                        an=new AnamnesifamiliareHasMalattiefamiliari();
                        an.setMalattiefamiliari(m);
                        an.setAnamnesifamiliare(anamnesi);
                        an.setFamiliare(malformazionifam);
                        an.setInizioEDettagli(malformazionidett);
                         try {
                                contr.create(an);
                            } catch (PreexistingEntityException ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                else
                if(m.getNome().equals("varici"))
                    {
                         String varicifam=request.getParameter("varicifamiliare");
                         String varicidett=request.getParameter("varicidettagli");
                         an=new AnamnesifamiliareHasMalattiefamiliari();
                         an.setMalattiefamiliari(m);
                         an.setAnamnesifamiliare(anamnesi);
                         an.setFamiliare(varicifam);
                         an.setInizioEDettagli(varicidett);
                          try {
                                contr.create(an);
                            } catch (PreexistingEntityException ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                 out.println("<html><body>"+ex+"</body></html>");
                                Logger.getLogger(inserisciAnamnesiFamiliare.class.getName()).log(Level.SEVERE, null, ex);
                            }

                    }


              
               
               



            
             i++;}
           //response.sendRedirect("/cod/dottore/VisualizzaPaziente.php?codicefiscale=");
              //creo nuova cartella ostetrica
            String codf=request.getParameter("codicefiscale");
            CartellaostetricadigitaleJpaController cod=new CartellaostetricadigitaleJpaController();
            List<Cartellaostetricadigitale> lista=cod.findCartellaostetricadigitaleEntities();
            
            List<Cartellaostetricadigitale> listafiltrata=new ArrayList<Cartellaostetricadigitale>();
            i=0;
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
          ultima.setAnamnesifamiliare(anamnesi);
          ultima.setData(today);
          CartellaostetricadigitaleJpaController con=new CartellaostetricadigitaleJpaController();
          con.create(ultima);
          response.sendRedirect("/cod/dottore/VisualizzaPaziente.jsp?codicefiscale="+codf);

        }

           
             
           catch(Exception ee)
           {

               out.println("<html><body>"+ee+"</body></html>");
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

