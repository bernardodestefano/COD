
<%@page import="controller.BambinoJpaController"%>
<%@page import="controller.StoriaostretricatabellaJpaController"%>
<%@page import="controller.StoriaostetricaJpaController"%>
<%@page import="controller.StoriapreconcezionaleJpaController"%>
<%@page import="controller.AnticoncezionaliJpaController"%>
<%@page import="controller.StoriaginecologicaJpaController"%>
<%@page import="controller.StoriamestrualeJpaController"%>
<%@page import="controller.AbitudinidivitaJpaController"%>
<%@page import="controller.AnamnesipartnerJpaController"%>
<%@page import="controller.AnamnesifamiliareHasMalattiefamiliariJpaController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="controller.CartellaostetricadigitaleJpaController"%>
<%@page import="controller.AnamnesifamiliareJpaController"%>
<%@page import="controller.DatiautenticazioneJpaController"%>
<%@page import="controller.PazienteJpaController"%>
<%@page import="bean.*"%>
<%@page import="bean.Cartellaostetricadigitale"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Documento senza titolo</title>
<style type="text/css">
<!--
body {
	background-color: #EBEDEC;
}

th{
	background-color:#FFFF66;
}
-->
</style></head>

<body>
<% String codf=request.getParameter("codicefiscale");
    PazienteJpaController paziente=new PazienteJpaController();
	Paziente p=paziente.findPaziente(codf);
    if(!codf.equals("")){
     boolean bB=false;
     List<Paziente> listas=paziente.findPazienteEntities();
     for(int l=0;l<listas.size();l++){
     if(listas.get(l).getCodiceFiscale().equals(codf))
        bB=true;
     }


	
    %>
<table align="center">
  <!--DWLayoutTable-->
  <tr>
    <td align="center" valign="middle"><img src="LogoCOD.png" width="213" height="136" />
    </td>
  </tr>
</table>
<%if(bB)
        {%>
<form action="/cod/businesslogic/dottore/modificaDatiPersonali" method="post">
<%
        DatiautenticazioneJpaController dati=new DatiautenticazioneJpaController();
        Datiautenticazione d=dati.findDatiautenticazione(p.getDatiautenticazione().getUsername());


        
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


         
         List l=listafiltrata;
         int s=l.size();
         Cartellaostetricadigitale[] cart=new Cartellaostetricadigitale[s];
         for(i=0;i<s;i++)
            {
              cart[i]=(Cartellaostetricadigitale)l.get(i);
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

        for(i=0;i<l.size();i++)
            l.remove(i);

        for( i=0;i<cart.length;i++)
            {
                l.add(i, cart[i]);
            }


       Cartellaostetricadigitale ultima=null;


         if(cart.length!=0)
             ultima=cart[cart.length-1];
       AnamnesifamiliareJpaController af=new AnamnesifamiliareJpaController();
       Anamnesifamiliare anamnesifam=af.findAnamnesifamiliare(ultima.getAnamnesifamiliare().getId());
       AnamnesifamiliareHasMalattiefamiliariJpaController c=new AnamnesifamiliareHasMalattiefamiliariJpaController();
       AnamnesipartnerJpaController c1=new AnamnesipartnerJpaController();
       AbitudinidivitaJpaController c2=new AbitudinidivitaJpaController();
       StoriamestrualeJpaController c3=new StoriamestrualeJpaController();
       StoriaginecologicaJpaController c4=new StoriaginecologicaJpaController();
       AnticoncezionaliJpaController c5=new AnticoncezionaliJpaController();
       StoriapreconcezionaleJpaController c6=new StoriapreconcezionaleJpaController();
       StoriaostetricaJpaController c7=new StoriaostetricaJpaController();
       BambinoJpaController c9=new BambinoJpaController();

          
%>
  <table width="800" border="0" align="center">
    <tr>
      <th colspan="4" scope="col">DATI PERSONALI</th>
    </tr>
    <tr>
      <td colspan="4"><hr /></td>
    </tr>
    <tr>
      <td>Nome</td>
      <td><input type="hidden" name="codicefiscale" value="<%out.print(codf);%>">
        <input type="text" name="nome" id="textfield144" 
               value="<%out.print(p.getNome());%>"/></td>
      <td>Cognome</td>
      <td>
        <input type="text" name="cognome" id="textfield145"
                 value="<%out.print(p.getCognome());%>"/></td>
    </tr>
    <tr>
      <td>Indirizzo</td>
      <td><label for="textfield146"></label>
        <input type="text" name="indirizzo" id="textfield146"
                 value="<%out.print(p.getIndirizzo());%>"/></td>
      <td>Telefono</td>
      <td><label for="textfield147"></label>
        <input type="text" name="telefono" id="textfield147"
               value="<%out.print(String.valueOf(p.getTelefono()));%>"/></td>
    </tr>
    <tr>
      <td>Data di nascita</td>
      <td><label for="textfield148"></label>
        <input type="text" name="datadinascita" id="textfield148"
                 value="<%out.print(p.getDataNascita());%>"/></td>
      <td>Luogo di nascita</td>
      <td><label for="textfield149"></label>
        <input type="text" name="luogodinascita" id="textfield149"
                 value="<%out.print(p.getLuogoNascita());%>"/></td>
    </tr>
    <tr>
      <td>Titolo di studio</td>
      <td><label for="textfield150"></label>
        <input type="text" name="titolodistudio" id="textfield150"
                 value="<%out.print(p.getTitoloStudi());%>"/></td>
      <td>Professione</td>
      <td><label for="textfield151"></label>
        <input type="text" name="professione" id="textfield151"
                 value="<%out.print(p.getProfessione());%>"/></td>
    </tr>
    <tr>
      <td>Stato Civile</td>
      <td>
        <select name="statocivile" id="select6">
       
        <option value="nubile">nubile</option>
        <option value="coniugata">coniugata</option>
      </select></td>
      <td>Codice Fiscale</td>
      <td><label for="textfield153"></label>
          <input name="codicefiscale" type="text" id="textfield153" maxlength="16" disabled
                   value="<%out.print(p.getCodiceFiscale());%>"/></td>
    </tr>
    <tr>
      <td>Data del matrimonio</td>
      <td><label for="nome"></label>
      <input type="text" name="datamatrimonio" id="datamatrimonio"
               value="<%out.print(p.getDataMatrimonio());%>"/></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="4"><hr /></td>
    </tr>
    <tr>
    	<td>Username:
        </td>
        <td>
      <input name="username" type="text" disabled
               value="<%out.print(d.getUsername());%>"/></td>
        <td>Password:
        </td>
        <td>
        <input name="password" type="password" disabled
               value="<%out.print(d.getPassword());%>"/></td>
    </tr>
    <tr>
      <td colspan="4"><hr /></td>
    </tr>
  </table>
</form>
<p>
<form action="/cod/businesslogic/dottore/inserisciAnamnesiFamiliare" method="post">
  <table width="800" border="0" align="center">
    <tr>
      <th colspan="3" scope="col">ANAMNESI FAMILIARE</th>
    </tr>
    <tr>
    <td colspan="3"> <hr />
    </td>
    </tr>
    <tr align="center">
      <td width="247">&nbsp;</td>
      <td width="255">Familiare</td>
      <td width="284">Inizio e Dettagli</td>
    </tr>
    <tr>
      <td>DIABETE</td>
      <td align="center"><input type="hidden" name="codicefiscale" value="<%out.print(codf);%>">
      <input type="text" name="diabetefamiliare" id="diabetefamiliare"
             value="<% AnamnesifamiliareHasMalattiefamiliariPK pk;
             AnamnesifamiliareHasMalattiefamiliari anamnehas;
             pk=new AnamnesifamiliareHasMalattiefamiliariPK(anamnesifam.getId(), "diabete");
                   anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
            if(anamnehas!=null)out.print(anamnehas.getFamiliare());%>"
             /></td>
      <td align="center"><label for="diabetedettagli"></label>
      <input type="text" name="diabetedettagli" id="diabetedettagli"
             value="<% if(anamnehas!=null)out.print(anamnehas.getInizioEDettagli());%>"/></td>
    </tr>
    <tr>
      <td>IPERTENSIONE</td>
      <td align="center"><label for="ipertensionefamiliare"></label>
      <input type="text" name="ipertensionefamiliare" id="ipertensionefamiliare"
             value="<% pk=new AnamnesifamiliareHasMalattiefamiliariPK(anamnesifam.getId(), "ipertensione");
                   anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getFamiliare());%>"/></td>
      <td align="center"><label for="ipertensionedettagli"></label>
      <input type="text" name="ipertensionedettagli" id="ipertensionedettagli"
             value="<%
                    anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getInizioEDettagli());%>"/></td>
    </tr>
    <tr>
      <td>GEMELLARITA'</td>
      <td align="center"><label for="gemellaritafamiliare"></label>
      <input type="text" name="gemellaritafamiliare" id="gemellaritafamiliare"
             value="<% pk=new AnamnesifamiliareHasMalattiefamiliariPK(anamnesifam.getId(), "gemellarità");
                   anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getFamiliare());%>"/></td>
      <td align="center"><label for="gemellaritadettagli"></label>
      <input type="text" name="gemellaritadettagli" id="gemellaritadettagli"
             value="<%
                    anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getInizioEDettagli());%>"/></td>
    </tr>
    <tr>
      <td>MALFORMAZIONI CONGENITE</td>
      <td align="center"><label for="malformazionifamiliare"></label>
      <input type="text" name="malformazionifamiliare" id="malformazionifamiliare"
             value="<% pk=new AnamnesifamiliareHasMalattiefamiliariPK(anamnesifam.getId(), "malformazioni congenite");
                   anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getFamiliare());%>"/></td>
      <td align="center"><label for="malformazionidettagli"></label>
      <input type="text" name="malformazionidettagli" id="malformazionidettagli"
              value="<%
                    anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getInizioEDettagli());%>"/></td>
    </tr>
    <tr>
      <td>VARICI</td>
      <td align="center"><label for="varicifamiliare"></label>
      <input type="text" name="varicifamiliare" id="varicifamiliare"
              value="<% pk=new AnamnesifamiliareHasMalattiefamiliariPK(anamnesifam.getId(), "varici");
                   anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getFamiliare());%>"/></td>
      <td align="center"><label for="varicidettagli"></label>
      <input type="text" name="varicidettagli" id="varicidettagli"
             value="<%
                    anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getInizioEDettagli());%>"/></td>
    </tr>
    <tr>
      <td>ALLERGIE</td>
      <td align="center"><label for="allergiefamiliare"></label>
      <input type="text" name="allergiefamiliare" id="allergiefamiliare"
             value="<% pk=new AnamnesifamiliareHasMalattiefamiliariPK(anamnesifam.getId(), "allergie");
                   anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getFamiliare());%>"/></td>
      <td align="center"><label for="allergiedettagli"></label>
      <input type="text" name="allergiedettagli" id="allergiedettagli"
             value="<%
                    anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getInizioEDettagli());%>"/></td>
    </tr>
    <tr>
      <td>CANCRO</td>
      <td align="center"><label for="cancrofamiliare"></label>
      <input type="text" name="cancrofamiliare" id="cancrofamiliare"
             value="<% pk=new AnamnesifamiliareHasMalattiefamiliariPK(anamnesifam.getId(), "cancro");
                   anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getFamiliare());%>"/></td>
      <td align="center"><label for="cancrodettagli"></label>
      <input type="text" name="cancrodettagli" id="cancrodettagli"
             value="<%
                    anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getInizioEDettagli());%>"/></td>
    </tr>
    <tr>
      <td>CARDIOPATIE</td>
      <td align="center"><label for="cardiopatiefamiliare"></label>
      <input type="text" name="cardiopatiefamiliare" id="cardiopatiefamiliare"
             value="<% pk=new AnamnesifamiliareHasMalattiefamiliariPK(anamnesifam.getId(), "cardiopatie");
                   anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getFamiliare());%>"/></td>
      <td align="center"><label for="cardiopatiedettagli"></label>
      <input type="text" name="cardiopatiedettagli" id="cardiopatiedettagli"
             value="<%anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getInizioEDettagli());%>"/></td>
    </tr>
    <tr>
      <td>MALATTIE RENALI</td>
      <td align="center"><label for="malattierenalifamiliare"></label>
      <input type="text" name="malattierenalifamiliare" id="malattierenalifamiliare"
             value="<% pk=new AnamnesifamiliareHasMalattiefamiliariPK(anamnesifam.getId(), "malattie renali");
                   anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getFamiliare());%>"/></td>
      <td align="center"><label for="malattierenalidettagli"></label>
      <input type="text" name="malattierenalidettagli" id="malattierenalidettagli"
             value="<%anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getInizioEDettagli());%>"/></td>
    </tr>
    <tr>
      <td>EPILESSIA</td>
      <td align="center"><label for="epilessiafamiliare"></label>
      <input type="text" name="epilessiafamiliare" id="epilessiafamiliare"
             value="<% pk=new AnamnesifamiliareHasMalattiefamiliariPK(anamnesifam.getId(), "epilessia");
                   anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getFamiliare());%>"/></td>
      <td align="center"><label for="epilessiadettagli"></label>
      <input type="text" name="epilessiadettagli" id="epilessiadettagli"
             value="<%anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getInizioEDettagli());%>"/></td>
    </tr>
    <tr>
      <td>MALATTIE PSICHIATRICHE</td>
      <td align="center"><label for="malattiepsichiatrichefamiliare"></label>
      <input type="text" name="malattiepsichiatrichefamiliare" id="malattiepsichiatrichefamiliare"
              value="<% pk=new AnamnesifamiliareHasMalattiefamiliariPK(anamnesifam.getId(), "malattie psichiatriche");
                   anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getFamiliare());%>"/></td>
      <td align="center"><label for="malattiepsichiatrichedettagli"></label>
      <input type="text" name="malattiepsichiatrichedettagli" id="malattiepsichiatrichedettagli"
             value="<%anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getInizioEDettagli());%>"/></td>
    </tr>
    <tr>
      <td>ALTRO</td>
      <td align="center"><label for="altrofamiliare"></label>
      <input type="text" name="altrofamiliare" id="altrofamiliare"
             value="<% pk=new AnamnesifamiliareHasMalattiefamiliariPK(anamnesifam.getId(), "altro");
                   anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getFamiliare());%>"/></td>
      <td align="center"><label for="altrodettagli"></label>
      <input type="text" name="altrodettagli" id="altrodettagli"
              value="<%anamnehas=c.findAnamnesifamiliareHasMalattiefamiliari(pk);
                    if(anamnehas!=null)out.print(anamnehas.getInizioEDettagli());%>"/></td>
    </tr>
    <tr>
      <td>Osservazioni</td>
      <td colspan="2"><label for="osservazioni"></label>
      <textarea name="osservazioni" id="osservazioni" cols="75" rows="3"><% out.print(anamnesifam.getOsservazioni());%></textarea></td>
    </tr>
    <tr>
      <td colspan="3"><hr /></td>
    </tr>
    <tr>
      <td colspan="3" align="center"><input type="submit" name="button13" id="button13" value="Modifica Anamnesi Familiare" /></td>
    </tr>
     <tr>
    <td colspan="3"> <hr />
    </td>
    </tr>
  </table>
