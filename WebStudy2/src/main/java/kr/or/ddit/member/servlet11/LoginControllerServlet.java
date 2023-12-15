package kr.or.ddit.member.servlet11;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.member.service.AuthenticateService;
import kr.or.ddit.member.service.AuthenticateServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/login/loginProcess.do")
public class LoginControllerServlet extends HttpServlet {
	private AuthenticateService service = new AuthenticateServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		
		MemberVO inputData = new MemberVO();
		inputData.setMemId(memId);
		inputData.setMemPass(memPass);

		boolean valid = validate(inputData);
		
		String logicalViewName = null;
		String message = null;
		HttpSession session = req.getSession(); // 연관된 세션이 없으면 새로운 세션을 자동으로 생성함, false 값을 주는것으로 생성을 막을 수 있음
		if(valid) {
			if(service.authenticate(inputData)) {
				if(session.isNew()) {
					message = "브라우저의 설정 오류, 쿠키 정보를 확인하세요";
					logicalViewName = "/login/loginForm.jsp";					
				}else {
					logicalViewName = "/";
					session.setAttribute("authId", inputData.getMemId());		
					int maxAge = Optional.ofNullable(req.getParameter("rememberMe"))
										.map(rv->60*60*24*3)
										.orElse(0);
					
					Cookie rememberMeCookie = new Cookie("rememberMe", inputData.getMemId());
					rememberMeCookie.setMaxAge(maxAge);
					rememberMeCookie.setPath(req.getContextPath());
					resp.addCookie(rememberMeCookie);
				}
			}else {
				message = "아이디나 비밀번호 오류";
				logicalViewName = "/login/loginForm.jsp";
			}
		}else {
//			resp.sendError(400);
			message = "아이디나 비밀번호 누락";
			logicalViewName = "/login/loginForm.jsp";
		}
		session.setAttribute("message", message);
		resp.sendRedirect(req.getContextPath() + logicalViewName);
	}
	
	public boolean validate(MemberVO inputData) {
		boolean valid = true;
		if(StringUtils.isBlank(inputData.getMemId())) {
			valid = false;
		}
		if(StringUtils.isBlank(inputData.getMemPass())) {
			valid = false;
		}
		return valid;
	}
}
