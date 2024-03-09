package kr.or.ddit.mbti.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.mbti.service.MbtiService;
import kr.or.ddit.mbti.service.MbtiServiceImpl;
import kr.or.ddit.vo.MbtiDescVO;

@WebServlet("/mbti/sync/mbtiInsert.do")
public class MbtiInsertControllerServlet extends HttpServlet{
	private MbtiService service = new MbtiServiceImpl();
	
	// 등록 UI - form 제공
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("contentPage", "/WEB-INF/views/mbti/mbtiForm.jsp");
		String view = "/WEB-INF/views/layout.jsp";
		req.getRequestDispatcher(view).forward(req, resp);
	}
	
	// form 을 통해 submit 된 데이터(파라미터-*, json 페이로드) 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		MbtiDescVO commandObject = new MbtiDescVO();
		req.setAttribute("mbti", commandObject);
		commandObject.setMtType( req.getParameter("mtType") );
		commandObject.setMtTitle( req.getParameter("mtTitle") );
		commandObject.setMtContent( req.getParameter("mtContent") );
		
		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = validate(commandObject, errors);
		String logicaViewName = null;
		if(valid) {
			service.createMBTI(commandObject);
//			Post-Redirect-Get : 갱신된 자원에 대해 새로운 요청이 발생하도록 유도함.
			logicaViewName = "redirect:/mbti/sync/mbtiList.do";
		}else {
			logicaViewName = "mbti/mbtiForm";
		}
		
		if(logicaViewName.startsWith("redirect:")) {
			String redirectPath = req.getContextPath() + logicaViewName.substring("redirect:".length());
			resp.sendRedirect(redirectPath);
		}else {
			req.setAttribute("contentPage", "/WEB-INF/views/"+logicaViewName+".jsp");
			String view = "/WEB-INF/views/layout.jsp";
			req.getRequestDispatcher(view).forward(req, resp);
		}
		
	}

	private boolean validate(MbtiDescVO commandObject, Map<String, String> errors) {
		boolean valid = true;
		if(StringUtils.isBlank(commandObject.getMtType())) {
			valid = false;
			errors.put("mtType", "유형 코드 누락");
		}
		if(StringUtils.isBlank(commandObject.getMtTitle())) {
			valid = false;
			errors.put("mtTitle", "유형 타이틀 누락");
		}
		if(StringUtils.isBlank(commandObject.getMtContent())) {
			valid = false;
			errors.put("mtContent", "유형 내용 누락");
		}
		return valid;
	}
}




















