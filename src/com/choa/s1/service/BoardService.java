package com.choa.s1.service;

import java.util.List;

import com.choa.s1.dao.BoardDAO;
import com.choa.s1.dto.BoardDTO;

public class BoardService {
	
	private BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO=new BoardDAO();
	}
	
	public List<BoardDTO> boardList() throws Exception {
		List<BoardDTO> boardDTOs = boardDAO.boardList();
		return boardDTOs;
	}
}
