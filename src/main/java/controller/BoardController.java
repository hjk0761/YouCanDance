package controller;

import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import spring.Board;
import spring.BoardDao;
import spring.BoardWriteRequest;
import spring.BoardWriteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
	
	private BoardDao boardDao;
	private BoardWriteService wrtService;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public void setBoardWriteService(BoardWriteService wrtService) {
		this.wrtService = wrtService;
	}
	
	@GetMapping("/board/list")
	public String list(Locale locale, Model model) {
		int count = boardDao.count();
		model.addAttribute("count", count);
		List<Board> boards = boardDao.list();
		model.addAttribute("boards", boards);
		return "board/list";
	}
	
	@GetMapping("/board/write")
	public String write(Model model) {
		model.addAttribute("boardWriteRequest", new BoardWriteRequest());
		return "board/write";
	}
	
	@PostMapping("/board/write")
	public String writed(BoardWriteRequest wrtReq, Errors errors, Model model) {
		new BoardWriteRequestValidator().validate(wrtReq, errors);
		if (errors.hasErrors()) {
			return "board/write";
		}
		wrtService.writePost(wrtReq);
		return "board/writed";
	}

}
