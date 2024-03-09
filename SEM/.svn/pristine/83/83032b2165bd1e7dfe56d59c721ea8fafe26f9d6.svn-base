package kr.or.ddit.mbti.service;

import java.util.List;

import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.vo.MbtiDescVO;

/**
 * MBTI 유형 관리 business logic layer
 *
 */
public interface MbtiService {
	/**
	 * MBTI 유형 등록
	 * @param mbti
	 */
	public void createMBTI(MbtiDescVO mbti);
	
	/**
	 * 전체 MBTI 목록 조회
	 * @return
	 */
	public List<MbtiDescVO> retrieveMbtiList();
	
	/**
	 * 하나의 MBTI 유형 조회
	 * @param type 조회할 MBTI 유형
	 * @return 해당 MBTI 유형이 없으면, {@link PKNotFoundException} 발생
	 */
	public MbtiDescVO retrieveMbti(String mtType);
}













