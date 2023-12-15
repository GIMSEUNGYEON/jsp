package kr.or.ddit.servlet01;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 클라이언트가 /now.do 라는 요청을 보냈을 때,
 * 현재 서버의 시각을 <h4> 태그로 보여주는 컨텐츠를 구성할 것.
 */
@WebServlet("/now_case1.do")
public class NowServlet_Case1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String html = "<html>";
		html += "<body>";
		html += "<h4>server time : "+ new Date() +"</h4>";
		html += "</body>";
		html += "</html>";
		resp.getWriter().println(html);
		
		resp.setContentType("text/html");
		resp.getWriter().println("<h4>" + new Date() + "</h4>");
		// html 태그를 직접 문자열에 포함시키거나 setContentType을 이용하여 html 태그를 생략하여 사용할 수 있음
	}
}
