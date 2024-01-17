package kr.or.ddit.bts;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mbti.exception.MbtiNotFoundException;
import kr.or.ddit.vo.MbtiVO;

@WebServlet("/bts")
public class BtsControllerServlet extends HttpServlet {
	
	private BtsService service = new BtsServiceImpl();

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	private void listToJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String, String> entryMap = service.retrieveEntryMap();
		
		req.setAttribute("entryMap", entryMap);

		String view = "/jsonView.do";
		req.getRequestDispatcher(view).forward(req, resp);
	
	}
	private void singleToHTML(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		if(name == null || name.isEmpty()) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		}
		
		try {
			BtsVO model = service.retrieveBts(name);			
			String view = model.getLogicalPath();
			req.getRequestDispatcher(view).forward(req, resp);
		}catch (NullPointerException e) {
			resp.sendError(404, e.getMessage());			
			return;
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accept = req.getHeader("accept");
		
		if(accept.contains("json")) {
			listToJson(req, resp);
		}else {
			singleToHTML(req, resp);			
		}
	}
}
