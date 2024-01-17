package kr.or.ddit.professor.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.professor.service.ProfessorService;
import kr.or.ddit.professor.service.ProfessorServiceImpl;

@WebServlet("/professor/profMyPage.do")
public class ProfessorMyPageControllerServlet extends HttpServlet {
	
	ProfessorService service = new ProfessorServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String proNo = "22A10";
		List<Map<String, Object>> lectureList = service.retrieveLectureList(proNo);
		
		req.setAttribute("lectureList", lectureList);
		
		String logicalViewName = "professor/lectureList";
		
		req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);
	}
}
