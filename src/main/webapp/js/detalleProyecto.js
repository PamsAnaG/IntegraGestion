/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var mapEdiciones = {};

function parseJSON(data) {
    return window.JSON && window.JSON.parse ? window.JSON.parse(data) : (new Function("return " + data))();
}

function generaTablaDetalle() {
    var proyecto = parseJSON($('#proyectoJSON').val());
    var tareasHijas = proyecto.tareaPrincipal.tareasHijas;
    for (var i = 0; i < tareasHijas.length; i++) {
        var node = $("#tblDetalleProyecto").treetable("node", i + 1);
        $("#tblDetalleProyecto").treetable("loadBranch", node,
                "<tr data-tt-id=" + (i + 1) + ">" +
                "<td class='tareaCabecera'>" + (i + 1) + "</td>" +
                "<td id='dpnd" + tareasHijas[i].idTarea + "' class='tareaCabecera' ondblclick='activaEdicion(" + tareasHijas[i].idTarea + ",1);' onblur='terminaEdicion();'>" + tareasHijas[i].nombre + "</td>" +
                "<td id='dpfi" + tareasHijas[i].idTarea + "' class='tareaCabecera' style='text-align:center;' ondblclick='activaEdicion(" + tareasHijas[i].idTarea + ",2);' onblur='terminaEdicion();'>" + convertDate(tareasHijas[i].fechaInicio) + "</td>" +
                "<td id='dpff" + tareasHijas[i].idTarea + "' class='tareaCabecera' style='text-align:center;' ondblclick='activaEdicion(" + tareasHijas[i].idTarea + ",3);' onblur='terminaEdicion();'>" + convertDate(tareasHijas[i].fechaFin) + "</td>" +
                "<td id='dpre" + tareasHijas[i].idTarea + "' class='tareaCabecera' style='text-align:center;' ondblclick='activaEdicion(" + tareasHijas[i].idTarea + ",4);' onblur='terminaEdicion();' title='Rogelio Gómez, Tania Jiménez'>RG, TJ</td>" +
                "</tr>");

        despliegaHijas(tareasHijas[i].tareasHijas, (i + 1));
    }
    $("#tblDetalleProyecto").treetable("collapseAll");
}

function despliegaHijas(tareasHijas, itmP) {
    for (var j = 0; j < tareasHijas.length; j++) {
        var node = $("#tblDetalleProyecto").treetable("node", itmP);
        var data =
                "<tr data-tt-id=" + itmP + "." + (j + 1) + " data-tt-parent-id=" + itmP + ">" +
                "<td>" + itmP + "." + (j + 1) + "</td>" +
                "<td id='dpnd" + tareasHijas[j].idTarea + "' ondblclick='activaEdicion(" + tareasHijas[j].idTarea + ",1);' onblur='terminaEdicion();'>" + tareasHijas[j].nombre + "</td>" +
                "<td id='dpfi" + tareasHijas[j].idTarea + "' style='text-align:center;' ondblclick='activaEdicion(" + tareasHijas[j].idTarea + ",2);' onblur='terminaEdicion();'>" + convertDate(tareasHijas[j].fechaInicio) + "</td>" +
                "<td id='dpff" + tareasHijas[j].idTarea + "' style='text-align:center;' ondblclick='activaEdicion(" + tareasHijas[j].idTarea + ",3);' onblur='terminaEdicion();'>" + convertDate(tareasHijas[j].fechaFin) + "</td>";
        var responsables = tareasHijas[j].responsables;
        var nombresResponsables = "";
        for (var k = 0; k < responsables.length; k++) {
            nombresResponsables = nombresResponsables + responsables[k].nombre + ",";
        }
        data = data + "<td id='dpre" + tareasHijas[j].idTarea + "' style='text-align:center;' ondblclick='activaEdicion(" + tareasHijas[j].idTarea + ",4);' onblur='terminaEdicion();' title='" + nombresResponsables + "' >" + nombresResponsables + "</td>" +
                "</tr>";
        $("#tblDetalleProyecto").treetable("loadBranch", node, data);
        if (tareasHijas[j].tareasHijas.length > 0) {
            despliegaHijas(tareasHijas[j].tareasHijas, itmP + "." + (j + 1));
        }
    }
}

