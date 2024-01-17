package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDAO;
import kr.or.ddit.buyer.dao.BuyerDAOImpl;
import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.BuyerVO;

public class BuyerServiceImpl implements BuyerService {

	BuyerDAO dao = new BuyerDAOImpl();
	
	@Override
	public BuyerVO retrieveBuyer(String buyerId) {
		BuyerVO buyer = dao.selectBuyer(buyerId);
		
		if(buyer == null) 
			throw new PKNotFoundException(String.format("%s에 해당하는 제조사 없음", buyerId));
		
		return buyer;
	}

	@Override
	public List<BuyerVO> retrieveBuyerList(PaginationInfo paging) {
		int totalRecord = dao.selectTotalRecord(paging);
		
		paging.setTotalRecord(totalRecord);
		
		List<BuyerVO> buyerList = dao.selectBuyerList(paging);
		
		return buyerList;
	}

	@Override
	public ServiceResult createBuyer(BuyerVO buyer) {
		ServiceResult result = null;
		
		result = dao.insertBuyer(buyer) > 0 ? ServiceResult.OK : ServiceResult.FAIL;

		return result;
	}

}