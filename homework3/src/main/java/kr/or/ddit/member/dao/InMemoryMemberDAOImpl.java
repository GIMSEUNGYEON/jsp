package kr.or.ddit.member.dao;

import java.util.LinkedHashMap;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;

public class InMemoryMemberDAOImpl implements MemberDAO {

	private Map<String, MemberVO> memberMap; 
	
	public InMemoryMemberDAOImpl() {
		memberMap = new LinkedHashMap<>();
		MemberVO a001 = new MemberVO();
		a001.setMemId("a001");
		a001.setMemPass("asdfasdf");
		memberMap.put("a001",a001);

		MemberVO b001 = new MemberVO();
		b001.setMemId("b001");
		b001.setMemPass("1004");
		memberMap.put("b001",b001);
	}

	@Override
	public MemberVO selectMemberForAuth(MemberVO inputData) {
		
		return memberMap.get(inputData.getMemId());
	}

}
