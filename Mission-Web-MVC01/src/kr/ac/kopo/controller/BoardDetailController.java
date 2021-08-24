package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.board.BoardDAO;
import kr.ac.kopo.board.BoardFileVO;
import kr.ac.kopo.board.BoardVO;

public class BoardDetailController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.selectOne( no );
		List<BoardFileVO> fileList = dao.selectFileByNo(board.getNo());

		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		// TODO Auto-generated method stub
		return "/board/detail.jsp";

	}
}
