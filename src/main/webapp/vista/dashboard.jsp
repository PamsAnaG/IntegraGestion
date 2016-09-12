<%-- 
    Document   : dashboard
    Created on : Aug 8, 2016, 3:01:07 PM
    Author     : pamela.gutierrez
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    
    <head>
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        
        <script type="text/javascript" src='../js/dashboard.js'></script>
        <SCRIPT>
            function nuevoProyecto() {
                $("#nuevoPF").submit();
            }
        </SCRIPT>
    </head>
    
    <body>
        
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