package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.biz.board.service.BoardService;
import spring.biz.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class test_boardservice {
	
	@Autowired
	BoardService serviceb;
	
	//@Test
	public void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("jdbc");
		board.setWriter("nam");
		board.setContent("oracle java");
		serviceb.insertBoard(board);
		int row = serviceb.insertBoard(board);
		System.out.println("insert => "+ row);
	}
	
	@Test
	public void update() {
		BoardVO board = serviceb.getBoard(1);
		board.setTitle("c++");
		serviceb.updateBoard(board);
		int row = serviceb.updateBoard(board);
		
		System.out.println("update" + row);
	}
	
	//@Test
	public void remove() {
		int row = serviceb.removeBoard(3);
		System.out.println("removeUser "+ row);
	}
	
	//@Test
	public void getList() {
		for(BoardVO board : serviceb.getBoardList()) {
			System.out.println(board);
		}
	}
	
	//@Test
	public void search() {
		for(BoardVO board : serviceb.searchBoard("content", "ora")) {
			System.out.println(board);
		}
	}
}
