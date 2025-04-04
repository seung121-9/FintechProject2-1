package com.test.Urban_Village.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;
import com.test.Urban_Village.accommodation.service.AccommodationService;
import com.test.Urban_Village.accommodation.service.AccommodationServiceImpl;
import com.test.Urban_Village.member.dto.MemberDTO;
import com.test.Urban_Village.member.dto.PayDTO;
import com.test.Urban_Village.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberControllerImpl implements MemberController {
	
	@Autowired
	MemberService service;
	@Autowired
	AccommodationService accService;

	
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
            mav.setViewName("/member/loginForm.do");
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
	@RequestMapping("/reservationForm.do")
	public ModelAndView reservationForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 ModelAndView mav = new ModelAndView();
	        String viewName = (String) request.getAttribute("viewName");
			mav.setViewName(viewName);
			return mav;
	}
	
	@Override
	@RequestMapping(value = "/reservation.do", method = RequestMethod.POST)
	public ModelAndView reservation(@ModelAttribute("payDTO") PayDTO payDTO,
	        HttpServletRequest request, HttpServletResponse response) {

		//여기 진입은 가능함
	    System.out.println(" 컨트롤러 진입ㅗㅗㅗ");

	    ModelAndView mav = new ModelAndView();

	    // 뷰 이름 가져오기
	    String viewName = (String) request.getAttribute("viewName");
	    System.out.println("뷰네임" + viewName);
	    

	    // 세션 체크 아이디가 페이 테이블에 필수 값이라 세션에 있는 현재 아이디값 가져옴
	    HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("loginId") == null) {
	        mav.setViewName("redirect:/member/loginForm.do");
	        return mav;
	    }

	    String loginId = (String) session.getAttribute("loginId");
	    AccommodationDTO acc = accService.findAccommodationById();
	    mav.addObject("acc", acc);
	    
	    // 출력 하지만 여기서 부터 출력 불가임
	    System.out.println("예약 정보 저장 시작");
	    System.out.println("숙소 ID: " + payDTO.getReservation_id());
	    System.out.println("예약 ID: " + payDTO.getReservation_id());
	    System.out.println("체크인 날짜: " + payDTO.getCheckin_date());
	    System.out.println("체크아웃 날짜: " + payDTO.getCheckout_date());
	    System.out.println("총 금액: " + payDTO.getTotal_price());
	    System.out.println("게스트 수: " + payDTO.getGuest_count());
	    System.out.println("회원 ID: " + loginId);
	    //애초에 출력이 안되사 여기서 안넘어 가는 듯함
	    // 예약 정보 저장
	    service.addPay(payDTO);

	    // 페이지 설정
	    mav.setViewName(viewName);
	    return mav;
	}
	@Override
	@RequestMapping("/reservationEnd.do")
	public ModelAndView reservationEnd(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		//이거 마지막에 예약 완료 화면 만들려고 한건데 하나도 안꾸밈
		mav.addObject("viewName",viewName);
		System.out.println("viewName"+viewName);
		PayDTO payDto = new PayDTO();
		String reservation_id = payDto.getReservation_id();
		mav.addObject("reservation_id", reservation_id);
		return	mav;
	}
	

}
