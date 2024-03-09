package kr.or.ddit.mbti.dao;

import java.util.List;

import kr.or.ddit.vo.MbtiDescVO;

/**
 * MBTI 유형 관리 persistence Layer
 *
 */
public interface MbtiDAO {
	/**
	 * 전체 MBTI 유형 조회
	 * @return .size()==0 일 수 있음.
	 */
	public List<MbtiDescVO> selectMbtiList();
	
	/** 
	 * 하나의 MBTI 유형 조회
	 * @param type 조회할 MBTI 유형
	 * @return 해당 MBTI 가 존재하지 않으면, null 반환.
	 */
	public MbtiDescVO selectMbti(String mtType);
	
	/**
	 * MBTI 유형 정보 등록
	 * @param mbti
	 * @return 등록된 레코드 수 반환
	 */
	public int insertMbti(MbtiDescVO mbti);
}
