package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String msg = (String) session.getAttribute("msg");
//		session.invalidate();
		session.removeAttribute("msg");
		System.out.println("msg : ");
		System.out.println(msg);
		request.setAttribute("msg", msg);		
		return "/login/login.jsp";
	}
}
