<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Integra Gesti&oacute;n</title>
        <link href="../img/Demexis.ico" rel="shortcut icon" />

        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

        <link href="../css/pure.css" rel="stylesheet">
        <link href="../css/integra.css" rel="stylesheet">

    </head>

    <body>
        <div class="login">
            <form:form cssClass="pure-form pure-form-stacked" commandName="Usuario" action="/igestion/login">
                <img src="../img/DemexisLogo3.png" alt="" border="0" height="50" width="100%"></img>
                <p class="txtCenter">Integra Gesti&oacute;n</p>
                <fieldset>
                    <div class="pure-control-group">
                        <!--label for="Usuario">Usuario:</label-->
                        <form:input path="usuario" cssClass="pure-input-1" placeholder="Usuario"/></span>
                    </div>       
                    <div class="pure-control-group">
                        <!--label for="Password">Password:</label-->
                        <form:password path="password" cssClass="pure-input-1" placeholder="Contraseña"/></span>
                    </div>
                    <div class="pure-controls">
                        <input class="pure-button pure-input-1 pure-button-primary" type="submit" id="entrar" name="entrar" value="Entrar"/> 
                    </div>
                </fieldset>
                <c:if test="${not empty Mensaje}">
                    ${Mensaje}
                </c:if>
            </form:form>
        </div>        
    </body>
</html>
