package com.edu.ks.dto;

public class Board_Param {
	private String pageno;  // 페이지수
	private String gubun;   // 검색옵션
	private String keyword; // 검색키워드
	private int index;      // 게시판 구분 인덱스
	private int num;        // 게시판 인덱스(키)
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getPageno() {
		return pageno;
	}
	public void setPageno(String pageno) {
		this.pageno = pageno;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
