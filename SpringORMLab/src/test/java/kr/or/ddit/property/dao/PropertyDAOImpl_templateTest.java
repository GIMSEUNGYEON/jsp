package kr.or.ddit.property.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringJUnitConfig(locations = "file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
class PropertyDAOImpl_templateTest {

	@Inject
	@Named("propertyDAO")
	PropertyDAO dao;
	
	@Test
	void testSelectProperties() {
		log.info("{}",dao.selectProperties());
	}
}
