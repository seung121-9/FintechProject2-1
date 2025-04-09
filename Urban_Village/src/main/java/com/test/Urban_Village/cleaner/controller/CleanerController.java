package com.test.Urban_Village.cleaner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.test.Urban_Village.cleaner.dto.CleanerDTO;

public interface CleanerController {
	public ModelAndView CleanerForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//public ModelAndView joinCleaner(CleanerDTO cleanerDTO, MultipartFile incomeFile, HttpServletRequest request) throws Exception;
	ResponseEntity<String> addCleaner(MultipartHttpServletRequest request, HttpServletResponse response)
			throws Exception;
}