</form>
<p>
<form  action="/cod/businesslogic/dottore/inserisciAnamnesiPartner" method="post">
<table width="800" border="0" align="center">
  <tr>
    <th colspan="4"  bgcolor="#FFFF66" align="center">ANAMNESI DEL PARTNER</th>
    </tr>
  <tr>
    <td><input type="hidden" name="codicefiscale" value="<%out.print(codf);%>">Nome:
      <input name="nome" type="text" id="nome" size="15"
             value="<% Anamnesipartner anam=c1.findAnamnesipartner(ultima.getAnamnesipartner().getId());
             out.print(anam.getNome());

    %>"/>
    </td>
    <td>Cognome:
      
        <input name="cognome" type="text" id="cognome" size="15"
             value="<%
                    
                    out.print(anam.getCognome());
    %>"  />
      </td>
    <td colspan="2">Gruppo Sangue:
      <select name="grupposanguigno">
          <%out.print("<option value='"+anam.getGruppoSangue()+"'>"+anam.getGruppoSangue()+"</option>");%>
        <option value="0" >seleziona</option>
        <option value="Apositivo">Apositivo</option>
        <option value="Anegativo">Anegativo</option>
        <option value="BPositivo">BPositivo</option>
        <option value="Bnegativo">Bnegativo</option>
        <option value="0positivo">0positivo</option>
        <option value="0negativo">0negativo</option>
        <option value="ABpositivo">ABpositivo</option>
        <option value="ABnegativo">ABnegativo</option>
      </select></td>
    </tr>
  <tr>
    <td width="190">Data nascita:
      <label for="datanascita"></label>
      <input name="datanascita" type="text" id="datanascita" size="10"
           value="<%
             out.print(anam.getDataNascita());

    %>"  /></td>
    <td width="221">Peso Nascita:
      <label for="textfield3"></label>
      <input name="pesonascita" type="text" id="textfield3" size="10"
             value="<%
             out.print(anam.getPesoNascita());

    %>"/></td>
    <td width="172">&nbsp;</td>
    <td width="199">&nbsp;</td>
  </tr>
  <tr>
    <td>Titolo di studio:</td>
    <td><label for="titolostudio"></label>
      <input type="text" name="titolostudio" id="titolostudio"
             value="<%
             out.print(anam.getTitoloStudio());

    %>"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><hr /></td>
    </tr>
  <tr>
    <td><input name="fumo" type="checkbox" id="fumo" value="si"
               <%
               if(anam.getFumo()!=null)
                if(anam.getFumo())out.print("checked");%>
                />
      <label for="fumo">FUMO</label></td>
    <td><input name="alcool" type="checkbox" id="alcool" value="alcool"  <% if(anam.getAlcool()!=null)if(anam.getAlcool())out.print("checked");%>/>
      <label for="fumo">ALCOOL</label></td>
    <td><input name="farmaci" type="checkbox" id="farmaci" value="farmaci"  <% if(anam.getFarmaci()!=null)if(anam.getFarmaci())out.print("checked");%> />
      <label for="fumo">FARMACI</label></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><hr /></td>
    </tr>
  <tr>
    <td>Malattie familiari:</td>
    <td><label for="malattiefamiliari"></label>
      <input type="text" name="malattiefamiliari" id="malattiefamiliari"
             value="<%
             out.print(anam.getMalattieFamiliari());

    %>"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Malattie personali:</td>
    <td><label for="malattiepersonali"></label>
      <input type="text" name="malattiepersonali" id="malattiepersonali"
             value="<%
             out.print(anam.getMalattiePersonali());

    %>"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Osservazioni:</td>
    <td colspan="2"><label for="osservazioni"></label>
      <textarea name="osservazioni" id="osservazioni" cols="45" rows="5"><%out.print(anam.getOsservazioni());%>
      </textarea></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><hr /></td>
    </tr>
  <tr>
    <td colspan="4" align="center"><input type="submit" name="button" id="button" value="Modifica Anamnesi Partner" /></td>
    </tr>
     <tr>
    <td colspan="4"> <hr />
    </td>
    </tr>
