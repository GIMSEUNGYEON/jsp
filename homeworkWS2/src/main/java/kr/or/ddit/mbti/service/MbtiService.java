package kr.or.ddit.mbti.service;

import java.util.Map.Entry;

import kr.or.ddit.vo.MbtiVO;

import java.util.Map;
import java.util.Set;

/**
 * raw data를 가공하여 information을 생성하는 서비스
 *
 */
public interface MbtiService {
	
	/**
	 * 전체 MBTI 유형을 Entry(key:Type, value;Title) 집합으로 조히
	 * @return 조회할 MBTI 유형이 없다면 .size() 가 0 인 객체 리턴
	 */
	public Set<Entry<String, String>> retrieveEntrySet();
	
	/**
	 * 전체 MBTI 유형을 Map(key:Type, value;Title)으로 collection함.
	 * @return 조회할 MBTI 유형이 없다면 .size() 가 0 인 객체 리턴
	 */
	public Map<String, String> retrieveEntryMap();
	
	
	/**
	 * 하나의 MBTI 유형 조회
	 * @param type : 조회할 MBTI 유형
	 * @return : 해당 MBTI 유형이 없으면, {@link MbtiNotFoundException} 발생
	 */
	public MbtiVO retrieveMbti(String type);
}
