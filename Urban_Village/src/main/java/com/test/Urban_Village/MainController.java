package com.test.Urban_Village;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value= {"/", "/main"}) 
	public String main() {
		// (WEB-INF/views/main.jsp)
		return "urbanMain";
	}
}