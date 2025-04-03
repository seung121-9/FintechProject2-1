package com.test.Urban_Village.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.Urban_Village.member.dto.MemberDTO;

public interface MemberController {
	 public ModelAndView urbanMemberList(HttpServletRequest request, HttpServletResponse response);
	 public ModelAndView login(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpServletRequest request, HttpServletResponse response);
	 public ModelAndView joinMember(HttpServletRequest request, HttpServletResponse response);
	 public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response);
	
	    public ModelAndView addMember(@ModelAttribute MemberDTO member,HttpServletRequest request, HttpServletResponse response)throws Exception;

	 
}
