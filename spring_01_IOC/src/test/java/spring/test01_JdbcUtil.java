package spring;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Util.JDBCUtil;

public class test01_JdbcUtil {
	Connection con;

	@Before
	public void setUp() {
		con = JDBCUtil.getConnection();
		System.out.println("con 할당");
	}

	@After
	public void tearDown() {
		JDBCUtil.close(con, null, null);
		System.out.println("con 해제");
	}

	@Test
	public void test() {
		assertNotNull(con);
	}

}
