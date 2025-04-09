package com.test.Urban_Village.accommodation.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;
import com.test.Urban_Village.accommodation.service.AccommodationService;

@Controller
@RequestMapping("/accommodation")
public class AccommodationControllerImpl implements AccommodationController {
@Autowired
AccommodationService service;
@Autowired
HttpSession session;

private static final String TEMP_DIR = "D:\\image\\temp\\";
private static final String DEST_DIR = "D:\\image\\addImage\\";

@Override
@RequestMapping("/accommodationPage.do")
public ModelAndView accommodationPage (@RequestParam("accommodation_id")String accommodation_id, HttpServletResponse response, HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	System.out.println("아이디 가져온거 출력" + accommodation_id);
	//String viewName = (String)request.getAttribute("viewName");
	//mav.setViewName(viewName);
	String viewName = (String)request.getAttribute("viewName");
	mav.setViewName(viewName);
	//mav.setViewName("accommodation/accommodationPage");
	
	System.out.println(viewName);
	
	AccommodationDTO accommodation = service.findAccommodationId(accommodation_id);
	session.setAttribute("accommodation", accommodation);
	List<AccommodationDTO> accList = service.accList();
	System.out.println("아이디 갯수: " + accList.size()); //아이디 갯수 보려고 적어둔거                     
	
	System.out.println(accommodation.getPrice());
	for (AccommodationDTO acc : accList) {
	    System.out.println(acc);
	}
	return mav;
}
@Override
@RequestMapping("/accommodationForm.do")
public ModelAndView accommodationForm(HttpServletResponse response, HttpServletRequest request) {
	ModelAndView mav = new ModelAndView();
	String viewName = (String)request.getAttribute("viewName");
	mav.setViewName(viewName);
	System.out.println("viewName : " + viewName);
	return mav;
}
@Override
@RequestMapping("/accommodation.do")
public ModelAndView accommodation(@ModelAttribute("dto") AccommodationDTO dto, HttpServletResponse response, HttpServletRequest request) throws IOException {
    ModelAndView mav = new ModelAndView();
    String viewName = (String) request.getAttribute("viewName");
    String generatedId = service.addAccommodation(dto);
    boolean isSuccess = (generatedId != null && !generatedId.isEmpty());

    //이거 알러트로 뜨는 건데 나중에 다 모달로 바꿔야
    PrintWriter out = response.getWriter();
    
    if (isSuccess) {
        out.write("alert('회원 가입이 성공적으로 완료되었습니다. ID: " + generatedId + "');");
    } else {
        out.write("alert('회원 가입에 실패했습니다.');");
    }
    out.write("location.href='accommodationList.do';"); // 가입 완료 후 숙소 목록 페이지로 이동
    out.write("</script>");
    mav.setViewName("urbanMain");
    return mav;

}
@Override
@RequestMapping(value = "/addNewAccommodation", method = RequestMethod.POST)
public ResponseEntity<String> addNewAccommodation(MultipartHttpServletRequest mRequest, HttpServletResponse response) throws Exception {
    mRequest.setCharacterEncoding("utf-8");
    Map<String, Object> accommodationMap = new HashMap<>();
    Enumeration<String> enu = mRequest.getParameterNames();

    while (enu.hasMoreElements()) {
        String name = enu.nextElement();
        String value = mRequest.getParameter(name);
        accommodationMap.put(name, value);
    }

    // 다중 이미지 파일에 대해 getFiles() 메서드를 사용하여 모두 받아옴
    List<MultipartFile> mFiles = mRequest.getFiles("accommodation_photo[]");
    List<String> fileList = new ArrayList<>();
    if (mFiles != null && !mFiles.isEmpty()){
        for(MultipartFile mFile : mFiles) {
            if(mFile != null && !mFile.isEmpty()){
                String originalFileName = mFile.getOriginalFilename();
                fileList.add(originalFileName);

                File file = new File(TEMP_DIR + originalFileName);
                if (!file.exists()) {
                    if (file.getParentFile().mkdirs()) {
                        file.createNewFile();
                    }
                }
                mFile.transferTo(file);
            }
        }
    }
    
    if (fileList != null && !fileList.isEmpty()) {
        String fileNames = String.join(",", fileList);
        accommodationMap.put("accommodation_photo", fileNames);
    }

    HttpSession session = mRequest.getSession();
    String id = (String) session.getAttribute("loginId");
    accommodationMap.put("id", id);

    String message;
    ResponseEntity<String> resEnt;
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.add("Content-Type", "text/html;charset=utf-8");

    try {
        // DB에 다중 이미지 파일명(콤마 구분 문자열)을 저장 
        String accommodationId = service.addNewAccommodation(accommodationMap);
        // TEMP_DIR에서 모든 파일을 DEST_DIR/accommodationId 폴더로 이동
        if (fileList != null && !fileList.isEmpty()) {
            for(String fileName : fileList) {
                File srcFile = new File(TEMP_DIR + fileName);
                File destDir = new File(DEST_DIR + accommodationId);
                FileUtils.moveFileToDirectory(srcFile, destDir, true);
            }
        }
       
        message = "<script>";
        message += "alert('숙소 등록이 성공적으로 완료되었습니다. ID: " + accommodationId + "');";
        message += "location.href='" + mRequest.getContextPath() + "/accommodation/main.do';";
        message += "</script>";
        resEnt = new ResponseEntity<>(message, responseHeaders, HttpStatus.OK);
    } catch (Exception e) {
        if (fileList != null && !fileList.isEmpty()) {
            for (String fileName : fileList) {
                File srcFile = new File(TEMP_DIR + fileName);
                srcFile.delete();
            }
        }
        message = "<script>";
        message += "alert('오류가 발생했습니다. 다시 시도해 주세요');";
        message += "location.href='" + mRequest.getContextPath() + "/accommodation/accommodationForm.do';";
        message += "</script>";
        resEnt = new ResponseEntity<>(message, responseHeaders, HttpStatus.CREATED);
    }
    return resEnt;
}
@RequestMapping(value = "/accommodationPage", method = RequestMethod.GET)
public ModelAndView accommodationPage(@RequestParam("accommodation_id") String accommodationId) {
    AccommodationDTO accommodation = service.findAccommodationId(accommodationId);
    ModelAndView mav = new ModelAndView("accommodation/accommodationPage");
    mav.addObject("accommodation", accommodation);
    return mav;
}
@RequestMapping("/main.do")
public ModelAndView main(HttpServletResponse response, HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    List<AccommodationDTO> accommodationList = service.accList();
    mav.addObject("accommodationList", accommodationList);
    mav.setViewName("urbanMain");
    return mav;
}
}
