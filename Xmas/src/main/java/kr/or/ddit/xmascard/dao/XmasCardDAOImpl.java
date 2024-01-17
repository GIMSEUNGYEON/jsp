package kr.or.ddit.xmascard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.XmasCardVO;

public class XmasCardDAOImpl implements XmasCardDAO {
	
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public XmasCardVO selectOneXCard(int xcNo) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			return sqlSession.selectOne("kr.or.ddit.member.dao.XmasCardDAO.selectOneXCard", xcNo);
			
		}
	}

	@Override
	public List<XmasCardVO> selectAllXCard(String xcSender) {
		return null;
	}

	@Override
	public int sendXCard(XmasCardVO xCard) {
		return 0;
	}

	@Override
	public int updateXCard(XmasCardVO xCard) {
		return 0;
	}

	@Override
	public int deleteXCard(XmasCardVO xCard) {
		return 0;
	}

}
