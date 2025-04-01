package com.test.Urban_Village.member.controller;

// �븘�슂�븳 �씪�씠釉뚮윭由� import
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.Urban_Village.member.dto.MemberDTO;
import com.test.Urban_Village.member.service.MemberService;

// 而⑦듃濡ㅻ윭 �뿭�븷�쓣 �븯�뒗 �겢�옒�뒪
@Controller
@EnableAspectJAutoProxy // AOP(Aspect Oriented Programming) �옄�룞 �봽濡앹떆 �솢�꽦�솕
public class MemberControllerImpl implements MemberController {

    // MemberService瑜� �옄�룞 二쇱엯�븯�뿬 �궗�슜
    @Autowired
    private MemberService service;

    // 濡쒓퉭 �꽕�젙 (�뵒踰꾧퉭 諛� 濡쒓렇 異쒕젰�슜)
    private static final Logger logger = 
        LoggerFactory.getLogger(MemberControllerImpl.class);

    /**
     * �쐟 �쉶�썝 紐⑸줉 議고쉶
     * - 濡쒓렇�씤�븳 �궗�슜�옄留� �젒洹� 媛��뒫
     * - 濡쒓렇�씤�븯吏� �븡�븯�떎硫� 濡쒓렇�씤 �럹�씠吏�濡� �씠�룞
     */
    @Override
    @RequestMapping("/member/listMembers.do")
    public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        
        HttpSession session = request.getSession(false);
        String viewName = (String) request.getAttribute("viewName");

        Boolean login = (Boolean) session.getAttribute("isLogin"); 