function generaTablaAlertas() {
    var proyecto = parseJSON($('#proyectoJSON').val());
    var tareasHijas = proyecto.tareaPrincipal.tareasHijas;
    for (var i = 0; i < tareasHijas.length; i++) {
        var node = $("#tblAlertasProyecto").treetable("node", i + 1);
        $("#tblAlertasProyecto").treetable("loadBranch", node,
                "<tr data-tt-id=" + (i + 1) + ">" +
                "<td class='tareaCabecera' style='text-align:center;'>" + (i + 1) + "</td>" +
                "<td class='tareaCabecera' style='text-align:center;'>" + tareasHijas[i].nombre + "</td>" +
                "<td class='tareaCabecera' style='text-align:center;'></td>" +
                "<td class='tareaCabecera' style='text-align:center;'></td>" +
                "<td class='tareaCabecera' style='text-align:center;'></td>" +
                "</tr>");

        despliegaHijasAlerta(tareasHijas[i].tareasHijas, (i + 1));
    }
    $("#tblAlertasProyecto").treetable("collapseAll");
}


function despliegaHijasAlerta(tareasHijas, itmP) {
    for (var j = 0; j < tareasHijas.length; j++) {
        var htmlalertas1 = "";
        var htmlalertas2 = "";
        var htmlalertas3 = "";
        var htmlalertas4 = "";
        var htmlalertas5 = "";
        var htmlalertas6 = "";
        var htmlalertas7 = "";
        for (var jAlertas = 0; jAlertas < tareasHijas[j].alertas.length; jAlertas++) {
            if (tareasHijas[j].alertas[jAlertas].idFaseTareaAlerta === 1) {
                htmlalertas1 = htmlalertas1 + tareasHijas[j].alertas[jAlertas].nombreTipoAlerta;
            } else if (tareasHijas[j].alertas[jAlertas].idFaseTareaAlerta === 2) {
                htmlalertas2 = htmlalertas2 + tareasHijas[j].alertas[jAlertas].nombreTipoAlerta;
            } else if (tareasHijas[j].alertas[jAlertas].idFaseTareaAlerta === 3) {
                htmlalertas3 = htmlalertas3 + tareasHijas[j].alertas[jAlertas].nombreTipoAlerta;
            } else if (tareasHijas[j].alertas[jAlertas].idFaseTareaAlerta === 4) {
                htmlalertas4 = htmlalertas4 + tareasHijas[j].alertas[jAlertas].nombreTipoAlerta;
            } else if (tareasHijas[j].alertas[jAlertas].idFaseTareaAlerta === 5) {
                htmlalertas5 = htmlalertas5 + tareasHijas[j].alertas[jAlertas].nombreTipoAlerta;
            } else if (tareasHijas[j].alertas[jAlertas].idFaseTareaAlerta === 6) {
                htmlalertas6 = htmlalertas6 + tareasHijas[j].alertas[jAlertas].nombreTipoAlerta;
            } else if (tareasHijas[j].alertas[jAlertas].idFaseTareaAlerta === 7) {
                htmlalertas7 = htmlalertas7 + tareasHijas[j].alertas[jAlertas].nombreTipoAlerta;
            }
        }
        var node = $("#tblAlertasProyecto").treetable("node", itmP);
        var data =
                "<tr data-tt-id=" + itmP + "." + (j + 1) + " data-tt-parent-id=" + itmP + ">" +
                "<td></td>" +
                "<td style='text-align:center;'>" + tareasHijas[j].nombre + "</td>" +
                "<td id=\"" + tareasHijas[j].idTarea + "-1\" onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 0, 1, '" + htmlalertas1 + "')\" style='text-align:center;'>" + htmlalertas1 + "</td>" +
                "<td id=\"" + tareasHijas[j].idTarea + "-2\" onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 0, 2, '" + htmlalertas2 + "')\" style='text-align:center;'>" + htmlalertas2 + "</td>" +
                "<td id=\"" + tareasHijas[j].idTarea + "-3\" onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 0, 3, '" + htmlalertas3 + "')\" style='text-align:center;'>" + htmlalertas3 + "</td>" +
                "<td id=\"" + tareasHijas[j].idTarea + "-4\" onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 1, 4, '" + htmlalertas4 + "')\" style='text-align:center;'>" + htmlalertas4 + "</td>" +
                "<td id=\"" + tareasHijas[j].idTarea + "-5\" onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 0, 5, '" + htmlalertas5 + "')\" style='text-align:center;'>" + htmlalertas5 + "</td>" +
                "<td id=\"" + tareasHijas[j].idTarea + "-6\" onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 0, 6, '" + htmlalertas6 + "')\" style='text-align:center;'>" + htmlalertas6 + "</td>" +
                "<td id=\"" + tareasHijas[j].idTarea + "-7\" onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 0, 7, '" + htmlalertas7 + "')\" style='text-align:center;'>" + htmlalertas7 + "</td>";
        ;
        $("#tblAlertasProyecto").treetable("loadBranch", node, data);
        if (tareasHijas[j].tareasHijas.length > 0) {
            despliegaHijasAlerta(tareasHijas[j].tareasHijas, itmP + "." + (j + 1));
        }
    }
}

