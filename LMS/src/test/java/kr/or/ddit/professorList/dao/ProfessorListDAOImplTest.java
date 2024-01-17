package kr.or.ddit.professorList.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
class ProfessorListDAOImplTest {

	ProfessorListDAO dao = new ProfessorListDAOImpl();
	
	@Test
	void selectListTest() {
		List<Map<String, Object>> profList = dao.selectListProfessor();
	
		profList.forEach((p)->{
			log.info("조회된 교수 목록 : {}", p);
		});
	}

}
