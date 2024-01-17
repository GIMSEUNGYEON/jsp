package kr.or.ddit.professor.service;

import java.util.List;
import java.util.Map;

public interface ProfessorService {
	
	public List<Map<String, Object>> retrieveLectureList(String proNo);
	
	public List<Map<String, Object>> retrieveLecture(String subCd);
	
	public List<Map<String, Object>> retrieveStudentList(String subCd);
	
	public Map<String, Object> retriveStudent(Map<String, String> stuMap);
	
}
