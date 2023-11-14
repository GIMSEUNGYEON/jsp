package kr.or.ddit.servlet01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/imageForm.do")
public class ImageFormServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer html = new StringBuffer();
		
		html.append("<html>");
		<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			
		</script>
		</head>
		<body>
		<form action="../image.do">
			<select name="image">
				<option>hamster.jpg</option>
				<option>lion.jpg</option>
			</select>
			<input type="submit" value="이미지내놔"/>
		</form>
		</body>
		</html>
	}
}
