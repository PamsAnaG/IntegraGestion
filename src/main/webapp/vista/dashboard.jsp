<%-- 
    Document   : dashboard
    Created on : Aug 8, 2016, 3:01:07 PM
    Author     : pamela.gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>

        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    </head>
    <body>
        <form:form method="post" action="cargap" enctype="multipart/form-data" commandName="fileFormBean">
            <table>
                <tr>
                    <td>Selecciona fichero: </td>
                    <td><input type="file" name="fichero" /></td>
                </tr>
                <tr>

                </tr>
                <tr><td colspan="2" align="center">
                        <input type="submit" value="Subir fichero"></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
