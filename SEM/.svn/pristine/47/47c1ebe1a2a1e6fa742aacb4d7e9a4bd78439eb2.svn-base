package kr.or.ddit.mbti.servlet.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mbti/ajax/singleView.do")
public class MbtiUIControllerServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("contentPage", "/WEB-INF/views/mbti/singleView.jsp");
		
		String view = "/WEB-INF/views/layout.jsp";
		req.getRequestDispatcher(view).forward(req, resp);
	}
	
}
