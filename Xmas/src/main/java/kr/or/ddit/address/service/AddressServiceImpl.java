package kr.or.ddit.address.service;

import java.util.List;

import kr.or.ddit.address.dao.AddressDAO;
import kr.or.ddit.address.dao.AddressDAOImpl;
import kr.or.ddit.common.exception.ColumnNotFoundException;
import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.vo.AddressVO;

public class AddressServiceImpl implements AddressService {
	
	AddressDAO dao = new AddressDAOImpl();
	
	@Override
	public AddressVO retrieveAdress(int adrsNo) {
		AddressVO address = dao.selectOneAdress(adrsNo);
		if(address == null) {
			throw new PKNotFoundException(String.format("해당하는 주소록 없음.", adrsNo));
		}
		return address;
	}

	@Override
	public List<AddressVO> retrieveAddressList(String adrsOwner) {
		List<AddressVO> addressList = dao.selectAllAdress(adrsOwner);
		if(addressList.size() == 0) {
			throw new ColumnNotFoundException("현재 조회할 수 있는 주소록이 없음");
		}
		return addressList;
	}

	@Override
	public boolean createAddress(AddressVO addr) {
		boolean result = false;
		
		if(dao.insertAddress(addr) != 0) {
			result = true;
		}
		
		return result;
	}

	@Override
	public boolean modifyAddress(AddressVO addr) {
		boolean result = false;
		
		if(dao.updateAddress(addr) != 0) {
			result = true;
		}
		
		return result;
	}

	@Override
	public boolean removeAddress(int adrsNo) {
		boolean result = false;
		
		if(dao.deleteAddress(adrsNo) != 0) {
			result = true;
		}
		
		return result;
	}

}
