package kr.or.ddit.professor.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ClassVO;

public interface ProfessorDAO {

	/**
	 * 교수의 담당 강의 리스트 조회
	 * @return
	 */
	public List<Map<String, Object>> selectLectureList(String proNo);

	/**
	 *  강의 정보 조회(한가지 강의가 다른 강의실, 다른 강의 시간에 있을 수 있어 list가 반환됨)
	 * @param subCd 조회할 강의 번호
	 * @return
	 */
	public List<Map<String, Object>> selectLecture(String subCd);
	
	/**
	 * 강의 수강 학생리스트 조회
	 * @return
	 */
	public List<Map<String, Object>> selectStudentList(String subCd);
	
	/**
	 * 학생 정보 조회
	 * @param stuName 조회할 학생 학번
	 * @return
	 */
	public Map<String, Object> selectStudent(Map<String, String> stuMap);

	/**
	 * 학점 입력
	 * @param proVO
	 * @return 등록된 레코드 수 > > 0 ? 성공
	 */
	public int insertHakJum(ClassVO classVO);

}
