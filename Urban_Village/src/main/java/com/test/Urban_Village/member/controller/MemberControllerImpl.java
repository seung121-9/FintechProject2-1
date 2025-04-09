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

import com.test.Urban_Village.accommodation.dao.AccommodationDAO;
import com.test.Urban_Village.accommodation.dao.AccommodationDAOImpl;
import com.test.Urban_Village.accommodation.dto.AccommodationDTO;
import com.test.Urban_Village.accommodation.service.AccommodationService;
import com.test.Urban_Village.accommodation.service.AccommodationServiceImpl;
import com.test.Urban_Village.admin.dto.AdminDTO;
import com.test.Urban_Village.admin.service.AdminService;
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
	@Autowired
	HttpSession session;
	@Autowired
	AdminService adminService;


	@Override
	@RequestMapping("urbanMemberList.do")
	public ModelAndView urbanMemberList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String viewName = (String) request.getAttribute("viewName");
		List<MemberDTO> membersList = service.listMembers();
		mav.addObject("membersList", membersList); 
		mav.setViewName(viewName);
		return mav;
	}

	// 로그인 폼 보여주는 메서드
	@Override
	@RequestMapping("/loginForm.do")
	public ModelAndView loginForm(@RequestParam(value="action", required=false) String action, HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		session.setAttribute("action", action); // 로그인 후 이동할 액션을 세션에 저장
		mav.setViewName(viewName);
		mav.addObject("viewName",viewName);
		System.out.println("viewName"+viewName);
		return mav;
	}

	// 로그인 처리 메서드
	@Override
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(RedirectAttributes rAttr, @RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		session = request.getSession();

		// 관리자 로그인 시도
		AdminDTO admin = adminService.login(id, pwd);
		if (admin != null) {
			session.setAttribute("isAdmin", true);
			session.setAttribute("adminInfo", admin);
			session.setAttribute("adminId", admin.getAdmin_id());
			String action = (String) session.getAttribute("action");
			session.removeAttribute("action");
			if(action != null) {
				mav.setViewName("redirect:"+action);
			}
			mav.setViewName("redirect:/"); // 메인 화면으로 리다이렉트
			return mav;
		}

		// 일반 회원 로그인 시도
		MemberDTO member = service.login(id, pwd);
		if (member != null) {
			// 회원 로그인 성공
			mav.setViewName("redirect:/");
			session.setAttribute("member", member);
			session.setAttribute("loginId", member.getId());
			session.setAttribute("memberName", member.getName()); //나중에 결제할 때 결제자 이름
			session.setAttribute("memberEmail", member.getEmail());
			session.setAttribute("memberGender", member.getGender());
			session.setAttribute("memberBirth", member.getBirth());
			session.setAttribute("memberPhone", member.getPhonenumber());
			session.setAttribute("isLogin", true);
			String action = (String) session.getAttribute("action");
			session.removeAttribute("action");
			if(action != null) {
				mav.setViewName("redirect:"+action);
			}
		} else {
			// 로그인 실패
			mav.setViewName("redirect:/member/loginForm.do");
			mav.addObject("error", "잘못된 로그인 정보입니다.");
			rAttr.addAttribute("result", "loginFailed");
		}
		return mav;
	}

	// 로그아웃 처리 메서드
	@Override
	@RequestMapping("/logout.do")
	public ModelAndView logout(RedirectAttributes rAttr,HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView();
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
		if(session != null && (isLogin != null || isAdmin != null)) {
			// 로그인 되어 있으면 세션 초기화
			session.invalidate();
			rAttr.addAttribute("result", "logout");
		} else {
			rAttr.addAttribute("result", "notLogin");
		}
		mav.setViewName("redirect:/member/loginForm.do");
		return mav;
	}

	// 회원 가입 페이지로 이동
	@Override
	@RequestMapping("/joinMember.do")
	public ModelAndView joinMember(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("viewName",viewName);
		System.out.println("viewName"+viewName);
		return mav;
	}

	// 회원 가입 처리
	@RequestMapping(value = "/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute MemberDTO member, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int result = service.addMember(member);
		System.out.println("Insert Result: " + result);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (result == 1) {
			// 성공 시 알림 후 로그인 페이지로 이동
			out.write("<script>");
			out.write("alert('회원 가입에 성공했습니다!');");
			out.write("location.href='/Urban_Village/member/urbanLogin.do';");
			out.write("</script>");
		} else {
			// 실패 시 알림 후 다시 회원가입 폼으로
			out.write("<script>");
			out.write("alert('회원 가입에 실패했습니다. 다시 시도해주세요.');");
			out.write("location.href='/Urban_Village/member/joinMember.do';");
			out.write("</script>");
		}
		return null;
	}
	@Override
	@RequestMapping("/myInfo.do")
	public ModelAndView myInfo(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) {
		List<MemberDTO> memberList = service.getUserInfoById(id);
		ModelAndView mav = new ModelAndView();
		String viewName = (String) request.getAttribute("viewName");
		mav.setViewName(viewName);
		mav.addObject("memberList", memberList);
		return mav;
	}

	@Override
	@RequestMapping("/updateUserInfo.do")
	public ModelAndView updateUserInfo(@ModelAttribute() MemberDTO member,
			@RequestParam("id") String id,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int result = service.updateUserInfo(member);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (result == 1) {
			out.write("<script>");
			out.write("alert('수정성공!');");
			out.write("location.href='" + request.getContextPath() + "/member/loginForm.do';");
			out.write("</script>");
		} else {
			out.write("<script>");
			out.write("alert('수정실패');");
			out.write("location.href='" + request.getContextPath() + "/member/getUserInfo.do';");
			out.write("</script>");
		}

		return null;
	}

	// 아이디 중복 체크 (AJAX 사용 가능)
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
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/reservationForm"); 
		return mav;
	}

	@Override
	@RequestMapping("/reservation.do")
	public ModelAndView reservation(
	        @RequestParam("accommodation_id") String accommodation_id,
	        @RequestParam("reservation_id") String reservation_id,
	        @RequestParam("checkin_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkin_date,
	        @RequestParam("checkout_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkout_date,
	        @RequestParam("guest_count") int guest_count,
	        @RequestParam("total_price") double total_price,
	        HttpServletRequest request, HttpServletResponse response) {

	    ModelAndView mav = new ModelAndView();

	    // 세션 가져오기
	    HttpSession session = request.getSession(false);
	    if (session == null || session.getAttribute("loginId") == null) {
	        mav.setViewName("redirect:/member/loginForm.do");
	        return mav;
	    }

	    // 세션에서 사용자 ID 가져오기
	    String loginId = (String) session.getAttribute("loginId");

	    // DTO 생성 및 값 설정
	    PayDTO payDTO = new PayDTO();
	    payDTO.setAccommodation_id(accommodation_id);
	    payDTO.setReservation_id(reservation_id);
	    payDTO.setCheckin_date(checkin_date);
	    payDTO.setCheckout_date(checkout_date);
	    payDTO.setGuest_count(guest_count);
	    payDTO.setTotal_price(total_price);
	    payDTO.setId(loginId);

	    System.out.println("=== [예약 컨트롤러 진입] ===");
	    System.out.println("숙소 ID: " + accommodation_id);
	    System.out.println("예약 ID: " + reservation_id);
	    System.out.println("체크인 날짜: " + checkin_date);
	    System.out.println("체크아웃 날짜: " + checkout_date);
	    System.out.println("게스트 수: " + guest_count);
	    System.out.println("총 금액: " + total_price);
	    System.out.println("회원 ID: " + loginId);

	    try {
	        // 예약 정보 저장
	        service.addPay(payDTO);
	        // 성공 시 리다이렉트
	        mav.setViewName("redirect:/member/reservationHistory.do");
	    } catch (Exception e) {
	        System.out.println("예약 정보 저장 중 오류 발생: " + e.getMessage());
	        e.printStackTrace();
	        mav.setViewName("error/reservationError"); // 에러 페이지 따로 구성했다면
	    }

	    return mav;
	}


	@Override
	@RequestMapping("/reservationHistory.do")
	public ModelAndView reservationHistory(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		session = request.getSession(false);
		if (session == null || session.getAttribute("loginId") == null) {
			mav.setViewName("redirect:/member/loginForm.do");
			System.out.println("로그인되지 않은 사용자");
			return mav;
		}
		String loginId = (String) session.getAttribute("loginId");
		System.out.println("로그인 아이디: " + loginId);
		System.out.println("viewName: " + viewName);

		if (loginId != null) {
			List<PayDTO> userReservations = service.reservationGetUserId(loginId);
			System.out.println("예약 정보: " + userReservations);
			mav.addObject("reservations", userReservations);
			mav.setViewName(viewName);
		}

		return mav;
	}
	@Override
	@RequestMapping("/payList.do")
	public ModelAndView payList(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		List<PayDTO> payList = service.payList();
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		session.setAttribute("payList", payList);
		for(PayDTO pay : payList) {
			System.out.println(pay);
		}
		return mav;
	}

}
