package kr.or.ddit.servlet08;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import kr.or.ddit.enumpkg.MediaType;
@WebServlet("/08/serverTime.do")
public class ServerTimeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setIntHeader("Refresh", 1); // 비동기요청에서는 의미 없음
//		resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
		
		ZonedDateTime model = ZonedDateTime.now();
		
		Locale locale = req.getLocale();
		
		req.setAttribute("now", model);
		String veiw = "/jsonView.do"; //context path 없음 server side 경로
		req.getRequestDispatcher(veiw).forward(req, resp);
		
//		String content = model.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(locale));
//		 ObjectMapper objectMapper = new ObjectMapper()
//				 						.registerModule(new JavaTimeModule())
//				 						.disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS)
//				 						.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//				 						//빌더패턴(원 객체가 반환값으로 돌아옴)
//		try(
//			PrintWriter out = resp.getWriter();
//		){
//			objectMapper.writeValue(out, model);
//		}
	}
}
