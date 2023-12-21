package kr.or.ddit.bts;

import java.util.Map;
import java.util.stream.Collectors;
import kr.or.ddit.bts.BtsVO;
public class BtsServiceImpl implements BtsService {
	private BtsDAO dao = new BtsDAOImpl();
	@Override
	public Map<String, String> retrieveEntryMap() {
		return dao.selectBtsList().stream()
				.collect(Collectors.toMap(BtsVO::getName, BtsVO::getTitle));
	}

	@Override
	public BtsVO retrieveBts(String name) {
		BtsVO vo = dao.selectBts(name);
		if(vo==null) {
			throw new NullPointerException(String.format("%s 멤버 없음", name));
		}
		return vo;
	}

}
