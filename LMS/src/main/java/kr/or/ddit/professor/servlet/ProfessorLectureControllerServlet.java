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

@WebServlet("/professor/lecture")
public class ProfessorLectureControllerServlet extends HttpServlet {
	
	ProfessorService service = new ProfessorServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subCd = req.getParameter("subCd");
		List<Map<String, Object>> stuList = service.retrieveStudentList(subCd);
		
		req.setAttribute("stuList", stuList);
		
		String logicalViewName = "professor/lecture";
		
		req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);

	}
}
