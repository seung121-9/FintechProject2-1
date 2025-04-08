package com.test.Urban_Village.accommodation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;
import com.test.Urban_Village.accommodation.service.AccommodationService;

@Controller
@RequestMapping("/accommodation")
public class AccommodationControllerImpl implements AccommodationController {
@Autowired
AccommodationService service;
@Autowired
HttpSession session;


@Override
@RequestMapping("/accommodationPage.do")
public ModelAndView accommodationPage (@RequestParam("accommodation_id")String accommodation_id, HttpServletResponse response, HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	System.out.println("아이디 가져온거 출력" + accommodation_id);
	//String viewName = (String)request.getAttribute("viewName");
	//mav.setViewName(viewName);
	String viewName = (String)request.getAttribute("viewName");
	mav.setViewName(viewName);
	//mav.setViewName("accommodation/accommodationPage");
	
	System.out.println(viewName);
	
	AccommodationDTO accommodation = service.findAccommodationId(accommodation_id);
	session.setAttribute("accommodation", accommodation);
	List<AccommodationDTO> accList = service.accList();
	System.out.println("아이디 갯수: " + accList.size()); //아이디 갯수 보려고 적어둔거                     
	
	System.out.println(accommodation.getPrice());
	for (AccommodationDTO acc : accList) {
	    System.out.println(acc);
	}
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

    //이거 알러트로 뜨는 건데 나중에 다 모달로 바꿔야
    PrintWriter out = response.getWriter();
    
    if (isSuccess) {
        out.write("alert('회원 가입이 성공적으로 완료되었습니다. ID: " + generatedId + "');");
    } else {
        out.write("alert('회원 가입에 실패했습니다.');");
    }
    out.write("location.href='accommodationList.do';"); // 가입 완료 후 숙소 목록 페이지로 이동
    out.write("</script>");
    mav.setViewName("urbanMain");
    return mav;

}



}
