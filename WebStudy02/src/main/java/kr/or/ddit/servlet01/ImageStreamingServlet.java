package kr.or.ddit.servlet01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/image.do", loadOnStartup = 1, initParams = {@WebInitParam(name = "imageFolderPath", value = "D:/01.medias/img")})
public class ImageStreamingServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String imageFolderPath = getServletConfig().getInitParameter("imageFolderPath");
//		String imageFolderPath = "D:/01.medias/img";
		File imageFolder = new File(imageFolderPath);
		
		String imageName = req.getParameter("image");
		
		if(imageName == null || imageName.trim().isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "필수 파라미터 누락");
			return;
		}
		File imageFile = new File(imageFolder, imageName);
		
		if(!imageFile.exists()) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "그런 이미지 없음");
			return;			
		}
		
		ServletContext application = getServletContext();
		
		String mime = application.getMimeType(imageName);
		
		resp.setContentType(mime);
		resp.setContentLengthLong(imageFile.length());
		
//		FileInputStream fis = null;
//		FileOutputStream fos = null;
//		
//		try {	
//			fis = new FileInputStream(imageFile);	
//			fos = new FileOutputStream(imageFile);
//		}finally {
//			if(fis != null) {				
//				fis.close();
//				fos.close();
//			}
//		}
		//일반적인 try catch finally
//		try {} catch(e) {} finally {}
		
		//자바 7 이후 사용
//		try with resource 구문의 형태
		
//		try (closable 객체 생성 구문) {} catch(e) {}
		//finally 생략 가능 close 생략 가능
		
		try(
			FileInputStream fis = new FileInputStream(imageFile);
			OutputStream os = resp.getOutputStream();
		){
			int buffer = -1;
			while((buffer = fis.read()) != -1) { //EOF(End Of File)(-1 혹은 null) 문자 이전까지 반복
				os.write(buffer);
			}
			os.flush();
		}
	}
}
