package kr.or.ddit.bts.servlet10;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bts.service.BtsService;
import kr.or.ddit.bts.service.BtsServiceImpl;

@WebServlet("/10/btsForm.do")
public class BtsFormControllerServlet extends HttpServlet {
	
	private BtsService service = new BtsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String, String> btsModel = service.retrieveEntryMap();
		
		req.setAttribute("btsModel", btsModel);
		req.setAttribute("contentPage","/WEB-INF/views/btsForm.jsp");
		
		String view = "/WEB-INF/views/layout.jsp";
		req.getRequestDispatcher(view).forward(req, resp);
	}
}
