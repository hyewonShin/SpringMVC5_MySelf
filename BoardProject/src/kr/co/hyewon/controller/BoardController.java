package kr.co.hyewon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {

	@GetMapping("/board_main")
	public String main() {
		return "board/board_main";
	}
	
	@GetMapping("/write")
	public String write() {
		return "board/write";
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
