package kr.or.ddit.mbti.servlet.ajax;

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

@WebServlet("/mbti/ajax/mbtiList.do")
public class MbtiDataListControllerServlet extends HttpServlet{
	private MbtiService service = new MbtiServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MbtiDescVO> mbtiList = service.retrieveMbtiList();
		
		req.setAttribute("mbtiList", mbtiList);
		
		String view = "/jsonView.do";
		req.getRequestDispatcher(view).forward(req, resp);
	}
	
}











