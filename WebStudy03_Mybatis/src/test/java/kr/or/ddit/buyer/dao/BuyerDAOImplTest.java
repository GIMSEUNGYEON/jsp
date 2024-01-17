package kr.or.ddit.buyer.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.common.paging.PaginationInfo;
import lombok.extern.slf4j.Slf4j;
@Slf4j
class BuyerDAOImplTest {

	BuyerDAO dao = new BuyerDAOImpl();
	@Test
	void testSelectBuyer() {
		log.info("{}", dao.selectBuyer("P10101"));
	}
	
	@Test
	void testSelectList() {
		PaginationInfo paging = new PaginationInfo();
		
		log.info("{}", dao.selectBuyerList(paging));
	}
}
