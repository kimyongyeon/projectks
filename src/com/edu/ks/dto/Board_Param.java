package com.edu.ks.dto;

public class Board_Param {
	private String pageno;  // ��������
	private String gubun;   // �˻��ɼ�
	private String keyword; // �˻�Ű����
	private int index;      // �Խ��� ���� �ε���
	private int num;        // �Խ��� �ε���(Ű)
	
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
