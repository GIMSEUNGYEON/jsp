package kr.or.ddit.property.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.PropertyVO;

class propertyDAOTest {
	
	PropertyDAO dao = new InMemoryPropertyDAOImpl("/kr/or/ddit/message/message-common_en.properties");
	
	@Test
	void testInsertProperty() {
		PropertyVO newProp = new PropertyVO();
		newProp.setPropertyName("DummyName");
		newProp.setPropertyValue("DummyValue");
		int rowcnt = dao.insertProperty(newProp);
		assertEquals(1, rowcnt);
	}

	@Test
	void testSelectProperties() {
		List<PropertyVO> propList = dao.selectProperties();
		//assertion
		assert propList != null;
		assertNotNull(propList);
		assertNotEquals(0, propList.size());
	}

	@Test
	void testSelectProperty() {
		PropertyVO vo = dao.selectProperty("adfad");
		assertNull(vo);
		vo = dao.selectProperty("fail.common.msg");
		
		assertNotNull(vo);

	}

	@Test
	void testUpdateProperty() {
		PropertyVO modifyProp = new PropertyVO();
		modifyProp.setPropertyName("fail.common.msg");
		modifyProp.setPropertyValue("modified value");
		int modcnt = dao.updateProperty(modifyProp);
		assertEquals(1, modcnt);
		
		modifyProp.setPropertyName("gaetdaaad");
		modifyProp.setPropertyValue("modified value");
		
		modcnt = dao.updateProperty(modifyProp);
		
		assertEquals(0, modcnt);
	}

	@Test
	void testDeleteProperty() {
		String name = "fail.common.msg";
		
		int delcnt = dao.deleteProperty(name);

		assertEquals(1, delcnt);
		
		}
}
