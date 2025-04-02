package com.test.Urban_Village.member.controller;

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

import com.test.Urban_Village.member.dto.MemberDTO;
import com.test.Urban_Village.member.service.MemberServiceImpl;

@Controller
@RequestMapping("/urban")
public class MemberControllerImpl implements MemberController {
	
	@Autowired
	MemberServiceImpl service;
    
	@Override
    @RequestMapping("/main.do")
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView("urbanMain");
    	return mav; 
    }
	@Override
    @RequestMapping("/memberList.do")
    public ModelAndView listMembers() {
        List<MemberDTO> membersList = service.listMembers();
        ModelAndView mav = new ModelAndView("urbanMemberList");
		mav.addObject("membersList", membersList);
		return mav;
    }
	@Override
    @RequestMapping("/loginForm.do")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("urbanLogin");
    	return mav; 
    }
	@Override
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
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
	
	@Override
	@RequestMapping("/memberJoin.do")
	public ModelAndView joinMember() {
		ModelAndView mav = new ModelAndView("urbanJoin");
		
		return	mav;
	}


}
