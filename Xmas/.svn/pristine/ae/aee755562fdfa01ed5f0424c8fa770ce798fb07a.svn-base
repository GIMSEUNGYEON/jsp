package kr.or.ddit.member.service;

import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO dao = new MemberDAOImpl();

	@Override
	public MemberVO retrieveMember(String memId) {
		MemberVO member = dao.selectMember(memId);
		if(member==null)
			throw new PKNotFoundException(String.format("%s 에 해당하는 사용자 없음.", memId));
		return member;
	}

}
