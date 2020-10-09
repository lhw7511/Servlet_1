package com.choa.s1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.choa.s1.dto.BoardDTO;
import com.choa.s1.util.DBConnector;

public class BoardDAO {

	private Connection con;
	private PreparedStatement st;
	private ResultSet rs;
	private DBConnector connector;
	
	public BoardDAO() {
		connector=new DBConnector();
	}
	public int boardInsert(BoardDTO boardDTO) throws Exception{
		con=connector.getConnect();
		int result=0;
		String sql="INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,?,?,?,SYSDATE,0)";
		st=con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getWriter());
		st.setString(3, boardDTO.getContents());
		
		
		result=st.executeUpdate();
		st.close();
		con.close();
		return result;
	}
	
	//전체 게시글 출력
	public List<BoardDTO> boardList() throws Exception {
		List<BoardDTO> boardDTOs = new ArrayList<>();
		con=connector.getConnect();
		String sql="SELECT * FROM BOARD ORDER BY NUM DESC";
		
		st=con.prepareStatement(sql);
		rs=st.executeQuery();
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getLong("NUM"));
			boardDTO.setTitle(rs.getString("TITLE"));
			boardDTO.setWriter(rs.getString("WRITER"));
			boardDTO.setContents(rs.getString("CONTENTS"));
			boardDTO.setRegdate(rs.getDate("REGDATE"));
			boardDTO.setHit(rs.getLong("HIT"));		
			boardDTOs.add(boardDTO);
		}
		rs.close();
		st.close();
		con.close();
		return boardDTOs;
		
	}
}
