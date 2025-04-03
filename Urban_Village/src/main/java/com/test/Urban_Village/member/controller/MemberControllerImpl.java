package com.test.Urban_Village.member.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.Urban_Village.member.dto.MemberDTO;
import com.test.Urban_Village.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberControllerImpl implements MemberController {
	
	@Autowired
	MemberService service;
    
	
	@Override
    @RequestMapping("/urbanMemberList.do")
    public ModelAndView urbanMemberList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        String viewName = (String) request.getAttribute("viewName");
        List<MemberDTO> membersList = service.listMembers();
		mav.addObject("membersList", membersList);
		mav.setViewName(viewName);
		return mav;
    }
	@Override
    @RequestMapping("/loginForm.do")
    public ModelAndView loginForm(@RequestParam(value="action", required=false) String action, HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.setAttribute("action", action);
		mav.setViewName(viewName);
		mav.addObject("viewName",viewName);
		System.out.println("viewName"+viewName);
		return	mav;
    }
	@Override
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView login(RedirectAttributes rAttr, @RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        MemberDTO member = service.login(id, pwd);
        if (member != null) {
            mav.setViewName("redirect:/member/urbanMemberList.do"); 
            session.setAttribute("member", member);
			session.setAttribute("loginId", member.getId());
			session.setAttribute("isLogin", true);
			String action = (String) session.getAttribute("action");
			session.removeAttribute("action");
			if(action != null) {
				mav.setViewName("redirect:"+action);
			} 
        } else {
            mav.setViewName("redirect:/member/loginForm.do");
            mav.addObject("error", "잘못된 로그인 정보입니다.");
            rAttr.addAttribute("result", "loginFailed");
        }
        return mav;
    }
	@Override
	@RequestMapping("/logout.do")
	public ModelAndView logout(RedirectAttributes rAttr,HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		if(session != null && isLogin != null) {
			session.invalidate();
			rAttr.addAttribute("result", "logout");
		} else {
			rAttr.addAttribute("result", "notLogin");
		}
		mav.setViewName("redirect:/member/loginForm.do");
		return mav;
	}
	
	@Override
	@RequestMapping("/joinMember.do")
	public ModelAndView joinMember(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("viewName",viewName);
		System.out.println("viewName"+viewName);
		return	mav;
	}
	
	   @RequestMapping(value = "/addMember.do", method = RequestMethod.POST)
	   public ModelAndView addMember(@ModelAttribute MemberDTO member, HttpServletRequest request, HttpServletResponse response) throws Exception {
	       int result = service.addMember(member);
	       System.out.println("Insert Result: " + result);
	       response.setContentType("text/html;charset=utf-8");
	       PrintWriter out = response.getWriter();

	       if (result == 1) {
	           out.write("<script>");
	           out.write("alert('회원 가입에 성공했습니다!');");
	           out.write("location.href='/Urban_Village/member/urbanLogin.do';");
	           out.write("</script>");
	       } else {
	           out.write("<script>");
	           out.write("alert('회원 가입에 실패했습니다. 다시 시도해주세요.');");
	           out.write("location.href='/Urban_Village/member/joinMember.do';");
	           out.write("</script>");
	       }
	       return null;
	   }

	   @Override
	   @RequestMapping("/checkId.do")
	    public void checkId(HttpServletRequest request, HttpServletResponse response) {
	        String userId = request.getParameter("id");
	        boolean exists = service.checkIfUserIdExists(userId);

	        response.setContentType("application/json");
	        try (PrintWriter out = response.getWriter()) {
	            out.print("{\"exists\": " + exists + "}");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	@Override
	@RequestMapping("/reservation.do")
	public ModelAndView reservation(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 ModelAndView mav = new ModelAndView();
	        String viewName = (String) request.getAttribute("viewName");
			mav.setViewName(viewName);
			return mav;
	}
	
	@RequestMapping("/getUserInfo.do")
    public ModelAndView getUserInfo(@RequestParam("id") String id) {
        List<MemberDTO> memberList = service.getUserInfoById(id);
        ModelAndView mav = new ModelAndView("member/myInfo");
        mav.addObject("memberList", memberList);
        return mav;
    }
	

}
