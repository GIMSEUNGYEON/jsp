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
 * 
 * ** 서블릿 스펙에서 제공되는 객체의 종류
 * 1. HttpServletRequest  : client와 요청에 대한 정보를 캡슐화한 객체
 * 2. HttpServletResponse : server에서 client로 전송하는 응답에 대한 정보를 캡슐화한 객체
 * 							ex) response content, content metadata(response header)
 * 3. ServletConfig 	  : 하나의 서블릿에 대한 설정 정보를 캡슐화한 객체. 서블릿 하나당 하나씩 인스턴스가 존재함
 * 4. ServletContext	  : 현재 실행 중인 어플리케이션과 서버에 대한 정보를 캡슐화한 객체로, 어플리케이션 내에 하나의 인스턴스만 존재함. was(서버)에 대한 객체
 * 5. HttpSession 		  : 한 사람의 클라이언트 혹은 하나의 에이전트(브라우저)에 대한 고유 정보를 캡슐화한 객체. 
 * 							ex) 한 사람의 클라이언트일지라도 여러개의 브라우저를 사용하여 접속한다면 사용한 브라우저의 개수만큼 세션이 생성됨
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
