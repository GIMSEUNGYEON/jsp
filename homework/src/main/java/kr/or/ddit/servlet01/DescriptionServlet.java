package kr.or.ddit.servlet01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿 스펙
 * : 웹상에서 발생하는 요청을 받고, 그에 대한 동적인 응답을 생성할 수 있는 객체의 요건. --> HttpServlet.
 * 
 * 개발 단계
 * 1. HttpServlet 상속 클래스 구현
 * 2. do~ callback 메소드 재정의
 * 	  서블릿의 callback 메소드 종류
 * 	  1) lifecycle callback(객체가 생성될때 호출 init/소멸될때 호출 destroy)
 *       컨테이너가 기본적으로 싱글턴으로 객체를 관리하기 때문에 어플리케이션 내에서 한번만 실행됨.
 *       init : 특별한 설정(loadOnStartup)이 없는 한 최초의 요청이 발생하면 실행됨.
 *    2) request callback : service, do~ 계열
 *    	 service : 컨테이너에 의해 직접 호출되는 callback
 *    	 do~ : service 메소드 내에서 현재 요청의 method를 판단한 후 실행되는 분기 메소드
 * 3. 서블릿 등록. web.xml : servlet -> servlet-name(simple name), servlet-class(qualified name) 
 * 4. 서블릿 매핑. web.xml : servlet-mapping -> servlet-name, url-pattern
 * 5. 서버 재구동(서버는 실행될 때 한번 web.xml파일을 스캔하기 때문)
 */
public class DescriptionServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String value = config.getInitParameter("dummy");
		System.out.printf("초기화된 서블릿 : %s, param value : %s\n", this.getClass().getName(), value);
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=====================================");
		System.out.println("super.service 이전 코드");
//		super.service(req, resp);
//		callback 호출 주체	
		System.out.println("super.service 이후 코드");
		System.out.println("=====================================");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget 메서드 실행");
		resp.getWriter().println("desc servlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.printf("소멸된 서블릿 : %s", this.getClass().getName());
	}
	
}