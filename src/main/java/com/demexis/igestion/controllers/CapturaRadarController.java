/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demexis.igestion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gabriel
 */
@Controller
public class CapturaRadarController {
    
    @RequestMapping(value = "/capturaRadar", method = RequestMethod.POST)
    public ModelAndView inicio() {

        ModelAndView model = new ModelAndView();        
        model.setViewName("capturaRadar");

        return model;

    }
    
}
