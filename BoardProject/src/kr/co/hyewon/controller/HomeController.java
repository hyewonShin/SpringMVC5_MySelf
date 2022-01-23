package kr.co.hyewon.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.hyewon.bean.UserBean;

@Controller
public class HomeController {
	
//	@Resource(name="loginUserBean")
//	private UserBean loginUserBean;
	
	// 사이트 오픈시 링크 주소를 main으로 설정
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		//System.out.println(loginUserBean);
		
		//System.out.println(request.getServletContext().getRealPath("/"));
		
		return "redirect:/main";
	}
}

