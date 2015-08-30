package com.edu.ks.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.util.Log;

import com.edu.ks.Intro;
import com.edu.ks.dto.Board_Param;

public class Address {
	/**
	 * ����Ʈ ������
	 */
	private String strlistAddr[] = {
			Intro.mainPath + "/xml/notice_list.asp?pageno=",
			//"http://dalparan777.cafe24.com/app_mobile" + "/xml/notice_list.asp?pageno=",
			Intro.mainPath + "/xml/enter_notice_list.asp?pageno=",
			Intro.mainPath + "/xml/news_list.asp?pageno=",
			Intro.mainPath + "/xml/qna_list.asp?pageno=",
			Intro.mainPath + "/xml/recuruit_list.asp?pageno=",
			Intro.mainPath + "/xml/photo_list.asp?pageno="
	};
	
	/**
	 * �˻� ������
	 */
	private String strsearchAddr[] = {
			Intro.mainPath + "/xml/notice_search.asp?gubun=",
			Intro.mainPath + "/xml/enter_notice_search.asp?gubun=",
			Intro.mainPath + "/xml/news_search.asp?gubun=",
			Intro.mainPath + "/xml/qna_search.asp?gubun=",
			Intro.mainPath + "/xml/recuruit_search.asp?gubun=",
			Intro.mainPath + "/xml/photo_search.asp?gubun="
	};
	/**
	 * ��ȭ�� ������ �Ⱦ��� ��
	 */
	private String strDetailAddr[] ={
			Intro.mainPath + "/xml/notice_view.asp?num=",
			Intro.mainPath + "/xml/enter_notice_view.asp?num=",
			Intro.mainPath + "/xml/news_view.asp?num=",
			Intro.mainPath + "/xml/qna_view.asp?num=",
			Intro.mainPath + "/xml/recuruit_view.asp?num=",
			Intro.mainPath + "/xml/photo_view.asp?num="
	};
	/**
	 *	�Խ��� ����Ʈ 
	 */
	public String comboardlistAddr(Board_Param bp) {
		String temp = "";
		temp = strlistAddr[bp.getIndex()] + bp.getPageno();
		Log.d("kimyongyeon", "list : " + temp);
		return temp;
	}
	/**
	 * �Խ��� �˻� 
	 * @throws UnsupportedEncodingException 
	 */
	public String comboardsearchAddr(Board_Param bp) throws UnsupportedEncodingException {
		String temp = "";
		temp = strsearchAddr[bp.getIndex()] + bp.getGubun() + "&keyword=" + 
			   URLEncoder.encode(bp.getKeyword(), "UTF-8") + "&pageno=" + bp.getPageno();
		Log.d("kimyongyeon", "search : " + temp);
		return temp;
	}
	/**
	 *	�Խ��� ��ȭ�� 
	 */
	public String comboardDetailAddr(Board_Param bp) {
		String temp = "";
		temp = strDetailAddr[bp.getIndex()] +  bp.getNum();
		Log.d("kimyongyeon", "detail : " + temp);
		return temp;
	}
	/**
	 * �Ĵܸ޴�
	 */
	public String foodMenulistAddr(){
		String temp = "";
		temp = Intro.mainPath + "/xml/food_list.asp";
		Log.d("kimyongyeon", "foodmenu : " + temp);
		return temp;
	}
	/**
	 * �ܸ��� UCC
	 */
	public String janmeucclistAddr(){
		String temp = "";
		//temp = Intro.mainPath + "/xml/janmeucc_list.asp";
		temp = "http://dalparan777.cafe24.com/app_mobile/xml/janmeucc_list.asp";
		Log.d("kimyongyeon", "janmenucc : " + temp);
		return temp;
	}
}
