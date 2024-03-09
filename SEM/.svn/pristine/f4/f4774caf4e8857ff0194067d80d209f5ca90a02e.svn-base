package kr.or.ddit.mbti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.mbti.service.MbtiService;
import kr.or.ddit.mbti.service.MbtiServiceImpl;
import kr.or.ddit.vo.MbtiDescVO;

@WebServlet("/mbti/sync/mbtiView.do")
public class MbtiViewControllerServlet extends HttpServlet{
	private MbtiService service = new MbtiServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String mtType = req.getParameter("what");
		if(StringUtils.isBlank(mtType)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "필수 파라미터 누락");
			return;
		}
		try {
			MbtiDescVO mbti = service.retrieveMbti(mtType);
			
			req.setAttribute("mbti", mbti);
			
			req.setAttribute("contentPage", "/WEB-INF/views/mbti/mbtiView.jsp");
			String view = "/WEB-INF/views/layout.jsp";
			req.getRequestDispatcher(view).forward(req, resp);
		}catch (PKNotFoundException e) {
			resp.sendError(e.getStatus(), e.getMessage());
		}
	}
}












