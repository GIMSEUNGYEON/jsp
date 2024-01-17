package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * welcome Page를 로드하기 위한 서블릿.
 * @author PC-2
 *
 */
@WebServlet("/index.do")
public class IndexControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String logicalViewName = "index"; 
		
		req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);
	}
}
