<%-- 
    Document   : menu
    Created on : 10/09/2016, 06:03:58 PM
    Author     : Gabriel
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    
    <head>
        <script type="text/javascript" src='../js/dashboard.js'></script>
    </head>
    
    <body>
    <center>
        <form:form id="frmMenu" class="pure-menu pure-menu-horizontal">
            <!--img src="../img/DemexisLogo3.png" class="logo" alt="logo"/-->
            <ul class="pure-menu-list" style="font-size: larger;">
                <!--li class="pure-menu-item"><a href="#" class="pure-menu-heading pure-menu-link">Dashboard</a></li-->
                <li class="pure-menu-item"><a href="javascript: menu(1);" class="pure-menu-link">Dashboard</a></li>
                <li class="pure-menu-item"><a href="javascript: menu(2);" class="pure-menu-link">Mapa de Recursos</a></li>
                <li class="pure-menu-item"><a href="javascript: menu(3);" class="pure-menu-link">Captura Radares</a></li>
                <li class="pure-menu-item"><a href="javascript: menu(4);" class="pure-menu-link">Aprobaci&oacute;n Radar</a></li>
                <li class="pure-menu-item"><a href="javascript: menu(5);" class="pure-menu-link">Salir</a></li>
            </ul>
        </form:form>
    </center>
    </body>
</html>
