package kr.or.ddit.address.service;

import java.util.List;

import kr.or.ddit.vo.AddressVO;

/**
 * Address CRUD Business Logic Layer
 * @author PC-2
 *
 */
public interface AddressService {
	
	/**
	 * 주소록 하나 조회
	 * @param adrsNo
	 * @return
	 */
	public AddressVO retrieveAdress(int adrsNo);

	/**
	 * 현재 로그인한 사용자의 모든 주소록 조회
	 * @return
	 */
	public List<AddressVO> retrieveAddressList(String adrsOwner);
	
	/**
	 * 주소록 생성(시퀀스를 이용해 데이터를 생성하므로 중복일 경우는 고려하지 않음)
	 * @param addr
	 * @return
	 */
	public boolean createAddress(AddressVO addr);
	
	/**
	 * 주소록 수정
	 * @param addr
	 * @return
	 */
	public boolean modifyAddress(AddressVO addr);
	
	/**
	 * 주소록 삭제
	 * @param adrsNo
	 * @return
	 */
	public boolean removeAddress(int adrsNo);
	
}
