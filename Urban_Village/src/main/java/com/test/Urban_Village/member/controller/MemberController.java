package com.test.Urban_Village.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.Urban_Village.member.dto.MemberDTO;


public interface MemberController {
	
	public ModelAndView listMembers(HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	
	public ModelAndView memberDetail(
			@ModelAttribute("dto") MemberDTO member,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	
	public ModelAndView delMember(
			@RequestParam("id") String id,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	
	public ModelAndView joinMember(HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	
	public ModelAndView addMember(
			@ModelAttribute("dto") MemberDTO member,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	
	public ModelAndView modMember(
			@ModelAttribute("dto") MemberDTO member,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	
	public ModelAndView loginForm(
			@RequestParam(value="action", required=false) String action,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	
	public ModelAndView login(
			@ModelAttribute("dto") MemberDTO member,
			RedirectAttributes rAttr,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	
	// 濡쒓렇�븘�썐 泥섎━
	public ModelAndView logout(
			RedirectAttributes rAttr,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
}
