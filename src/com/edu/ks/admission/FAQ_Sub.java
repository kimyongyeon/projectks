package com.edu.ks.admission;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;

public class FAQ_Sub extends Activity{
	ListView lv;
	TitleDTO t;
	ArrayList<TitleDTO> ar = new ArrayList<TitleDTO>();
	private String m_FaqSub2;
	
	// Title Class 
	class TitleDTO {
		String title;
		String contents;
		int leftIcon;
		int rightIcon;
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.admission_faq_sub);
		Intro.gubunView = 4;
		lv = (ListView)findViewById(R.id.admission_faq_sub_lv01);
		
		String temp1[] = getResources().getStringArray(R.array.faq_contents01);
		String temp2[] = getResources().getStringArray(R.array.faq_contents02);
		String temp3[] = getResources().getStringArray(R.array.faq_contents03);
		String temp4[] = getResources().getStringArray(R.array.faq_contents04);
		m_FaqSub2 = temp4[0];
		String temp5[] = getResources().getStringArray(R.array.faq_contents05);
		String temp6[] = getResources().getStringArray(R.array.faq_contents06);
		
		String value = getIntent().getStringExtra("FAQ");
		int idx = Integer.parseInt(value);
		
		switch(idx){
		case 0:
			for(int i=0; i<temp1.length; i++){
				if(i%2==0){
					t = new TitleDTO();
					t.title = temp1[i];	
				}else{
					t.contents = temp1[i];
					ar.add(t);
				}
			}
			break;
		case 1:
			for(int i=0; i<temp2.length; i++){
				if(i%2==0){
					t = new TitleDTO();
					t.title = temp2[i];	
				}else{
					t.contents = temp2[i];
					ar.add(t);
				}
			}
			break;
		case 2:
			for(int i=0; i<temp3.length; i++){
				if(i%2==0){
					t = new TitleDTO();
					t.title = temp3[i];	
				}else{
					t.contents = temp3[i];
					ar.add(t);
				}
			}
			break;
		case 3:
			for(int i=0; i<temp4.length; i++){
				if(i%2==0){
					t = new TitleDTO();
					t.title = temp4[i];	
				}else{
					t.contents = temp4[i];
					ar.add(t);
				}
			}
			break;
		case 4:
			for(int i=0; i<temp5.length; i++){
				if(i%2==0){
					t = new TitleDTO();
					t.title = temp5[i];	
				}else{
					t.contents = temp5[i];
					ar.add(t);
				}
			}
			break;
		case 5:
			for(int i=0; i<temp6.length; i++){
				if(i%2==0){
					t = new TitleDTO();
					t.title = temp6[i];	
				}else{
					t.contents = temp6[i];
					ar.add(t);
				}
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
						R.layout.admission_faq_sub_row, parent,
						false);
			}

			TextView tv_str1 = (TextView) v.findViewById(R.id.admission_faq_sub_row_tv01);
			TextView tv_str2 = (TextView) v.findViewById(R.id.admission_faq_sub_row_tv02);

			mTitle = new TitleDTO();
			mTitle = arrTitle.get(position);
			if (mTitle != null) {
				tv_str1.setText(mTitle.title); // 글쓴시간
				if(tv_str1.getText().toString().equals(m_FaqSub2)){
					tv_str2.setText("등록금 상세보기"); // 글쓴시간
					tv_str2.setOnClickListener(new View.OnClickListener() {
						
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent i = new Intent(getApplicationContext(), FAQ_Sub2.class);
							startActivity(i);
							finish();
						}
					});
				}else{
					tv_str2.setText(mTitle.contents); // 글쓴시간
				}
			}

			return v;
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent i = new Intent(getApplicationContext(), FAQ.class);
		startActivity(i);
		finish();
	}
}
