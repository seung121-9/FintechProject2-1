package com.test.Urban_Village.accommodation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AccommodationController {
	public ModelAndView accommodationpage(HttpServletResponse response, HttpServletRequest request);
}