</table>
</form>
<p>
<form action="/cod/businesslogic/dottore/inserisciAbitudiniDiVita" method="post">
<table width="800"  border="0" align="center">
  <tr>
    <th colspan="4" bgcolor="#FFFF66">ABITUDINI DI VITA</th>
    </tr>
     <tr>
    <td colspan="4"> <hr />
    </td>
    </tr>
  <tr>
    <td width="189">Lavoro:</td>
    <td width="226">
    <input type="hidden" name="codicefiscale" value="<%out.print(codf);%>">
      <input type="text" name="lavoro" id="lavoro"
        value="<% Abitudinidivita ab=c2.findAbitudinidivita(ultima.getAbitudinidivita().getId());
             out.print(ab.getLavoro());

    %>"/></td>
    <td width="148">Attivit&agrave; domestica:</td>
    <td width="219">
      <input type="text" name="attivitadomestica" id="attivitadomestica"
             value="<% out.print(ab.getAttivitaDomestica()); %>
             "/></td>
  </tr>
  <tr>
    <td>Attivit&agrave; corporea:</td>
    <td><label for="attivitacorporea"></label>
      <input type="text" name="attivitacorporea" id="attivitacorporea"
             value="<% out.print(ab.getAttivitaCorporea()); %>
             "/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Abitazione (Dove, con chi):</td>
    <td><label for="abitazione"></label>
      <input type="text" name="abitazione" id="abitazione"
             value="<% out.print(ab.getAbitazione()); %>
             "/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Viaggi:</td>
    <td><label for="viaggi"></label>
      <input type="text" name="viaggi" id="viaggi"
             value="<% out.print(ab.getViaggi()); %>
             "/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Alimentazione:</td>
    <td><label for="alimentazione"></label>
      <select name="alimentazione" id="alimentazione">
         <%if(ab.getAlimentazione()!=null)out.print("<option selected value='"+ab.getAlimentazione()+"'>"+ab.getAlimentazione()+"</option>");%>
        <option value="0">seleziona</option>
        <option value="vegetariana">vegetariana</option>
        <option value="lactovegetariana">lactovegetariana</option>
        <option value="macrobiotica">macrobiotica</option>
        <option value="varia">varia</option>
      </select></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Metodo di cura:</td>
    <td><label for="metododicura"></label>
      <input type="text" name="metododicura" id="metododicura"
      value=" <% out.print(ab.getMetodoCura()); %>
             "/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
  	<td colspan="3">
    	<hr />
    </td>
  </tr>
  <tr>
      <td><input name="fumo" type="checkbox" id="fumo" value="fumo" <%if (ab.getFumo()!=null)
          if(ab.getFumo()!=null)
              if(ab.getFumo())out.print("checked");

          %> />
     
      Fumo</td>
    <td nowrap>N. Sigarette prima della gravidanza:</td>
    <td>
      <input name="nsigarettepregravidanza" type="text" id="nsigarettepregravidanza" size="8"
             value="<% out.print(ab.getQtaGiornalieraSigarettePrimaGravidanza()); %>
             "/></td>
    <td nowrap>Durante la gravidanza:
      
      <input name="nsigarettedurantegravidanza" type="text" id="nsigarettedurantegravidanza" size="8"
             value="<% out.print(ab.getQtaGiornalieraSigaretteDuranteGravidanza());%>
             "/></td>
  </tr>
  <tr>
    <td><input name="caffe" type="checkbox" id="caffe" value="caffe" <%if (ab.getCaffe()!=null)
          if(ab.getCaffe())out.print("checked");

             


          %> />
      <label for="fumo">Caff&egrave;</label></td>
    <td>Quantit&agrave;: 
      <label for="quantitacaffe"></label>
      <input name="quantitacaffe" type="text" id="quantitacaffe" size="8"
              value="<% out.print(ab.getQuantitaCaffeAlGiorno());%>"
             /></td>
    <td><input name="alcool" type="checkbox" id="alcool" value="alcool"
               <%if(ab.getAlcool()!=null)
                   if(ab.getAlcool()) out.print("checked");%>/>
      <label for="fumo">Alcool</label></td>
    <td>Quantit&agrave;: 
      <label for="quantitaalcool"></label>
      <input name="quantitaalcool" type="text" id="quantitaalcool" size="8"
             value="<% out.print(ab.getQuantitaAlcoolAlMese());%>"
             /></td>
  </tr>
  <tr>
    <td nowrap><input name="stupefacenti" type="checkbox" id="stupefacenti" value="stupefacenti"
                      <%
                      if(ab.getStupefacenti()!=null)
                          if(ab.getStupefacenti())out.print("checked");
                      %>/>
      <label for="fumo">Stupefacenti</label></td>
    <td>Quantit&agrave;: 
      <label for="quantitastupefacenti"></label>
      <input name="quantitastupefacenti" type="text" id="quantitastupefacenti" size="8"
             value="<% out.print(ab.getQuantitaStupefacentiAlMese());%>"/></td>
    <td nowrap>Farmaci abituali:
      <label for="checkbox31"></label></td>
    <td><label for="farmaciabituali"></label>
      <input type="text" name="farmaciabituali" id="farmaciabituali"
             value="<% out.print(ab.getFarmaciAbituali());%>"/></td>
  </tr>
  <tr>
    <td>Altro: </td>
    <td><label for="altro"></label>
      <input type="text" name="altro" id="altro"
             value="<% out.print(ab.getAltreOsservazioni());%>"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><hr /></td>
    </tr>
  <tr>
    <td colspan="4" align="center"><input type="submit" name="button2" id="button2" value="Modifica Abitudini di vita" /></td>
    </tr>
     <tr>
    <td colspan="4"> <hr />
    </td>
    </tr>
