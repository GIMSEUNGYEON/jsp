package kr.or.ddit.property.servlet09;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.property.service.PropertyService;
import kr.or.ddit.property.service.PropertyServiceImpl;
import kr.or.ddit.vo.PropertyVO;

@WebServlet("/09/jdbcDesc.do")
public class JdbcDescControllerServlet extends HttpServlet {
	
	private PropertyService service = new PropertyServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<PropertyVO> propList = service.retrieveProperties();
		String contentPage = "/WEB-INF/views/12/jdbcDesc.jsp";
		
		req.setAttribute("propList", propList);
		req.setAttribute("contentPage", contentPage);
		String view = "/WEB-INF/views/layout.jsp";
		req.getRequestDispatcher(view).forward(req, resp);
		
	}
}
