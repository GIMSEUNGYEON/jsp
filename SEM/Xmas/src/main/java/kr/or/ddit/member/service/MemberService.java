package kr.or.ddit.member.service;

import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.vo.MemberVO;

/**
 * 회원 관리(crud)용 business logic layer
 *
 */
public interface MemberService {
	/** 
	 * 회원 정보 상세 조회
	 * @param memId 조회할 회원의 primary key 
	 * @return 존재하지 않는 경우, {@link PKNotFoundException}
	 */
	public MemberVO retrieveMember(String memId);
}
