function convertDate(inputFormat) {
    function pad(s) {
        return (s < 10) ? '0' + s : s;
    }
    var d = new Date(inputFormat);
    return [d.getFullYear(), pad(d.getMonth() + 1), pad(d.getDate())].join('-');
}

var idTD, valorTD, tmpIdTarea, tmpIdColumna;
var esActivaEdicion = false;
function activaEdicion(idTarea, idColumna) {
    if (!esActivaEdicion) {
        tmpIdColumna = idColumna;
        tmpIdTarea = idTarea;
        var esFecha = false;
        switch (idColumna) {
            case 1:
                idTD = "dpnd" + idTarea;
                break;
            case 2:
                idTD = "dpfi" + idTarea;
                esFecha = true;
                break;
            case 3:
                idTD = "dpff" + idTarea;
                esFecha = true;
                break;
            case 4:
                idTD = "dpre" + idTarea;
                break;
        }
        valorTD = document.getElementById(idTD).textContent;
        if (idColumna !== 4) {
            document.getElementById(idTD).setAttribute('contenteditable', true);
            var html = $(("#" + idTD)).html();
            var input = $('<input id="' + idTD + 'TMP" type="text" style="width:100%;" onblur="terminaEdicion();"/>');
            input.val(html);
            $("#" + idTD).html(input);
            if (esFecha) {
                new Kalendae.Input(idTD + "TMP", {months: 1, direction: 'future', format: 'YYYY-MM-DD'});
            }
            document.getElementById(idTD + "TMP").focus();
        } else {
            document.getElementById(idTD).focus();
            muestraRecursos();
        }
        esActivaEdicion = true;
    }
}

var mapRecursos = {};
var tmpRecursos = "", tmpAbreviaciones = "";
function terminaEdicion() {
    esActivaEdicion = false;
    var tmpValorTD;
    if (tmpIdColumna !== 4) {
        tmpValorTD = document.getElementById(idTD + "TMP").value;
        $(("#" + idTD + "TMP")).remove();
    } else {
        tmpValorTD = tmpAbreviaciones;
        document.getElementById(idTD).setAttribute('title', tmpRecursos);
    }
    document.getElementById(idTD).textContent = tmpValorTD;
    if (!(tmpValorTD === valorTD)) {
        if (tmpIdTarea in mapEdiciones) {
            var tmpTareaE = mapEdiciones[tmpIdTarea];
            switch (tmpIdColumna) {
                case 1:
                    tmpTareaE.descripcion = tmpValorTD;
                    break;
                case 2:
                    tmpTareaE.fechaInicio = tmpValorTD;
                    break;
                case 3:
                    tmpTareaE.fechaFin = tmpValorTD;
                    break;
                case 4:
                    tmpTareaE.recursos = mapRecursos;
                    break;
            }
            mapEdiciones[tmpIdTarea] = tmpTareaE;
        } else {
            var tDesc = null, tFechaIni = null, tFechaFin = null, tRecursos = null;
            switch (tmpIdColumna) {
                case 1:
                    tDesc = tmpValorTD;
                    break;
                case 2:
                    tFechaIni = tmpValorTD;
                    break;
                case 3:
                    tFechaFin = tmpValorTD;
                    break;
                case 4:
                    tRecursos = mapRecursos;
                    break;
            }
            mapEdiciones[tmpIdTarea] = new TareaE(tmpIdTarea, tDesc, tFechaIni, tFechaFin, tRecursos, "m");
        }
    }
    document.getElementById(idTD).setAttribute('contenteditable', false);
    idTD = null;
    valorTD = null;
    tmpIdTarea = null;
    tmpRecursos = "";
    tmpAbreviaciones = "";
    mapRecursos = {};
}

