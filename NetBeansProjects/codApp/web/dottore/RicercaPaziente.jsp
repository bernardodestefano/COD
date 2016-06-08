<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="bean.Paziente"%>
<%@page import="controller.PazienteJpaController"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<link rel="stylesheet" href="../2col_leftNav.css" type="text/css" />
<style type="text/css">
<!--
#Layer1 {	position:absolute;
	left:31px;
	top:50px;
	width:88px;
	height:50px;
	z-index:1;
}
body {
	background-color: #EBEDEC;
}
a:link {
	color: #000000;
}

a:visited {
	color: #000000;
}
a:hover {
	color: #000000;
}
a:active {
	color: #000000;
}
.Stile3 {font-size: small; }
.Stile5 {font-size: x-small}
.Stile7 {color: #FFFFFF}
.Stile13 {
	color: #000000;
	font-weight: bold;
}
.Stile15 {font-size: small; font-weight: bold; color: #FFFFFF; }
.Stile16 {color:#000000;
}
.Stile17 {font-size:small;
font-style:italic;
}
-->
</style>


</head>
<%


    String codf=request.getParameter("codicefiscale");
    String cognome=request.getParameter("cognome");

    PazienteJpaController p=new PazienteJpaController();
    List<Paziente> paziente=p.findPazienteEntities();
    List<Paziente> listafiltrata=new ArrayList<Paziente>();

    if(codf.equals("")&&cognome.equals(""))
        response.sendRedirect("Logo.html");
    
    else
        if(!codf.equalsIgnoreCase("")&&!cognome.equalsIgnoreCase(""))
        {
           for(int i=0;i<paziente.size();i++)
            {
                if(paziente.get(i).getCognome().equals(cognome)&&paziente.get(i).getCodiceFiscale().equals(codf))
                    response.sendRedirect("VisualizzaPaziente.jsp?codicefiscale="+codf);
            }
        }
       if(!codf.equalsIgnoreCase("")&&cognome.equalsIgnoreCase(""))
       {
           response.sendRedirect("VisualizzaPaziente.jsp?codicefiscale="+codf);
       }
else
        if(codf.equals("")&& !cognome.equalsIgnoreCase(""))
       {
            for(int i=0;i<paziente.size();i++)
            {
                if(paziente.get(i).getCognome().equals(cognome))
                    listafiltrata.add(paziente.get(i));
            }
            if(listafiltrata.size()==0)
                {
                %>
                <table align="center">
  <!--DWLayoutTable-->
  <tr>
    <td align="center" valign="middle"><img src="LogoCOD.png" width="213" height="136" />
    </td>
  </tr>
</table>
                <table align="center">

  <tr>
      <td align="center" valign="middle"><h1>Nessun Paziente trovato</h1>
    </td>
  </tr>
</table>
                
                <%
                }

else{

%>
<!-- The structure of this file is exactly the same as 2col_rightNav.html;
     the only difference between the two is the stylesheet they use -->
<body><!-- end masthead -->
<p align="left">





  <!--end content --></p>
<table width="800" border="0" align="center" bgcolor="#FFFFFF">
  <!--DWLayoutTable-->
  <tr bgcolor="#CCCCCC">
      <th width="23" height="30" scope="col"><div align="center"><span class="Stile7"><span class="Stile3"></span></span>N</div></th>
      <th width="62" height="30" class="Stile5" scope="col"><div align="center" class="Stile5 Stile16">
          <div align="center">Cognome</div>
      </div></th>
      <th width="60" height="30" class="Stile5" scope="col"><div align="center" class="Stile5 Stile16">
          <div align="center">Nome</div>
      </div></th>
      <th width="113" height="30" class="Stile5" scope="col"><div align="center" class="Stile16">Codice fiscale</div></th>
      <th width="145" class="Stile5" scope="col"><div align="center" class="Stile16">Indirizzo</div></th>
      <th width="74" height="30" class="Stile5" scope="col"><div align="center" class="Stile16">Telefono</div></th>
      <th width="75" class="Stile5" scope="col"><div align="center" class="Stile16">Data Nascita</div></th>
      <th width="156" height="30" class="Stile5" scope="col"><div align="center" class="Stile5 Stile16">
          <div align="center">Luogo Nascita</div>
      </div></th>
      <th width="54" height="30" class="Stile5" scope="col"><div align="center" class="Stile16"></div></th>
    </tr>
  <%
  
       for(int i=0;i<listafiltrata.size();i++) {
           Paziente paz=listafiltrata.get(i);
  %>

    
    <tr>
      <td height="22" nowrap="nowrap" bgcolor=
			'#009900'

			><div align="center" class="Stile15">
              <div align="center"><% out.print(i+1); %></div>
      </div></td>
      <td height="22" bgcolor="#FFFFDF"  nowrap="nowrap" class="Stile5"><div align="center" class="Stile5">
              <div align="center"><%out.print(paz.getNome());%></div>
      </div></td>
      <td height="22" bgcolor="#FFFFDF" nowrap="nowrap" class="Stile5"><div align="center" class="Stile5">
              <% out.print(paz.getCognome());%>
          </div></td>
      <td height="22" bgcolor="#FFFFDF"  nowrap="nowrap" class="Stile5"><div align="center" class="Stile5">
              <%out.print(paz.getCodiceFiscale());%>
      </div></td>
      <td bgcolor="#FFFFDF" nowrap="nowrap" class="Stile5"><div align="center" class="Stile5">
              <%
              out.print(paz.getIndirizzo());
              %>
          </div></td>
      <td height="22" bgcolor="#FFFFDF" nowrap="nowrap" class="Stile5"><div align="center" class="Stile5">
              <%
                  out.print(paz.getTelefono());
              %>
      </div></td>
      <td bgcolor="#FFFFDF" nowrap="nowrap" class="Stile5"><div align="center">
              <%
                out.print(paz.getDataNascita());
              %>
          </div></td>
      <td height="22" nowrap="nowrap" bgcolor="#FFFFDF" class="Stile5"><div align="center">
              <%
                out.print(paz.getLuogoNascita());
              %></div></td>
      <td height="22" nowrap="nowrap" bgcolor="#FFFFDF" class="Stile5"><div align="left" class="Stile5">
              <div align="center"><strong><a href="VisualizzaPaziente.jsp?codicefiscale=<%out.print(paz.getCodiceFiscale()); %>">Dettagli</a></strong></div>
      </div></td>
    </tr>
    <%}%>
    
  </table>
  <p>&nbsp;</p>
<% }}%>
</body>

</html>
