package kr.ac.kopo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.BoardListController;
import kr.ac.kopo.controller.Controller;
import kr.ac.kopo.controller.HandlerMapping;
import kr.ac.kopo.controller.WriteFormController;

@SuppressWarnings("serial")
public class FrontControllerServlet extends HttpServlet {
	
	private HandlerMapping mappings; 
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		String propLoc = config.getInitParameter("propertyLocation");
		System.out.println(propLoc);
		if(propLoc != null){
			mappings = new HandlerMapping(propLoc);
		} else {
			mappings = new HandlerMapping();
		}		
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String context = request.getContextPath();
		// 이게 파라미터 함수는 제거한 절대 경로를 보여준다.
		String uri = request.getRequestURI();
		uri = uri.substring(context.length());

//		System.out.println("요청 uri : " + uri);
//		String callPage = "";
//		Controller control = null;
		try {
			Controller  control = mappings.getController(uri);
						
			if (control != null) {
				String callPage = control.handleRequest(request, response);
				
				if(callPage.startsWith("redirect:")) {
					System.out.println(callPage);
					callPage = callPage.substring("redirect:".length());
					response.sendRedirect(request.getContextPath() +  callPage);					
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
					dispatcher.forward(request, response);
				}							
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
