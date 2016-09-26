<%-- 
    Document   : detalleProyecto
    Created on : 17/09/2016, 02:46:11 PM
    Author     : Gabriel
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script type="text/javascript" src='../js/jquery.js'></script>
        <script type="text/javascript" src='../js/jquery-ui.js'></script>
        <script type="text/javascript" src='../js/jquery-ui.min.js'></script>
        <script type="text/javascript" src='../js/jquery.treetable.js'></script>
        <script type="text/javascript" src='../js/detalleProyecto.js'></script>
        
        <link href="../img/Demexis.ico" rel="shortcut icon" />
        
        <link type="text/css" href='../css/structure.css' rel="stylesheet" media="screen" />        
        <link type="text/css" href='../css/jquery.treetable.css' rel="stylesheet" />
        <link type="text/css" href="../css/jquery.treetable.theme.default.css" rel="stylesheet" />
        <link type="text/css" href='../css/jquery-ui.structure.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.min.css' rel="stylesheet" media="screen" />

        <title>Integra Gesti�n</title>
        <script>
            $(function() {
                $("#tabs").tabs();
                $(document).tooltip();
                $("#dialog").dialog({autoOpen: false});
            });
            function muestraDialog() {
                $("#dialog").dialog('open');
            }
        </script>
        <style>
            .ui-tabs{
                width: 90%;
                position: relative;
                left: 5%;
            }

            .ui-tabs .ui-widget-content{
                background: white;
                font-size: 14px;
            }
            .ui-tabs .ui-state-default a{
                background: white;
                font-size: 16px;
            }
            .ui-tabs .ui-state-default a:hover{
                background: #72BECD;
                color: white;
            }
            .ui-tabs .ui-tabs-active a, .ui-tabs .ui-tabs-active a:hover{
                background: #607290;
                color: white;

            }             
            .ui-tabs .ui-tabs-nav{
                background: #448dae;
            }
            label {
                display: inline-block;
                width: 5em;
            }
        </style>

    </head>    
    <body>
        
        <input type="text" hidden="true" id="proyectoJSON" value='${proyectoJson}'>

        <div style="display:none" id="dialog" title="Configuraci�n alerta">
            Medio de entrega:<br>
            <input type="checkbox" name="Calendario">Programaci�n calendario<br>
            <input type="checkbox" name="Calendario">Mensaje texto<br>
            <input type="checkbox" name="Calendario">Aviso m�vil<br>
            <input type="checkbox" name="Calendario">Correo electr�nico<br>
        </div>


        <table class="tablaProyecto">
            <tr>
                <th>
                    Proyecto
                </th>
                <td>
                    ${proyecto.idProyecto}
                </td>
                <td colspan="2">
                    ${proyecto.nombre}
                </td>
            </tr>
            <tr>
                <th>
                    Cliente
                </th>
                <td>
                    ${proyecto.cliente.nombre}
                </td>
            </tr>
            <tr>
                <th>
                    Fechas
                </th>
                <td>
                    <fmt:formatDate value="${proyecto.fechaInicio}" pattern="yyyy-MM-dd" />
                </td>
                <td>
                    <fmt:formatDate value="${proyecto.fechaFin}" pattern="yyyy-MM-dd" />
                </td>
                <th>
                    Tipo
                </th>
                <td>
                    ${proyecto.tipo.nombre}
                </td>
            </tr>
        </table>
        <div id="tabs">
            <ul>
                <li><a href="#tabs-1">Grupo Tareas</a></li>
                <li><a href="#tabs-2">Tareas/Recurso</a></li>
                <li><a href="#tabs-3">Colaboradores</a></li>
                <li><a href="#tabs-4">Alertas</a></li>
            </ul>
            <div id="tabs-1">
                <table class="tablaDetProyecto">
                    <tr>
                        <th>
                            Grupo
                        </th>
                        <th>
                            Descripci&oacute;n
                        </th>
                        <th>
                            Fecha de inicio
                        </th>
                        <th>
                            Fecha fin
                        </th>
                    </tr>  
                    <c:forEach var="tarea" varStatus="numeroTarea" items="${proyecto.tareaPrincipal.tareasHijas}">
                        <tr>
                            <td>
                                ${numeroTarea.count}
                            </td>
                            <td>
                                ${tarea.nombre}
                            </td>
                            <td>
                                <fmt:formatDate value="${tarea.fechaInicio}" pattern="yyyy-MM-dd" />
                            </td>
                            <td>
                                <fmt:formatDate value="${tarea.fechaFin}" pattern="yyyy-MM-dd" />
                            </td>
                        </tr>     
                    </c:forEach>        
                </table>
            </div>
            <div id="tabs-2">
                <!--table id="tblDetalleProyecto" class="tablaDetProyecto"-->
                <table id="tblDetalleProyecto" class="treetable">
                    <tr>
                        <th style='text-align:left;'>
                            Grupo
                        </th>
                        <th style='text-align:left;'>
                            Descripci&oacute;n
                        </th>
                        <th>
                            Fecha de inicio
                        </th>
                        <th>
                            Fecha fin
                        </th>
                        <th>
                            Recursos
                        </th>
                    </tr>
                </table>
            </div>
            <div id="tabs-3">
                <table class="tablaDetProyecto">
                    <tr>
                        <th>
                            ID Colaborador
                        </th>                    
                        <th>
                            Nombre
                        </th>                    
                        <th>
                            Tipo
                        </th>                        
                    </tr>
                    <tr>                        
                        <td>
                            RG
                        </td>
                        <td>
                            Rogelio G&oacute;mez
                        </td>
                        <td>
                            L&iacute;der de proyecto
                        </td>                        
                    </tr>
                    <tr>                        
                        <td>
                            TJ
                        </td>
                        <td>
                            Tania Jim&eacute;nez
                        </td>
                        <td>
                            Gerente de proyecto
                        </td>                        
                    </tr>
                    <tr>                        
                        <td>
                            JF
                        </td>
                        <td>
                            Jos&eacute; Flores
                        </td>
                        <td>
                            ABAP
                        </td>                        
                    </tr>
                    <tr>                        
                        <td>
                            DJ
                        </td>
                        <td>
                            Daniel Jarabo
                        </td>
                        <td>
                            BD
                        </td>                        
                    </tr>
                    <tr>                        
                        <td>
                            AO
                        </td>
                        <td>
                            Arely Ortega
                        </td>
                        <td>
                            Java
                        </td>                        
                    </tr>
                </table>
            </div>
            <div id="tabs-4">
                <table class="tablaDetProyecto">
                    <tr>
                        <th>
                            Grupo
                        </th>                    
                        <th>
                            Descripci&oacute;n
                        </th>                    
                        <th>
                            Inicio tarea
                        </th>                    
                        <th>
                            Fin tarea
                        </th>
                        <th>
                            Atraso
                        </th>
                        <th>
                            % Avance
                        </th>
                        <th>
                            Liberaci&oacute;n de recurso
                        </th>
                        <th>
                            Inicio de tarea anticipado
                        </th>
                        <th>
                            Fin de tarea anticipado
                        </th>
                    </tr>
                    <tr>
                        <td class="tareaCabecera">
                            1
                        </td>
                        <td class="tareaCabecera">
                            Levantamiento de informaci&oacute;n
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>                        
                    </tr>
                    <tr>
                        <td></td>
                        <td onclick="javascript: muestraDialog()">
                            Requerimientos funcionales
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> PT
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> PA
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> C
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            40 MA
                        </td>
                        <td onclick="javascript: muestraDialog()">

                        </td>
                        <td onclick="javascript: muestraDialog()"></td>
                        <td onclick="javascript: muestraDialog()"></td>                        
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            Requerimientos no funcionales
                        </td>
                        <td onclick="javascript: muestraDialog()">                            </td>
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> PA
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> C
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            60 MA
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> P
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            1 TA
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            1 PC
                        </td>                        
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            Propuesta tecnol&oacute;gica
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> PA
                        </td>
                        <td onclick="javascript: muestraDialog()">                            
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> C
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            60 MA
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> P
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            1 TA
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            1 PC
                        </td>                        
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            Entrega demo no funcional
                        </td>
                        <td onclick="javascript: muestraDialog()">                            
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> C
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> P
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            1 PC
                        </td>                        
                    </tr>  
                    <tr>
                        <td class="tareaCabecera">
                            2
                        </td>
                        <td class="tareaCabecera">
                            Construcci&oacute;n
                        </td>
                        <td onclick="javascript: muestraDialog()"></td>
                        <td onclick="javascript: muestraDialog()"></td>
                        <td onclick="javascript: muestraDialog()"></td>
                        <td onclick="javascript: muestraDialog()"></td>
                        <td onclick="javascript: muestraDialog()"></td>
                        <td onclick="javascript: muestraDialog()"></td>
                        <td onclick="javascript: muestraDialog()"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            Dise�o de base de datos
                        </td>
                        <td onclick="javascript: muestraDialog()">   
                            <img src="../img/correcto.png" width="10" height="10" alt=''> PA
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">                            
                        </td>                        
                    </tr>  
                    <tr>
                        <td></td>
                        <td>
                            Creaci�n de proyecto
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>                        
                        <td onclick="javascript: muestraDialog()"> 
                            <img src="../img/correcto.png" width="10" height="10" alt=''> PTA
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>                        
                    </tr>  
                    <tr>
                        <td></td>
                        <td>
                            M�dulo de Administraci�n
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> TA
                        </td>                        
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                            1 PTA
                        </td>                        
                    </tr>  
                    <tr>
                        <td></td>
                        <td>
                            M�dulo de recepci�n de documentos
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>                        
                        <td onclick="javascript: muestraDialog()">
                            <img src="../img/correcto.png" width="10" height="10" alt=''> PA
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()"> 
                            <img src="../img/correcto.png" width="10" height="10" alt=''> TA
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>
                        <td onclick="javascript: muestraDialog()">
                        </td>                        
                    </tr>  
                </table>
            </div>
        </div>
        <footer id="main">            
        </footer>
                
        <script>
            $("#tblDetalleProyecto").treetable({ expandable: true });
            generaTablaDetalle();
        </script>
    </body>
</html>

