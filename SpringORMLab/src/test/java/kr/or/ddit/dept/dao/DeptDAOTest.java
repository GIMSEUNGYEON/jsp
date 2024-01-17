package kr.or.ddit.dept.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.common.paging.PaginationInfo;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringJUnitConfig(locations = "file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
class DeptDAOTest {
	
	@Inject
	DeptDAO dao;
	
	@Test
	void test() {
		PaginationInfo paging = new PaginationInfo(4,1);
		paging.setCurrentPage(1);
		log.info("{}",dao.selectDeptList(paging));
		
	}

}