</table>
</form>

<p>
<form action="/cod/businesslogic/dottore/inserisciStoriaMestruale" method="post">
<table width="800" border="0" align="center">
  <tr>
    <th colspan="4" align="center" bgcolor="#FFFF66">STORIA MESTRUALE</th>
    </tr>
     <tr>
    <td colspan="4"> <hr />
    </td>
    </tr>
  <tr>
    <td width="200">Menarca: 
     <input type="hidden" name="codicefiscale" value="<%out.print(codf);%>">
      <input name="menarca" type="text" id="menarca" size="8"
             value="<% Storiamestruale sm=c3.findStoriamestruale(ultima.getStoriamestruale().getId());
             out.print(sm.getMenarca());

    %>"/></td>
    <td width="200">Ritmo:
      <label for="ritmo"></label>
      <input name="ritmo" type="text" id="ritmo" size="8"
             value=" <%out.print(sm.getMenarca());
                     %>"
             /></td>
    <td width="200">Durata:
      <label for="durata"></label>
      <input name="durata" type="text" id="durata" size="8"
              value=" <%out.print(sm.getDurata());
                     %>"/></td>
    <td width="200">&nbsp;</td>
  </tr>
  <tr>
    <td>Quantit&agrave;: </td>
    <td><label for="quantita"></label>
      <input type="text" name="quantita" id="quantita"
              value=" <%out.print(sm.getQuantita());
                     %>"/></td>
    <td>Dismerronea:</td>
    <td><label for="dismerronea"></label>
      <input type="text" name="dismerronea" id="dismerronea"
              value=" <%out.print(sm.getDismorrea());
                     %>"/></td>
  </tr>
  <tr>
    <td colspan="4"><hr /></td>
    </tr>
  <tr>
    <td colspan="4" align="center"><input type="submit" name="button3" id="button3" value="Modifica Storia Mestruale" /></td>
    </tr>
     <tr>
    <td colspan="4"> <hr />
    </td>
    </tr>
