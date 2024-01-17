package kr.or.ddit.member.servlet11;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 회원 가입 처리 
 * 1. 가입 양식 제공(get) 
 * 2. 양식을 통해 입력 및 전송된 데이터 처리(post)
 * 
 */
@Slf4j
@WebServlet("/member/memberInsert.do")
public class MemberInsertControllerServlet extends HttpServlet {

	private MemberService service = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String logicalViewName = "member/memberForm";

		req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 1. 특수문자 디코딩 설정 
		 * 2. 17개의 파라미터를 받고 -> Command Object로 캡슐화(MemberVO) 
		 * 2-1. 검증 작업 :통과, 불통 
		 * 3. 가입 로직 호출 
		 * 4. 로직의 실행결과에 따라 view 선택 
		 * 5. 해당 뷰로 이동
		 */
		req.setCharacterEncoding("UTF-8");
		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
//		member.setMemId(req.getParameter("memId"));
//		member.setMemPass(req.getParameter("memPass"));

		Map<String, String[]> parameterMap = req.getParameterMap();
		// 첫번째 파라미터 : 자바빈의 규약에 따라 만들어진 vo일것, map은 vo의 프로퍼티와 일치하는 키를 가질것

		try {
			PopulateUtils.populate(member, parameterMap);			
		}catch (Exception e) {
			
		}
	
		log.info("{}", member);
		//2-1. 검증
		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = validate(member, errors);

		String logicalViewName = null;
		String message = null;

		if (valid) {
			ServiceResult result = service.createMember(member);
			switch (result) {
			case OK:
				logicalViewName = "redirect:/"; // PostRedirectGet Pattern
				break;

			case FAIL:
				logicalViewName = "member/memberForm";
				break;

			default: // 아이디 중복
				logicalViewName = "member/memberForm";
				message = "아이디 중복입니다.";
				break;
			}

			req.setAttribute("message", message);

		} else {
			logicalViewName = "member/memberForm";
		}
		//5. 해당 뷰로 이동
		if (logicalViewName.startsWith("redirect:")) {
			String redirectViewPath = req.getContextPath() + logicalViewName.substring("redirect:".length());
			resp.sendRedirect(redirectViewPath);
		} else {
			req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);
		}
	}

	private boolean validate(MemberVO member, Map<String, String> errors) {
		boolean valid = true;

		if (StringUtils.isBlank(member.getMemId())) {
			valid = false;
			errors.put("memId", "회원아이디 누락");
		}
		
		if (StringUtils.isBlank(member.getMemPass())) {
			valid = false;
			errors.put("memPass", "비밀번호 누락");
		}
		
		if (StringUtils.isBlank(member.getMemZip())) {
			valid = false;
			errors.put("memZip", "우편주소 누락");
		}
		
		if (StringUtils.isBlank(member.getMemAdd1())) {
			valid = false;
			errors.put("memAdd1", "주소1 누락");
		}
		
		if (StringUtils.isBlank(member.getMemAdd2())) {
			valid = false;
			errors.put("memAdd2", "주소2 누락");
		}
		
		if (StringUtils.isBlank(member.getMemHp())) {
			valid = false;
			errors.put("memHp", "휴대폰번호 누락");
		}
		
		if(StringUtils.isNotBlank(member.getMemName())) {
			if(member.getMemName().length() > 10) {
				valid = false;
				errors.put("memName", "10글자 미만이 필요함.");
			}
				
		}
		
		return valid;
	}
}
