package com.test.Urban_Village.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController2 {
    
    @RequestMapping("/urbanMain")
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView("urbanMain");
    	return mav; 
    }
}
