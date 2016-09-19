<%-- 
    Document   : dashboard
    Created on : Aug 8, 2016, 3:01:07 PM
    Author     : pamela.gutierrez
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        
        <script type="text/javascript" src='../js/dashboard.js'></script>
    </head>
    
    <body>
        
        <div>
            <div style="width: 60%;">
                <form:form id="nuevoPF" action="/igestion/nuevop">
                    <!--img src='../img/addP.png' style="left:5%; top:15px; width:60px; height:55px;" alt="AddP"/-->
                    <center><input class="pure-button pure-button-primary" type="submit"
                                   id="nuevoP" name="nuevoP" value="Agregar Proyecto"/></center>
                </form:form>
            </div>
            <div class="dashboardLeft" style="height:85%;">
                <form:form id="lstProyectos" >
                    <label class="table avance t">Proyectos en curso: ${numProyectos}</label>
                    <div style="height:100%; overflow: auto; margin-top: 15px;" id="boxScroll">
                        <table style="width: 100%;" id="progressBar">
                            <c:forEach var="fProyecto" items="${proyectos}">
                                <tr onclick="javascript: detalleProyecto(${fProyecto.idProyecto})" style="height: 35px; vertical-align: bottom;">
                                    <td align="left" colspan="2">
                                        <label class="table avance p" >ID ${fProyecto.idProyecto} | ${fProyecto.cliente.nombre} | ${fProyecto.nombre}</label>
                                    </td>
                                </tr>
                                <tr onclick="javascript: detalleProyecto(${fProyecto.idProyecto})">
                                    <td >
                                        <div class="progress-bar" data-value="${fProyecto.avance}" 
                                             data-value2="${fProyecto.estatusAvance}"></div>
                                    </td>
                                    <td align="center" style="width: 8%;">
                                        <label class="table avance p" >${fProyecto.avance}%</label>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </form:form>
            </div>
        </div>
        
        <div style="margin-left: 62%; margin-top: -30%;">
            <center>
                <div style="width: 450px; height: 350px; background-color: #999999;">
                    <form:form id="resumenDshbrd" >
                        </br>
                        <table class="table avance white">
                            <tr style="height:30px;te: white;">
                                <td align="right" style="width:50%;">
                                    <label>Recursos Ocupados: ${resumen.recursosOcupados}</label>
                                </td>
                            </tr>
                            <tr style="height:30px;">
                                <td align="right" style="width:50%;">
                                    <label>Recursos Disponibles: ${resumen.recursosDisponibles}</label>
                                </td>
                            </tr>
                            <tr style="height:30px;">
                                <td align="right" style="width:50%;">
                                    <label>Proyectos en Cola: ${resumen.colaProyectos}</label>
                                </td>
                            </tr>
                        </table>

                        <table style="margin-top:20px; width:90%;" class="table avance white">
                            <tr style="height:35px;">
                                <td colspan="2">
                                    <label class="table avance" style="font-size: large;">Alertas</label>
                                </td>
                            </tr>
                            <tr style="height:30px;">
                                <td align="center" style="width:80%;">
                                    <label >No. Registros de Radar</label>
                                </td>
                                <td align="center">
                                    <label>${resumen.registrosRadar}</label>
                                </td>
                            </tr>
                            <tr style="height:30px;">
                                <td align="center" style="width:80%;">
                                    <label>Validaci&oacute;n de Radar</label>
                                </td>
                                <td align="center">
                                    <label>${resumen.validacionRadar}</label>
                                </td>
                            </tr>
                            <tr style="height:30px;">
                                <td align="center" style="width:80%;">
                                    <label>Tarea Finalizada</label>
                                </td>
                                <td align="center">
                                    <label>${resumen.tareaFinalizada}</label>
                                </td>
                            </tr>
                            <tr style="height:30px;">
                                <td align="center" style="width:80%;">
                                    <label>Inicio de Proyecto</label>
                                </td>
                                <td align="center">
                                    <label>${resumen.inicioProyecto}</label>
                                </td>
                            </tr>
                            <tr style="height:30px;">
                                <td align="center" style="width:80%;">
                                    <label>Cierre de Proyecto</label>
                                </td>
                                <td align="center">
                                    <label>${resumen.cierreProyecto}</label>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </div>
            </center>
        </div>
        
    </body>
</html>