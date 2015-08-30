package com.edu.ks.dao;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.edu.ks.dto.Board_Param;
import com.edu.ks.dto.Com_Board;

public class Board {
	ArrayList<Com_Board> m_ArrayComBoard = new ArrayList<Com_Board>();
	Com_Board m_ComBoard;
	/**
	 * �Խ��� ����Ʈ
	 * @param pageno : ��������ȣ
	 * @param gubun : �Խ��� ����(Address Class ����)
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public ArrayList<Com_Board> boardList(Board_Param tbp) throws UnsupportedEncodingException{
		Board_Param bp = tbp;
		XmlParse xml = new XmlParse();
		return m_ArrayComBoard = xml.getXml_comboardlistAddr(bp, 0); 
	}
	/**
	 * �Խ��� �˻�
	 * @param pageno : ��������ȣ
	 * @param gubun : �Խ��� ����(Address Class ����)
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public ArrayList<Com_Board> boardSearch(Board_Param tbp) throws UnsupportedEncodingException{
		Board_Param bp = tbp;
		XmlParse xml = new XmlParse();
		return m_ArrayComBoard = xml.getXml_comboardlistAddr(bp, 1);
	}
	/**
	 * �Խ��� �󼼺���
	 * @param key : �Խ��� ���� ���ڵ�
	 * @param gubun : �Խ��� ����(Address Class ����)
	 * @return
	 */
	public Com_Board boardDeatail(Board_Param tbp){
		Board_Param bp = tbp;
		XmlParse xml = new XmlParse();
		return m_ComBoard = xml.getXml_comboardDetailAddr(bp);
	}
}
