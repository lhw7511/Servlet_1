package com.choa.s1.service;

import java.util.List;

import com.choa.s1.dao.BoardDAO;
import com.choa.s1.dto.BoardDTO;

public class BoardService {
	
	private BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO=new BoardDAO();
	}
	//게시글 작성
	public void boardInsert(BoardDTO boardDTO)throws Exception {
		 int result = boardDAO.boardInsert(boardDTO);
		 if(result>0) {
			 System.out.println("Insert 성공");
		 }else {
			 System.out.println("Insert 실패");
		 }
	}
	
	//전체게시글 출력
	public List<BoardDTO> boardList() throws Exception {
		List<BoardDTO> boardDTOs = boardDAO.boardList();
		return boardDTOs;
	}
}
