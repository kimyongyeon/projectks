package com.edu.ks.dao;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.edu.ks.dto.Board_Param;
import com.edu.ks.dto.Com_Board;

public class Board {
	ArrayList<Com_Board> m_ArrayComBoard = new ArrayList<Com_Board>();
	Com_Board m_ComBoard;
	/**
	 * 게시판 리스트
	 * @param pageno : 페이지번호
	 * @param gubun : 게시판 종류(Address Class 참조)
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public ArrayList<Com_Board> boardList(Board_Param tbp) throws UnsupportedEncodingException{
		Board_Param bp = tbp;
		XmlParse xml = new XmlParse();
		return m_ArrayComBoard = xml.getXml_comboardlistAddr(bp, 0); 
	}
	/**
	 * 게시판 검색
	 * @param pageno : 페이지번호
	 * @param gubun : 게시판 종류(Address Class 참조)
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public ArrayList<Com_Board> boardSearch(Board_Param tbp) throws UnsupportedEncodingException{
		Board_Param bp = tbp;
		XmlParse xml = new XmlParse();
		return m_ArrayComBoard = xml.getXml_comboardlistAddr(bp, 1);
	}
	/**
	 * 게시판 상세보기
	 * @param key : 게시판 선택 레코드
	 * @param gubun : 게시판 종류(Address Class 참조)
	 * @return
	 */
	public Com_Board boardDeatail(Board_Param tbp){
		Board_Param bp = tbp;
		XmlParse xml = new XmlParse();
		return m_ComBoard = xml.getXml_comboardDetailAddr(bp);
	}
}
