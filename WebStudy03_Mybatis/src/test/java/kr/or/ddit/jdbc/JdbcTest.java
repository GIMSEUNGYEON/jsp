package kr.or.ddit.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.property.dao.PropertyDAO;
import kr.or.ddit.property.dao.PropertyDAOImpl;

class JdbcTest {
	PropertyDAO dao = new PropertyDAOImpl();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testDeleteProperty() {
		int del = dao.deleteProperty("DICT.BASE");
		assertEquals(1, del);
	}

}
