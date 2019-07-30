package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.biz.board.service.BoardService;
import spring.biz.board.vo.BoardVO;
import spring.biz.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class test_boardservice {
	
	@Autowired
	BoardService service;
	
	//@Test
	public void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("java");
		board.setWriter("nam");
		board.setContent("java는 객체지향 언어");
		service.insertBoard(board);
		int row = service.insertBoard(board);
		System.out.println("insert => "+ row);
	}
	
	@Test
	public void update() {
		BoardVO board = service.getBoard(2);
		board.setTitle("c++");
		int row = service.updateBoard(board);
		
		System.out.println("update" + row);
	}
	
	//@Test
	public void remove() {
		int row = service.removeBoard(2);
		System.out.println("removeUser "+ row);
	}
	
	//@Test
	public void getList() {
		for(BoardVO board : service.getBoardList()) {
			System.out.println(board);
		}
	}
	
	//@Test
	public void search() {
		for(BoardVO board : service.searchBoard("content", "java")) {
			System.out.println(board);
		}
	}
}
