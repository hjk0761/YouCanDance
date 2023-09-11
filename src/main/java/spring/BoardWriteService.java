package spring;

import java.time.LocalDateTime;

public class BoardWriteService {
	
	private BoardDao boardDao;
	
	public BoardWriteService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public Long writePost(BoardWriteRequest req) {
		Board newBoard = new Board(req.getSubject(), req.getContent(), req.getName(), LocalDateTime.now(), (long) 0);
		boardDao.insert(newBoard);
		return newBoard.getId();
	}

}
