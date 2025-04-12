package com.test.Urban_Village;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;
import com.test.Urban_Village.accommodation.service.AccommodationService;

@Controller
public class MainController {
	
	@Autowired
	AccommodationService service;

	@RequestMapping(value= {"/", "/main"}) 
	public String main(HttpSession session, @ModelAttribute AccommodationDTO accDTO) {
	    List<AccommodationDTO> accommodationList = service.accList();
	    session.setAttribute("accommodationList", accommodationList);
	    return "urbanMain";
	}

}