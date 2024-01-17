package kr.or.ddit.professor.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProfessorDAOImplTest {

	ProfessorDAO dao = new ProfessorDAOImpl();

	@Test
	void testSelectLectureList() {
		dao.selectLectureList("07A01").forEach(l -> {
			log.info("조회된 강의 목록 : {}", l);
		});
	}

	@Test
	void testSelectLecture() {
		List<Map<String, Object>> result = dao.selectLecture("231AA101");
		assertFalse(result.isEmpty());

	}

	@Test
	void testSelectStudentList() {
		assertFalse(dao.selectStudentList("191AA104").isEmpty());
	}

	@Test
	void testSelectStudent() {
		Map<String, String> stuMap = new HashMap<>();
		stuMap.put("subCd", "191AA104");
		stuMap.put("stuNo", "23AB100002");
		assertFalse(dao.selectStudent(stuMap).isEmpty());
		
	}

}
