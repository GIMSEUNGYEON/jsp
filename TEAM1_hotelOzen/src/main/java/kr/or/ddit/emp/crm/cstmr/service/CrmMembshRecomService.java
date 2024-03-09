package kr.or.ddit.emp.crm.cstmr.service;

import java.util.List;

import kr.or.ddit.global.common.exception.PKNotFoundException;
import kr.or.ddit.global.vo.MberVO;
import kr.or.ddit.global.vo.RecomMbrshVO;

public interface CrmMembshRecomService {
	
	/**
	 * 회원 정보 상세 조회
	 * @param memId 조회할 회원의 primary key
	 * @return 존재하지 않는 경우, {@link PKNotFoundException} 발생
	 */
	public MberVO retrieveMember(String memId);
	
	
	/**
	 * 회원 목록 조회(관리자 용)
	 * totalRecord & 페이징 처리 결과 데이터 목록 조회
	 * @param paging TODO
	 * @return 
	 */
	public List<MberVO> retrieveMemberList();
	
	public RecomMbrshVO getRecomMbrsh(String memId);

}