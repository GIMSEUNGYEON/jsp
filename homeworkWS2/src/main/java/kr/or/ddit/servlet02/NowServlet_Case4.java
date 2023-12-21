package kr.or.ddit.servlet02;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 클라이언트의 요청이 처리되는 단계
 * 1. 요청을 접수
 * 2. 요청한 데이터 생성
 * 3. 데이터를 컨텐츠로 만들고, 응답으로 전송
 * Model1 아키텍처 : 1~3 단계가 하나의 서블릿이나 JSP에 의해 처리되는 구조. 책임이 분리되어있지 않음
 * Model2 아키텍처 : 1,2 단계를 담당하는 요청 처리 서블릿과 3단계 응답을 생성하는 서블릿이 분리된 형태
 */
@WebServlet("/now_case4.do")
public class NowServlet_Case4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("today", LocalDate.now());
		req.setAttribute("now", LocalDateTime.now());
		
		req.getRequestDispatcher("/01/nowView.c41").forward(req, resp);
	}
}