        if (login != null && login) { // 濡쒓렇�씤 �긽�깭�씪硫� �쉶�썝 紐⑸줉 議고쉶
            List<MemberDTO> membersList = service.listMembers();
            mav.addObject("membersList", membersList);
            mav.setViewName(viewName);
        } else { // 濡쒓렇�씤�븯吏� �븡�븯�떎硫� 濡쒓렇�씤 �럹�씠吏�濡� �씠�룞
            mav.addObject("result", "notLogin");
            mav.setViewName("redirect:/member/loginForm.do");
        }
        return mav;
    }

    /**
     * �쐟 �쉶�썝 �긽�꽭 議고쉶
     * - �듅�젙 �쉶�썝�쓽 �젙蹂대�� 議고쉶�븯�뿬 �솕硫댁뿉 �쟾�떖
     */
    @Override
    @RequestMapping("/member/memberDetail.do")
    public ModelAndView memberDetail(
            @ModelAttribute("dto") MemberDTO member,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        String viewName = (String) request.getAttribute("viewName");
        ModelAndView mav = new ModelAndView(viewName);
        
        member = service.memberDetail(member.getId());
        mav.addObject("member", member);
        return mav;
    }

    /**
     * �쐟 �쉶�썝 �궘�젣
     * - �듅�젙 �쉶�썝�쓣 �궘�젣�븯怨� �쉶�썝 紐⑸줉�쑝濡� 由щ떎�씠�젆�듃
     */
    @Override
    @RequestMapping("/member/delMember.do")
    public ModelAndView delMember(
            @RequestParam("id") String id,
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
        int result = service.delMember(id);
        
        ModelAndView mav = new ModelAndView();
        if(result != 0) { // �궘�젣 �꽦怨�
            mav.addObject("msg", "delMember");
            mav.addObject("id", id);
        } else { // �궘�젣 �떎�뙣
            mav.addObject("msg", "delMember");
            mav.addObject("id", null);
        }
        mav.setViewName("redirect:/member/listMembers.do");
        return mav;
    }

    /**
     * �쐟 �쉶�썝 媛��엯 �뤌 �씠�룞
     */
    @Override
    @RequestMapping("/member/joinMember.do")
    public ModelAndView joinMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String viewName = (String) request.getAttribute("viewName");
        ModelAndView mav = new ModelAndView(viewName);
        return mav;
    }

  

    /**
     * �쐟 �쉶�썝 媛��엯 泥섎━
     * - �엯�젰諛쏆� �쉶�썝 �젙蹂대�� ���옣 �썑 �쉶�썝 紐⑸줉�쑝濡� �씠�룞
     */
    @Override
    @RequestMapping("/member/addMember.do")
    public ModelAndView addMember(MemberDTO member, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        int result = service.addMember(member);
        ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
        mav.addObject("msg", "addMember");
        mav.addObject("id", member.getId());
        
        return mav;
    }

    /**
     * �쐟 �쉶�썝 �젙蹂� �닔�젙
     * - �듅�젙 �쉶�썝 �젙蹂대�� �닔�젙�븯怨� �쉶�썝 紐⑸줉�쑝濡� �씠�룞
     */
    @Override
    @RequestMapping("/member/modMember.do")
    public ModelAndView modMember(MemberDTO member, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        int result = service.modMember(member);
        ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
        mav.addObject("msg", "modMember");
        mav.addObject("id", member.getId());
        
        return mav;
    }

    /**
     * �쐟 濡쒓렇�씤 �뤌 �씠�룞
     */
    @Override
    @RequestMapping("/member/loginForm.do")
    public ModelAndView loginForm(
            @RequestParam(value="action", required=false) String action,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String viewName = (String) request.getAttribute("viewName");
        
        HttpSession session = request.getSession();
        session.setAttribute("action", action);
        ModelAndView mav = new ModelAndView(viewName);
        return mav;
    }

    /**
     * �쐟 濡쒓렇�씤 泥섎━
     * - �궗�슜�옄媛� �엯�젰�븳 ID/PW瑜� 寃�利� �썑 �꽭�뀡�뿉 ���옣
     */
    @Override
    @RequestMapping(value="/member/login.do", method=RequestMethod.POST)
    public ModelAndView login(MemberDTO member, 
            RedirectAttributes rAttr,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        member = service.login(member);
        
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        
        if(member != null) { // 濡쒓렇�씤 �꽦怨�
            mav.setViewName("redirect:/member/listMembers.do");
            session.setAttribute("member", member);
            session.setAttribute("loginId", member.getId());
            session.setAttribute("isLogin", true);
            
            String action = (String) session.getAttribute("action");
            session.removeAttribute("action");
            if(action != null) {
                mav.setViewName("redirect:"+action);
            } 
        } else { // 濡쒓렇�씤 �떎�뙣
            mav.setViewName("redirect:/member/loginForm.do");
            rAttr.addAttribute("result", "loginFailed");
        }
        
        return mav;
    }

    /**
     * �쐟 濡쒓렇�븘�썐 泥섎━
     * - �꽭�뀡 �궘�젣 �썑 濡쒓렇�씤 �럹�씠吏�濡� �씠�룞
     */
    @Override
    @RequestMapping("/member/logout.do")
    public ModelAndView logout(
            RedirectAttributes rAttr,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession(false);
        
        ModelAndView mav = new ModelAndView();
        Boolean isLogin = (Boolean) session.getAttribute("isLogin");
        
        if(session != null && isLogin != null) {
            session.invalidate(); // �꽭�뀡 �궘�젣
            rAttr.addAttribute("result", "logout");
        } else {
            rAttr.addAttribute("result", "notLogin");
        }
        mav.setViewName("redirect:/member/loginForm.do");
        return mav;
    }
    
    /**
     * �쐟 OpenAI �슂泥� 泥섎━
     * - OpenAI API瑜� �샇異쒗븯�뿬 �쓳�떟�쓣 諛섑솚�븯怨� �씠瑜� DB�뿉 ���옣
     */
    @RequestMapping(value = "/member/openaiRequest.do", method = RequestMethod.POST)
    public String openaiRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // �삁�떆: OpenAI API �샇異� 肄붾뱶
        String inputText = "Hello, OpenAI!";  // �궗�슜�옄 �엯�젰 �뀓�뒪�듃 �삁�떆
        String openAIResponse = callOpenAIAPI(inputText);  // OpenAI API �샇異� 硫붿꽌�뱶

        // DB�뿉 �슂泥�怨� �쓳�떟 ���옣
        saveOpenAIRequest(inputText, openAIResponse);

        // �쓳�떟 諛섑솚 (HTML �궡�슜�쑝濡� 異쒕젰)
        return openAIResponse;  // �씠 媛믪� body�뿉 異쒕젰�맆 �궡�슜
    }
    
    // OpenAI API �샇異� 硫붿꽌�뱶
    private String callOpenAIAPI(String inputText) {
        // �떎�젣 OpenAI API �샇異� 肄붾뱶 �옉�꽦
        return "OpenAI�쓽 �쓳�떟 �궡�슜";  // �삁�떆 �쓳�떟
    }

    // DB�뿉 OpenAI �슂泥� 諛� �쓳�떟 ���옣
    private void saveOpenAIRequest(String inputText, String responseText) {
        // MyBatis �삉�뒗 JPA瑜� �씠�슜�빐�꽌 DB�뿉 �슂泥� ���옣
        service.saveOpenAIRequest(inputText, responseText);
    }
}