</table>
</form>
<p> 
<form action="/cod/businesslogic/dottore/inserisciStoriaGinecologica" method="post">
<table width="800" border="0" align="center">
  <tr>
    <th colspan="4" bgcolor="#FFFF66" align="center">STORIA GINECOLOGICA</th>
    </tr>
     <tr>
    <td colspan="4"> <hr />
    </td>
    </tr>
  <tr>
    <td width="135"><input type="hidden" name="codicefiscale" value="<%out.print(codf);%>">
        <input name="paptest" type="checkbox" id="paptest" value="paptest"
               <%
                Storiaginecologica sg=c4.findStoriaginecologica(ultima.getStoriaginecologica().getId());
                if(sg.getPapTest()!=null)
                    if(sg.getPapTest())
                        out.print("checked");
                              %>/>
      Pap Test</td>
    <td width="322" nowrap>Data dell'ultimo: 
      <label for="dataultimopaptest"></label>
      <input type="text" name="dataultimopaptest" id="dataultimopaptest"
             value="<%
            
             out.print(sg.getPapTestDataUltimo());
             %>"
             /></td>
    <td width="314">Esito: 
      <label for="esitopaptest"></label>
      <input type="text" name="esitopaptest" id="esitopaptest"
             value="<%

             out.print(sg.getPapTestEsito());
             %>"/></td>
    <td width="11">&nbsp;</td>
  </tr>
  <tr>
    <td><input name="colposcopia" type="checkbox" id="colposcopia" value="colposcopia"
               <%
               if(sg.getColposcopia()!=null)
                   if(sg.getColposcopia())
                       out.println("checked");
               %>/>
      <label for="paptest"></label>
      Colposcopia</td>
    <td>Data: 
      <label for="datacolposcopia"></label>
      <input type="text" name="datacolposcopia" id="datacolposcopia"
             value="<%

             out.print(sg.getColposcopiaData());
             %>"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2"><input name="patologia" type="checkbox" id="patologia" value="patologiamammella"
                           <%
                           if(sg.getPatalogiaMammella()!=null)
                               if(sg.getPatalogiaMammella())
                                   out.print("checked");
                           %>/>
      <label for="paptest"></label>
      Patologia della mammella</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Interventi chirurgici:</td>
    <td><label for="interventichirurgici"></label>
      <input type="text" name="interventichirurgici" id="interventichirurgici"
             value="<%

             out.print(sg.getInterventiChirurgici());
             %>"/></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><hr /></td>
    </tr>
  <tr>
    <td colspan="4" align="center"><input type="submit" name="button4" id="button4" value="Modifica Storia Ginecologica" /></td>
    </tr>
     <tr>
    <td colspan="4"> <hr />
    </td>
    </tr>
