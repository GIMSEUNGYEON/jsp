package kr.or.ddit.professor.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.professor.dao.ProfessorDAO;
import kr.or.ddit.professor.dao.ProfessorDAOImpl;

public class ProfessorServiceImpl implements ProfessorService {

	ProfessorDAO dao = new ProfessorDAOImpl();
	
	
	@Override
	public List<Map<String, Object>> retrieveLectureList(String proNo) {
		
		return dao.selectLectureList(proNo);
	}

	@Override
	public List<Map<String, Object>> retrieveLecture(String subCd) {
		return dao.selectLecture(subCd);
	}

	@Override
	public List<Map<String, Object>> retrieveStudentList(String subCd) {

		return dao.selectStudentList(subCd);
	}

	@Override
	public Map<String, Object> retriveStudent(Map<String, String> stuMap) {
		return dao.selectStudent(stuMap);
	}

}
