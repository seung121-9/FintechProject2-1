package com.test.Urban_Village.admin.controller;

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

import com.test.Urban_Village.admin.dto.AdminDTO;
import com.test.Urban_Village.admin.service.AdminService;
import com.test.Urban_Village.admin.service.AdminServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController {
	@Autowired
	AdminService adminService; // AdminService로 인터페이스 타입 주입

	@Override
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(RedirectAttributes rAttr,
			@RequestParam("id") String id, @RequestParam("pwd") String pwd,
			HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		AdminDTO admin = adminService.login(id, pwd); // AdminService의 login 메서드 사용
		if (admin != null) {
			System.out.println("로그인 성공");
			
			session.setAttribute("isAdmin", true);
			session.setAttribute("adminInfo", admin);
			mav.setViewName("redirect:/");
			String action = (String) session.getAttribute("action");
			session.removeAttribute("action");
			if(action != null) {
				mav.setViewName("redirect:"+action);
			}
		} else {
			mav.setViewName("admin/loginForm"); // 관리자 로그인 실패 시 관리자 로그인 폼으로
			mav.addObject("error", "잘못된 로그인 정보입니다.");
			rAttr.addAttribute("result", "loginFailed");
		}
		return mav;
	}

	@Override
	@RequestMapping("/logout.do")
	public ModelAndView logout(RedirectAttributes rAttr,
			HttpServletRequest request,
			HttpServletResponse response)
					throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		if(session != null && session.getAttribute("isAdmin") != null) {
			session.invalidate();
			rAttr.addAttribute("result", "logout");
		} else {
			rAttr.addAttribute("result", "notLogin");
		}
		mav.setViewName("redirect:/admin/loginForm.do"); // 로그아웃 후 관리자 로그인 폼으로 이동
		return mav;
	}

	@Override
	@RequestMapping("/loginForm.do")
	public ModelAndView loginForm(@RequestParam(value="action", required=false)
	String action,
	HttpServletRequest request,
	HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.setAttribute("action", action);
		mav.setViewName("admin/loginForm"); // 관리자 로그인 폼 뷰 이름
		mav.addObject("viewName",viewName);
		System.out.println("viewName"+viewName);
		return	mav;
	}
}