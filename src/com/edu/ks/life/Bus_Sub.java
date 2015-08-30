package com.edu.ks.life;

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

public class Bus_Sub extends Activity{
	ListView lv;
	TitleDTO t;
	ArrayList<TitleDTO> ar = new ArrayList<TitleDTO>();
	private int m_Idx;
	private TextView tv;
	
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
		setContentView(R.layout.life_bus_sub);
		Intro.gubunView = 4;
		lv = (ListView)findViewById(R.id.life_bus_sub_lv01);
		tv = (TextView) findViewById(R.id.life_bus_sub_textview);
		
		String temp1[] = getResources().getStringArray(R.array.bus_contents01);
		String temp2[] = getResources().getStringArray(R.array.bus_contents02);
		String temp3[] = getResources().getStringArray(R.array.bus_contents03);
		String temp4[] = getResources().getStringArray(R.array.bus_contents04);
		
		String value = getIntent().getStringExtra("Bus");
		int idx = Integer.parseInt(value);
		m_Idx = idx;
		
		switch(idx){
		case 0:
			
			for(int i=0; i<temp1.length; i++){
				t = new TitleDTO();
				t.title = temp1[i];
				tv.setText("수영교차로 방면");
				if(i == 0){
					t.img = getResources().getDrawable(R.drawable.sectionbar);
				}
				if(i == 8){
					t.img = getResources().getDrawable(R.drawable.sectionbar);
				}
				ar.add(t);
			}
			
			break;
		case 1:
			for(int i=0; i<temp2.length; i++){
				t = new TitleDTO();
				t.title = temp2[i];
				tv.setText("연산교차로 방면");
				if(i == 0){
					t.img = getResources().getDrawable(R.drawable.sectionbar);
				}
				if(i == 5){
					t.img = getResources().getDrawable(R.drawable.sectionbar);
				}
				ar.add(t);
			}
			break;
		case 2:
			for(int i=0; i<temp3.length; i++){
				t = new TitleDTO();
				t.title = temp3[i];
				tv.setText("울산 방면");
				if(i == 0){
					t.img = getResources().getDrawable(R.drawable.sectionbar);
				}
				if(i == 13){
					t.img = getResources().getDrawable(R.drawable.sectionbar);
				}
				ar.add(t);
			}
			break;
		case 3:
			for(int i=0; i<temp4.length; i++){
				t = new TitleDTO();
				t.title = temp4[i];
				tv.setText("마산,창원,장유");
				if(i == 0){
					t.img = getResources().getDrawable(R.drawable.sectionbar);
				}
				
				ar.add(t);
			}
			break;
	
		}
		
		LifeListAdapter lva = new LifeListAdapter(this, ar);
		lv.setAdapter(lva);
		
		// 게시글 클릭시 발생 이벤트 처리
/*		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent intent = new Intent(getApplication(), FAQ_Sub.class);
				intent.putExtra("FAQ", position+"");
				startActivity(intent);
			}

		});*/
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
						R.layout.life_bus_sub_row, parent,
						false);
			}

			TextView tv_str1 = (TextView) v.findViewById(R.id.life_bus_sub_row_tv01);

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
		Intent i = new Intent(getApplicationContext(), Bus.class);
		startActivity(i);
		finish();
	}
}
