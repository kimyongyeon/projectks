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
import com.edu.ks.job.Center;
import com.edu.ks.job.Jobinfo;

public class Job extends Activity{
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
		tv.setText("취업정보");
	    t = new TitleDTO();
		t.title = "종합인력개발센터";
		ar.add(t);
		t = new TitleDTO();
		t.title = "취업정보";
		ar.add(t);
		t = new TitleDTO();
		t.title = "모바일 사람인";
		ar.add(t);
		t = new TitleDTO();
		t.title = "모바일 워크넷";
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
				if(t.title.equals("종합인력개발센터")){
					i = new Intent(getApplicationContext(), Center.class);
					startActivity(i);
					finish();
				}else if(t.title.equals("취업정보")){
					i = new Intent(getApplicationContext(), Jobinfo.class);
					startActivity(i);
					finish();
				}else if(t.title.equals("모바일 사람인")){
					/*i = new Intent(getApplicationContext(), Saramin.class);
					startActivity(i);
					finish();*/
					i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.saramin.co.kr/"));
					startActivity(i);
				}else if(t.title.equals("모바일 워크넷")){
/*					i = new Intent(getApplicationContext(), WorkNet.class);
					startActivity(i);
					finish();
*/					i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.work.go.kr/"));
					startActivity(i);
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
					lv_img1.setImageResource(R.drawable.subicon_20);
					break;
				case 1:
					lv_img1.setImageResource(R.drawable.subicon_22);
					break;
				case 2:
					lv_img1.setImageResource(R.drawable.subicon_24);
					break;
				case 3:
					lv_img1.setImageResource(R.drawable.subicon_18);
					break;
				}
			}

			return v;
		}
	
	}
}
