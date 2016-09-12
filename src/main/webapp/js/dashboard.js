/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    /*$(function() {
        $("#progressbar1").progressbar({
            value: 75,
            create: function(event, ui) {
                $(this).find('.ui-widget-header').css({'background-color': '#3CB371'})
            }
        });
        $("#progressbar2").progressbar({
            value: 41,
            create: function(event, ui) {
                $(this).find('.ui-widget-header').css({'background-color': '#3CB371'})
            }
        });
        $("#progressbar3").progressbar({
            value: 63,
            create: function(event, ui) {
                $(this).find('.ui-widget-header').css({'background-color': '#3CB371'})
            }
        });
        $("#progressbar4").progressbar({
            value: 52,
            create: function(event, ui) {
                $(this).find('.ui-widget-header').css({'background-color': '#FFC125'})
            }
        });
        $("#progressbar5").progressbar({
            value: 80,
            create: function(event, ui) {
                $(this).find('.ui-widget-header').css({'background-color': '#3CB371'})
            }
        });
        $("#progressbar6").progressbar({
            value: 50,
            create: function(event, ui) {
                $(this).find('.ui-widget-header').css({'background-color': '#EE0000'})
            }
        });
    });*/

    function nuevoProyecto() {
        $("#nuevoPF").submit();
    }

    function menu(opcion) {
        alert(opcion);
        if (opcion === 1) {
            $("#frmMenu").attr('action', '/igestion/salir');
            $("#frmMenu").submit();
        }
    }