</table>
</form>
<p>
<form action="/cod/businesslogic/dottore/inserisciAnticoncezionali" method="post">
<table width="800" border="0" align="center">
  <tr>
    <th colspan="4" bgcolor="#FFFF66" align="center">ANTICONCEZIONALI</th>
    </tr>
     <tr>
    <td colspan="4"> <hr />
    </td>
    </tr>
  <tr>
    <td width="200">&nbsp;</td>
    <td width="200">TIPO</td>
    <td width="200">PER QUANTO TEMPO</td>
    <td width="200">EFFETTI COLLATERALI</td>
  </tr>
  <tr>
    <td><input type="hidden" name="codicefiscale" value="<%out.print(codf);%>">
        <input name="pillola" type="checkbox" id="pillola" value="pillola"
               <%
                    Anticoncezionali an=c5.findAnticoncezionali(ultima.getAnticoncezionali().getId());
                    if(an.getPillola()!=null)
                        if(an.getPillola())out.print("checked");
               %>/>
      <label for="pillola">PILLOLA</label></td>
    <td><label for="tipopillola"></label>
      <input type="text" name="tipopillola" id="tipopillola"
             value="<%

             out.print(an.getPillolaTipo());
             %>"/></td>
    <td><label for="tempopillola"></label>
      <input type="text" name="tempopillola" id="tempopillola"
             value="<%

             out.print(an.getPillolaDurata());
             %>"/></td>
    <td><label for="effettipillola"></label>
      <input type="text" name="effettipillola" id="effettipillola"
             value="<%

             out.print(an.getPillolaEffetti());
             %>"/></td>
  </tr>
  <tr>
    <td><input name="iud" type="checkbox" id="iud" value="iud"
               <%
               if(an.getIud()!=null)
                   if(an.getIud())out.print("checked");
               %>/>
      IUD
      <label for="pillola"></label></td>
    <td><label for="tipoiud"></label>
      <input type="text" name="tipoiud" id="tipoiud"
             value="<%

             out.print(an.getIUDTipo());
             %>"/></td>
    <td><label for="tempoiud"></label>
      <input type="text" name="tempoiud" id="tempoiud"
             value="<%

             out.print(an.getIUDDurata());
             %>"/></td>
    <td><label for="effettiiud"></label>
      <input type="text" name="effettiiud" id="effettiiud"
             value="<%

             out.print(an.getIUDEffetti());
             %>"/></td>
  </tr>
  <tr>
    <td><input name="diaframma" type="checkbox" id="diaframma" value="diaframma" 
               <% 
               if(an.getDiaframma()!=null)
                   if(an.getDiaframma())out.print("checked");
                %>/>

      DIAFRAMMA
      <label for="pillola"></label></td>
    <td><label for="tipodiaframma"></label>
      <input type="text" name="tipodiaframma" id="tipodiaframma"
             value="<%

             out.print(an.getDiaframaTipo());
             %>"/></td>
    <td><label for="tempodiaframma"></label>
      <input type="text" name="tempodiaframma" id="tempodiaframma"
             value="<%

             out.print(an.getDiaframmaDurata());
             %>"/></td>
    <td><label for="effettidiaframma"></label>
      <input type="text" name="effettidiaframma" id="effettidiaframma"
             value="<%

             out.print(an.getDiaframmaEffetti());
             %>"/></td>
  </tr>
  <tr>
    <td><input name="altro" type="checkbox" id="altro" value="altro"
               <%
               if(an.getAltro()!=null)
                   if(an.getAltro())out.print("checked");
               %>/>
      <label for="pillola">ALTRO</label></td>
    <td><label for="tipoaltro"></label>
      <input type="text" name="tipoaltro" id="tipoaltro"
             value="<%

             out.print(an.getAltroTipo());
             %>"/></td>
    <td><label for="tempoaltro"></label>
      <input type="text" name="tempoaltro" id="tempoaltro"
             value="<%

             out.print(an.getAltroDurata());
             %>"/></td>
    <td><label for="effettialtro"></label>
      <input type="text" name="effettialtro" id="effettialtro"
             value="<%

             out.print(an.getAltroEffetti());
             %>"/></td>
  </tr>
  <tr>
  	<td colspan="4"><hr /></td>
  </tr>
  <tr>
  <td colspan="4" align="center"><input name="" type="submit" value="Modifica Anticoncezionali" /></td>
  </tr>
   <tr>
    <td colspan="4"> <hr />
    </td>
    </tr>
