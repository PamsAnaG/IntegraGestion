/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    $(document).ready(function() {
        var $progressBar = $(this).find('.progress-bar');
        $progressBar.each(function() {
            var bar = $(this);
            var backColor;
            switch (bar.data('value2')) {
                case 1: backColor = '#3CB371'; break;
                case 2: backColor = '#FFC125'; break;
                case 3: backColor = '#EE0000'; break;
            }
            bar.progressbar({ 
                value: parseFloat(bar.data('value')),
                create: function(event, ui) {
                    $(this).find('.ui-widget-header').css({'background-color': backColor})
                }
            })
        })
    });

    function detalleProyecto(idProyecto) {
        $("#lstProyectos").attr('action', '/igestion/detalleProyecto');
        $("#lstProyectos").attr('idProyecto', idProyecto);
        $("#lstProyectos").submit();
    }

    function menu(opcion) {
        var urlOpcion;
        switch(opcion) {
            case 1: urlOpcion = 'dashboard'; break;
            case 2: urlOpcion = 'mapaRecurso'; break;
            case 3: urlOpcion = 'capturaRadar'; break;
            case 4: urlOpcion = 'apruebaRadar'; break;
            case 5: urlOpcion = 'salir'; break;
        }
        $("#frmMenu").attr('action', '/igestion/' + urlOpcion);
        $("#frmMenu").submit();
    }
