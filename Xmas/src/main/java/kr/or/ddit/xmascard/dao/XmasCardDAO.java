package kr.or.ddit.xmascard.dao;

import java.util.List;

import kr.or.ddit.vo.XmasCardVO;

public interface XmasCardDAO {
	public XmasCardVO selectOneXCard(int xcNo);
	
	public List<XmasCardVO> selectAllXCard(String xcSender);
	
	public int sendXCard(XmasCardVO xCard);
	
	public int updateXCard(XmasCardVO xCard);
	
	public int deleteXCard(XmasCardVO xCard);
}
