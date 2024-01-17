package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.professorList.dao.ProfessorListDAO;

public class StudentDAOImpl implements StudentDAO {

	SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<Map<String, Object>> selectScoreList() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			StudentDAO mapperProxy = sqlSession.getMapper(StudentDAO.class);
			return mapperProxy.selectScoreList();
		}
	}

	@Override
	public List<Map<String, Object>> selectClassList() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			StudentDAO mapperProxy = sqlSession.getMapper(StudentDAO.class);
			return mapperProxy.selectClassList();
		}
	}
	
}
