package spring.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.biz.board.vo.BoardVO;

@Repository("mybatis1")
public class BoardDAO_MyBatis implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertBoard(BoardVO board) {
		System.out.println("board insert 실행");	
		return sqlSession.insert("board.insert", board);
	}

	@Override
	public int updateBoard(BoardVO board) {
		System.out.println("board update 실행");
		
		return sqlSession.update("board.update", board);
	}

	@Override
	public int removeBoard(int seq) {
		System.out.println("board remove 실행");
		return sqlSession.delete("board.delete", seq);
	}

	@Override
	public List<BoardVO> getBoardList() {
		System.out.println("board list 실행");
		return sqlSession.selectList("board.list"); // list 반환
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		System.out.println("search board 실행");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(condition,keyword);
		
		return sqlSession.selectList("board.search", map);
	}

	@Override
	public BoardVO getBoard(int seq) {
		System.out.println("getboard 실행");
		
		return sqlSession.selectOne("board.seq", seq);
	}

}
