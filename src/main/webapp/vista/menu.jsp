<%-- 
    Document   : menu
    Created on : 10/09/2016, 06:03:58 PM
    Author     : Gabriel
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    
    <head>
        <script type="text/javascript" src='../js/dashboard.js'></script>
        <SCRIPT>
            function menu(opcion) {
                if (opcion === 1) {
                    $("#frmMenu").attr('action', '/igestion/salir');
                    $("#frmMenu").submit();
                }
            }
        </SCRIPT>
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
                        <a href="javascript: menu(1);" class="linkMenu">Salir</a>
                    </th>
                </tr>
            </table>
        </form:form>

    </body>
</html>
