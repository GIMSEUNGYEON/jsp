package kr.or.ddit.property.servlet09;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import kr.or.ddit.property.service.PropertyService;
import kr.or.ddit.property.service.PropertyServiceImpl;
import kr.or.ddit.vo.PropertyVO;
/**
 * 요청의 목적 : 서버사이드의 자원을 대상으로 어떤 행위를 수행하기 위함.
 * 자원의 식별(명사) : URI 
 * 어떤 행위(동사) : request method
 * RESTful URI 구조 표현 명사와 동사를 분리하는 구조
 * /09/property GET : 전체 조회
 * /09/property/propertyName GET : 한건 조회
 * /09/property POST : 등록
 * /09/property/propertyName PUT : 한건 수정
 * /09/property/propertyName DELETE : 한건 삭제
 * /09/property DELETE : 전체 삭제
 */
@WebServlet({"/09/property", "/09/property/*"})
public class PropertiesControllerServlet extends HttpServlet {
	
	private PropertyService service = new PropertyServiceImpl();
	
	private int list(HttpServletRequest req) {
		Set<String> keySet = service.retrieveKeySet();
		//restful url
		// /property get post put delete
		//rest : resource verb representation
		// uri를 통해자원을 표시하고, http method를 통해 자원의 행위를 규정하여 결과를 받는것.
		req.setAttribute("keySet", keySet);
		
		return 200;
	}
	
	private int single(String propertyName, HttpServletRequest req) {
		
		PropertyVO property = service.retrieveProperty(propertyName);
		
		int status = 200;
		if(property==null) {
			status = 404;
		}else {
			req.setAttribute("property", property);
		}
		
		return status;
	}
	
	private String getPropertyName(HttpServletRequest req) throws UnsupportedEncodingException {
		
		String propertyName = null;
		String requestURI = req.getRequestURI(); //ex) /WebStudy01/09/property, /WebStudy01/09/property/code
		
		String reqex = "\\S*/09/property/(\\S+)";
		// \s : 공백 한칸
		// \S : 공백이 아닌 문자 한칸
		// \S+ : 공백이 아닌 문자 하나 이상
		// \S* : 공백일수도 있고 여러공백일수도 있고 안들어올수도 있고

		Pattern ptrn = Pattern.compile(reqex);
		Matcher matcher = ptrn.matcher(requestURI);
		
		if(matcher.find()) {
		
			propertyName = URLDecoder.decode(matcher.group(1), "utf-8");
		}
		
		return propertyName;
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String propertyName = getPropertyName(req);
		
		int status;
		
		if(propertyName != null) {
			status = single(propertyName,req);			
		}else {
			status = list(req);			
		}
		
		if(status == 200) {
			String view = "/jsonView.do";
			req.getRequestDispatcher(view).forward(req,resp);						
		} else {
			resp.sendError(status);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(
			InputStream is = req.getInputStream();
		){
			PropertyVO newProp = new ObjectMapper().readValue(is, PropertyVO.class);
			boolean success = service.createProperty(newProp);
			
			if(success) {
				resp.sendRedirect(req.getContextPath() + "/09/property");
			}else {
				
			}
		}	
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(
			InputStream is = req.getInputStream();
		){
			PropertyVO modifyProp = new ObjectMapper()
										.registerModule(new JavaTimeModule())
										.readValue(is, PropertyVO.class);
			boolean success = service.updateProperty(modifyProp);
			req.setAttribute("success", success);
			String view = "/jsonView.do";
			req.getRequestDispatcher(view).forward(req,resp);
		}	
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String propertyName = getPropertyName(req);
		
		if(propertyName != null) {
			boolean success = service.deleteProperty(propertyName);
			
			String view = "/jsonView.do";
			req.setAttribute("success", success);
			req.getRequestDispatcher(view).forward(req,resp);
		}else {
			resp.sendError(400);
		}
	}
}
