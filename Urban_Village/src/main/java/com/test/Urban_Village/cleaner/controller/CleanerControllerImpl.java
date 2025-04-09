package com.test.Urban_Village.cleaner.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.Urban_Village.cleaner.dto.CleanerDTO;
import com.test.Urban_Village.cleaner.service.CleanerService;
import com.test.Urban_Village.member.dto.MemberDTO;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cleaner")
public class CleanerControllerImpl implements CleanerController{

	@Autowired
	private CleanerService service;
	@Autowired
	HttpSession session;
	private static final String CLEANER_UPLOAD_PATH = "D:\\file\\addCleaner\\";


	@Override
	@RequestMapping("/cleanerForm.do")
	public ModelAndView CleanerForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		return new ModelAndView(viewName);
	}

	@RequestMapping(value="/joinCleaner.do", method=RequestMethod.POST)
	public ResponseEntity<String> addCleaner(
	        MultipartHttpServletRequest request, 
	        HttpServletResponse response) throws Exception {

	    Map<String, Object> cleanerMap = new HashMap<>();
	    Enumeration<String> enu = request.getParameterNames();
	    while (enu.hasMoreElements()) {
	        String name = enu.nextElement();
	        String value = request.getParameter(name);
	        cleanerMap.put(name, value);
	    }

	    // 세션에서 로그인 ID 추출
	    String id = (String) session.getAttribute("loginId"); 
	    cleanerMap.put("member_id", id);

	    // 파일 업로드 처리
	    MultipartFile mFile = request.getFile("income_proof");

	    String uploadPath = "D:\\file\\addCleaner\\" + id;

	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) {
	        uploadDir.mkdirs();
	    }

	    String savedFileName = null;

	    if (mFile != null && !mFile.isEmpty()) {
	        String originalFileName = mFile.getOriginalFilename();
	        savedFileName = UUID.randomUUID().toString() + "_" + originalFileName;
	        File destFile = new File(uploadDir, savedFileName);
	        mFile.transferTo(destFile);
	        cleanerMap.put("income_proof", "/addCleaner/" + id + "/" + savedFileName); // DB에는 상대경로 저장
	    }

	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "text/html;charset=utf-8");

	    String msg;
	    ResponseEntity<String> resEntity;

	    try {
	        service.addCleaner(cleanerMap);

	        msg = "<script>";
	        msg += "alert('클리너 등록이 완료되었습니다.');";
	        msg += "location.href='/Urban_Village/main.do';";
	        msg += "</script>";

	        resEntity = new ResponseEntity<>(msg, headers, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();

	        msg = "<script>";
	        msg += "alert('오류가 발생했습니다. 다시 시도하세요.');";
	        msg += "history.back();";
	        msg += "</script>";

	        resEntity = new ResponseEntity<>(msg, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    return resEntity;
	}


	private List<String> upload
	(MultipartHttpServletRequest request) throws Exception {
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = request.getFileNames();
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = request.getFile(fileName);
			String imageFileName = mFile.getOriginalFilename();
			File file = new File(CLEANER_UPLOAD_PATH + "//" + fileName);
			fileList.add(imageFileName);

			if(mFile.getSize() != 0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(CLEANER_UPLOAD_PATH+"//"
						+"temp//"+imageFileName));
			}
		}

		return fileList;
	}
	/*
	 * @Override
	 * 
	 * @RequestMapping(value = "/joinCleaner.do", method = RequestMethod.POST)
	 * public ModelAndView joinCleaner(CleanerDTO cleanerDTO, MultipartFile
	 * incomeFile, HttpServletRequest request) throws Exception { String viewName =
	 * (String) request.getAttribute("viewName");
	 * 
	 * String uploadPath = request.getSession().getServletContext().getRealPath(
	 * "/resources/upload/cleaner"); File uploadDir = new File(uploadPath); if
	 * (!uploadDir.exists()) { uploadDir.mkdirs(); }
	 * 
	 * if (incomeFile != null && !incomeFile.isEmpty()) { String originalFileName =
	 * incomeFile.getOriginalFilename(); String savedFileName =
	 * UUID.randomUUID().toString() + "_" + originalFileName; File dest = new
	 * File(uploadDir, savedFileName); incomeFile.transferTo(dest);
	 * 
	 * // 파일 경로 저장 cleanerDTO.setIncome_proof("/resources/upload/cleaner/" +
	 * savedFileName); }
	 * 
	 * cleanerService.insertCleaner(cleanerDTO);
	 * 
	 * return new ModelAndView("redirect:/"); // 등록 후 이동할 페이지 }
	 * 
	 * @RequestMapping("/jusoPopup") public void jusoPopup() { // 아무 것도 반환하지 않음 →
	 * ViewNameInterceptor가 URI에서 뷰 이름 추출 }
	 */
	
	@RequestMapping("/jusoPopup") 
	public void jusoPopup() { 
		 // ViewNameInterceptor가 URI에서 뷰 이름 추출 
		 }
}
