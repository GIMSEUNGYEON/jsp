package kr.or.ddit.dept.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.common.paging.PaginationInfo;

@SpringJUnitConfig(locations = "file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
class DeptDAOTest {

	@Autowired
	DeptDAO dao;
	
	@Test
	void testSelectDeptList() {
		PaginationInfo paging = new PaginationInfo(4, 2);
		paging.setCurrentPage(1);
		dao.selectDeptList(paging);
	}

}
