package kr.or.ddit.servlet09;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.servlet08.ServerTimeServlet;
/**
 * RESTful URI 구조 표현
 * /09/property GET : 전체 조회
 * /09/property/propertyName GET : 한건 조회
 * /09/property POST : 등록
 * /09/property/propertyName PUT : 한건 수정
 * /09/property/propertyName DELETE : 한건 삭제
 * /09/property DELETE : 전체 삭제
 * 
 */
@WebServlet({"/09/property", "/09/property/*"})
public class PropertiesControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//restful url
		// /property get post put delete
		//rest : resource verb representation
		// uri를 통해자원을 표시하고, http method를 통해 자원의 행위를 규정하여 결과를 받는것.
		String logicalPath = "/kr/or/ddit/message/message-common.properties";
		URL realPath = ServerTimeServlet.class.getResource(logicalPath);
		try {
			File file = new File(realPath.toURI());
			Properties properties = new Properties();
			try(
				FileInputStream fis = new FileInputStream(file);
			){
				properties.load(fis);
				Set<Object> keySet = properties.keySet();
				req.setAttribute("keySet", keySet);
				String view = "/jsonView.do";
				req.getRequestDispatcher(view).forward(req,resp);			
			}
		} catch (URISyntaxException e) {
			throw new IOException(e);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
