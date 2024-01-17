package kr.or.ddit.prod.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.others.advice.OthersControllerAdvice;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodInsert.do")
public class ProdInsertControllerServlet extends HttpServlet {

	private ProdService service = new ProdServiceImpl();
	private OthersControllerAdvice advice = new OthersControllerAdvice();

	// view layer로 연결하기 위한 컨트롤러
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		advice.addLprodList(req);
		advice.addBuyerList(req);

		String logicalViewName = "prod/prodForm";

		req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);

	}

	// form을 통해 전송된 데이터에 대한 처리를 위한 컨트롤러
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		advice.addLprodList(req);
		advice.addBuyerList(req);
		
		//1. 특수문자 디코딩 설정
		//2.18개의 파라미터를 받고, Command Object로 캡슐화
		ProdVO prod = new ProdVO();
		req.setAttribute("prod", prod);
		
		Map<String, String[]> paramMap = req.getParameterMap();
		
		PopulateUtils.populate(prod, paramMap);
		
		// 2-1. 검증 작업 : 통과, 불통
		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		
		boolean valid = ValidateUtils.validate(prod, errors, InsertGroup.class);
		
		String logicalViewName = null;
		String message = null;
		
		if(valid) {
			// 3. 가입 로직 호출
			ServiceResult result = service.createProd(prod);
			switch (result) {
			// 4. 로직 실행 결과에 따른 뷰 선택
			case OK:
				logicalViewName = "redirect:/prod/prodView.do?what="+prod.getProdId();
				break;
			case FAIL:
				logicalViewName = "prod/prodForm";
				break;
			default:
				logicalViewName = "prod/prodForm";
				message = "상품 코드 중복";
				break;
			}
			req.setAttribute("message", message);
		} else {
			logicalViewName = "prod/prodForm";
		}
		
		if (logicalViewName.startsWith("redirect:")) {
			String redirectViewPath = req.getContextPath() + logicalViewName.substring("redirect:".length());
			resp.sendRedirect(redirectViewPath);
		} else {
			req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);
		}
	}
}
