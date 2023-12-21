package kr.or.ddit.mbti.servlet10;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.AbstractMap.SimpleEntry;

import kr.or.ddit.mbti.dao.InMemoryMbtiDAOImpl;
import kr.or.ddit.mbti.dao.MbtiDAO;
import kr.or.ddit.mbti.exception.MbtiNotFoundException;
import kr.or.ddit.mbti.service.MbtiService;
import kr.or.ddit.mbti.service.MbtiServiceImpl;
import kr.or.ddit.vo.MbtiVO;

@WebServlet("/10/mbti")
public class MbtiContorollerServlet extends HttpServlet {
	ServletContext application = null;
	
	private MbtiService service = new MbtiServiceImpl();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		
	}
	private void listToJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Set<Entry<String, String>> entrySet = service.retrieveEntrySet();
		//16개의 각기 다른 맵을 하나의 set으로 합침
	
		req.setAttribute("entrySet", entrySet);
		
		Map<String, String> entryMap = service.retrieveEntryMap();
		// 16개의 레퍼런스를 가진 1개의 맵을 만들었음
		
		req.setAttribute("entryMap", entryMap);

		String view = "/jsonView.do";
		req.getRequestDispatcher(view).forward(req, resp);
	
	}
	private void singleToHTML(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		if(type == null || type.isEmpty()) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		}
		
		try {
			MbtiVO model = service.retrieveMbti(type);			
			int maxAge =Optional.of(req.getParameter("remember"))
								.map(rv->60*60*24*5)
								.orElse(0);
			
			Cookie remember = new Cookie("mbtiCookie", type);
			remember.setMaxAge(maxAge);
			remember.setPath(req.getContextPath());
			
			resp.addCookie(remember);
			resp.setHeader("Cache-Control", "no-cache");
			resp.setHeader("Cache-Control", "no-store");
			//캐시를 아예 저장하지 않기
			
			String view = model.getLogicalPath();
			req.getRequestDispatcher(view).forward(req, resp);
		}catch (MbtiNotFoundException e) {
			resp.sendError(404, e.getMessage());			
			return;
		}
		
	}
	// type 파라미터의 존재 여부에 따라 전체 MBTI 조회와 한개의 유형 조회로 구분됨.
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
