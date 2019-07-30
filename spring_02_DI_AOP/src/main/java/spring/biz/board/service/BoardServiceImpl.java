package spring.biz.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import spring.biz.board.dao.BoardDAO;
import spring.biz.board.vo.BoardVO;

@Service("boardservice")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="jdbc1")
	BoardDAO dao;
	
	public BoardServiceImpl() {	}
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}
	public BoardDAO getDao() {
		return dao;
	}
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	@Override
	public int insertBoard(BoardVO board) {
		return dao.insertBoard(board);
	}

	@Override
	public int updateBoard(BoardVO board) {
		return dao.updateBoard(board);
	}

	@Override
	public int removeBoard(int seq) {
		return dao.removeBoard(seq);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		return dao.searchBoard(condition, keyword);
	}
	@Override
	public BoardVO getBoard(int seq) {
		return dao.getBoard(seq);
	}

}
