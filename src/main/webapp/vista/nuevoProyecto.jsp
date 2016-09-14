<%-- 
    Document   : dashboard
    Created on : Aug 8, 2016, 3:01:07 PM
    Author     : pamela.gutierrez
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <form:form method="post" action="cargap" enctype="multipart/form-data" commandName="proyecto">
            <table class="tablaProyecto" style="margin-bottom: 0;">
                <tr>
                    <th>
                        Cliente
                    </th>
                    <td>   
                        <form:select id="selCliente" name="cliente" path="cliente.idCliente">
                            <c:forEach var="clienteS" items="${clientes}">
                                <form:option value="${clienteS.idCliente}"><c:out value="${clienteS.nombre}"/></form:option>
                            </c:forEach>
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
                <tr>
                    <th>
                        Fechas
                    </th>
                    <td>Inicio:<form:input id="fechaIni" type="text" class="auto-kal" data-kal="months: 1, direction: 'future'" path="fechaInicio"/></td>
                    <td>Fin:<form:input id="fechaFin" type="text" class="auto-kal" data-kal="months: 1, direction: 'future'" path="fechaFin"/></td>
                    <th>
                        Tipo
                    </th>
                    <td>
                        <form:select id="selTipoP" name="tipoProyecto" path="tipo.idTipoProyecto">
                            <c:forEach var="tipoS" items="${tiposP}">
                                <form:option value="${tipoS.idTipoProyecto}"><c:out value="${tipoS.nombre}"/></form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>                
            </table>
            <table class="tablaProyecto a">
                <tr>                    
                    <th>
                        Clase
                    </th>
                    <td>
                        <form:select id="selClase" name="clase" path="clase.idClaseProyecto">
                            <c:forEach var="claseS" items="${clasesP}">
                                <form:option value="${claseS.idClaseProyecto}"><c:out value="${claseS.nombre}"/></form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                    <th>
                        Facturación
                    </th>
                    <td>
                        <form:select id="selFacturacion" name="tFacturacion" path="tipoFacturacion.idTipoFacturacion">
                            <c:forEach var="tiposS" items="${tiposF}">
                                <form:option value="${tiposS.idTipoFacturacion}"><c:out value="${tiposS.nombre}"/></form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>  
                <tr>
                    <th>
                        Modalidad
                    </th>
                    <td>
                        <form:select id="selModalidad" name="modalidad" path="modalidad.idModalidadProyecto">
                            <c:forEach var="modalidadS" items="${modalidadP}">
                                <form:option value="${modalidadS.idModalidadProyecto}"><c:out value="${modalidadS.nombre}"/></form:option>
                            </c:forEach>
                        </form:select>
                    </td>                    
                    <td>

                    </td>
                </tr>                
            </table>
            <table>
                <tr>
                    <td>Carga archivo: </td>
                    <td><form:input path="archivoProyecto.fichero" type="file" class="btnGuardar"  name="archivoProyecto" /></td>
                </tr>                           
            </table>
            <input type="submit" value="Guardar proyecto">
        </form:form>
    </body>
</html>
