package kr.or.ddit.buyer.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.common.paging.PaginationRenderer;
import kr.or.ddit.others.dao.OthersDAO;
import kr.or.ddit.others.dao.OthersDAOImpl;
import kr.or.ddit.vo.BuyerVO;

/**
 * 스크린 사이즈는 3 블럭사이즈는 2를 기준으로 한 페이징 처리
 * 다음의 검색 상황에 대한 지원 
 *  : 전자제품 분류에 해당하는 제조사 중 서울 지역의 제조사 중 삼성전자라는 이름이 포함된 제조사 정보 검색
 * 제조사 분류(select에서 이름을 선택, 넘어가는 value는 코드), 지역, 이름
 */
@WebServlet("/buyer/buyerList.do")
public class BuyerListControllerServlet extends HttpServlet {
	
	private BuyerService service = new BuyerServiceImpl();
	private OthersDAO dao = new OthersDAOImpl();
	
	public void addLprodList(HttpServletRequest req) {
		req.setAttribute("lprodList", dao.selectLprodList());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		addLprodList(req);
		
		PaginationInfo paging = new PaginationInfo(3,2);
		
		String pageStr = req.getParameter("page");
		
		Enumeration<String> paramNames = req.getParameterNames();
		
		Map<String, Object> detailCondition = new LinkedHashMap<>();
		
		while(paramNames.hasMoreElements()) {
			String name = (String) paramNames.nextElement();
			detailCondition.put(name,req.getParameter(name));
		}
		
		req.setAttribute("condition", detailCondition);
		
		int currentPage = 1;
		
		if(StringUtils.isNumeric(pageStr)) {
			currentPage = Integer.parseInt(pageStr);
		}
		
		paging.setCurrentPage(currentPage);
		paging.setDetailCondition(detailCondition);
		
		List<BuyerVO> buyerList = service.retrieveBuyerList(paging);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#buyerSearchForm");
		
		String pagingHTML = renderer.renderPagination(paging);
		
		req.setAttribute("buyerList", buyerList);
		req.setAttribute("pagingHTML", pagingHTML);
		
		String logicalViewName = "buyer/buyerList";
		
		req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);
				
				
	}
}
