package kr.or.ddit.bts.dao;

import java.util.List;

import kr.or.ddit.vo.BtsVO;

public interface BtsDAO {
	
	/**
	 * 전체 Bts 유형 조회
	 * @return	.size()==0 일 수 있음.
	 */
	public List<BtsVO> selectBtsList();
	
	/**
	 * 하나의 MBTI 유형 조회 
	 * @param type 조회할 MBTI 유형
	 * @return 해당 MBTI가 존재하지 않으면, null 반환.
	 */
	
	public BtsVO selectBts(String name);
}