function TareaE(idTarea, descripcion, fechaInicio, fechaFin, recursos, accion) {
    this.idTarea = idTarea;
    this.descripcion = descripcion;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.recursos = recursos;
    this.accion = accion;
}

function guardarCambios() {
    alert(JSON.stringify(mapEdiciones));
    $.ajax({
        method: "POST",
        url: "guardaCambiosDP",
        data: {jsonCambios: JSON.stringify(mapEdiciones)}
    });
}


$(function() {
    $("#tabs").tabs();
    $(document).tooltip();
    $("#dialog").dialog({
        height: 350,
        modal: true,
        resizable: false,
        autoOpen: false,
        open: function() {

            $('#calendario').prop("checked", false);
            $('#mensaje').prop("checked", false);
            $('#push').prop("checked", false);
            $('#correo').prop("checked", false);
            $('#calendario').prop("disabled", false);
            $('#mensaje').prop("disabled", false);
            $('#push').prop("disabled", false);
            $('#correo').prop("disabled", false);

            if ($(this).data('porcentaje') === 0) {
                $("#porcentajeC").hide();
            } else {
                $("#porcentajeC").show();
            }

            if ($(this).data('alertasProgramadas').includes("P")) {
                $('#calendario').prop("disabled", true);
            }
            if ($(this).data('alertasProgramadas').includes("T")) {
                $('#mensaje').prop("disabled", true);
            }
            if ($(this).data('alertasProgramadas').includes("A")) {
                $('#push').prop("disabled", true);
            }
            if ($(this).data('alertasProgramadas').includes("C")) {
                $('#correo').prop("disabled", true);
            }
        },
        buttons: {
            Programar: function() {
                var tipoAlert = 0;
                var tipoAlertS = 0;
                if ($('#calendario').is(':checked')) {
                    tipoAlert = 1;
                    tipoAlertS = "P";
                } else if ($('#mensaje').is(':checked')) {
                    tipoAlert = 2;
                    tipoAlertS = "T";
                } else if ($('#push').is(':checked')) {
                    tipoAlert = 3;
                    tipoAlertS = "A";
                } else if ($('#correo').is(':checked')) {
                    tipoAlert = 4;
                    tipoAlertS = "C";
                } else {
                    alert("Debes seleccionar un tipo de alerta.");
                    return;
                }
                $.ajax({
                    method: "POST",
                    url: "guardaAlerta",
                    data: {idTarea: $(this).data('idTarea'), tipoAlerta: tipoAlert, faseAlerta: $(this).data('faseAlerta'), porcentajeAvance: $(this).data('porcentaje')}
                })
                        .done(function(msg) {
                            var arrRespuesta = msg.split("-");
                            if (arrRespuesta[0] === 'Correcto') {
                                alert("Alerta almacenada");
                                var idTD = arrRespuesta[1] + "-" + arrRespuesta[2];
                                console.log(idTD);
                                $("#" + idTD).html(tipoAlertS);
                            }
                        });
                $(this).dialog("close");
            }
        }
    });

    $("#dialog input:checkbox").change(function() {
        $("#dialog input:checkbox").prop("checked", false);
        $(this).prop("checked", true);
    });

    $("#dialogRecursos").dialog({
        height: 350,
        modal: true,
        resizable: false,
        autoOpen: false,
        open: function() {
        },
        close: function() {
            var $recursosA = $("#dialogRecursos").find(":checkbox");
            $recursosA.each(function() {
                if ($(this).is(':checked')) {
                    mapRecursos[$(this).data('value')] = 1;
                    tmpRecursos += $(this).data('value3') + "  ";
                    tmpAbreviaciones += $(this).data('value2') + "  ";
                }
            });
            terminaEdicion();
        },
        buttons: {
            Asignar: function() {
                $(this).dialog("close");
            }
        }
    });

});
function muestraDialog(idTarea, porcentaje, faseAlerta, alertasProgramadas) {
    $("#dialog").data('porcentaje', porcentaje).data('idTarea', idTarea).data('faseAlerta', faseAlerta).data('alertasProgramadas', alertasProgramadas).dialog('open');
}
function muestraRecursos() {
    $("#dialogRecursos").dialog('open');
}