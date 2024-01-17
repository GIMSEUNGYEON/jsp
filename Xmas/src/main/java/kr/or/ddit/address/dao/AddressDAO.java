package kr.or.ddit.address.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.MemberVO;

/**
 * Address CRUD Persistence Layer
 *
 */
public interface AddressDAO {
	
	/**
	 * 하나의 주소록을 조회. 추후 카드를 발송할 때 사용할 주소록
	 * @param Addr : 복합키를 사용하는 VO이므로 adrsNo + String adrsOwner으로 구성된 VO
	 * @return 모든 속성이 채워진 VO 반환
	 */
	public AddressVO selectOneAdress(int adrsNo);
	
	/**
	 * 현재 로그인한 사용자의 전체 주소록 조회
	 * @return
	 */
	public List<AddressVO> selectAllAdress(String adrsOwner);
	
	/**
	 * 새로운 주소록 추가
	 * @param Addr 전체 속성을 가진 VO, 입력되지 않는 칼럼은 null로 채워짐
	 * @return
	 */
	public int insertAddress(AddressVO addr);
	
	/**
	 * 주소록 수정
	 * @param Addr 전체 속성을 가진 VO
	 * @return
	 */
	public int updateAddress(AddressVO addr);

	/**
	 * 주소록 삭제
	 * @param 
	 * @return
	 */
	public int deleteAddress(int adrsNo);
	
}

























