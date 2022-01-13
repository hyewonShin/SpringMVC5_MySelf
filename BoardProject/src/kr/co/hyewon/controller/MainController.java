package kr.co.hyewon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.hyewon.bean.BoardInfoBean;
import kr.co.hyewon.service.TopMenuService;

@Controller
public class MainController {

	@Autowired
	private TopMenuService topMenuService;
	
	@GetMapping("/main")
	public String main(Model model) {
		
		List<BoardInfoBean> board_list = topMenuService.getTopmenuList();
		model.addAttribute("board_list", board_list);
		
		return "main";
	}
	
	
	
}
