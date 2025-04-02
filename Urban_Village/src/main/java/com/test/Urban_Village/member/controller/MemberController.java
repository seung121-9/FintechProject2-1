package com.test.Urban_Village.member.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface MemberController {
	 public ModelAndView main();
	 public ModelAndView listMembers();
	 public ModelAndView login();
	 public ModelAndView login(@RequestParam("id") String id, @RequestParam("pwd") String pwd);
	 
}
