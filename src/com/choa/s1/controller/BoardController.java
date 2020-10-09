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
		//index.jsp에서 boardList a태그를 눌렀을 경우
		case "boardList.board":
				info="./boardList.jsp";
			try {
				boardDTOs=boardService.boardList();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//boardList.jsp에서 db에서가져온 게시글리스트를 뿌려주기위해 set함.
			request.setAttribute("list", boardDTOs);
			break;
			//boardList페이지에서 write버튼을눌러서 작성페이지로 가는경우
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
		//write페이지에서 게시글을 작성하고 write버튼을 눌렀을땐 post형식으로 디비에 게시글insert후 boardlist페이지로이동함
		case "boardList.board":
				info="./boardList.jsp";

			try {
				//insert작성
				boardDTO =new BoardDTO();
				boardDTO.setTitle(request.getParameter("title"));
				boardDTO.setWriter(request.getParameter("writer"));
				boardDTO.setContents(request.getParameter("contents"));
				boardService.boardInsert(boardDTO);
				
			   //db에 인서트후 list화면으로 넘어가기위해 get방식과 같이 db에서 게시글리스트를 가져옴
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
