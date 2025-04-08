package com.test.Urban_Village.accommodation.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;

public interface AccommodationController {

	ModelAndView accommodationPage(String accommodation_id, HttpServletResponse response, HttpServletRequest request);

	ModelAndView accommodationForm(HttpServletResponse response, HttpServletRequest request);

	ModelAndView accommodation(AccommodationDTO dto, HttpServletResponse response, HttpServletRequest request)
			throws IOException;



}
