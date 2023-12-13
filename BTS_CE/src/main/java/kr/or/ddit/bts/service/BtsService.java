package kr.or.ddit.bts.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import kr.or.ddit.vo.BtsVO;

/**
 * raw data 를 가공해서 information을 생성함.
 *
 */
public interface BtsService {
	/**
	 * 전체 BTS 멤버를 Entry(key:Name, value:Title) 집합으로 조회 
	 * @return 
	 */
	public Set<Entry<String, String>> retrieveEntrySet();
	/**
	 * 전체 BTS 멤버를 Map(key:Type, value:Title)으로 collecting 함. 
	 * @return
	 */
	public Map<String, String> retrieveEntryMap();
	/**
	 * 한 명의 BTS 멤버 조회  
	 * @param name 조회 할 멤버 이름
	 * @return 해당 멤버가 없으면, {@link BtsNotFoundException} 발생
	 */
	public BtsVO retrieveBts(String name);
}
