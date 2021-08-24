package kr.ac.kopo.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		this("C:\\\\Users\\\\hmchu\\\\Mission-Web\\\\Mission-Web-MVC01\\\\bean.properties");
	}

	public HandlerMapping(String propLoc) {
		
		mappings = new HashMap<>(); 
//		 mappings.put("/board/list.do", new BoardListController());
//		 mappings.put("/board/writeForm.do", new WriteFormController());
//		 mappings.put("/board/detail.do", new BoardDetailController());
//		 mappings.put("/member/memberList.do", new MemberListController());
//		 mappings.put("/member/memberDetail.do", new MemberDetailController());
		 

		Properties prop = new Properties();
		try {
//			InputStream is = new FileInputStream("C:\\Users\\hmchu\\Mission-Web\\Mission-Web-MVC01\\bean.properties");
			InputStream is = new FileInputStream(propLoc);
			prop.load(is);
			Set<Object> keys =  prop.keySet();
//			prop.getProperty("/board/list.do");
			
			for(Object key : keys) {
				
				String className = prop.getProperty(key.toString());
				Class<?> clz = Class.forName(className);
				mappings.put(key.toString(), (Controller)clz.newInstance());
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Controller getController(String uri) {
		return mappings.get(uri);
	}
}
