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
        <script type="text/javascript" src='../js/kalendae.js'></script>

        <link href="../img/Demexis.ico" rel="shortcut icon" />

        <link type="text/css" href='../css/structure.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery.treetable.css' rel="stylesheet" />
        <link type="text/css" href="../css/jquery.treetable.theme.default.css" rel="stylesheet" />
        <link type="text/css" href='../css/jquery-ui.structure.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/font-awesome-4.6.3/css/font-awesome.min.css' rel="stylesheet" media="screen" />

        <title>Integra Gestión</title>
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

        <div style="display:none" id="dialog" title="Configuración alerta">
            Medio de entrega:<br>
            <input type="checkbox" id="calendario" name="calendario">Programación calendario<br>
            <input type="checkbox" id="mensaje" name="mensaje">Mensaje texto<br>
            <input type="checkbox" id="push" name="push">Aviso móvil<br>
            <input type="checkbox" id="correo" name="correo">Correo electrónico<br>
            <div id="porcentajeC">
                Porcentaje de avance
                <input type="text" id="porcentaje" name="procentaje"/>
            </div>            
        </div>
        
        <div style="display:none" id="dialogRecursos" title="Selecci&oacute;n de Recursos">
            <c:forEach var="recurso" varStatus="numeroRecurso" items="${recursos}">
                <input type="checkbox" id="chkR${recurso.idRecurso}" data-value="${recurso.idRecurso}" data-value2="${recurso.abreviacion}" data-value3="${recurso.nombre} ${recurso.apPaterno}">${recurso.nombre} ${recurso.apPaterno}<br>
            </c:forEach>          
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
                <center>
                    <input id="agregarTaraDP" type="button" class="button-success pure-button pure-button-primary" 
                               value="Agregar Tarea" onclick="agregarTarea();"/>
                    <input id="guardaCambiosDP" type="button" class="pure-button pure-button-primary" 
                               value="Guardar Cambios" onclick="guardarCambios();"/>
                </center>
                <!--table id="tblDetalleProyecto" class="tablaDetProyecto"-->
                <table id="tblDetalleProyecto"  style="font-size:medium;">
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
                <table border="1" id="tblAlertasProyecto" class="tablaDetProyecto">
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
                </table>
            </div>
        </div>
        <footer id="main">            
        </footer>

        <script>
            $("#tblAlertasProyecto").treetable({expandable: true});
            generaTablaAlertas();
            $("#tblDetalleProyecto").treetable({expandable: true});
            generaTablaDetalle();
        </script>
    </body>
</html>

