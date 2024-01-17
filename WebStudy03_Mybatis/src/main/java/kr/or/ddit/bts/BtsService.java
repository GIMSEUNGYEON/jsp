package kr.or.ddit.bts;

import java.util.Map;

public interface BtsService {
	public Map<String, String> retrieveEntryMap();
	
	public BtsVO retrieveBts(String name);
}
