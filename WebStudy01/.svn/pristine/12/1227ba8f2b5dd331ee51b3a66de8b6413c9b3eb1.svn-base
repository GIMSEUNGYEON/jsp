package kr.or.ddit.servlet02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
@WebServlet("/case3/imageForm.do")
//, initParams = {@WebInitParam(name = "imageFolderPath", value = "D:/01.medias/img")})
public class ImageFormServlet_Case3 extends HttpServlet {
	
	private ServletContext application;
	
	@Override
	public void init() throws ServletException {
		application = getServletContext();		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String imageFolderPath = application.getInitParameter("imageFolderPath");
		
		File imageFolder = new File(imageFolderPath);
			
		File[] files = imageFolder.listFiles((d,n)->
			Optional.ofNullable(application.getMimeType(n))
				    .filter(m->m.startsWith("image/"))
				    .isPresent()
		);
		
		String cPath = req.getContextPath();
		
		String options = (Stream.of(files)
			  .map(f->String.format("<option values='%1$s'>%1$s</option>", f.getName()))
			  .collect(Collectors.joining("\n")));
		
		req.setAttribute("cPath", cPath);
		req.setAttribute("options", options);
		
		resp.setContentType("text/html;charset=UTF-8");
		
		req.getRequestDispatcher("/01/imageForm_mine.c41").forward(req, resp);
	}
}
