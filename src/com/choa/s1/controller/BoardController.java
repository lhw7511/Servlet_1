package com.choa.s1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.choa.s1.dto.BoardDTO;
import com.choa.s1.service.BoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        boardService= new BoardService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path=request.getRequestURL().toString();
		path=path.substring(path.lastIndexOf("/")+1);
		List<BoardDTO> boardDTOs = null;
		String info="";
		switch(path) {
		case "boardList.board":
				info="./boardList.jsp";
			try {
				boardDTOs=boardService.boardList();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("list", boardDTOs);
			break;
		case "boardWrite.board":
				info="./boardWrite.jsp";
			break;
			
		}
		
		
		RequestDispatcher view =request.getRequestDispatcher(info);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path=request.getRequestURL().toString();
		path=path.substring(path.lastIndexOf("/")+1);
		String info="";
		BoardDTO boardDTO =null;
		List<BoardDTO> boardDTOs = null;
		switch(path) {
		case "boardList.board":
				info="./boardList.jsp";

			try {
				boardDTO =new BoardDTO();
				boardDTO.setTitle(request.getParameter("title"));
				boardDTO.setWriter(request.getParameter("writer"));
				boardDTO.setContents(request.getParameter("contents"));
				boardService.boardInsert(boardDTO);
				boardDTOs=boardService.boardList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("list", boardDTOs);
			break;
	
			
		}
		RequestDispatcher view =request.getRequestDispatcher(info);
		view.forward(request, response);
	}

}
