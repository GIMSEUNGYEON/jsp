package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
class ProdDAOImplTest {
	
	ProdDAO dao = new ProdDAOImpl();
	
	@Test
	void testInsert	() {
		ProdVO prod = new ProdVO();
		prod.setProdLgu("P101");
		prod.setProdName("name");
		prod.setProdBuyer("P10101");
		prod.setProdPrice(1000);
		prod.setProdCost(1000);
		prod.setProdSale(1000);
		prod.setProdOutline("1000");
		prod.setProdImg("1000");
		prod.setProdTotalstock(1000);
		prod.setProdProperstock(1000);
		log.info("{}", dao.insertProd(prod));
		
		
	}	
	
	@Test
	void testSelectList() {
		List<ProdVO> prodList = dao.selectProdList(null);
		
		assertNotEquals(0, prodList.size());
	}
	
	@Test
	void testSelectProd() {
		log.info("{}",dao.selectProd("P101000001"));
	}
	
	@Test
	void testUpdateProd() {
		ProdVO prod = new ProdVO();
		
		prod.setProdId("P101000001");
		prod.setProdLgu("P101");
		prod.setProdName("name");
		prod.setProdBuyer("P10101");
		prod.setProdPrice(1000);
		prod.setProdCost(1000);
		prod.setProdSale(1000);
		prod.setProdOutline("1000");
		prod.setProdImg("1000");
		prod.setProdTotalstock(1000);
		prod.setProdProperstock(1000);
		log.info("{}", dao.updateProd(prod));
	}
}
