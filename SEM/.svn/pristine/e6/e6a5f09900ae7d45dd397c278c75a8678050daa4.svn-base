package kr.or.ddit.mbti.service;

import java.util.List;

import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.mbti.dao.MbtiDAO;
import kr.or.ddit.mbti.dao.MbtiDAOImpl;
import kr.or.ddit.vo.MbtiDescVO;

public class MbtiServiceImpl implements MbtiService {
	
	private MbtiDAO dao = new MbtiDAOImpl();

	@Override
	public void createMBTI(MbtiDescVO mbti) {
		if(retrieveMbtiList().size() > 16) {
			throw new RuntimeException("더이상의 mbti 유형은 추가 불가");
		}else {
			dao.insertMbti(mbti);
		}
	}

	@Override
	public List<MbtiDescVO> retrieveMbtiList() {
		return dao.selectMbtiList();
	}

	@Override
	public MbtiDescVO retrieveMbti(String mtType) {
		MbtiDescVO mbti = dao.selectMbti(mtType);
		if(mbti==null)
			throw new PKNotFoundException(404, "조회할 MBTI 유형이 없음.");
		return mbti;
	}

}
















