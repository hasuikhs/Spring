package spring.biz.board.dao;

import java.util.List;

import spring.biz.board.vo.BoardVO;

public interface BoardDAO {
	
	BoardVO getBoard(int seq);
	
	int insertBoard(BoardVO board); // 글 등록
	
	int updateBoard(BoardVO board); // 글 수정
	
	int removeBoard(int seq); // 글 삭제
	
	List<BoardVO> getBoardList(); // 글 목록
	
	List<BoardVO> searchBoard(String condition, String keyword); // 글 검색
}
