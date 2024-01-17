package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
		
	@Override
	public MemberVO selectMemberForAuth(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession()
		){
			return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMemberForAuth", memId);
		}
	}
//	template method pattern으로 해결 예정
	@Override
	public int insertMember(MemberVO member) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(true)
		){
			return sqlSession.update("kr.or.ddit.member.dao.MemberDAO.insertMember", member);
		}
	}

	@Override
	public MemberVO selectMember(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession()
		){
			
			return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMember", memId);
		}
	}

	@Override
	public List<MemberVO> selectMemberList() {
		return null;
	}

	@Override
	public int updateMember(MemberVO member) {
		return 0;
	}

	@Override
	public int deleteMember(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(true)
		){
			return sqlSession.update("kr.or.ddit.member.dao.MemberDAO.deleteMember", memId);
		}
	}

}
