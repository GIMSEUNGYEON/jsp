package kr.or.ddit.student.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
@Slf4j
class StudentDAOImplTest {
	
	StudentDAO dao = new StudentDAOImpl();
	
	@Test
	void testSelectScoreList() {
		dao.selectScoreList().forEach(s->{
			log.info("조회된 학생의 점수{}", s);
		});
	}

	@Test
	void testSelectClassList() {
		dao.selectClassList().forEach(s->{
			log.info("조회된 강의{}", s);
		});
	}

}
