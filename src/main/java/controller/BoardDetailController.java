package controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import spring.BoardNotFoundException;
import spring.Board;
import spring.BoardDao;

@Controller
public class BoardDetailController {
	
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@GetMapping("/board/{id}")
	public String detail(@PathVariable("id") Long Id, Model model) {
		Board board = boardDao.selectById(Id);
		board = boardDao.updateReadCount(board);
		if (board == null) {
			throw new BoardNotFoundException();
		}
		model.addAttribute("board", board);
		return "board/boardDetail";
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException() {
		return "board/invalidId";
	}
	
	@ExceptionHandler(BoardNotFoundException.class)
	public String handleNotFoundException() {
		return "board/noBoard";
	}

}
