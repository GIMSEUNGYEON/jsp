package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

public interface StudentDAO {
	public List<Map<String, Object>> selectScoreList();
	public List<Map<String, Object>> selectClassList();
}
