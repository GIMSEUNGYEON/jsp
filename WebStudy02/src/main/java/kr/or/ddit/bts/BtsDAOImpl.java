package kr.or.ddit.bts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BtsDAOImpl implements BtsDAO {
	private Map<String, BtsVO> btsMap;
	
	public BtsDAOImpl() {
		super();
		btsMap = new HashMap<>();
		btsMap.put("rm", new BtsVO("rm", "RM", "/WEB-INF/views/bts/rm.jsp"));
		btsMap.put("jin", new BtsVO("jin", "진", "/WEB-INF/views/bts/jin.jsp"));
		btsMap.put("suga", new BtsVO("suga", "슈가", "/WEB-INF/views/bts/suga.jsp"));
		btsMap.put("jhop", new BtsVO("jhop", "제이홉", "/WEB-INF/views/bts/jhop.jsp"));
		btsMap.put("jimin", new BtsVO("jimin", "지민", "/WEB-INF/views/bts/jimin.jsp"));
		btsMap.put("bui", new BtsVO("bui", "뷔", "/WEB-INF/views/bts/bui.jsp"));
		btsMap.put("jungkuk", new BtsVO("jungkuk","정국", "/WEB-INF/views/bts/jungkuk.jsp"));
	}

	@Override
	public List<BtsVO> selectBtsList() {
		return new ArrayList<>(btsMap.values());
	}

	@Override
	public BtsVO selectBts(String name) {
		return btsMap.get(name);
	}

}
