<%-- 
    Document   : mapaRecursos
    Created on : 17/09/2016, 02:26:21 PM
    Author     : Gabriel
--%>

?<html xmlns="http://www.w3.org/1999/xhtml">

    <head>
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
        <script type="text/javascript" src='../js/jquery.js'></script>
        <script type="text/javascript" src='../js/jquery-ui.js'></script>
        <script type="text/javascript" src='../js/jquery-ui.min.js'></script>
        <link href="../img/Demexis.ico" rel="shortcut icon" />
        <!--link type="text/css" href='../css/reset.css' rel="stylesheet" media="screen"-->
        <link href="../css/structure.css" media="screen" rel="stylesheet" type="text/css" />
        <link type="text/css" href='../css/jquery-ui.structure.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.min.css' rel="stylesheet" media="screen" />
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
                width: 95%;
                position: relative;
                left: 1%;
            }

            .ui-tabs .ui-widget-content{
                background: white;
                font-size: 10px;
            }
            .ui-tabs .ui-state-default a{
                background: white;
                font-size: 10px;
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
            /*label {
                display: inline-block;
                width: 5em;
            }*/
        </style>
    </head>

    <body>

        <div id="tabs" style="margin-top:2%; margin-left:15px;">
            <ul>
                <li><a href="#tabs-1"></a></li>
                <div id="tabs-1">
                    <table class="tablaDetMapRec" style="margin: auto;" border="1">
                        <tr>
                            <th rowspan="2">
                                Cliente
                            </th>
                            <th rowspan="2">
                                ID Proyecto
                            </th>
                            <th rowspan="2">
                                Requerimiento
                            </th>
                            <th rowspan="2">
                                Estatus
                            </th>
                            <th rowspan="2">
                                Actividad
                            </th>
                            <th rowspan="2">
                                Facturable
                            </th>
                            <th rowspan="2">
                                Recurso Asignado
                            </th>
                            <th rowspan="2">
                                Tipo Recurso
                            </th>
                            <th rowspan="2">
                                % Avance
                            </th>
                            <th colspan="2">
                                Fechas
                            </th>
                            <th rowspan="2">
                                Horas Reportadas
                            </th>
                            <th colspan="3">
                                Radares
                            </th>
                        </tr>
                        <tr>
                            <th>
                                Inicio
                            </th>
                            <th>
                                Liberación
                            </th>
                            <th>
                                Entregados
                            </th>
                            <th>
                                Revisados
                            </th>
                            <th>
                                Faltantes
                            </th>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Rogelio Gómez</td>
                            <td>.NET</td>
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
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Arturo Ramirez</td>
                            <td>ABAP</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>MLS</td>
                            <td>6578</td>
                            <td>REQ-15</td>
                            <td>Análisis</td>
                            <td>CU-Alta de proveedores</td>
                            <td>Sí</td>
                            <td>Tania Jiménez</td>
                            <td>Funcional</td>
                            <td>50</td>
                            <td>29/04/2016</td>
                            <td>02/05/2016</td>
                            <td>9</td>
                            <td>1</td>
                            <td>0</td>
                            <td>0</td>
                        </tr>
                        <tr>
                            <td>MLS</td>
                            <td>6580</td>
                            <td>REQ-03</td>
                            <td>Desarrollo</td>
                            <td>CU-Autenticación</td>
                            <td>Sí</td>
                            <td>Daniel Jarabo</td>
                            <td>.NET</td>
                            <td>40</td>
                            <td>27/04/2016</td>
                            <td>03/05/2016</td>
                            <td>12</td>
                            <td>1</td>
                            <td>1</td>
                            <td>2</td>
                        </tr>
                        <tr>
                            <td>MLS</td>
                            <td>6580</td>
                            <td>REQ-01</td>
                            <td>Pruebas</td>
                            <td>CU-Servicio de usuarios</td>
                            <td>Sí</td>
                            <td>Arely Ortega</td>
                            <td>ABAP</td>
                            <td>95</td>
                            <td>25/04/2016</td>
                            <td>29/04/2016</td>
                            <td>45</td>
                            <td>5</td>
                            <td>4</td>
                            <td>0</td>
                        </tr>
                        <tr>
                            <td>MLS</td>
                            <td>6583</td>
                            <td>REQ-07</td>
                            <td>Cerrado</td>
                            <td>CU-ABC artículos</td>
                            <td>Sí</td>
                            <td>Rogelio Gómez</td>
                            <td>.NET</td>
                            <td>95</td>
                            <td>25/04/2016</td>
                            <td>29/04/2016</td>
                            <td>45</td>
                            <td>5</td>
                            <td>5</td>
                            <td>0</td>
                        </tr>
                        <tr>
                            <td>MLS</td>
                            <td>6570</td>
                            <td>N/A</td>
                            <td>Soporte</td>
                            <td>Reporte de ventas, no se muestran los totales con formato de moneda</td>
                            <td>No</td>
                            <td>Laura Robles</td>
                            <td>Funcional</td>
                            <td>95</td>
                            <td>29/04/2016</td>
                            <td>02/05/2016</td>
                            <td>0</td>
                            <td>0</td>
                            <td>0</td>
                            <td>1</td>
                        </tr>
                    </table>
                </div>
            </ul>
        </div>

    </body>

</html>
