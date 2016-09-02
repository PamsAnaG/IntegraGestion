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
        <title>Nuevo Proyecto</title>
        <script type="text/javascript" src='/js/jquery.js'></script>
        <script type="text/javascript" src='/js/jquery-ui.js'></script>
        <script type="text/javascript" src='/js/jquery-ui.min.js'></script>
        <link href="/img/Demexis.ico" rel="shortcut icon" />
        <link type="text/css" href='/css/structure.css' rel="stylesheet" media="screen" />        
        <link type="text/css" href='/css/jquery-ui.structure.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='/css/jquery-ui.theme.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='/css/jquery-ui.theme.min.css' rel="stylesheet" media="screen" />
        <script type="text/javascript" src='../js/kalendae.js'></script>
        <link type="text/css" href='../js/kalendae.css' rel="stylesheet" media="screen" />

        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
        <script>
            $(function() {
                $.getJSON("/igestion/clientes", function(data) {
                    var items = [];
                    $.each(data, function(key, val) {
                        $("#selCliente").append('<option value="' + val.idCliente + '" >' + val.nombre + '</option>');
                    });
                });
            });
        </script>
    </head>
    <body>
        <form>
            <table class="tablaProyecto" style="margin-bottom: 0;">
                <tr>
                    <th>
                        Cliente
                    </th>
                    <td>
                        <select id="selCliente" name="cliente">
                            <option value=""></option>                            
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>
                        Proyecto
                    </th>
                    <td colspan="3">
                        <input id="proyecto" type="text" style="width: 100%;"/>
                    </td>
                </tr>
                <tr>
                    <th>
                        Fechas
                    </th>
                    <td>Inicio:<input id="fechaIni" type="text" class="auto-kal" data-kal="months: 1, direction: 'future'"/></td>
                    <td>Fin:<input id="fechaFin" type="text" class="auto-kal" data-kal="months: 1, direction: 'future'"/></td>
                    <th>
                        Tipo
                    </th>
                    <td>
                        <select id="selTipoP" name="cliente">
                            <option value=""></option>
                            <option value="1">Bajo Plan</option>
                            <option value="2">Soporte</option>
                            <option value="3">Garantía</option>
                            <option value="4">Iguala</option>
                            <option value="4">Tiempo y Materiales</option>
                        </select>
                    </td>
                </tr>
            </table>
            <table class="tablaProyecto a">
                <tr>
                    <th>
                        Radar
                    </th>
                    <td>
                        <select id="selTipoP" name="cliente">
                            <option value=""></option>
                            <option value="1">Programadas</option>
                            <option value="2">No Programadas</option>
                        </select>
                    </td>
                    <th>
                        Clase
                    </th>
                    <td>
                        <select id="selTipoP" name="cliente">
                            <option value=""></option>
                            <option value="1">Cliente final</option>
                            <option value="2">Asociado</option>
                        </select>
                    </td>
                    <th>
                        Facturación
                    </th>
                    <td>
                        <select id="selTipoP" name="cliente">
                            <option value=""></option>
                            <option value="1">% Fase</option>
                            <option value="2">Mensual</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>
                        Modalidad
                    </th>
                    <td>
                        <select id="selTipoP" name="cliente">
                            <option value=""></option>
                            <option value="1">Local</option>
                            <option value="2">Remoto</option>
                        </select>
                    </td>
                    <th>
                        Alertas
                    </th>
                    <td>
                        <select id="selTipoP" name="cliente">
                            <option value=""></option>
                            <option value="1">% Avance</option>
                            <option value="2">Finalizar grupo tareas</option>
                        </select>
                    </td>
                    <td>
                        <input type="button" class="btnGuardar" value="Carga de archivo">
                    </td>
                </tr>
            </table>
        </form>
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
