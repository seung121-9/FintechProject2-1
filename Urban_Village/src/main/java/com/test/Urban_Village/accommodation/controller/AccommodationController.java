package com.test.Urban_Village.accommodation.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;

public interface AccommodationController {
	public ModelAndView  accommodationpage (HttpServletResponse response, HttpServletRequest request);

	public ModelAndView accommodationForm(HttpServletResponse response, HttpServletRequest request);

	public ModelAndView accommodation(AccommodationDTO dto, HttpServletResponse response, HttpServletRequest request) throws IOException;
}
