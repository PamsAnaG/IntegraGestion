<%-- 
    Document   : layout
    Created on : 10/09/2016, 06:03:47 PM
    Author     : Gabriel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        
        <script type="text/javascript" src='/js/jquery.js'></script>
        <script type="text/javascript" src='/js/jquery-ui.js'></script>
        <script type="text/javascript" src='/js/jquery-ui.min.js'></script>
        
        <link href="/img/Demexis.ico" rel="shortcut icon" />
        <link type="text/css" href='/css/structure.css' rel="stylesheet" media="screen" />        
        <link type="text/css" href='/css/jquery-ui.structure.min.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='/css/jquery-ui.theme.css' rel="stylesheet" media="screen" />
        <link type="text/css" href='/css/jquery-ui.theme.min.css' rel="stylesheet" media="screen"/>
        
        <script type="text/javascript" src='../js/dashboard.js'></script>
    </head>
    
    <body>
        <div style="width:100%;height:50px;">
            <tiles:insertAttribute name="menu" />
        </div>
        <div style="width:100%;">
            <tiles:insertAttribute name="body" />
        </div>
    </body>
    
</html>