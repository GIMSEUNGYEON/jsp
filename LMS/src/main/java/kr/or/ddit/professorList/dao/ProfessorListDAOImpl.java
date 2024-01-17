package kr.or.ddit.professorList.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;

public class ProfessorListDAOImpl implements ProfessorListDAO {

	SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<Map<String, Object>> selectListProfessor() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			ProfessorListDAO mapperProxy = sqlSession.getMapper(ProfessorListDAO.class);
			return mapperProxy.selectListProfessor();
		}

	}

}
