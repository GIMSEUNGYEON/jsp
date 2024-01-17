package kr.or.ddit.filter.auth;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.principal.MemberVOWrapper;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
 
/**
 * 보호자원에 대한 요청을 확인하고, 인가 여부를 결정하는 필터
 * 인가 여 : 해당 자원에 대한 접근 권한을 부여받은 사용자이므로, 해당 자원으로 제어권 이동.
 * 인가 부 : 해당 자원에 대한 접근 권한이 없는 사용자이므로, 403 상태코드로 응답 전송
 * 클라이언트에 대한 인증(로그인한 사용자의 권한 여/부)
 */
public class AuthorizationCheckFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Map<String, String[]> securedResources = 
				(Map<String, String[]>) request.getServletContext().getAttribute("securedResources");
		
		String uri = req.getRequestURI().substring(req.getContextPath().length());
		
		boolean pass = false;
		
		boolean secured = securedResources.containsKey(uri);

		if(secured) {
			MemberVOWrapper wrapper = (MemberVOWrapper) req.getUserPrincipal();
			MemberVO authMemver = wrapper.getRealUser();
			String userRole = authMemver.getMemRole();
			String [] authorities = securedResources.get(uri);
			int idx = Arrays.binarySearch(authorities, userRole);
			
			pass = idx < 0 ? false : true; 
//			pass = idx >= 0 ? true : false; 
		
		} else {
			pass = true;
		}
		
		if(pass) {
			chain.doFilter(request, response);
		}else {
			resp.sendError(HttpServletResponse.SC_FORBIDDEN, "권한이 없는 사용자입니다.");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
