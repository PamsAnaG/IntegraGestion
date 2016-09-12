<%-- 
    Document   : dashboard
    Created on : Aug 8, 2016, 3:01:07 PM
    Author     : pamela.gutierrez
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <script type="text/javascript" src='/js/jquery.js'></script>
        <script type="text/javascript" src='/js/jquery-ui.js'></script>
        <script type="text/javascript" src='/js/jquery-ui.min.js'></script>
        <link href="/img/Demexis.ico" rel="shortcut icon" />
        <link type="text/css" href='../css/structure.css' rel="stylesheet" media="screen" />        
        <link type="text/css" href='../css/jquery-ui.structure.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.min.css' rel="stylesheet" media="screen" />
        <script type="text/javascript" src='../js/kalendae.js'></script>
        <link type="text/css" href='../css/kalendae.css' rel="stylesheet" media="screen" />
        
        <script>
            $(function() {
                /*$.getJSON("/igestion/clientes", function(data) {
                 var items = [];
                 $.each(data, function(key, val) {
                 $("#selCliente").append('<option value="' + val.idCliente + '" label="' + val.nombre + '"</>');
                 });
                 });
                 
                 $.getJSON("/igestion/tipoProyecto", function(data) {
                 var items = [];
                 $.each(data, function(key, val) {
                 $("#selTipoP").append('<option value="' + val.idCliente + '" >' + val.nombre + '</option>');
                 });
                 });*/
            });
        </script>
    </head>
    <body>
        <form:form method="post" action="cargap" commandName="proyecto">
            <table class="tablaProyecto" style="margin-bottom: 0;">
                <tr>
                    <th>
                        Cliente
                    </th>
                    <td>   
                        <form:select id="selCliente" name="cliente" path="cliente">
                            <!--form:options itemLabel=""/-->
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <th>
                        Proyecto
                    </th>
                    <td colspan="3">
                        <form:input id="proyecto" type="text" style="width: 100%;" path="nombre"/>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Guardar proyecto">
        </form:form>
    </body>
</html>
