package kr.or.ddit.servlet04;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Model2 아키텍처
 *  : SRP(단일 책임의 원칙)에 따라 request에 대한 처리자와 response 처리자를 분리하는 구조
 *  
 *  MVC(Model View Controler) : 하나의 어플리케이션을 구조화할 때 역할별로 3개 이상의 레이어를 분리하는 구조.
 *  
 *  request(Model + Controler) / response(View)
 *
 */
@WebServlet("/case2/factorial.do")
public class FactorialServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int status = 200;
		String message = null;
		String param = request.getParameter("operand");
			
		if(param == null || param.trim().isEmpty() || !param.matches("\\d{1,3}")){
			status = HttpServletResponse.SC_BAD_REQUEST;
			message = "필수 파라미터가 누락되었거나 파라미터의 데이터형이 잘못되었습니다.";
		}else {		
			int operand = Integer.parseInt(param);
	
			try{
				
			long answer = factorial(operand);
			String expression = MessageFormat.format("{0}! = {1}", operand, answer);
			request.setAttribute("expression", expression);
			} catch(IllegalArgumentException e){
				status = HttpServletResponse.SC_BAD_REQUEST;
				message = e.getMessage();
			}
			
			if(status == 200) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/03/factorial.jsp");
				dispatcher.forward(request, response);
				
			} else {
				response.sendError(status, message);
			}
		}
	}

	
	long factorial(int operand) {
		if(operand < 1){
			throw new IllegalArgumentException("팩토리얼 연산은 양수만 처리 가능");
		}
		if(operand==1){
			return 1;		
		}else{
			return operand*factorial(operand-1);
		}
		
	}

}
