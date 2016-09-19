<%-- 
    Document   : dashboard
    Created on : Aug 8, 2016, 3:01:07 PM
    Author     : pamela.gutierrez
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        
        <script type="text/javascript" src='../js/jquery.js'></script>
        <script type="text/javascript" src='../js/jquery-ui.js'></script>
        <script type="text/javascript" src='../js/jquery-ui.min.js'></script>
        <script type="text/javascript" src='../js/kalendae.js'></script>

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
        <center><div></br></br>
            <table class="tablaProyecto" style="margin-bottom: 0;">
                <tr>
                    <th>
                        Cliente
                    </th>
                    <td>   
                        <form:select  id="selCliente" name="cliente" path="cliente.idCliente">
                            <form:option value="0" disabled="true"><c:out value="Seleccionar..."/></form:option>
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
                    <td colspan="2">
                        <form:input id="proyecto" type="text" style="width: 100%;" path="nombre"/>
                    </td>
                </tr>
                <tr>
                   <th>
                        Fechas
                    </th>
                    <td>Inicio: <form:input id="fechaIni" type="text" class="auto-kal" data-kal="months: 1, direction: 'future'" path="fechaInicio"/></td>
                    <td>Fin: <form:input id="fechaFin" type="text" class="auto-kal" data-kal="months: 1, direction: 'future'" path="fechaFin"/></td>
                </tr>
            </table>
            <table class="tablaProyecto a" style="margin-bottom: 0;">    
                <tr>                    
                    <th>
                        Tipo
                    </th>
                    <td>
                        <form:select id="selTipoP" name="tipoProyecto" path="tipo.idTipoProyecto">
                            <form:option value="0" disabled="true"><c:out value="Seleccionar..."/></form:option>
                            <c:forEach var="tipoS" items="${tiposP}">
                                <form:option value="${tipoS.idTipoProyecto}"><c:out value="${tipoS.nombre}"/></form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                    <th style="text-align: right;">
                        Facturación
                    </th>
                    <td>
                        <form:select id="selFacturacion" name="tFacturacion" path="tipoFacturacion.idTipoFacturacion">
                            <form:option value="0" disabled="true"><c:out value="Seleccionar..."/></form:option>
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
                            <form:option value="0" disabled="true"><c:out value="Seleccionar..."/></form:option>
                            <c:forEach var="modalidadS" items="${modalidadP}">
                                <form:option value="${modalidadS.idModalidadProyecto}"><c:out value="${modalidadS.nombre}"/></form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                    <th style="text-align: right;">
                        Clase
                    </th>
                    <td>
                        <form:select id="selClase" name="clase" path="clase.idClaseProyecto">
                            <form:option value="0" disabled="true"><c:out value="Seleccionar..."/></form:option>
                            <c:forEach var="claseS" items="${clasesP}">
                                <form:option value="${claseS.idClaseProyecto}"><c:out value="${claseS.nombre}"/></form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>
            </table>
            <table class="tablaProyecto">
                <tr>
                    <th>
                        Carga archivo
                    </th>
                    <td colspan="2">
                        <form:input path="archivoProyecto.fichero" type="file" name="archivoProyecto" />
                    </td>
                </tr>
            </table>
            <input type="submit" value="Guardar Proyecto" class="pure-button pure-button-primary">
        </div></center>
        </form:form>
    </body>
</html>
