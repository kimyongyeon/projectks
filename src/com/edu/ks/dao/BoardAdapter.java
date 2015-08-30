package com.edu.ks.dao;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.ks.R;
import com.edu.ks.dto.Com_Board;

public class BoardAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	
	ArrayList<Com_Board> m_ArrayComBoard = new ArrayList<Com_Board>();
	Com_Board m_ComBoard;
	
	public BoardAdapter(Context context,
			ArrayList<Com_Board> m_ArrayComBoard) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.m_ArrayComBoard = m_ArrayComBoard;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return m_ArrayComBoard.size();
	}

	public Com_Board getItem(int position) {
		// TODO Auto-generated method stub
		return m_ArrayComBoard.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.board_list_row,
							parent, false);
		}
		// 제목
		TextView tv_str1 = (TextView) convertView
				.findViewById(R.id.boardlistRow_Tv01);
		// 날짜
		TextView tv_str2 = (TextView) convertView
				.findViewById(R.id.boardlistRow_Tv02);
		// 내용
		ImageView iv = (ImageView) convertView.findViewById(R.id.boardlistRow_Iv01);
		
		// 문자하기
		m_ComBoard = new Com_Board();
		m_ComBoard = m_ArrayComBoard.get(position);
		if(m_ComBoard != null){
			if(m_ComBoard.getSubject().length() > 10){
				String temp = m_ComBoard.getSubject();
				temp = temp.substring(0, 8) + "...";
				tv_str1.setText(temp);
			}else{
				tv_str1.setText(m_ComBoard.getSubject());	
			}
			tv_str2.setText(m_ComBoard.getReg_date());
		}

		return convertView;
	}

}
