package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.member.MemberDAO;
import kr.ac.kopo.member.MemberVO;

public class MemberDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		String name = request.getParameter("name");
		MemberVO memberDetail = 	dao.selectOne(name);	
		request.setAttribute("member", memberDetail);
		
		return "/member/memberDetail.jsp";
	}
}
