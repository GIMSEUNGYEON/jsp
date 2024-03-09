package kr.or.ddit.dummy.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.vo.CartVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(locations = "file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
class DummyDAOTest {

	@Inject
	@Named("dummyDAO")
	DummyDAO dao;
	
	@Test
	void testSelectCartList() {
		log.info("주입 확인 : {}", dao);
		log.info("{}", dao.selectCartList());
	}

}
