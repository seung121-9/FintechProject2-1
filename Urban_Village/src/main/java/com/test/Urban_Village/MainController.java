package com.test.Urban_Village;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;
import com.test.Urban_Village.accommodation.dto.AccommodationIdDTO;
import com.test.Urban_Village.accommodation.service.AccommodationService;
import com.test.Urban_Village.admin.service.AdminService;

@Controller
public class MainController {
	
	@Autowired
	AccommodationService service;
	@Autowired
	AdminService adminService;

	@RequestMapping(value= {"/", "/main"}) 
	public ModelAndView main(HttpSession session,@ModelAttribute("AccommodationIdDTO") AccommodationIdDTO accIdDTO, @ModelAttribute AccommodationDTO accDTO) {
	    List<AccommodationDTO> accommodationList = service.accList();
	    session.setAttribute("accommodationList", accommodationList);
	    ModelAndView mav = new ModelAndView();
	    List<AccommodationIdDTO> hostBestAccIdList = adminService.accIdListAll(accIdDTO);
	    mav.addObject("hostBestAccIdList", hostBestAccIdList);
	    for(AccommodationIdDTO accIdDTO2 : hostBestAccIdList) {
	    System.out.println("호스트 추천 숙소??" + accIdDTO2.getAccommodation_id());
	    System.out.println("호스트 추천 숙소 관리자 아이디"+ accIdDTO2.getAdmin_id());
	    }
	    mav.setViewName("urbanMain");
	    return mav;
	}

}