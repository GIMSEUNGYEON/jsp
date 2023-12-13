package kr.or.ddit.bts.servlet10;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bts.exception.BtsNotFoundException;
import kr.or.ddit.bts.service.BtsService;
import kr.or.ddit.bts.service.BtsServiceImpl;
import kr.or.ddit.vo.BtsVO;

@WebServlet("/10/bts")
public class BtsControllerServlet extends HttpServlet{
	private BtsService service = new BtsServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accept = req.getHeader("accept");
		
		String name = req.getParameter("name");
		if(name==null || name.isEmpty()) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		}
		
		try {
			BtsVO model = service.retrieveBts(name);
			
			req.setAttribute("contentPage", model.getLogicalPath());
			String view = "/WEB-INF/views/layout.jsp";
			req.getRequestDispatcher(view).forward(req, resp);
		}catch(BtsNotFoundException e) {
			resp.sendError(404, e.getMessage());
			return;
		}
		
	}
}

