<%-- 
    Document   : layout
    Created on : 10/09/2016, 06:03:47 PM
    Author     : Gabriel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="../img/Demexis.ico" rel="shortcut icon" />
        
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        
        <script type="text/javascript" src='../js/jquery.js'></script>
        <script type="text/javascript" src='../js/jquery-ui.js'></script>
        <script type="text/javascript" src='../js/jquery-ui.min.js'></script>
        <script type="text/javascript" src='../js/dashboard.js'></script>
        <script type="text/javascript" src='../js/kalendae.js'></script>
        
        <link type="text/css" href='../css/structure.css' rel="stylesheet" media="screen" />    
        <link type="text/css" href="../css/pure.css" rel="stylesheet" media="screen">
        <link type="text/css" href="../css/integra.css" rel="stylesheet" media="screen">
        <link type="text/css" href="../css/kalendae.css" rel="stylesheet" media="screen">
        <link type="text/css" href='../css/jquery-ui.structure.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='../css/jquery-ui.theme.min.css' rel="stylesheet" media="screen"/>
    </head>
    
    <body>
        <div style="width:100%;height:50px;">
            <tiles:insertAttribute name="menu" />
        </div>
        </br>
        <div style="width:100%;height:85%">
            <tiles:insertAttribute name="body" />
        </div>
    </body>
    
</html>