package kr.or.ddit.datasource;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.or.ddit.vo.PropertyVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
class PropertiesTBConnectTest {

	@Inject
	@Named("sqlSession")
	SqlSession sqlSession;
	
	@Test
	void test() {
		log.info("주입된 sql session : {}", sqlSession);
		
	}
	@Test
	void selectListTest() {
		List<PropertyVO> propList = sqlSession.selectList("kr.or.ddit.property.dao.PropertyDAO.selectProperties");
		log.info("조회된 propList : {}", propList);		
	}
	
	@Test
	void selectOneTest() {
		PropertyVO vo = sqlSession.selectOne("kr.or.ddit.property.dao.PropertyDAO.selectProperty", "NLS_SORT");
		log.info("조회된 prop : {}", vo);		
	}
	@Test
	void insertTest() {
		PropertyVO vo = new PropertyVO();
		vo.setPropertyName("Dummy");
		vo.setPropertyValue("Dummy");
		vo.setDescription("Dummy");

//		int rowCnt = sqlSession.insert("kr.or.ddit.property.dao.PropertyDAO.insertProperty", vo);
//		
//		log.info("insert test : {}", rowCnt);
		
	}
	@Test
	void updateTest() {
		PropertyVO vo = new PropertyVO();
		vo.setPropertyName("Dummy");
		vo.setPropertyValue("ModiDummy");
		vo.setDescription("ModiDummy");
		int updateCnt = sqlSession.update("kr.or.ddit.property.dao.PropertyDAO.updateProperty", vo);
		
	}
	
	@Test
	void deleteTest() {
		String prodName = "Dummy";
		int rowCnt = sqlSession.delete("kr.or.ddit.property.dao.PropertyDAO.deleteProperty", prodName);
	}

}
