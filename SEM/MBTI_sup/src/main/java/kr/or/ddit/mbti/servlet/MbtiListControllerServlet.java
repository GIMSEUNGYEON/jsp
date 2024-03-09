package kr.or.ddit.mbti.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mbti.service.MbtiService;
import kr.or.ddit.mbti.service.MbtiServiceImpl;
import kr.or.ddit.vo.MbtiDescVO;

@WebServlet("/mbti/sync/mbtiList.do")
public class MbtiListControllerServlet extends HttpServlet{
	private MbtiService service = new MbtiServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MbtiDescVO> list = service.retrieveMbtiList();
		
		// Request Scope, Session Scope
		req.setAttribute("mbtiList", list);
		
		req.setAttribute("contentPage", "/WEB-INF/views/mbti/mbtiList.jsp");
		
		String view = "/WEB-INF/views/layout.jsp";
		req.getRequestDispatcher(view).forward(req, resp);
	}
}


