</table>
</form>
<p>
<form action="/cod/businesslogic/dottore/inserisciStoriaOstetrica" method="post">

  <table width="800" border="0" align="center">
    <tr>
      <th colspan="14" bgcolor="#FFFF66" align="center"
          <%
                Storiaostetrica so=c7.findStoriaostetrica(ultima.getStoriaostetrica().getId());
                StoriaostretricatabellaJpaController c8=new StoriaostretricatabellaJpaController();
                List<Storiaostretricatabella> listaos=c8.findStoriaostretricatabellaEntities();
                List<Storiaostretricatabella> listafiltrataso=new ArrayList<Storiaostretricatabella>();
                for(int ii=0;ii<listaos.size();ii++)
                    {
                        if(listaos.get(ii).getStoriaostetrica().getId().equals(so.getId()))
                            listafiltrataso.add(listaos.get(ii));
                    }

                
               
                

          %>>STORIA OSTETRICA</th>
    </tr>

     <tr>
    <td colspan="14"> <hr />
    </td>
    </tr>
    <tr align="center">
      <td width="18">N.</td>
      <td width="33">Anno</td>
      <td width="75">Et&agrave; gestionale</td>
      <td width="30">IVG</td>
      <td width="65">Aborto Spontaneo</td>
      <td width="78">Tipo parto</td>
      <td>Luogo parto</td>
      <td width="61">Peso bambino</td>
      <td width="36">Sesso</td>
      <td width="89">Condizioni del bambino</td>
      <td width="102"><p>tipo allattamento</p></td>
      <td width="102"><p>durata allattamento</p></td
      ><td width="167">Complicazioni della gravidanza, puerperio, parto o aborto</td>
      
    </tr>
    <% for(i=0;i<listafiltrataso.size();i++){
    Storiaostretricatabella x=listafiltrataso.get(i);
        %>
    <tr align="center">
        <td><% out.print(i+1); %></td>
      <td><input type="hidden" name="codicefiscale" value="<%out.print(codf);%>" disabled>
      <input name="anno" type="text" id="anno" size="4"  disabled="disabled"
             value="<%out.print(x.getAnno());

             %>"/></td>
      <td><label for="eta"></label>
      <input name="eta" type="text" id="eta" size="10" disabled="disabled"
             value="<%out.print(x.getEtaGestionale());

             %>"
             /></td>
      <td><label for="ivg"></label>
      <input name="ivg" type="text" id="ivg" size="4" disabled="disabled"
              value="<%out.print(x.getIvg());

             %>"/></td>
      <td><input name="aborto" type="checkbox" id="aborto" value="aborto" disabled="disabled"
                  <%if(x.getAbortoSpontaneo()!=null)
                      if(x.getAbortoSpontaneo())out.print("checked");

             %>/></td>
      <td>
      <input name="tipoparto" type="text" id="tipoparto" size="10" disabled="disabled"
              value="<%out.print(x.getTipoParto());

             %>"
             /></td>
      <td><label for="tipoluogoparto"></label>
      <input name="luogoparto" type="text" id="luogoparto" size="10" disabled="disabled"
              value="<%out.print(x.getLuogoParto());

             %>"/></td>
      <td><label for="pesobambino"></label>
      <input name="pesobambino" type="text" id="pesobambino" size="4" disabled="disabled"
              value="<%out.print(x.getPesoBambino());

             %>"/></td>
      <td><label for="sesso" ></label>
        <select name="sesso" id="sesso" disabled="disabled">
            <%if(x.getSesso().equals("m"))out.print("<option>maschio</option>");
              else
                  out.print("<option>femmina</option>");
              %>

        <option value="m">maschio</option>
        <option value="f">femmina</option>
      </select></td>
      <td><label for="condizioni"></label>
      <input name="condizioni" type="text" id="condizioni" size="10" disabled="disabled"
             value="<%out.print(x.getCondizioniBambino());

             %>"/></td>
      <td><label for="tipoallattamento"></label>
      <input name="tipoallattamento" type="text" id="tipoallattamento" size="10" disabled="disabled"
             value="<%out.print(x.getTipoAllattamento());

             %>"/></td>
      <td><label for="tipoallattamento"></label>
      <input name="durataallattamento" type="text" id="durataallattamento" size="10" disabled="disabled"
             value="<%out.print(x.getDurataAllattamento());

             %>"/></td>
      <td><label for="complicazioni"></label>
      <input name="complicazioni" type="text" id="complicazioni" size="10" disabled="disabled"
             value="<%out.print(x.getComplicazioniGravidanza());

             %>"/></td>
      
    </tr>
    <% } %>
     <tr align="center">
         <td><%out.print(i+1);%></td>
      <td><input type="hidden" name="codicefiscale" value="<%out.print(codf);%>">
      <input name="anno" type="text" id="anno" size="4" /></td>
      <td><label for="eta"></label>
      <input name="eta" type="text" id="eta" size="10" /></td>
      <td><label for="ivg"></label>
      <input name="ivg" type="text" id="ivg" size="4" /></td>
      <td><input name="aborto" type="checkbox" id="aborto" value="aborto" />
      <label for="aborto"></label></td>
      <td><label for="tipoluogoparto"></label>
      <input name="tipoparto" type="text" id="tipoparto" size="10" /></td>
      <td><label for="tipoluogoparto"></label>
      <input name="luogoparto" type="text" id="luogoparto" size="10" /></td>
      <td><label for="pesobambino"></label>
      <input name="pesobambino" type="text" id="pesobambino" size="4" /></td>
      <td><label for="sesso"></label>
        <select name="sesso" id="sesso">
        <option value="m">maschio</option>
        <option value="f">femmina</option>
      </select></td>
      <td><label for="condizioni"></label>
      <input name="condizioni" type="text" id="condizioni" size="10" /></td>
      <td><label for="tipoallattamento"></label>
      <input name="tipoallattamento" type="text" id="tipoallattamento" size="10" /></td>
      <td><label for="tipoallattamento"></label>
      <input name="durataallattamento" type="text" id="durataallattamento" size="10" /></td>
      <td><label for="complicazioni"></label>
      <input name="complicazioni" type="text" id="complicazioni" size="10" /></td>
      
    </tr>
    <tr>
      <td colspan="14"><hr /></td>
    </tr>
    <tr>
      <td colspan="14" align="center"><input type="submit" name="button5" id="button5" value="Modifica Storia Ostetrica" /></td>
    </tr>
     <tr>
    <td colspan="14"> <hr />
    </td>
    </tr>
  </table>
