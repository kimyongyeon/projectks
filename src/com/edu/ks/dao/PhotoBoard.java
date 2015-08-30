package com.edu.ks.dao;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.edu.ks.dto.Board_Param;
import com.edu.ks.dto.Com_Board;
import com.edu.ks.dto.Photo_Board;

public class PhotoBoard {
	ArrayList<Photo_Board> m_ArrayPhotoBoard = new ArrayList<Photo_Board>();
	Photo_Board m_PhotoBoard;
	/**
	 * 포토게시판 리스트
	 * @param pageno : 페이지번호
	 * @param gubun : 게시판 종류(Address Class 참조)
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public ArrayList<Photo_Board> boardList(Board_Param tbp) throws UnsupportedEncodingException{
		Board_Param bp = tbp;
		XmlParse xml = new XmlParse();
		return m_ArrayPhotoBoard = xml.getXml_phtoboardlistAddr(bp, 0); 
	}
	/**
	 * 포토게시판 검색
	 * @param pageno : 페이지번호
	 * @param gubun : 게시판 종류(Address Class 참조)
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public ArrayList<Photo_Board> boardSearch(Board_Param tbp) throws UnsupportedEncodingException{
		Board_Param bp = tbp;
		XmlParse xml = new XmlParse();
		return m_ArrayPhotoBoard = xml.getXml_phtoboardlistAddr(bp, 1);
	}
	/**
	 * 포토게시판 상세보기
	 * @param key : 게시판 선택 레코드
	 * @param gubun : 게시판 종류(Address Class 참조)
	 * @return
	 */
	public Photo_Board boardDeatail(Board_Param tbp){
		Board_Param bp = tbp;
		XmlParse xml = new XmlParse();
		return m_PhotoBoard = xml.getXml_photoboardDetailAddr(bp);
	}
}
