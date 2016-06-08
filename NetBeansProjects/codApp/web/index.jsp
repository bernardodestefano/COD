<%-- 
    Document   : index
    Created on : 8-dic-2010, 16.50.07
    Author     : Lodato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title> COD </title>
        <link rel="stylesheet" type="text/css" href="css/cod_mu_stylesheet.css">
    </head>
    <body>
     <table align="center">
    	<tr>
				<td>
					<img src="LogoCOD.png" width="396" height="236" align="center" />
  			    </td>
			</tr>
  			
		
        
        <tr align="center">
        <tD>
        	<a href="/cod/amministratore/richiediAbilitazione.html">Vuoi essere abilitato a COD?</a>
    	</tD>
        </tr>
        
    <tr>
    <td align="center">
     <form action="/cod/verificaAutenticazione" method="POST">
      <p><input type="text" class="login-text" name="Utente"   value="Nome utente" /><p>
                <input type="password" class="login-text" name="Password" value="Password" /><p>
                <input type="submit" value="Accedi" />
         </form>
         </td>
         </tr>
      </table>
                
   
        
    </body>
</html>