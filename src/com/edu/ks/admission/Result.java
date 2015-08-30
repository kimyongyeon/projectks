package com.edu.ks.admission;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;

public class Result extends Activity{
	ListView lv, lv2;
	TitleDTO t;
	ArrayList<TitleDTO> ar = new ArrayList<TitleDTO>();
	ArrayList<TitleDTO> ar2 = new ArrayList<TitleDTO>();
	private int m_Idx;
	
	// Title Class 
	class TitleDTO {
		String title;
		String contents;
		Drawable img;
		int leftIcon;
		int rightIcon;
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.admission_result);
		Intro.gubunView = 4;
		lv = (ListView)findViewById(R.id.admission_result_lv01);
		//lv2 = (ListView)findViewById(R.id.admission_result_lv02);
		
		String temp1[] = getResources().getStringArray(R.array.preyear_contents01);
		//String temp2[] = getResources().getStringArray(R.array.preyear_contents02);
		
		for(int i=0; i<temp1.length; i++){
			t = new TitleDTO();
			t.title = temp1[i];
			if(i == 0 || i == 26){
				t.img = getResources().getDrawable(R.drawable.sectionbar);
			}
			ar.add(t);
		}
		
		LifeListAdapter lva = new LifeListAdapter(this, ar);
		lv.setAdapter(lva);
		
		/*for(int i=0; i<temp2.length; i++){
			t = new TitleDTO();
			t.title = temp2[i];
			if(i == 0){
				t.img = getResources().getDrawable(R.drawable.sectionbar);
			}
			ar2.add(t);
		}
		
		LifeListAdapter2 lva2 = new LifeListAdapter2(this, ar2);
		lv2.setAdapter(lva2);*/
	}
	
	class LifeListAdapter extends BaseAdapter {
		private LayoutInflater inflater;
		TitleDTO mTitle = new TitleDTO();
		ArrayList<TitleDTO> arrTitle = new ArrayList<TitleDTO>();
		
		LifeListAdapter(Context context,
				ArrayList<TitleDTO> arrTitle) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			this.arrTitle = arrTitle;
		}

		public int getCount() {
			// TODO Auto-generated method stub
			return arrTitle.size();
		}

		public TitleDTO getItem(int position) {
			// TODO Auto-generated method stub
			return arrTitle.get(position);
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public View getView(int position, View v, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (v == null) {
				v = inflater.inflate(
						R.layout.admission_result_row, parent,
						false);
			}

			TextView tv_str1 = (TextView) v.findViewById(R.id.admission_result_row_tv01);

			mTitle = new TitleDTO();
			mTitle = arrTitle.get(position);
			if (mTitle != null) {
				tv_str1.setBackgroundDrawable(mTitle.img);
				tv_str1.setText(mTitle.title); 
			}

			return v;
		}
	}
	
	class LifeListAdapter2 extends BaseAdapter {
		private LayoutInflater inflater;
		TitleDTO mTitle = new TitleDTO();
		ArrayList<TitleDTO> arrTitle = new ArrayList<TitleDTO>();
		
		LifeListAdapter2(Context context,
				ArrayList<TitleDTO> arrTitle) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			this.arrTitle = arrTitle;
		}

		public int getCount() {
			// TODO Auto-generated method stub
			return arrTitle.size();
		}

		public TitleDTO getItem(int position) {
			// TODO Auto-generated method stub
			return arrTitle.get(position);
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public View getView(int position, View v, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (v == null) {
				v = inflater.inflate(
						R.layout.admission_result_row, parent,
						false);
			}

			TextView tv_str1 = (TextView) v.findViewById(R.id.admission_result_row_tv01);

			mTitle = new TitleDTO();
			mTitle = arrTitle.get(position);
			if (mTitle != null) {
				tv_str1.setBackgroundDrawable(mTitle.img);
				tv_str1.setText(mTitle.title); 
			}

			return v;
		}
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent i = new Intent(getApplicationContext(), Tab.class);
		startActivity(i);
		finish();
	}

}
