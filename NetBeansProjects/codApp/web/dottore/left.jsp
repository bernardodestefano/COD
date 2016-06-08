<%@page import="bean.Dottore"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Untitled Document</title>
<link rel="stylesheet" href="../css/2col_leftNav.css" type="text/css" />

<style type="text/css">
<!--
body {
	background-color: #EAECEB;
}
-->
</style>
<link href="../css/emx_nav_left.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.Stile10 {font-size: small
			}
body,td,th {
	font-size: small;
}
.Stile18 {color: #FFCC33; font-size: medium;}
.Stile19 {
	font-size: medium;
	font-weight: bold;
	color: #FFFFFF;
}
.Stile21 {
	font-size: x-small;
	color: #EAEBED;
}
.Stile23 {font-size: x-small; }
-->
</style>
</head>
<!-- The structure of this file is exactly the same as 2col_rightNav.html;
     the only difference between the two is the stylesheet they use -->
<body>
<table width="150" border="0" cellpadding="0" cellspacing="0">
  <!--DWLayoutTable-->
  
  <tr>
    <td width="150" height="23" valign="middle"><div align="right" class="Stile21"><span class="Stile23">
    </span></div></td>
  </tr>
  <tr>
    <td height="37" align="center" valign="middle" bgcolor="#13A19A"><strong> 
	<%
                //HttpSession sessione=request.getSession();
                //out.print(((Dottore)sessione.getAttribute("Dottore")).getCognome());
        %>
    </strong></td>
  </tr>
  <tr>
    <td height="25" valign="top"><!--DWLayoutEmptyCell-->&nbsp;</td>
  </tr>
  <tr>
    <td height="250" valign="top" ><div id="sectionLinks">
      <p align="left" class="Stile18"><a href="Logo.html" target="mainFrame" class="story"><font size="1">Home</font></a><a href="Primoinserimento.html" target="mainFrame" class="Stile10"><font size="1">Nuovo Paziente</font></a><a href="Menu-2.html" class="Stile10" target="topFrame" ><font size="1">Ricerca Paziente</font></a></p>
        <p><a href="#" target="mainFram" class="Stile10">-- </a><a href="#" target="mainFrame" class="story">--</a><a href="#" target="mainFrame" class="story">--</a></p>
        <p><a href="#" target="mainFrame" class="Stile10">-- </a><a href="#" target="mainFrame" class="story">-- </a><a href="#" target="mainFrame" class="story">--</a></p>
        <p><a href="#" target="mainFrame" class="Stile10">--</a>
		<a href="../index.jsp" target="_top" class="story">Logout</a></p>
        </div></td>
  </tr>
</table>
</body>
</html>
