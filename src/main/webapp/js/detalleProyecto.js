/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    function parseJSON(data) {
        return window.JSON && window.JSON.parse ? window.JSON.parse( data ) : (new Function("return " + data))(); 
    }

    function generaTablaDetalle() {
        var proyecto = parseJSON($('#proyectoJSON').val());
        var tareasHijas = proyecto.tareaPrincipal.tareasHijas;
        for (var i = 0; i < tareasHijas.length; i++) {
            var node = $("#tblDetalleProyecto").treetable("node", i+1);
            $("#tblDetalleProyecto").treetable("loadBranch", node, 
                    "<tr data-tt-id="+(i+1)+">" + 
                        "<td class='tareaCabecera'>" + (i+1) + "</td>" +
                        "<td class='tareaCabecera'>" + tareasHijas[i].nombre + "</td>" + 
                        "<td class='tareaCabecera' style='text-align:center;'>" + convertDate(tareasHijas[i].fechaInicio) + "</td>" + 
                        "<td class='tareaCabecera' style='text-align:center;'>" + convertDate(tareasHijas[i].fechaFin) + "</td>" + 
                        "<td class='tareaCabecera' style='text-align:center;' title='Rogelio Gómez, Tania Jiménez'>RG, TJ</td>" + 
                    "</tr>");
            
            despliegaHijas(tareasHijas[i].tareasHijas, (i+1));
        }
        $("#tblDetalleProyecto").treetable("collapseAll");
    }
    
    function generaTablaAlertas() {
        var proyecto = parseJSON($('#proyectoJSON').val());
        var tareasHijas = proyecto.tareaPrincipal.tareasHijas;
        for (var i = 0; i < tareasHijas.length; i++) {
            var node = $("#tblAlertasProyecto").treetable("node", i+1);
            $("#tblAlertasProyecto").treetable("loadBranch", node, 
                    "<tr data-tt-id="+(i+1)+">" + 
                        "<td class='tareaCabecera' style='text-align:center;'>" + (i+1) + "</td>" +
                        "<td class='tareaCabecera' style='text-align:center;'>" + tareasHijas[i].nombre + "</td>" + 
                        "<td class='tareaCabecera' style='text-align:center;'></td>" + 
                        "<td class='tareaCabecera' style='text-align:center;'></td>" + 
                        "<td class='tareaCabecera' style='text-align:center;'></td>" + 
                    "</tr>");
            
            despliegaHijasAlerta(tareasHijas[i].tareasHijas, (i+1));
        }
        $("#tblAlertasProyecto").treetable("collapseAll");
    }
    
    
    function despliegaHijasAlerta(tareasHijas, itmP) {
        for (var j = 0; j < tareasHijas.length; j++) {
            var node = $("#tblAlertasProyecto").treetable("node", itmP);
            var data =                     
                    "<tr data-tt-id="+itmP+"."+(j+1)+" data-tt-parent-id="+itmP+">" + 
                        "<td></td>" +                        
                        "<td style='text-align:center;'>" + tareasHijas[j].nombre + "</td>" + 
                        "<td onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 0, 1)\" style='text-align:center;'></td>" + 
                        "<td onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 0, 2)\" style='text-align:center;'></td>" + 
                        "<td onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 0, 3)\" style='text-align:center;'></td>" + 
                        "<td onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 1, 4)\" style='text-align:center;'></td>" + 
                        "<td onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 0, 5)\" style='text-align:center;'></td>" + 
                        "<td onclick=\"javascript: muestraDialog(" + tareasHijas[j].idTarea + ", 0, 6)\" style='text-align:center;'></td>";
            $("#tblAlertasProyecto").treetable("loadBranch", node, data);
            if (tareasHijas[j].tareasHijas.length > 0) {
                despliegaHijasAlerta(tareasHijas[j].tareasHijas, itmP+"."+(j+1));
            }
        }
    }
    
    function despliegaHijas(tareasHijas, itmP) {
        for (var j = 0; j < tareasHijas.length; j++) {
            var node = $("#tblDetalleProyecto").treetable("node", itmP);
            var data = 
                    "<tr data-tt-id="+itmP+"."+(j+1)+" data-tt-parent-id="+itmP+">" + 
                        "<td>" + itmP+"."+(j+1) + "</td>" +
                        "<td>" + tareasHijas[j].nombre + "</td>" + 
                        "<td style='text-align:center;'>" + convertDate(tareasHijas[j].fechaInicio) + "</td>" + 
                        "<td style='text-align:center;'>" + convertDate(tareasHijas[j].fechaFin) + "</td>";
            var responsables = tareasHijas[j].responsables;
            var nombresResponsables = "";
            for (var k = 0; k < responsables.length; k++) {
                nombresResponsables = nombresResponsables + responsables[k].nombre + "," ;
            }
            data = data + "<td style='text-align:center;' title='" + nombresResponsables + "' >" + nombresResponsables + "</td>" + 
                    "</tr>";
            $("#tblDetalleProyecto").treetable("loadBranch", node, data);
            if (tareasHijas[j].tareasHijas.length > 0) {
                despliegaHijas(tareasHijas[j].tareasHijas, itmP+"."+(j+1));
            }
        }
    }
    
    function convertDate(inputFormat) {
        function pad(s) { return (s < 10) ? '0' + s : s; }
        var d = new Date(inputFormat);
        return [d.getFullYear(), pad(d.getMonth()+1), pad(d.getDate())].join('-');
    }