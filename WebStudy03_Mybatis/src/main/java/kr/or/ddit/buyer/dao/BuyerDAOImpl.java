package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.ProdVO;

public class BuyerDAOImpl implements BuyerDAO {

	SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public BuyerVO selectBuyer(String buyerId) {
		try(		
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			BuyerDAO proxyMapper = sqlSession.getMapper(BuyerDAO.class);
			return proxyMapper.selectBuyer(buyerId);
			
		}
	}

	@Override
	public int selectTotalRecord(PaginationInfo paging) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			BuyerDAO proxyMapper = sqlSession.getMapper(BuyerDAO.class);
			return proxyMapper.selectTotalRecord(paging);
		}
	}

	@Override
	public List<BuyerVO> selectBuyerList(PaginationInfo paging) {
		try (
			SqlSession sqlSession = sqlSessionFactory.openSession()
		) {
			BuyerDAO proxyMapper = sqlSession.getMapper(BuyerDAO.class);
			List<BuyerVO> prodList = proxyMapper.selectBuyerList(paging);

			return prodList;
		}
	}

	@Override
	public int insertBuyer(BuyerVO buyer) {
		try (
			SqlSession sqlSession = sqlSessionFactory.openSession()
		) {
			BuyerDAO proxyMapper = sqlSession.getMapper(BuyerDAO.class);
			int cnt = proxyMapper.insertBuyer(buyer);
			sqlSession.commit();
			return cnt;
		}
	}
}
