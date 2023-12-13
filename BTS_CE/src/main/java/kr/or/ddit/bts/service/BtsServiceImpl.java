package kr.or.ddit.bts.service;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import kr.or.ddit.bts.dao.BtsDAO;
import kr.or.ddit.bts.dao.InMemoryBtsDAOImpl;
import kr.or.ddit.bts.exception.BtsNotFoundException;
import kr.or.ddit.vo.BtsVO;

public class BtsServiceImpl implements BtsService {
	private BtsDAO dao = new InMemoryBtsDAOImpl();
	
	@Override
	public Set<Entry<String, String>> retrieveEntrySet() {
		 return dao.selectBtsList().stream()
					.map(vo->new SimpleEntry<String,String>(vo.getName(), vo.getTitle()))
					.collect(Collectors.toSet());
	}

	@Override
	public Map<String, String> retrieveEntryMap() {
		return dao.selectBtsList().stream()
				.collect(Collectors.toMap(BtsVO::getName, BtsVO::getTitle));
	}

	@Override
	public BtsVO retrieveBts(String name) {
		BtsVO vo = dao.selectBts(name);
		if(vo==null) {
			throw new BtsNotFoundException(String.format("%s 멤버가 없음.", name));
		}
		return vo;
	}

}
