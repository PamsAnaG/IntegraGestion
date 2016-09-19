<%-- 
    Document   : aprobacionRadar
    Created on : 17/09/2016, 02:38:48 PM
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
                document.getElementById("actividad").innerHTML = document.getElementById("tActividad").innerHTML;
                document.getElementById("descripcion").innerHTML = "Alta de proveedores";
                document.getElementById("proyecto").innerHTML = document.getElementById("tProyecto").innerHTML;
                document.getElementById("avance").innerHTML = "35%";
                document.getElementById("horas").innerHTML = "15";
                document.getElementById("fechaIni").innerHTML = "29/04/2016";
                document.getElementById("fechaFin").innerHTML = "02/05/2016";
                document.getElementById("recurso").innerHTML = document.getElementById("tRecurso").innerHTML;
                document.getElementById("comentarios").innerHTML = "";
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
                        <th>Id Actividad:</th><td id="actividad">10.1</td>
                        <td style="width:15px;"></td>
                        <th align="right">Descripción:</th><td id="descripcion">Levantamiento de información</td>
                        <td style="width:15px;"></td>
                        <th align="right">Proyecto:</th><td id="proyecto" colspan="2">Presupuestos/momentos presupuestales</td>
                    </tr>
                    <tr>
                        <th align="right">Avance:</th><td id="avance">15%</td>
                        <td style="width:15px;"></td>
                        <th align="right">Horas:</th><td id="horas">9</td>
                        <td style="width:15px;"></td>
                        <th align="right">Fechas:</th><td id="fechaIni">Inicio: 01/05/16</td><td id="fechaFin">Fin: 27/05/16</td>
                    </tr>
                    <tr>
                        <th align="right">Recurso:</th><td id="recurso">Rogelio Gómez</td>
                        <td style="width:15px;"></td>
                        <th align="right">Observaciones:</th><td id="comentarios" colspan="3">Hay dudas pendientes de tratar con el cliente</td>
                    </tr>
                    <tr>
                        <label class="table avance">Observaciones</label><br>
                        <textarea rows="4" cols="100"></textarea><br>
                        <input type="button" class="btnGuardar" value="Confirmar">
                        &nbsp;
                        <input type="button" class="btnEliminar" value="Rechazar">
                    </tr>
                    <br><br>
                </table>
                <br><br>
                <table class="tablaDetProyecto">
                    <tr>
                        <th>
                            Id actividad
                        </th>
                        <th>
                            Proyecto
                        </th>
                        <th>
                            Recurso
                        </th>
                        <th>
                            Fecha
                        </th>
                    </tr>
                    <tr onclick="cargaDatos()" style="cursor: pointer;">
                        <td id="tActividad">9.5</td>
                        <td id="tProyecto">Creación de lotes venta por fundición</td>
                        <td id="tRecurso">Tania Jiménez</td>
                        <td id="tFecha">27/05/16</td>
                    </tr>
                </table>
            </div>
            
            <div id="tabs-2">
                <table class="tablaProyectoRad">
                    <tr>
                        <th>Id Actividad:</th><td id="actividad">15.1</td>
                        <td style="width:15px;"></td>
                        <th align="right">Descripción:</th><td id="descripcion">Soporte pactado</td>
                        <td style="width:15px;"></td>
                        <th align="right">Proyecto:</th><td id="proyecto" colspan="2">Proyecto mantenimiento WM</td>
                    </tr>
                    <tr>
                        <th align="right">Avance:</th><td id="avance">90%</td>
                        <td style="width:15px;"></td>
                        <th align="right">Horas:</th><td id="horas">4</td>
                        <td style="width:15px;"></td>
                        <th align="right">Fechas:</th><td id="fechaIni">Inicio: 01/05/16</td><td id="fechaFin">Fin: 01/05/16</td>
                    </tr>
                    <tr>
                        <th align="right">Recurso:</th><td id="recurso">Daniel Jarabo</td>
                        <td style="width:15px;"></td>
                        <th align="right">Solicita:</th><td id="comentarios">Anabel Sosa</td>
                        <td style="width:15px;"></td>
                        <th align="right">Facturable:</th><td id="comentarios" colspan="2">No</td>
                    </tr>
                    <tr>
                        <label class="table avance">Observaciones</label><br>
                        <textarea rows="4" cols="100"></textarea><br>
                        <input type="button" class="btnGuardar" value="Confirmar">
                        &nbsp;
                        <input type="button" class="btnEliminar" value="Rechazar">
                    </tr>
                    <br><br>
                </table>
                <br><br>
                <table class="tablaDetProyecto">
                    <tr>
                        <th>
                            Id actividad
                        </th>
                        <th>
                            Proyecto
                        </th>
                        <th>
                            Recurso
                        </th>
                        <th>
                            Fecha
                        </th>
                    </tr>
                    <!--tr onclick="cargaDatos()" style="cursor: pointer;">
                        <td id="tActividad">9.5</td>
                        <td id="tProyecto">Creación de lotes venta por fundición</td>
                        <td id="tRecurso">Tania Jiménez</td>
                        <td id="tFecha">27/05/16</td>
                    </tr-->
                </table>
            </div>
        </div>
    </body>
</html>