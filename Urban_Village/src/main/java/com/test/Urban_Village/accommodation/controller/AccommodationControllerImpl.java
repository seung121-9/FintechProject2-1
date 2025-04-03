package com.test.Urban_Village.accommodation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.Urban_Village.accommodation.service.AccommodationService;

@Controller
@RequestMapping("/accommdation")
public class AccommodationControllerImpl implements AccommodationController {
@Autowired
AccommodationService service;

@Override
@RequestMapping("/accommdationPage.do")
public ModelAndView accommodationpage(HttpServletResponse response, HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	String viewName = (String)request.getAttribute("viewName");
	mav.setViewName(viewName);
	return mav;
}


}
