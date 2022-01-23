package kr.co.hyewon.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.hyewon.bean.ContentBean;

@Controller
@RequestMapping("board")
public class BoardController {

	@GetMapping("/board_main")
	public String main(@RequestParam("board_info_idx") int board_info_idx,
					   Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		
		return "board/board_main";
	}
	
	@GetMapping("/write")
	public String write(@ModelAttribute("writeContentBean") ContentBean writeContentBean) {
		return "board/write";
	}

	@PostMapping("/write_pro")
	public String write_pro(@Valid @ModelAttribute("writeContentBean") ContentBean writeContentBean, BindingResult result) {
		if(result.hasErrors()) {
			return "board/write";
		}
		
		return "board/write_suceess";
	}
	
	@GetMapping("/read")
	public String read() {
		return "board/read";
	}

	@GetMapping("/board_modify")
	public String board_modify() {
		return "board/board_modify";
	}
	
}
