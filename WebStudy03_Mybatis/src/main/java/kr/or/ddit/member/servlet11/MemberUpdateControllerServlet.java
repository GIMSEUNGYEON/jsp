package kr.or.ddit.member.servlet11;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/member/memberUpdate.do")
public class MemberUpdateControllerServlet extends HttpServlet {

	private MemberService service = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 현재 로그인한 사용자의 기본정보를 초기값으로 가지고 있는 수정 양식의 제공
		MemberVO authMember = (MemberVO) req.getSession().getAttribute("authMember");

		MemberVO member = service.retrieveMember(authMember.getMemId());

		req.setAttribute("member", member);

		String logicalViewName = "member/memberEdit";

		req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVO authMember = (MemberVO) req.getSession().getAttribute("authMember");

		// POST 파라미터로 수정 절차 진행
		MemberVO modMem = new MemberVO();
		req.setAttribute("member", modMem);
		
		
		Map<String, String[]> parameterMap = req.getParameterMap();

		try {
			PopulateUtils.populate(modMem, parameterMap);
		} catch (Exception e) {

		}
		modMem.setMemId(authMember.getMemId());
		
		log.info("{}", modMem);
		
		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = ValidateUtils.validate(modMem, errors, UpdateGroup.class);

		String logicalViewName = null;
		String message = null;

		if (valid) {
			ServiceResult result = service.ModifyMember(modMem);
			switch (result) {
			case OK:
				logicalViewName = "redirect:/mypage";
				break;
			case FAIL:
				logicalViewName = "member/memberEdit";
				message = "서버에 일시적 오류 발생";
				break;
			default:
				logicalViewName = "member/memberEdit";
				message = "비밀번호가 일치하지 않음";
				break;
			}
			req.setAttribute("message", message);
		} else {
			logicalViewName = "member/memberEdit";
		}
		
		if(logicalViewName.startsWith("redirect:")) {
			String redirectViewPath = req.getContextPath() + logicalViewName.substring("redirect:".length());
			resp.sendRedirect(redirectViewPath);
		} else {
			req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);
		}
	}

}
