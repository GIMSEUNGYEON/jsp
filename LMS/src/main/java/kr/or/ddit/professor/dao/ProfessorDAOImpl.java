package kr.or.ddit.professor.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.ClassVO;

public class ProfessorDAOImpl implements ProfessorDAO {
	
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
		
	@Override
	public List<Map<String, Object>> selectLectureList(String proNo) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			ProfessorDAO proxyMapper = sqlSession.getMapper(ProfessorDAO.class);
			return proxyMapper.selectLectureList(proNo);
		}
	}

	@Override
	public List<Map<String, Object>> selectLecture(String subCd) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			ProfessorDAO proxyMapper = sqlSession.getMapper(ProfessorDAO.class);
			return proxyMapper.selectLecture(subCd);
		}
	}

	@Override
	public List<Map<String, Object>> selectStudentList(String subCd) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			ProfessorDAO proxyMapper = sqlSession.getMapper(ProfessorDAO.class);
			return proxyMapper.selectStudentList(subCd);
		}
	}

	@Override
	public Map<String, Object> selectStudent(Map<String, String> stuMap) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			ProfessorDAO proxyMapper = sqlSession.getMapper(ProfessorDAO.class);
			return proxyMapper.selectStudent(stuMap);
		}
	}

	@Override
	public int insertHakJum(ClassVO classVO) {
		return 0;
	}

}
