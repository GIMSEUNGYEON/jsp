package kr.or.ddit.address.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.AddressVO;

public class AddressDAOImpl implements AddressDAO {

	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public AddressVO selectOneAdress(int adrsNo) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
				return sqlSession.selectOne("kr.or.ddit.member.dao.AddressDAO.selectOneAdress", adrsNo);
		}
	}

	@Override
	public List<AddressVO> selectAllAdress(String adrsOwner) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			return sqlSession.selectList("kr.or.ddit.member.dao.AddressDAO.selectAllAdress", adrsOwner);
		}

	}

	@Override
	public int insertAddress(AddressVO addr) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(true);	
		){
			return sqlSession.update("kr.or.ddit.member.dao.AddressDAO.insertAddress", addr);
		}		
	}

	@Override
	public int updateAddress(AddressVO addr) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(true);	
		){
			return sqlSession.update("kr.or.ddit.member.dao.AddressDAO.updateAddress", addr);
		}		
	}

	@Override
	public int deleteAddress(int adrsNo) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(true);	
		){
			return sqlSession.update("kr.or.ddit.member.dao.AddressDAO.deleteAddress", adrsNo);
		}		
	}
}
