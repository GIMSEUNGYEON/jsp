package calcServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enumPck.MimeType;
import enumPck.Operator;


@WebServlet("/calculate.do")
public class calcServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int status = 200;
		String message = null;
//		String accept = req.getHeader("dataType");
		String operator = req.getParameter("operator");		
		System.out.println("oper : " + operator);
		String param1 = req.getParameter("leftOp");
		String param2 = req.getParameter("rightOp");
		
		int oper1 = 0, oper2 = 0;
		
		if(param1 == null || param1.trim().isEmpty() || !param1.matches("\\d{1,3}")
				|| param2 == null || param2.trim().isEmpty() || !param2.matches("\\d{1,3}")){
			status = HttpServletResponse.SC_BAD_REQUEST;
			message = "필수 파라미터가 누락되었거나 파라미터의 데이터형이 잘못되었습니다.";
		}else {		
			oper1 = Integer.parseInt(param1);
			oper2 = Integer.parseInt(param2);
			System.out.println("o1 : " + oper1);
			System.out.println("o2 : " + oper2);
		}

		int answer = Operator.calculate(operator, oper1, oper2);
		
		String OperName = Operator.findOperName(operator);

		String dataType = req.getParameter("dataType");
		String typeName = MimeType.findMimeType(dataType);
		System.out.println(typeName);
		
		String expression = String.format("%d %s %d = %d", oper1, OperName, oper2, answer);
		System.out.println("answer : " + answer);
		if(status == 200) {
//			req.setAttribute("answer", answer);
			String jsonResp = String.format("{\"expression\":\"%s\", \"typeName\":\"%s\"}", expression, typeName);
			resp.setContentType(typeName);
			PrintWriter out = resp.getWriter();
			out.print(jsonResp);
//			String mime = req.getParameter("dataType");
//			req.setAttribute("mime", MimeType.findTypeName(mime));
//			RequestDispatcher dispatcher = req.getRequestDispatcher("/02/calculateForm.jsp");
//			dispatcher.forward(req, resp);
		}
	}
}
