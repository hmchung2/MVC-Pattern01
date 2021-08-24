package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.login.LoginDAO;
import kr.ac.kopo.login.LoginVO;

public class LoginProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String id       = request.getParameter("id");
		String password = request.getParameter("password");
		
		System.out.println(id);
		System.out.println(password);
		
		LoginVO loginVO = new LoginVO();
		loginVO.setId(id);
		loginVO.setPassword(password);
		LoginDAO dao = new LoginDAO();	
		LoginVO userVO = dao.login(loginVO);
		
		String msg = "";
		String url = "";
		HttpSession session =request.getSession();
		if(userVO == null){
			msg = "���̵� �Ǵ� �н����带 �߸� �Է��ϼ˽��ϴ�.";
//			url = request.getContextPath() + "/login.do";
			url = "redirect:/login.do";
			session.setAttribute("msg", msg);
		}else{		
			msg = userVO.getName() + "�� ȯ���մϴ�.";
//			url = "/index.jsp";
			url = "redirect:/";
			session.setAttribute("userVO", userVO);			
		}
		return url;
	}
}
