package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.member.MemberDAO;
import kr.ac.kopo.member.MemberVO;

public class MemberListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.selectAll();
		request.setAttribute("list", list);
		
		return "/member/memberList.jsp";		
	}

}
