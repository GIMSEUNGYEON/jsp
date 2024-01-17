package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.vo.ProdVO;

/**
 * 상품관리(CRUD) Persistence Layer
 */
public interface ProdDAO {
	
	/**
	 *  상품 추가를 위한 메서드 
	 * @param prod 추가될 메서드
	 * @return 영향을 받은 행
	 */
	public int insertProd(ProdVO prod);
	
	/**
	 * Total Record 및 Total Page 결정을 위한 쿼리
	 * @param paging
	 * @return
	 */
	public int selectTotalRecord(PaginationInfo paging);
	
	/**
	 * 페이징 처리 결과 데이터 목록 조회
	 * @param paging TODO
	 * @return 조회된 상품 목록
	 */
	public List<ProdVO> selectProdList(PaginationInfo paging); //다건 조회
	
	/**
	 * 상품 단건 조회 메서드
	 * @param proId 상품의 primary key
	 * @return 조회된 상품
	 */
	public ProdVO selectProd(String proId); //단건 조회
	
	/**
	 * 상품 수정 메서드
	 * @param prod 수정할 상품 정보
	 * @return 영향을 받은 행
	 */
	public int updateProd(ProdVO prod);

}
