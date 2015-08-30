package com.edu.ks.life;

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
import com.edu.ks.tab.Life;

public class Bus extends Activity{
	ListView lv;
	TitleDTO t;
	ArrayList<TitleDTO> ar = new ArrayList<TitleDTO>();
	
	// Title Class 
	class TitleDTO {
		String title;
		int leftIcon;
		int rightIcon;
	}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.life_bus_menu);
		Intro.gubunView = 2;
		
		lv = (ListView)findViewById(R.id.life_bus_menu_lv01);
		
		/*t = new TitleDTO();
		t.title = getResources().getString(R.string.bus1);
		ar.add(t);*/
		t = new TitleDTO();
		t.title = getResources().getString(R.string.bus2);
		ar.add(t);
		t = new TitleDTO();
		t.title = getResources().getString(R.string.bus3);
		ar.add(t);
		t = new TitleDTO();
		t.title = getResources().getString(R.string.bus4);
		ar.add(t);
		t = new TitleDTO();
		t.title = getResources().getString(R.string.bus5);
		ar.add(t);
		
		LifeListAdapter lva = new LifeListAdapter(this, ar);
		lv.setAdapter(lva);
		
		// 게시글 클릭시 발생 이벤트 처리
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent intent = new Intent(getApplication(), Bus_Sub.class);
				intent.putExtra("Bus", position+"");
				startActivity(intent);
				finish();
			}

		});
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
						R.layout.life_bus_menu_row, parent,
						false);
			}

			//ImageView lv_img1 = (ImageView)v.findViewById(R.id.LifeRow_Iv01);
			TextView tv_str1 = (TextView) v.findViewById(R.id.life_bus_menu_row_tv01);
			//ImageView lv_img2 = (ImageView)v.findViewById(R.id.LifeRow_Iv02);

			mTitle = new TitleDTO();
			mTitle = arrTitle.get(position);
			if (mTitle != null) {
				//lv_img1.setImageResource(R.drawable.no_image); // 사진
				tv_str1.setText(mTitle.title); // 글쓴시간
				//lv_img2.setImageResource(R.drawable.no_image); // 전화하기
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
