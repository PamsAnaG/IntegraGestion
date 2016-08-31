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
        <script type="text/javascript" src='/js/jquery.js'></script>
        <script type="text/javascript" src='/js/jquery-ui.js'></script>
        <script type="text/javascript" src='/js/jquery-ui.min.js'></script>
        <link href="/img/Demexis.ico" rel="shortcut icon" />
        <link type="text/css" href='/css/structure.css' rel="stylesheet" media="screen" />        
        <link type="text/css" href='/css/jquery-ui.structure.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='/css/jquery-ui.theme.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='/css/jquery-ui.theme.min.css' rel="stylesheet" media="screen" />

        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>        
        <script>
            $(function() {
                $("#progressbar1").progressbar({
                    value: 75,
                    create: function(event, ui) {
                        $(this).find('.ui-widget-header').css({'background-color': '#3CB371'})
                    }
                });
                $("#progressbar2").progressbar({
                    value: 41,
                    create: function(event, ui) {
                        $(this).find('.ui-widget-header').css({'background-color': '#3CB371'})
                    }
                });
                $("#progressbar3").progressbar({
                    value: 63,
                    create: function(event, ui) {
                        $(this).find('.ui-widget-header').css({'background-color': '#3CB371'})
                    }
                });
                $("#progressbar4").progressbar({
                    value: 52,
                    create: function(event, ui) {
                        $(this).find('.ui-widget-header').css({'background-color': '#FFC125'})
                    }
                });
                $("#progressbar5").progressbar({
                    value: 80,
                    create: function(event, ui) {
                        $(this).find('.ui-widget-header').css({'background-color': '#3CB371'})
                    }
                });
                $("#progressbar6").progressbar({
                    value: 50,
                    create: function(event, ui) {
                        $(this).find('.ui-widget-header').css({'background-color': '#EE0000'})
                    }
                });
            });

            function nuevoProyecto() {
                $("#nuevoPF").submit();
            }

            function menu(opcion) {
                if (opcion === 1) {
                    $("#frmMenu").attr('action', '/igestion/salir');
                    $("#frmMenu").submit();
                }
            }
        </script>
    </head>
    <body>
        <form:form id="frmMenu" class="header">
            <table style="height:100%;">
                <tr align="left" style=" vertical-align:middle;">
                    <th style="width:15px;"></th>
                    <th class="title generalUsr">
                        <img src="../img/DemexisLogo3.png" class="logo" alt="logo"/>
                    </th>  
                    <th style="width:15px;"></th>
                    <th class="title generalUsr">
                        <a href="dashboard.html" class="linkMenu">Dashboard</a>
                    </th>
                    <th style="width:15px;"></th>
                    <th class="title generalUsr">
                        <a href="mapaRecursos.html" class="linkMenu">Mapa de Recursos</a>
                    </th>
                    <th style="width:15px;"></th>
                    <th class="title generalUsr">
                        <a href="capturaRadar.html" class="linkMenu">Captura Radares</a>
                    </th>
                    <th style="width:15px;"></th>
                    <th class="title generalUsr">
                        <a href="aprobacionRadar.html" class="linkMenu">Aprobación Radar</a>
                    </th>
                    <th style="width:15px;"></th>
                    <th class="title generalUsr">
                        <a href="javascript: menu(1)" class="linkMenu">Salir</a>
                    </th>
                </tr>
            </table>
        </form:form>


        <form:form class="box dashboard" style="left: 13%; top: 35%; width: 60%; height: 80%;">
            <div style="height: 80%; overflow: auto;" id="boxScroll">
                <table style="margin-top: 2%; margin-left: 10px;">
                    <tr>
                        <td align="left" valign="middle" colspan="3" height="30px;">
                            <label class="table avance">Proyectos en curso: 6</label>
                        </td>
                    </tr>
                    <tr onclick="document.location = 'cabeceraProyecto.html';" style="height: 35px; vertical-align: bottom;">
                        <td align="left" style="width: 100%;" colspan="2">
                            <label class="table avance p" >ID 6578 | Servicios Salud Zacatecas | Implementación Seguro Popular</label>
                        </td>
                    </tr>
                    <tr onclick="document.location = 'cabeceraProyecto.html';">
                        <td>
                            <div id="progressbar1"></div>
                            <!--<img src="../img/avance1.png" style="width: 100%; height: 40px; cursor: pointer;"/>-->
                        </td>
                        <td align="center" style="width: 8%;">
                            <label class="table avance p" >75%</label>
                        </td>
                    </tr>
                    <tr onclick="document.location = 'cabeceraProyecto.html';" style="height: 35px; vertical-align: bottom;">
                        <td align="left" style="width: 100%;" colspan="2">
                            <label class="table avance p" >ID 6579 | Monte Pío Luz Saviñon | Creación de lotes venta por fundición</label>
                        </td>
                    </tr>
                    <tr onclick="document.location = 'cabeceraProyecto.html';">
                        <td>
                            <div id="progressbar2"></div>
                        </td>
                        <td align="center" style="width: 8%;">
                            <label class="table avance p" >41%</label>
                        </td>
                    </tr>
                    <tr onclick="document.location = 'cabeceraProyecto.html';" style="height: 35px; vertical-align: bottom;">
                        <td align="left" style="width: 100%;" colspan="3">
                            <label class="table avance p" >ID 6580 | COVEG | Configuración y actualización de momentos presupuestales</label>
                        </td>
                    </tr>
                    <tr onclick="document.location = 'cabeceraProyecto.html';">
                        <td>
                            <div id="progressbar3"></div>
                        </td>
                        <td align="center" style="width: 8%;">
                            <label class="table avance p" >63%</label>
                        </td>
                    </tr>
                    <tr onclick="document.location = 'cabeceraProyecto.html';" style="height: 35px; vertical-align: bottom;">
                        <td align="left" style="width: 100%;" colspan="3">
                            <label class="table avance p" >ID 6583 | Deportenis | Proyecto mantenimiento WM</label>
                        </td>
                    </tr>
                    <tr onclick="document.location = 'cabeceraProyecto.html';">
                        <td>
                            <div id="progressbar4"></div>
                        </td>
                        <td align="center" style="width: 8%;">
                            <label class="table avance p">52%</label>
                        </td>
                    </tr>
                    <tr onclick="document.location = 'cabeceraProyecto.html';" style="height: 35px; vertical-align: bottom;">
                        <td align="left" colspan="2">
                            <label class="table avance p">ID 6590 | COVEG | Configuración cuentas amortización contable</label>
                        </td>
                    </tr>
                    <tr style="left: 5%;" onclick="document.location = 'cabeceraProyecto.html';">
                        <td>
                            <div id="progressbar5"></div>
                        </td>
                        <td align="center" style="width: 8%;">
                            <label class="table avance p">86%</label>
                        </td>
                    </tr>
                    <tr onclick="document.location = 'cabeceraProyecto.html';" style="height: 35px; vertical-align: bottom;">
                        <td align="left" colspan="2">
                            <label class="table avance p">ID 6591 | Cliente | Descripción de proyecto</label>
                        </td>
                    </tr>
                    <tr style="left: 5%;" onclick="document.location = 'cabeceraProyecto.html';">
                        <td>
                            <div id="progressbar6"></div>
                        </td>
                        <td align="center" style="width: 8%;">
                            <label class="table avance p">86%</label>
                        </td>
                    </tr>
                </table>
            </div>
        </form:form>
        <form:form action="/igestion/nuevop" id="nuevoPF">
            <table>
                <tr onclick="javascript: nuevoProyecto()" style="cursor: pointer;">
                    <td>
                        <img src='../img/addP.png' style="left:5%; top:15px; width:60px; height:55px;" alt="AddP"/>
                    </td>
                    <td>
                        <label class="table avance p">Agregar proyecto</label>
                    </td>
                </tr>
            </table>      
        </form:form>
    </body>
</html>
