package com.edu.ks.dao;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.edu.ks.dto.Board_Param;
import com.edu.ks.dto.Com_Board;
import com.edu.ks.dto.FoodMenu_Item;
import com.edu.ks.dto.JanmeUcc_Item;
import com.edu.ks.dto.Photo_Board;

public class XmlParse {
	/**
	 * ����Խ���(����Ʈ,�˻�) : ��������, ���а�������, ķ�۽��ҽ�, QNA, �������
	 * @throws UnsupportedEncodingException 
	 */
	public ArrayList<Com_Board> getXml_comboardlistAddr(Board_Param bp, int gubun) throws UnsupportedEncodingException {
		String temp = "";
		Address a = new Address();
		String rss = "";
		// 0: ����Ʈ, 1: �˻�
		if(gubun == 0){
			rss = a.comboardlistAddr(bp);	
		}else{
			rss = a.comboardsearchAddr(bp);
		}

		ArrayList<Com_Board> tempList = new ArrayList<Com_Board>();
		Com_Board board = new Com_Board();

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			URL url = new URL(rss);
			InputStream is = url.openStream();
			xpp.setInput(is, "UTF-8");

			int eventType = xpp.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.START_TAG) {
					if (xpp.getName().equals("Num")) {
						board = new Com_Board();
						temp = xpp.nextText();
						board.setNum(temp);
					}
					if (xpp.getName().equals("Subject")) {
						temp = xpp.nextText();
						board.setSubject(temp);
					}
					if (xpp.getName().equals("Writer")) {
						temp = xpp.nextText();
						board.setWriter(temp);
					}
					if (xpp.getName().equals("Email")) {
						temp = xpp.nextText();
						board.setEmail(temp);
					}
					if (xpp.getName().equals("Reg_Date")) {
						temp = xpp.nextText();
						board.setReg_date(temp);
					}
					if (xpp.getName().equals("Visited")) {
						temp = xpp.nextText();
						board.setVisited(temp);
						tempList.add(board);
					}
					// �б������� ������� ����.
					/*if (xpp.getName().equals("Recom")) {
						temp = xpp.nextText();
						board.setRecom(temp);
						tempList.add(board);
					}*/
				}
				eventType = xpp.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempList;
	}
	/**
	 * ���䰶���� �Խ��� ����Ʈ
	 * @throws UnsupportedEncodingException 
	 */
	public ArrayList<Photo_Board> getXml_phtoboardlistAddr(Board_Param bp, int gubun) throws UnsupportedEncodingException {
		String temp = "";
		Address a = new Address();
		String rss = "";
		// ���䰶������ �ʵ尡 �ٸ��� ������ 5������ ������.
		bp.setIndex(5); 
		if(gubun == 0){
			rss = a.comboardlistAddr(bp);	
		}else{
			rss = a.comboardsearchAddr(bp);
		}

		ArrayList<Photo_Board> tempList = new ArrayList<Photo_Board>();
		Photo_Board board = new Photo_Board();

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			URL url = new URL(rss);
			InputStream is = url.openStream();
			xpp.setInput(is, "UTF-8");

			int eventType = xpp.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.START_TAG) {
					if (xpp.getName().equals("seq")) {
						board = new Photo_Board();
						temp = xpp.nextText();
						board.setSeq(temp);
					}
					if (xpp.getName().equals("date")) {
						temp = xpp.nextText();
						board.setDate(temp);
					}
					if (xpp.getName().equals("Title")) {
						temp = xpp.nextText();
						board.setTitle(temp);
					}
					if (xpp.getName().equals("AttachImage")) {
						temp = xpp.nextText();
						board.setAttchimage(temp);
						tempList.add(board);
					}
				}
				eventType = xpp.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempList;
	}
	/**
	 * ����Խ��� ��ȭ��
	 */
	public Com_Board getXml_comboardDetailAddr(Board_Param bp) {
		String temp = "";
		Address a = new Address();
		String rss = "";
		rss = a.comboardDetailAddr(bp);	

		Com_Board board = new Com_Board();

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			URL url = new URL(rss);
			InputStream is = url.openStream();
			xpp.setInput(is, "UTF-8");

			int eventType = xpp.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.START_TAG) {
					if (xpp.getName().equals("Content")) {
						board = new Com_Board();
						temp = xpp.nextText();
						board.setContents(temp);
					}
					if (xpp.getName().equals("Visited")) {
						temp = xpp.nextText();
						board.setVisited(temp);
					}
					if (xpp.getName().equals("Writer")) {
						temp = xpp.nextText();
						board.setWriter(temp);
					}
					if (xpp.getName().equals("Subject")) {
						temp = xpp.nextText();
						board.setSubject(temp);
					}
					if (xpp.getName().equals("Email")) {
						temp = xpp.nextText();
						board.setEmail(temp);
					}
					if (xpp.getName().equals("Reg_Date")) {
						temp = xpp.nextText();
						board.setReg_date(temp);
					}
				}
				eventType = xpp.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	/**
	 * ����Խ��� ��ȭ��
	 */
	public Photo_Board getXml_photoboardDetailAddr(Board_Param bp) {
		String temp = "";
		Address a = new Address();
		String rss = "";
		bp.setIndex(5);
		rss = a.comboardDetailAddr(bp);	

		Photo_Board board = new Photo_Board();

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			URL url = new URL(rss);
			InputStream is = url.openStream();
			xpp.setInput(is, "UTF-8");

			int eventType = xpp.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.START_TAG) {
					if (xpp.getName().equals("Title")) {
						board = new Photo_Board();
						temp = xpp.nextText();
						board.setTitle(temp);
					}
					if (xpp.getName().equals("memo")) {
						temp = xpp.nextText();
						board.setMemo(temp);
					}
					if (xpp.getName().equals("name")) {
						temp = xpp.nextText();
						board.setName(temp);
					}
					if (xpp.getName().equals("date")) {
						temp = xpp.nextText();
						board.setDate(temp);
					}
					if (xpp.getName().equals("Contents")) {
						temp = xpp.nextText();
						board.setContents(temp);
					}
					if (xpp.getName().equals("path")) {
						temp = xpp.nextText();
						board.setAttchimage(temp);
					}
				}
				eventType = xpp.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	
	/**
	 * �Ĵܸ޴�
	 */
	public ArrayList<FoodMenu_Item> getXml_foodMenulistAddr() {
		String temp = "";
		Address a = new Address();
		String rss = "";
		rss = a.foodMenulistAddr();	

		ArrayList<FoodMenu_Item> arryFm = new ArrayList<FoodMenu_Item>();
		FoodMenu_Item fm = new FoodMenu_Item();

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			URL url = new URL(rss);
			InputStream is = url.openStream();
			xpp.setInput(is, "UTF-8");

			int eventType = xpp.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.START_TAG) {
					if (xpp.getName().equals("Num")) {
						fm = new FoodMenu_Item();
						temp = xpp.nextText();
						fm.setNum(temp);
					}
					if (xpp.getName().equals("Day")) {
						temp = xpp.nextText();
						fm.setDay(temp);
					}
					if (xpp.getName().equals("Content")) {
						temp = xpp.nextText();
						fm.setContent(temp);
					}
					if (xpp.getName().equals("Reg_date")) {
						temp = xpp.nextText();
						fm.setReg_date(temp);
						arryFm.add(fm);
					}
				}
				eventType = xpp.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arryFm;
	}
	
	/**
	 * �ܸ�UCC
	 */
	public ArrayList<JanmeUcc_Item> getXml_janmeucclistAddr() {
		String temp = "";
		Address a = new Address();
		String rss = "";
		rss = a.janmeucclistAddr();	

		ArrayList<JanmeUcc_Item> arryucc = new ArrayList<JanmeUcc_Item>();
		JanmeUcc_Item ucc = new JanmeUcc_Item();

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			URL url = new URL(rss);
			InputStream is = url.openStream();
			xpp.setInput(is, "UTF-8");

			int eventType = xpp.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.START_TAG) {
					if (xpp.getName().equals("Num")) {
						ucc = new JanmeUcc_Item();
						temp = xpp.nextText();
						ucc.setNum(temp);
					}
					if (xpp.getName().equals("Title")) {
						temp = xpp.nextText();
						ucc.setTitle(temp);
					}
					if (xpp.getName().equals("http")) {
						temp = xpp.nextText();
						ucc.setHttp(temp);
					}
					if (xpp.getName().equals("Reg_date")) {
						temp = xpp.nextText();
						ucc.setReg_date(temp);
						arryucc.add(ucc);
					}
				}
				eventType = xpp.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arryucc;
	}
}
