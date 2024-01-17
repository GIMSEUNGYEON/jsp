package kr.or.ddit.address.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.address.service.AddressService;
import kr.or.ddit.address.service.AddressServiceImpl;
import kr.or.ddit.common.exception.ColumnNotFoundException;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/address/address.do")
public class AddressControllerServlet extends HttpServlet {

	private MemberService memService = new MemberServiceImpl();
	private AddressService service = new AddressServiceImpl();
		
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
		
		MemberVO member = memService.retrieveMember(authMember.getMemId());
		
		req.setAttribute("member", member);
		
		String message = "";
		
		try {
			
			List<AddressVO> addresses = service.retrieveAddressList(authMember.getMemId());
		
			req.setAttribute("addresses", addresses);			
		
		}catch (ColumnNotFoundException e) {
			message = "현재 조회할 수 있는 주소록이 없습니다.";
			req.setAttribute("message", message);
		}
		
		String logicalViewName = "addressList/address"; 
		
		req.getRequestDispatcher("/" + logicalViewName + ".miles").forward(req, resp);

	}
}
