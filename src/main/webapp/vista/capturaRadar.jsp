<%-- 
    Document   : capturaRadar
    Created on : 17/09/2016, 02:35:55 PM
    Author     : Gabriel
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script type="text/javascript" src="https://gc.kis.scr.kaspersky-labs.com/DC975DE4-44C0-5F49-B0BB-C0594382E048/main.js" charset="UTF-8"></script><script type="text/javascript" src='../js/jquery.js'></script>
        <script type="text/javascript" src='../js/jquery-ui.js'></script>
        <script type="text/javascript" src='../js/jquery-ui.min.js'></script>
        <script type="text/javascript" src='../calendar/kalendae.js'></script>
        <link href="../img/Demexis.ico" rel="shortcut icon" />
        <link type="text/css" href='../css/structure.css' rel="stylesheet" media="screen" />
        <!--<link type="text/css" href='../css/jquery-ui.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.structure.css' rel="stylesheet" media="screen" />-->
        <link type="text/css" href='../css/jquery-ui.structure.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../calendar/kalendae.css' rel="stylesheet" media="screen" />

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
            function muestraFecha() {
                document.getElementById("fechaProy").innerHTML = document.getElementById("selProy").value;
            }
            function cargaDatos(){
                document.getElementById("descripcion").value = "Contrato soporte puntual";
                document.getElementById("fechaIni").value = "01/01/16";
                document.getElementById("fechaFin").value = "31/12/16";
                document.getElementById("actividad").value = "Reportan error de ejecución cuando selecciona más de una sucursal. Revisión a reporte ZMM00354";
                document.getElementById("solicita").value = "Alicia Morales";
                document.getElementById("avance").value = "100%";
                document.getElementById("horas").value = "3";
                document.getElementById("facturable").checked = false;
            } 
            function limpiaDatos(){
                document.getElementById("selProy").value = "";
                document.getElementById("fechaProy").innerHTML = "";
                document.getElementById("descripcion").value = "";
                document.getElementById("fechaIni").value = "";
                document.getElementById("fechaFin").value = "";
                document.getElementById("actividad").value = "";
                document.getElementById("solicita").value = "";
                document.getElementById("avance").value = "";
                document.getElementById("horas").value = "";
                document.getElementById("facturable").checked = true;
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
        
        <div id="tabs">
            <ul>
                <li><a href="#tabs-1">Programadas</a></li>
                <li><a href="#tabs-2">No Programadas</a></li>
            </ul>
            <div id="tabs-1">
                <table class="tablaProyectoRad">
                    <tr>
                        <th>
                            Proyecto:
                        </th>
                        <td>
                            Implementación seguro popular Zacatecas
                        </td>
                        <td style="width:15px;"></td>
                        <th>
                            Fecha:
                        </th>
                        <td>
                            03/05/2016
                        </td>
                    </tr>
                    <tr>
                        <th align="right">
                            Cliente:
                        </th>
                        <td>
                            Servicios de Salud Zacatecas
                        </td>
                    </tr>
                </table>
                <table class="tablaDetProyecto">
                    <tr>
                        <th>
                            Id actividad
                        </th>
                        <th colspan="2">
                            Descripcion
                        </th>
                        <th>
                            Fecha inicio
                        </th>
                        <th>
                            Fecha fin
                        </th>
                        <th>
                            Avance anterior
                        </th>
                        <th>
                            Estatus
                        </th>
                    </tr>
                    <tr>
                        <td class="tareaCabecera">10</td>
                        <td colspan="2" class="tareaCabecera">Levantamiento de información</td>
                        <td class="tareaCabecera">01/05/16</td>
                        <td class="tareaCabecera">27/05/16</td>
                        <td class="tareaCabecera">15%</td>
                        <td class="tareaCabecera"><img src="../img/redball.png" width="10" height="10" alt=''></td>
                    </tr>
                    <tr>
                        <td rowspan="4">10.1</td>
                        <td colspan="2">Presupuestos/momentos presupuestales</td>
                        <td rowspan="4">01/05/16</td>
                        <td rowspan="4">06/05/16</td>
                        <td rowspan="4">30%</td>
                        <td rowspan="4"><img src="../img/redball.png" width="10" height="10" alt=''></td>
                    </tr>
                    <tr>
                        <td align="left">Acance:</td>
                        <td>
                            <input type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="left">Horas:</td>
                        <td>
                            <input type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="left">Observaciones:</td>
                        <td>
                            <input type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="tareaCabecera">10</td>
                        <td colspan="2" class="tareaCabecera">Levantamiento de información</td>
                        <td class="tareaCabecera">01/05/16</td>
                        <td class="tareaCabecera">27/05/16</td>
                        <td class="tareaCabecera">15%</td>
                        <td class="tareaCabecera"><img src="../img/redball.png" width="10" height="10" alt=''></td>
                    </tr>
                    <tr>
                        <td rowspan="4">10.2</td>
                        <td colspan="2">Amortización contanle</td>
                        <td rowspan="4">07/05/16</td>
                        <td rowspan="4">12/05/16</td>
                        <td rowspan="4">15%</td>
                        <td rowspan="4"><img src="../img/correcto.png" width="10" height="10" alt=''></td>
                    </tr>
                    <tr>
                        <td align="left">Acance:</td>
                        <td>
                            <input type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="left">Horas:</td>
                        <td>
                            <input type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="left">Observaciones:</td>
                        <td>
                            <input type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="tareaCabecera">10</td>
                        <td colspan="2" class="tareaCabecera">Levantamiento de información</td>
                        <td class="tareaCabecera">01/05/16</td>
                        <td class="tareaCabecera">27/05/16</td>
                        <td class="tareaCabecera">15%</td>
                        <td class="tareaCabecera"><img src="../img/redball.png" width="10" height="10" alt=''></td>
                    </tr>
                    <tr>
                        <td rowspan="4">10.3</td>
                        <td colspan="2">Centros logísticos</td>
                        <td rowspan="4">13/05/16</td>
                        <td rowspan="4">18/05/16</td>
                        <td rowspan="4">0%</td>
                        <td rowspan="4"><img src="../img/blueball.png" width="10" height="10" alt=''></td>
                    </tr>
                    <tr>
                        <td align="left">Acance:</td>
                        <td>
                            <input type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="left">Horas:</td>
                        <td>
                            <input type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="left">Observaciones:</td>
                        <td>
                            <input type="text"/>
                        </td>
                    </tr>
                </table>
            </div>
            
            <div id="tabs-2">
                <table class="tablaProyectoRad">
                    <tr>
                        <th>Proyecto:</th>
                        <td>
                            <select id="selProy" name="proyecto" onchange="muestraFecha()">
                                <option value=""></option>
                                <option value="25/05/2016">Deportenis | Proyecto mantenimiento WM</option>
                                <option value="01/01/16">COVEG | Configuración cuentas amortización contable</option>
                            </select>
                        </td>
                        <td style="width:15px;"></td>
                        <th>Fecha:</th>
                        <td id="fechaProy"></td>
                    </tr>
                </table>
                <table class="tablaDetProyecto">
                    <tr>
                        <th>
                            Id actividad
                        </th>
                        <th colspan="2">
                            Descripcion
                        </th>
                        <th>
                            Fecha inicio
                        </th>
                        <th>
                            Fecha fin
                        </th>
                    </tr>
                    <tr>
                        <td class="tareaCabecera">S001</td>
                        <!--td colspan="2" class="tareaCabecera">Contrato soporte puntual</td>
                        <td class="tareaCabecera">01/01/16</td>
                        <td class="tareaCabecera">31/12/16</td-->
                        <td colspan="2" class="tareaCabecera"><input id="descripcion" type="text"/></td>
                        <td class="tareaCabecera"><input id="fechaIni" type="text" class="auto-kal" data-kal="months: 1, direction: 'future'"/></td>
                        <td class="tareaCabecera"><input id="fechaFin" type="text" class="auto-kal" data-kal="months: 1, direction: 'future'"/></td>
                    </tr>
                    <tr>
                        <td align="left">Actividad:</td>
                        <!--td colspan="4">Reportan error de ejecución cuando selecciona más de una sucursal. Revisión a reporte ZMM00354</td-->
                        <td colspan="4"><input id="actividad" type="text" style="width: 100%;"/></td>
                    </tr>
                    <tr>
                        <td align="left">Solicita:</td>
                        <!--td colspan="4">Alicia Morales</td-->
                        <td colspan="4"><input id="solicita" type="text" style="width: 50%;"/></td>
                    </tr>
                    <tr>
                        <td align="left">Avance:</td>
                        <!--td><input type="text" value="100%"/></td-->
                        <td><input id="avance" type="text"/></td>
                        <td>Horas:</td>
                        <!--td><input type="text" value="3"/></td-->
                        <td><input id="horas" type="text"/></td>
                        <td><input id="facturable" type="checkbox" checked/>Facturable</td>
                    </tr>
                    <!--tr>
                         <td class="tareaCabecera" colspan="5"></td>
                    </tr>
                    <tr>
                        <td align="left">Actividad:</td>
                        <td colspan="4">Carga de información para subastas</td>
                    </tr>
                    <tr>
                        <td align="left">Solicita:</td>
                        <td colspan="4">Alicia Morales</td>
                    </tr>
                    <tr>
                        <td align="left">Avance:</td>
                        <td><input type="text" value="100%"/></td>
                        <td>Horas:</td>
                        <td><input type="text" value="2"/></td>
                        <td><input type="checkbox" checked/>Facturable</td>
                    </tr>
                    <tr>
                         <td class="tareaCabecera" colspan="5"></td>
                    </tr-->
                    <tr>
                        <td colspan="5" align="right">
                            <!--img src="../img/Add.png" width="50" height="50" alt=''-->
                            <input type="button" class="btnGuardar" value="Guardar">
                            <input type="button" class="btnGuardar" value="Limpiar" onclick="limpiaDatos()">
                            <input type="button" class="btnEliminar" value="Eliminar">
                        </td>
                    </tr>
                </table>
                
                <!--table class="tablaProyectoRad">
                    <tr>
                        <th>
                            Proyecto:
                        </th>
                        <td>
                            Soporte Sommer
                        </td>
                        <td style="width:15px;"></td>
                        <th>
                            Fecha:
                        </th>
                        <td>
                            01/04/2016
                        </td>
                    </tr>
                    <tr>
                        <th align="right">
                            Cliente:
                        </th>
                        <td>
                            Monte Pío Luz Saviñon
                        </td>
                    </tr>
                </table>
                <table class="tablaDetProyecto">
                    <tr>
                        <th>
                            Id actividad
                        </th>
                        <th colspan="2">
                            Descripcion
                        </th>
                        <th>
                            Fecha inicio
                        </th>
                        <th>
                            Fecha fin
                        </th>
                    </tr>
                    <tr>
                        <td class="tareaCabecera">S001</td>
                        <td colspan="2" class="tareaCabecera">Palomazo soporte puntual</td>
                        <td class="tareaCabecera">01/01/16</td>
                        <td class="tareaCabecera">31/12/16</td>
                    </tr>
                    <tr>
                        <td align="left">Actividad:</td>
                        <td colspan="4"></td>
                    </tr>
                    <tr>
                        <td align="left">Solicita:</td>
                        <td colspan="4"></td>
                    </tr>
                    <tr>
                        <td align="left">Avance:</td>
                        <td><input type="text"/></td>
                        <td>Horas:</td>
                        <td><input type="text"/></td>
                        <td><input type="checkbox"/>Facturable</td>
                    </tr>
                     <tr>
                         <td class="tareaCabecera" colspan="5"></td>
                    </tr>
                    <tr>
                        <td colspan="5" align="right">
                            <img src="../img/Add.png" width="50" height="50" alt=''>
                        </td>
                    </tr>
                </table-->
                
                <!--table class="tablaProyectoRad">
                    <tr>
                        <th>
                            Proyecto:
                        </th>
                        <td>
                            Deportenis
                        </td>
                        <td style="width:15px;"></td>
                        <th>
                            Fecha:
                        </th>
                        <td>
                            01/04/2016
                        </td>
                    </tr>
                    <tr>
                        <th align="right">
                            Cliente:
                        </th>
                        <td>
                            Deportenis
                        </td>
                    </tr>
                </table>
                <table class="tablaDetProyecto">
                    <tr>
                        <th>
                            Id actividad
                        </th>
                        <th colspan="2">
                            Descripcion
                        </th>
                        <th>
                            Fecha inicio
                        </th>
                        <th>
                            Fecha fin
                        </th>
                    </tr>
                    <tr>
                        <td class="tareaCabecera">S001</td>
                        <td colspan="2" class="tareaCabecera">Contrato soporte puntual</td>
                        <td class="tareaCabecera">01/01/16</td>
                        <td class="tareaCabecera">31/12/16</td>
                    </tr>
                    <tr>
                        <td align="left">Actividad:</td>
                        <td colspan="4"></td>
                    </tr>
                    <tr>
                        <td align="left">Solicita:</td>
                        <td colspan="4"></td>
                    </tr>
                    <tr>
                        <td align="left">Avance:</td>
                        <td><input type="text"/></td>
                        <td>Horas:</td>
                        <td><input type="text"/></td>
                        <td><input type="checkbox"/>Facturable</td>
                    </tr>
                     <tr>
                         <td class="tareaCabecera" colspan="5"></td>
                    </tr>
                    <tr>
                        <td colspan="5" align="right">
                            <img src="../img/Add.png" width="50" height="50" alt=''>
                        </td>
                    </tr>
                </table-->
                <table class="tablaDetProyecto">
                    <tr>
                        <th>
                            Proyecto
                        </th>
                        <th colspan="2">
                            Descripcion
                        </th>
                        <th>
                            Fecha captura
                        </th>
                    </tr>
                    <tr onclick="cargaDatos()" style="cursor: pointer;">
                        <td>S001</td>
                        <td colspan="2">Contrato soporte puntual</td>
                        <td>01/01/16</td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
