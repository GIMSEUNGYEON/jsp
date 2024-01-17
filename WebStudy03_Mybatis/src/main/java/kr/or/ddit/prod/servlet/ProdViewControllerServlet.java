package kr.or.ddit.prod.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodView.do")
public class ProdViewControllerServlet extends HttpServlet {

	private ProdService service = new ProdServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String prodId = null;

		Enumeration<String> paramNames = req.getParameterNames();

		if (!paramNames.hasMoreElements()) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		} else {
			prodId = req.getParameter((String) paramNames.nextElement());
		}

		ProdVO prod = service.retrieveProd(prodId);

		req.setAttribute("prod", prod);

		String logicalViewName = "prod/prodView";

		req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);

	}
}
