package kr.or.ddit.dummy.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitWebConfig(locations = "file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
class DummyDAOTest {
	
	@Inject
	DummyDAO mapper;

	@Test
	void testSelectCartList() {
		log.info("cart list : {}", mapper.selectCartList());
	}

}
