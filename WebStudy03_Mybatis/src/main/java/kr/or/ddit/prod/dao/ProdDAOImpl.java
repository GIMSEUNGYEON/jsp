package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.ProdVO;

public class ProdDAOImpl implements ProdDAO {

	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public int insertProd(ProdVO prod) {
		try (
			SqlSession sqlSession = sqlSessionFactory.openSession(true)
		) {
		ProdDAO proxyMapper = sqlSession.getMapper(ProdDAO.class);
		return proxyMapper.insertProd(prod);
		}
	}

	@Override
	public int selectTotalRecord(PaginationInfo paging) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			ProdDAO proxyMapper = sqlSession.getMapper(ProdDAO.class);
			int totalRecord = proxyMapper.selectTotalRecord(paging);

			return totalRecord;
		}

	}

	@Override
	public List<ProdVO> selectProdList(PaginationInfo paging) {

		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			ProdDAO proxyMapper = sqlSession.getMapper(ProdDAO.class);
			List<ProdVO> prodList = proxyMapper.selectProdList(paging);

			return prodList;
		}

	}

	@Override
	public ProdVO selectProd(String proId) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			ProdDAO proxyMapeer = sqlSession.getMapper(ProdDAO.class);
			return proxyMapeer.selectProd(proId);
		}
	}

	@Override
	public int updateProd(ProdVO prod) {
		try (
			SqlSession sqlSession = sqlSessionFactory.openSession(true)
		) {
			ProdDAO proxyMapper = sqlSession.getMapper(ProdDAO.class);
			return proxyMapper.updateProd(prod);
		}
	}

}
