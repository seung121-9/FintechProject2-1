package com.test.Urban_Village.accommodation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;
import com.test.Urban_Village.accommodation.service.AccommodationService;

@Controller
@RequestMapping("/accommodation")
public class AccommodationControllerImpl implements AccommodationController {
@Autowired
AccommodationService service;

@Override
@RequestMapping("/accommodationPage.do")
public ModelAndView accommodationpage (HttpServletResponse response, HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	String viewName = (String)request.getAttribute("viewName");
	mav.setViewName(viewName);
	List<AccommodationDTO> accList = service.accList();
	mav.addObject("accList",accList);
	System.out.println("아이디 : " + accList.size());
	return mav;
}
@Override
@RequestMapping("/accommodationForm.do")
public ModelAndView accommodationForm(HttpServletResponse response, HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	String viewName = (String)request.getAttribute("viewName");
	mav.setViewName(viewName);
	System.out.println("viewName : " + viewName);
	return mav;
}
@Override
@RequestMapping("/accommodation.do")
public ModelAndView accommodation(@ModelAttribute("dto") AccommodationDTO dto, HttpServletResponse response, HttpServletRequest request) throws IOException {
    ModelAndView mav = new ModelAndView();
    String viewName = (String) request.getAttribute("viewName");
    String generatedId = service.addAccommodation(dto);
    boolean isSuccess = (generatedId != null && !generatedId.isEmpty());

    // 성공 여부에 따라 메시지 출력
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.write("<script>");
    if (isSuccess) {
        out.write("alert('숙소 등록에 성공했습니다. ID: " + generatedId + "');");
    } else {
        out.write("alert('숙소 등록에 실패했습니다.');");
    }
    out.write("location.href='accommodationList.do';"); //이거 아직 안만들었음.. 나중에 관리자가 열어봐야 할 것같아서
    out.write("</script>");

    return mav;
}



}
