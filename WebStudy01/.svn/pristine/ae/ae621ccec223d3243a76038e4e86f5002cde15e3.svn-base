package kr.or.ddit.servlet04;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/04/formProcess.do")
public class FormProcessServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("방법1");
		
		Map<String, String[]> params = req.getParameterMap();
		
		Iterator<String> it = params.keySet().iterator();
		
		while(it.hasNext()) {			
			String key = it.next();
			String [] values = params.get(key);
			for(int i = 0; i < values.length; i++) {
				System.out.printf("%s : %s \n", key, values[i]);
			}
		}
	
		System.out.println("\n=============================================");
		System.out.println("\n방법2");
		
		Enumeration<String> keyNames =  req.getParameterNames();
		
		while(keyNames.hasMoreElements()) {
			String keyName = keyNames.nextElement();
			String [] values2 = req.getParameterValues(keyName);
			for(String s : values2) {
				System.out.printf("%s : %s \n", keyName, s);
				
			}
		}
		System.out.println("\n=============================================");
		System.out.println("\n방법3");
		
		for(Entry<String, String[]> entry : params.entrySet()) {
			String paramName = entry.getKey();
			String [] paramValues = entry.getValue();
			
			System.out.printf("%s : %s \n", paramName, Arrays.toString(paramValues));
		}
		System.out.println("\n=============================================");
		System.out.println("\n방법4");
		
		params.forEach((k, v)->	System.out.printf("%s : %s \n", k, Arrays.toString(v)));

		System.out.println("\n=============================================");
		System.out.println("\n방법5");
		
		String textParam = req.getParameter("textParam");
		
		int numParam = Optional.ofNullable(req.getParameter("numParam"))
					.map(np->new Integer(np))
					.orElse(-1);
		
		System.out.printf("number param : %d\n", numParam);
		
		LocalDate dateParam = Optional.ofNullable(req.getParameter("dateParam"))
					.map(dp->LocalDate.parse(dp))
					.orElseThrow(()->new RuntimeException("data parameter 누락"));

		System.out.printf("date param : %s\n", dateParam);
				
		LocalDateTime dateTimeParam = Optional.ofNullable(req.getParameter("dateTimeParam"))
				.map(dtp->LocalDateTime.parse(dtp))
				.orElseGet(()->LocalDateTime.now());
		
		System.out.printf("date time param : %1$tY-%1$tM-%1$td %1$tH:%1$tm \n", dateTimeParam);
		
		String [] checkbox = req.getParameterValues("checkbox");
		
		
	}

}
