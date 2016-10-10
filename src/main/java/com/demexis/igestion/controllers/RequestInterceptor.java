/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.controllers;

import com.demexis.igestion.domain.ConstantesIntegra;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author pamela.gutierrez
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        long startTime = System.currentTimeMillis();
        logger.info("Request URL::" + request.getRequestURL().toString() + ":: Start Time=" + System.currentTimeMillis());
        request.setAttribute("startTime", startTime);
        if (request.getSession().getAttribute(ConstantesIntegra.USUARIO_SESSION_INTEGRA.toString()) == null && (!request.getRequestURL().toString().contains("/igestion/inicio") && !request.getRequestURL().toString().contains("/igestion/login"))) {
            logger.info("No se encontro la configuracion de la sesion...");
            response.sendRedirect(request.getContextPath() + "/igestion/inicio");
            return false;
        } 
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        logger.info("Request URL::" + request.getRequestURL().toString() + ":: End Time=" + System.currentTimeMillis());
        logger.info("Request URL::" + request.getRequestURL().toString() + ":: Time Taken=" + (System.currentTimeMillis() - startTime));
    }

}
