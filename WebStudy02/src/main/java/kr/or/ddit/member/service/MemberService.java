package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;

/**
 * 회원 관리(CRUD)용 business logic layer
 *
 */
/**
 * @author PC-2
 *
 */
public interface MemberService {
	
	/**
	 * 회원 가입 처리
	 * @param member
	 * @return PKDUPLICATED(존재하지 않는 아이디), OK(성공), FAIL(실패)
	 */
	public ServiceResult createMember(MemberVO member);
	
	/**
	 * 회원 정보 상세 조회
	 * @param memId 조회할 회원의 primary key
	 * @return 존재하지 않는 경우, {@link PKNotFoundException} 발생
	 */
	public MemberVO retrieveMember(String memId);
	
	
	/**
	 * 회원 목록 조회(관리자 용)
	 * @return 
	 */
	public List<MemberVO> retrieveMemberList();
	
	
	/**
	 * 회원 정보 수정
	 * @param member
	 * @return INVALIDPASSWORD(인증 실패), OK(성공), FAIL(실패)
	 */
	public ServiceResult ModifyMember(MemberVO member);
	
	
	/**
	 * 회원 탈퇴
	 * @param memId
	 * @return INVALIDPASSWORD(인증 실패), OK(성공), FAIL(실패)
	 */
	public ServiceResult removeMember(MemberVO inputData);
	
}
