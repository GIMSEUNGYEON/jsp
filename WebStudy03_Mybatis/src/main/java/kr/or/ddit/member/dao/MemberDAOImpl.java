package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.common.exception.CustomPersistenceException;
import kr.or.ddit.common.paging.PaginationInfo;
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
	public int selectTotalRecord(PaginationInfo paging) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO proxyMapper = sqlSession.getMapper(MemberDAO.class);
			
			return proxyMapper.selectTotalRecord(paging);
		}
	}

	@Override
	public List<MemberVO> selectMemberList(PaginationInfo paging) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO proxyMapper = sqlSession.getMapper(MemberDAO.class);
			
			return proxyMapper.selectMemberList(paging);
		}
	}

	@Override
	public int updateMember(MemberVO member) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			int cnt = mapperProxy.updateMember(member);
			sqlSession.commit();
			return cnt;
		}
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
