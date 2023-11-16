package kr.or.ddit.servlet01;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/case1/imageForm.do", initParams = {@WebInitParam(name = "imageFolderPath", value = "D:/01.medias/img")})
public class ImageFormServlet_Case1 extends HttpServlet {
	
	private ServletContext application;
	
	@Override
	public void init() throws ServletException {
		application = getServletContext();		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer html = new StringBuffer();
		
		html.append("\n<html>");
		html.append("\n<head>");
		html.append("\n<meta charset='UTF-8'>");
		html.append("\n<title>Insert title here</title>");
		html.append("\n<script type='text/javascript'>");
		html.append("\n</script>");
		html.append("\n</head>");
		html.append("\n<body>");
		html.append(String.format("\n<form action='%s/image.do'>", req.getContextPath()));
		html.append("\n<select name='image'>");
		
		String imageFolderPath = getServletConfig().getInitParameter("imageFolderPath");
		File imageFolder = new File(imageFolderPath);
//		File[] files = imageFolder.listFiles();
			
		File[] files = imageFolder.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				String mime = application.getMimeType(name);
				
				return mime!=null && mime.startsWith("image/");
			}
		});
		
		for(File f : files) {
			html.append(String.format("\n<option values='%1$s'>%1$s</option>", f.getName()));
		}
		
		html.append("\n</select>");
		html.append("\n<input type='submit' value='이미지내놔'/>");
		html.append("\n</form>");
		html.append("\n</body>");
		html.append("\n</html>");
		
		resp.setContentType("text/html;charset=UTF-8");
		
		try (
			PrintWriter out = resp.getWriter();				
		){			
			out.print(html);
		}
	}
}