</form>
<p>
<form action="/cod/businesslogic/dottore/inserisciStoriaPreconcezionale" method="post">


<table width="800" border="0" align="center">
  <tr>
    <th colspan="3" align="center" bgcolor="#FFFF66">STORIA PRECONCEZIONALE</th>
  </tr>
   <tr>
    <td colspan="3"> <hr />
    </td>
    </tr>
  <tr>
    <td colspan="3"><input type="hidden" name="codicefiscale" value="<%out.print(codf);%>">
        <input name="1" type="checkbox" id="1" value="desiderata"
               <%
                Storiapreconcezionale sp=c6.findStoriapreconcezionale(ultima.getStoriapreconcezionale().getId());
                if(sp.getGravidanzaDesiderataPrevista()!=null)
                    if(sp.getGravidanzaDesiderataPrevista())
                        out.print("checked");
               %>/>
    <label for="1">Gravidanza desiderata/prevista</label></td>
  </tr>
  <tr>
    <td colspan="3"><input name="2" type="checkbox" id="2" value="imprevistadonna"
                           <%
                           if(sp.getGravidanzaImprevistaAccettazioneDonna()!=null)
                               if(sp.getGravidanzaImprevistaAccettazioneDonna())
                                   out.print("checked");
                           %>/>
      <label for="1">Gravidanza imprevista/accettazione della donna</label></td>
  </tr>
  <tr>
    <td colspan="3"><input name="3" type="checkbox" id="3" value="imprevistapartner"
                           <%
                           if(sp.getGravidanzaImprevistaAccettazionePartner()!=null)
                               if(sp.getGravidanzaImprevistaAccettazionePartner())out.print("checked");
                           %>/>
      Gravidanza imprevista/accettazione del partner</td>
    </tr>
  <tr>
    <td width="175" nowrap><input name="4" type="checkbox" id="4" value="difficolta"
                                  <%
                                  if(sp.getDifficoltaConcepimento()!=null)
                                      if(sp.getDifficoltaConcepimento())
                                          out.print("checked");
                                  %>/>
      <label for="1">Difficolt&agrave; di concepimento</label></td>
    <td width="269">Accertamenti e provvedimenti:</td>
    <td width="252"><label for="accertamentiprovvedimenti"></label>
      <input type="text" name="accertamentiprovvedimenti" id="accertamentiprovvedimenti"
             value="<%

             out.print(sp.getAccertamentiProvvedimenti());
             %>"/></td>
  </tr>
  <tr>
    <td>Condizioni coppia:</td>
    <td><label for="condizionicoppia"></label>
      <input type="text" name="condizionicoppia" id="condizionicoppia"
             value="<%

             out.print(sp.getCondizioneCoppia());
             %>"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3"><hr /></td>
    </tr>
    <tr>
    <td colspan="3" align="center"><input type="submit" name="button6" id="button6" value="Modifica Storia Preconcezionale" /></td>
    </tr>
     <tr>
    <td colspan="3"> <hr />
    </td>
    </tr>
</table>
</form>
<p>
<form action="/cod/businesslogic/dottore/inserisciBambino" method="post">
<table width="800" border="0" align="center">
  <tr>
    <th colspan="3" align="center" bgcolor="#FFFF66">BAMBINO</th>
  </tr>
  <tr>
    <td colspan="3"><hr /></td>
  </tr>
  <tr>
    <td><input type="hidden" name="codicefiscale" value="<%out.print(codf);%>">
      Valutazione bacino:</td>
      <td><label for="bacino"></label>
      <input type="text" name="bacino" id="bacino"
             value="<%
                Bambino b=c9.findBambino(ultima.getBambino().getId());
                out.print(b.getValutazioneBacino());

             %>"></td>
  </tr>
  <tr>
    <td nowrap>Corso preparazione parto:</td>
    <td><label for="corso"></label>
    <input type="text" name="corso" id="corso"
           value="<%out.print(b.getCorsoPreparazioneParto());
           %>
           "></td>
  </tr>
  <tr>
    <td>Luogo previsto parto:</td>
    <td><label for="corso"></label>
      <label for="luogoparto"></label>
      <textarea name="luogoparto" id="luogoparto" cols="45" rows="5"><%
      out.print(b.getLuogoPrevistoParto());%>
      </textarea>
  </tr>
  <tr>
    <td width="175" nowrap>Visita fase prodromica:</td>
    <td width="269"><label for="visitaprodromica"></label>
    <textarea name="visitaprodromica" id="visitaprodromica" cols="45" rows="5"><%
        out.print(b.getVisitaFaseProdromica()); %>
    </textarea></td>
    <td width="252"><label for="accertamentiprovvedimenti2"></label></td>
  </tr>
  <tr>
    <td colspan="3"><hr /></td>
  </tr>
  <tr>
    <td colspan="3" align="center"><input type="submit" name="button7" id="button7" value="Modifica dati bambino" /></td>
  </tr>
  <tr>
    <td colspan="3"><hr /></td>
  </tr>
</table>
</form>
   <%}  else{
      %>

       <table align="center">
  
  <tr>
      <td align="center" valign="middle"><h1>Nessun Paziente trovato</h1>
    </td>
  </tr>
</table>
        <% }} %>
</body>
</html>
