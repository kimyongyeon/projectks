package com.edu.ks.dao;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.ks.R;
import com.edu.ks.dto.Photo_Board;
import com.edu.ks.lib.HttpFileDownload;

public class PhotoBoardAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	
	ArrayList<Photo_Board> m_ArrayPhotoBoard = new ArrayList<Photo_Board>();
	Photo_Board m_PhotoBoard;
	
	public PhotoBoardAdapter(Context context,
			ArrayList<Photo_Board> m_ArrayPhotoBoard) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.m_ArrayPhotoBoard = m_ArrayPhotoBoard;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return m_ArrayPhotoBoard.size();
	}

	public Photo_Board getItem(int position) {
		// TODO Auto-generated method stub
		return m_ArrayPhotoBoard.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.photoboard_list_row,
							parent, false);
		}
		// 제목
		TextView tv_str1 = (TextView) convertView.findViewById(R.id.photoboardlistRow_Tv01);
		// 날짜
		TextView tv_str2 = (TextView) convertView.findViewById(R.id.photoboardlistRow_Tv02);
		// 내용
		ImageView iv = (ImageView) convertView.findViewById(R.id.photoboardlistRow_Iv01);
		
		m_PhotoBoard = new Photo_Board();
		m_PhotoBoard = m_ArrayPhotoBoard.get(position);
		if(m_PhotoBoard != null){
			if(m_PhotoBoard.getTitle().length() > 10){
				String temp = m_PhotoBoard.getTitle()+"";
				temp = temp.substring(0, 8) + "...";
				tv_str1.setText(temp);
			}else{
				tv_str1.setText(m_PhotoBoard.getTitle()+"");	
			}
			tv_str2.setText(m_PhotoBoard.getDate()+"");
			HttpFileDownload imgDown = new HttpFileDownload();
			Bitmap bmImg = imgDown.downloadFile(m_PhotoBoard.getAttchimage());
			iv.setImageBitmap(bmImg);
		}

		return convertView;
	}

}
