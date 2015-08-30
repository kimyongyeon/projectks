package com.edu.ks.tab;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;
import com.edu.ks.admission.FAQ;
import com.edu.ks.admission.GuideLine;
import com.edu.ks.admission.Info;
import com.edu.ks.admission.Notice;
import com.edu.ks.admission.QnA;
import com.edu.ks.admission.Result;
import com.edu.ks.board.BoardDetail;

public class Admission extends Activity{
	ListView lv;
	TitleDTO t;
	ArrayList<TitleDTO> ar = new ArrayList<TitleDTO>();
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intro.gubunView = 0;
		Intent i = new Intent(getApplicationContext(), Tab.class);
		startActivity(i);
		finish();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.sub_menu);
		
		lv = (ListView)findViewById(R.id.com_edu_ks_tab_sub_menu_lv01);
		TextView tv = (TextView) findViewById(R.id.sub_menu_textview);
		tv.setText("입학안내");
	    t = new TitleDTO();
		t.title = "입학 공지사항";
		ar.add(t);
		t = new TitleDTO();
		t.title = "모집요강";
		ar.add(t);
		t = new TitleDTO();
		t.title = "학과별 입시상담 안내";
		ar.add(t);
		t = new TitleDTO();
		t.title = "입학 FAQ";
		ar.add(t);
		t = new TitleDTO();
		t.title = "입학 Q&A";
		ar.add(t);
		t = new TitleDTO();
		t.title = "합격자 조회";
		ar.add(t);
		t = new TitleDTO();
		t.title = "전년도 입시결과";
		ar.add(t);
		
		LifeListAdapter lva = new LifeListAdapter(
				this, ar);
		lv.setAdapter(lva);
		
		// 게시글 클릭시 발생 이벤트 처리
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent i;
				t = ar.get(position);
				// 공지사항 클릭시
				if(t.title.equals("입학 공지사항")){
					i = new Intent(getApplicationContext(), Notice.class);
					startActivity(i);
					finish();
				}else if(t.title.equals("모집요강")){
					// BoardDetail은 게시판 상세페이지 웹뷰를 위한 것만이 아닌
					// 전체 웹뷰를 이곳에서 관리함.
					i = new Intent(getApplicationContext(), GuideLine.class);
					//i = new Intent(getApplicationContext(), BoardDetail.class);
					i.putExtra("Board", "0"+","+"29");
					startActivity(i);
					finish();
				}else if(t.title.equals("학과별 입시상담 안내")){
					i = new Intent(getApplicationContext(), Info.class);
					startActivity(i);
					finish();
				}else if(t.title.equals("입학 FAQ")){
					i = new Intent(getApplicationContext(), FAQ.class);
					startActivity(i);
					finish();
				}else if(t.title.equals("입학 Q&A")){
					i = new Intent(getApplicationContext(), QnA.class);
					startActivity(i);
					finish();
				}else if(t.title.equals("합격자 조회")){
					//http://www.bsks.ac.kr/iphak/04_result/sub1_01.asp
					i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bsks.ac.kr/iphak/04_result/sub1_01.asp"));
					startActivity(i);
				}else if(t.title.equals("전년도 입시결과")){
					i = new Intent(getApplicationContext(), Result.class);
					startActivity(i);
					finish();
				}
			}

		});
		
	}
	
	// Title Class 
	class TitleDTO {
		String title;
		int leftIcon;
		int rightIcon;
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
						R.layout.sub_menu_row, parent,
						false);
			}

			ImageView lv_img1 = (ImageView)v.findViewById(R.id.com_edu_ks_tab_sub_menu_row_iv02);
			TextView tv_str1 = (TextView) v.findViewById(R.id.com_edu_ks_tab_sub_menu_row_tv01);
			//ImageView lv_img2 = (ImageView)v.findViewById(R.id.LifeRow_Iv02);

			mTitle = new TitleDTO();
			mTitle = arrTitle.get(position);
			if (mTitle != null) {
				tv_str1.setText(mTitle.title); 
				switch (position) {
				case 0:
					lv_img1.setImageResource(R.drawable.subicon_02);
					break;
				case 1:
					lv_img1.setImageResource(R.drawable.subicon_12);
					break;
				case 2:
					lv_img1.setImageResource(R.drawable.subicon_01);
					break;
				case 3:
					lv_img1.setImageResource(R.drawable.subicon_09);
					break;
				case 4:
					lv_img1.setImageResource(R.drawable.subicon_23);
					break;
				case 5:
					lv_img1.setImageResource(R.drawable.subicon_07);
					break;
				case 6:
					lv_img1.setImageResource(R.drawable.subicon_10);
					break;
				}
			}

			return v;
		}
	
	}
}
