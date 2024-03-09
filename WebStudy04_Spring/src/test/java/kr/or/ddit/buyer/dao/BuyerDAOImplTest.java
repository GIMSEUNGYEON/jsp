package kr.or.ddit.buyer.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
class BuyerDAOImplTest extends AbstractRootContextTest {

	@Inject
	BuyerDAO dao;

	
	@Test
	void testDao() {
		log.info("다오 주입 확인 : {}", dao);
	}
	@Test
	void testSelectBuyer() {
		log.info("{}", dao.selectBuyer("P10101"));
	}
	
	@Test
	void testSelectList() {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(1);
		paging.setTotalRecord(10);
		log.info("{}", dao.selectBuyerList(paging));
	}
	
	@Test
	void updateBuyer() {
		BuyerVO buyer = dao.selectBuyer("P10105");
		buyer.setBuyerName("test");
		
		log.info("{}", dao.updateBuyer(buyer));
	}
	@Test
	void deleteBuyer() {
		log.info("{}", dao.deleteBuyer("P10105"));
	}
}
