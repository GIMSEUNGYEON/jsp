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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
@WebServlet("*.c41")
public class C41Servlet extends HttpServlet {
	
	private ServletContext application;
	
	@Override
	public void init() throws ServletException {
		application = getServletContext();		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		
		try {			
			String templateSource = readTemplate(req);
			StringBuffer html = new StringBuffer();
			html.append(mergeDataAndTemplate(req, templateSource));
			try (
				PrintWriter out = resp.getWriter();				
			){			
				out.print(html);
			}
		}catch (FileNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
		}
	
	}

	private String mergeDataAndTemplate(HttpServletRequest req, String templateSource) {
		//컬렉션 뷰
		Enumeration<String> names = req.getAttributeNames();
		while (names.hasMoreElements()) {
			String key = (String) names.nextElement();
			templateSource = templateSource.replace("#"+key+"#", req.getAttribute(key).toString());
			
		}
		
		return templateSource;
	}

	private String readTemplate(HttpServletRequest req) throws IOException, FileNotFoundException, ServletException {
		// *.c41
		// /WebStudy01/01/sample.c41
		String tmplUrl = req.getRequestURI();
		
		System.out.printf("servlet path : %s\n", req.getServletPath());
		System.out.printf("request URI : %s\n", req.getRequestURI());
		
		String contextPath = getServletContext().getContextPath();
		
//		String regex = contextPath + "[a-zA-Z0-9]+" + "\\.c41";
		String regex = contextPath + "([\\w_/]+)" + "\\.c41";
		//*  0글자 이상
		//+  1글자 이상
		// \\w : 영문자와 숫자를 포함하여 한글자
		// \\d : 숫자 한글자
		
		Pattern regexp = Pattern.compile(regex); 
		//regex의 패턴을 컴파일
		Matcher matcher = regexp.matcher(tmplUrl);
		//컴파일된 패턴을 url과 일치하는지 매치 검사
		if(matcher.find()) { // 매치하는지 여부 boolean 리턴
			String filePathPart = matcher.group(1);
			//일치할 경우 스트링타입에 저장 (그룹이 여러개일 경우 각 그룹에 인덱스가 부여되므로 group(1)을 명시
			//인덱스 0번은 regex 작성한 전체 내용이 해당됨, 인덱스 1번이 그룹으로 생성한 () 안의 내용
			tmplUrl = filePathPart+ ".c41";
			//d:/~~~~/01/imageForm.c41
			String tmplFSPath = getServletContext().getRealPath(tmplUrl);
			
			File templateFile = new File(tmplFSPath);
			
			//확장자가 .c41이 맞으나 존재하지 않는 파일이 입력되었을경우
			if(!templateFile.exists()) {
				throw new FileNotFoundException(String.format("%s 파일을 찾을 수 없음!!!!!", tmplUrl));
				// throw : 일부러 예외를 발생시킴
			}
			
			try(
				FileReader reader = new FileReader(templateFile);			
				BufferedReader br = new BufferedReader(reader);
			){
				String tmp = null;
				StringBuffer template = new StringBuffer();
				while((tmp = br.readLine()) != null) {
					template.append("\n");
					template.append(tmp);
				}
				
				return template.toString();	
			} //try end
		} else {
			throw new ServletException("정규식을 파싱해서 c41 파일의 위치를 찾는 과정에서 예외 발생");
		} // if(matcher.find()) end
	}
}
