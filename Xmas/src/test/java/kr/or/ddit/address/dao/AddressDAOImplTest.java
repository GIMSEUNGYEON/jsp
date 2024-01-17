package kr.or.ddit.address.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.AddressVO;

class AddressDAOImplTest {

	AddressDAO dao = new AddressDAOImpl();
	
	@Test
	void selectOneTest() {
		AddressVO address = dao.selectOneAdress(1);
		
		assertNotNull(address);
		
	}
	
	@Test
	void insertTest() {
		
	}
	
	@Test
	void deleteTest() {
		AddressVO address = dao.selectOneAdress(1);
		
		assertNotNull(address);
	}

}
