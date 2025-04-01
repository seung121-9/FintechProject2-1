package com.test.Urban_Village.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.Urban_Village.dto.MemberDTO;
import com.test.Urban_Village.service.MemberService;

@Controller
@RequestMapping("/urban")
public class MainController2 {
	
	@Autowired
	MemberService service;
    
    @RequestMapping("/main")
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView("urbanMain");
    	return mav; 
    }
    @RequestMapping("/memberList")
    public ModelAndView listMembers() {
        List<MemberDTO> membersList = service.listMembers();
        ModelAndView mav = new ModelAndView("urbanMemberList");
		mav.addObject("membersList", membersList);
		return mav;
    }
    @RequestMapping("/loginForm")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("urbanLogin");
    	return mav; 
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
        ModelAndView mav = new ModelAndView();
        // 로그인 서비스에서 아이디와 비밀번호 확인
        MemberDTO member = service.login(id, pwd);
        if (member != null) {
            mav.setViewName("redirect:/urban/memberList"); 
        } else {
            mav.setViewName("urbanLogin");
            mav.addObject("error", "잘못된 로그인 정보입니다.");
        }
        return mav;
    }


}
