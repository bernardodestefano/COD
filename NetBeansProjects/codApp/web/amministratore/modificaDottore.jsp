<%-- 
    Document   : modificaDottore
    Created on : 12-dic-2010, 17.40.47
    Author     : Sabato Luca 'noidhoon' Guadagno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifica Dottore</title>
    </head>
    <body>

        <form action="/cod/modificaDottore">
            <p>Id Dottore <input type="text" size="11" maxlength="11" name="id" /></p>

            <table>
                <tr>
                    <td>Codice fiscale:</td>
                    <td><input type="text" size="16" maxlength="16" name="codicefiscale" /></td>
                </tr>

                <tr>
                    <td>Nome:</td>
                    <td><input type="text" size="10" name="nome" /></td>
                </tr>

                <tr>
                    <td>Cognome:</td>
                    <td><input type="text" name="cognome" /></td>
                </tr>

                <tr>
                    <td>Indirizzo:</td>
                    <td><input type="text" name="indirizzo" /></td>
                </tr>

                <tr>
                    <td>Cellulare:</td>
                    <td><input type="text" name="cellulare" /></td>
                </tr>

                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" /></td>
                </tr>

                <tr>
                    <td>Comune:</td>
                    <td><input type="text" name="comune" /></td>
                </tr>

                <tr>
                    <td>Provincia:</td>
                    <td><input type="text" name="provincia" /></td>
                </tr>

                <tr>
                    <td><input type="submit"></input> </td>
                </tr>

            </table>


        </form>

    </body>
</html>
