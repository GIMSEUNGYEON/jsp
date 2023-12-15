package kr.or.ddit.bts;

import java.util.List;

public interface BtsDAO {
	
	/**
	 * 전체 멤버 조회
	 * @return size()==0 가능
	 */
	public List<BtsVO> selectBtsList();
	
	
	/**
	 * 멤버 한명의 정보 조회
	 * @param name : 조회할 멤버 이름
	 * @return 해당 멤버가 존재하지 않으면 null
	 */
	public BtsVO selectBts(String name);
}
