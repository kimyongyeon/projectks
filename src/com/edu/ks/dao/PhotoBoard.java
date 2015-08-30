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
	 * ����Խ��� ����Ʈ
	 * @param pageno : ��������ȣ
	 * @param gubun : �Խ��� ����(Address Class ����)
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public ArrayList<Photo_Board> boardList(Board_Param tbp) throws UnsupportedEncodingException{
		Board_Param bp = tbp;
		XmlParse xml = new XmlParse();
		return m_ArrayPhotoBoard = xml.getXml_phtoboardlistAddr(bp, 0); 
	}
	/**
	 * ����Խ��� �˻�
	 * @param pageno : ��������ȣ
	 * @param gubun : �Խ��� ����(Address Class ����)
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public ArrayList<Photo_Board> boardSearch(Board_Param tbp) throws UnsupportedEncodingException{
		Board_Param bp = tbp;
		XmlParse xml = new XmlParse();
		return m_ArrayPhotoBoard = xml.getXml_phtoboardlistAddr(bp, 1);
	}
	/**
	 * ����Խ��� �󼼺���
	 * @param key : �Խ��� ���� ���ڵ�
	 * @param gubun : �Խ��� ����(Address Class ����)
	 * @return
	 */
	public Photo_Board boardDeatail(Board_Param tbp){
		Board_Param bp = tbp;
		XmlParse xml = new XmlParse();
		return m_PhotoBoard = xml.getXml_photoboardDetailAddr(bp);
	}
}
