package com.test.Urban_Village.accommodation.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;

public interface AccommodationController {


	ModelAndView accommodationForm(HttpServletResponse response, HttpServletRequest request);

	ModelAndView accommodation(AccommodationDTO dto, HttpServletResponse response, HttpServletRequest request)
			throws IOException;

	ResponseEntity<String> addNewAccommodation(MultipartHttpServletRequest mRequest, HttpServletResponse response)
			throws Exception;


	ModelAndView main(HttpServletResponse response, HttpServletRequest request);

	ModelAndView accommodationList(HttpServletResponse response, HttpServletRequest request);

	ModelAndView delAccommodation(String accommodation_id, HttpServletResponse response, HttpServletRequest request)throws IOException;

	ModelAndView accommodationPage(String accommodationName, String accommodation_id, HttpServletResponse response,
			HttpServletRequest request);




}
