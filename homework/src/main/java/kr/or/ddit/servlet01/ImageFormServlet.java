package kr.or.ddit.servlet01;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value = "/imageForm.do", initParams = {@WebInitParam(name = "imageFolderPath", value = "D:/01.medias/img")})
public class ImageFormServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer html = new StringBuffer();
		
		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset='UTF-8'>");
		html.append("<title>Insert title here</title>");
		html.append("<script type='text/javascript'>");
		html.append("</script>");
		html.append("</head>");
		html.append("<body>");
		html.append("<form action='./image.do'>");
		html.append("<select name='image'>");
		
		String imageFolderPath = getServletConfig().getInitParameter("imageFolderPath");
		File imageFolder = new File(imageFolderPath);
		File[] files = imageFolder.listFiles();
		
		for(File f : files) {
			html.append(String.format("<option>%s</option>", f.getName()));
		}
		
		html.append("<option>hamster.jpg</option>");
		html.append("<option>lion.jpg</option>");
		html.append("</select>");
		html.append("<input type='submit' value='이미지내놔'/>");
		html.append("</form>");
		html.append("</body>");
		html.append("</html>");
		
		resp.setContentType("text/html;charset=UTF-8");

		resp.getWriter().print(html);
		
	}
}
