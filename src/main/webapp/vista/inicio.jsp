<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Integra Gestión</title>

        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    </head>

    <body>
        <p>Integra Gestion</p>
        <form:form commandName="Usuario" action="/igestion/login">
            <fieldset>
                <div>
                    <label for="Usuario">Usuario:</label>
                    <span class="input"><form:input path="usuario"/></span>
                </div>       
                <div>
                    <label for="Password">Password:</label>
                    <span class="input"><form:input path="password"/></span>
                </div>
                <div class="form-buttons">
                    <div class="button">
                        <input type="submit" id="entrar" name="entrar" value="Entrar"/>
                    </div>    
                </div>
            </fieldset>
        </form:form>
    </body>
</html>
