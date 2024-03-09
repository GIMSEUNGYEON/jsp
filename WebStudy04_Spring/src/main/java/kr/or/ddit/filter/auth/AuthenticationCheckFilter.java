package kr.or.ddit.filter.auth;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 보호 자원에 대한 요청을 확인하고, 해당 요청의 인증 여부를 결정하기 위한 필터
 * 인증 여 : 인증된 요청을 해당 자원으로 제어권을 이동시킴.
 * 인증 부 : 인증이 안된 요청인 경우, loginForm으로 제어권을 이동시킴.
 * 요청에 대한 인증(로그인 여/부)
 */
@Slf4j
public class AuthenticationCheckFilter implements Filter {
	
	private Map<String, String[]> securedResources;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String securedResourcesPath = "/kr/or/ddit/auth/SecuredResources.properties";
		Properties resourcesProps = new Properties();
		securedResources = new LinkedHashMap<>();
		try(
			InputStream is = this.getClass().getResourceAsStream(securedResourcesPath);
		){
			resourcesProps.load(is);
			resourcesProps.forEach((k, v)->{
				String url = k.toString().trim();
				String [] tmpArray = v.toString().trim().split("\\s*,\\s*");
				Arrays.sort(tmpArray);
				securedResources.put(url, tmpArray);
				log.info("보호자원 로딩 - {} : {}", url, tmpArray);
			});
			filterConfig.getServletContext().setAttribute("securedResources", securedResources);
		} catch (IOException e) {
			throw new ServletException(e);
		}		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String uri = req.getRequestURI().substring(req.getContextPath().length());
		
		boolean pass = false;
		boolean secured = securedResources.containsKey(uri);
		
		// 1. 보호자원의 요청 여부
		if(secured) {
//			여 : 
//	 		2. 인증 여부
//			boolean authenticated = req.getSession().getAttribute("authMember") != null;
			boolean authenticated = req.getUserPrincipal()!= null;
			if(authenticated) {
//	 			여 : 통과
				pass = true;
			}else {
//	 			부 : 접근 통제
				pass = false;
			}
			
			
		}else {
//			부(비보호자원에 대한 요청) : 통과
			pass = true;
		}
		
		if(pass){
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login/loginForm.jsp");
		}
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
