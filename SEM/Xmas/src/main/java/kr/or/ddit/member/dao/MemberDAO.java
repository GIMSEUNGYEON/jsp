package kr.or.ddit.member.dao;

import kr.or.ddit.vo.MemberVO;

/**
 * 회원 관리(CRUD)용 Persistence Layer
 *
 */
public interface MemberDAO {
	/**
	 * 인증 처리를 위해 회원 정보 조회
	 * @param memId TODO
	 * @return  persistent한 형태로 저장되어 있던 정보를 가진 VO, 없으면 null 반환
	 */
	public MemberVO selectMemberForAuth(String memId);
	/**
	 * 회원 정보 조회
	 * @param memId 조회할 회원의 아이디
	 * @return 존재하지 않는 경우, null 반환.
	 */
	public MemberVO selectMember(String memId);
}

























