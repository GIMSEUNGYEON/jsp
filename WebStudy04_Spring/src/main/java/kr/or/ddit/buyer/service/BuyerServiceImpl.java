package kr.or.ddit.buyer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.buyer.dao.BuyerDAO;
import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.BuyerVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {

	private final BuyerDAO dao;
	
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

	@Override
	public ServiceResult modifyBuyer(BuyerVO buyer) {
		ServiceResult result = null;
		
		result = dao.updateBuyer(buyer) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		
		return result;
	}

	@Override
	public ServiceResult removeBuyer(String buyerId) {
		ServiceResult result = null;

		result = dao.deleteBuyer(buyerId) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		
		return result;
	}

}
