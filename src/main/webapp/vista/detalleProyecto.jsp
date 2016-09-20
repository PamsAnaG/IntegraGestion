<%-- 
    Document   : detalleProyecto
    Created on : 17/09/2016, 02:46:11 PM
    Author     : Gabriel
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script type="text/javascript" src="https://gc.kis.scr.kaspersky-labs.com/DC975DE4-44C0-5F49-B0BB-C0594382E048/main.js" charset="UTF-8"></script><script type="text/javascript" src='../js/jquery.js'></script>
        <script type="text/javascript" src='../js/jquery-ui.js'></script>
        <script type="text/javascript" src='../js/jquery-ui.min.js'></script>
        <link href="../img/Demexis.ico" rel="shortcut icon" />
        <link type="text/css" href='../css/structure.css' rel="stylesheet" media="screen" />        
        <link type="text/css" href='../css/jquery-ui.structure.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.min.css' rel="stylesheet" media="screen" />

        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <title>Integra Gestión</title>
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

        <div style="display:none" id="dialog" title="Configuración alerta">
            Medio de entrega:<br>
            <input type="checkbox" name="Calendario">Programación calendario<br>
            <input type="checkbox" name="Calendario">Mensaje texto<br>
            <input type="checkbox" name="Calendario">Aviso móvil<br>
            <input type="checkbox" name="Calendario">Correo electrónico<br>
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
                    ${proyecto.fechaInicio}
                </td>
                <td>
                    ${proyecto.fechaFin}
                </td>
                <td>
                    Tipo
                </td>
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
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            Levantamiento de informaci&oacute;n
                        </td>
                        <td>
                            01/05/2016
                        </td>
                        <td>
                            10/05/2016
                        </td>
                    </tr>
                    <tr>
                        <td>
                            2
                        </td>
                        <td>
                            Construcci&oacute;n
                        </td>
                        <td>
                            11/05/2016
                        </td>
                        <td>
                            19/06/2016
                        </td>
                    </tr>
                    <tr>
                        <td>
                            3
                        </td>
                        <td>
                            Pruebas
                        </td>
                        <td>
                            20/06/2016
                        </td>
                        <td>
                            25/07/2016
                        </td>
                    </tr>
                    <tr>
                        <td>
                            4
                        </td>
                        <td>
                            Implantaci&oacute;n
                        </td>
                        <td>
                            25/07/2016
                        </td>
                        <td>
                            10/08/2016
                        </td>
                    </tr>
                </table>
            </div>
            <div id="tabs-2">
                <table class="tablaDetProyecto">
                    <tr>
                        <th>
                            Grupo
                        </th>                    
                        <th colspan="2">
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
                    <tr>
                        <td class="tareaCabecera">
                            1
                        </td>
                        <td colspan="2" class="tareaCabecera">
                            Levantamiento de informaci&oacute;n
                        </td>
                        <td class="tareaCabecera">
                            01/05/2016
                        </td>
                        <td class="tareaCabecera">
                            10/05/2016
                        </td>
                        <td class="tareaCabecera" title="Rogelio Gómez, Tania Jiménez">
                            RG, TJ                            
                        </td>                                                
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            Tarea
                        </td>
                        <td>
                            Descripci&oacute;n
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            1.1
                        </td>
                        <td>
                            Requerimientos funcionales
                        </td>
                        <td>
                            01/0/2016
                        </td>
                        <td>
                            03/0/2016
                        </td>
                        <td title="José Flores">
                            JF
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            1.2
                        </td>
                        <td>
                            Requerimientos no funcionales
                        </td>
                        <td>
                            04/0/2016
                        </td>
                        <td>
                            05/0/2016
                        </td>
                        <td title="José Flores">
                            JF
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            1.3
                        </td>
                        <td>
                            Propuesta tecnol&oacute;gica
                        </td>
                        <td>
                            06/0/2016
                        </td>
                        <td>
                            07/0/2016
                        </td>
                        <td title="José Flores">
                            JF
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            1.4
                        </td>
                        <td>
                            Entrega demo no funcional
                        </td>
                        <td>
                            07/0/2016
                        </td>
                        <td>
                            10/0/2016
                        </td>
                        <td title="José Flores">
                            JF
                        </td>
                    </tr>
                    <tr>
                        <td class="tareaCabecera">
                            2
                        </td>
                        <td colspan="2" class="tareaCabecera">
                            Construcci&oacute;n                            
                        </td>
                        <td class="tareaCabecera">
                            11/05/2016
                        </td>
                        <td class="tareaCabecera">
                            19/05/2016
                        </td>
                        <td class="tareaCabecera" title="Rogelio Gómez, Tania Jiménez">
                            RG, TJ
                        </td>                                                
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            2.1
                        </td>
                        <td>
                            Diseño de base de datos
                        </td>
                        <td>
                            11/05/2016
                        </td>
                        <td>
                            13/05/2016
                        </td>
                        <td title="Daniel Jarabo">
                            DJ
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            2.2
                        </td>
                        <td>
                            Creaci&oacute;n de proyecto
                        </td>
                        <td>
                            13/05/2016
                        </td>
                        <td>
                            15/05/2016
                        </td>
                        <td title="Arely Ortega">
                            AO
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            2.3
                        </td>
                        <td>
                            M&oacute;dulo de Administraci&oacute;n
                        </td>
                        <td>
                            15/05/2016
                        </td>
                        <td>
                            16/05/2016
                        </td>
                        <td title="Arely Ortega">
                            AO
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                            2.4
                        </td>
                        <td>
                            M&oacute;dulo de recepci&oacute;n de documentos
                        </td>
                        <td>
                            16/05/2016
                        </td>
                        <td>
                            20/05/2016
                        </td>
                        <td title="Arely Ortega">
                            AO
                        </td>
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
                            Diseño de base de datos
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
                            Creación de proyecto
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
                            Módulo de Administración
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
                            Módulo de recepción de documentos
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

    </body>
</html>

