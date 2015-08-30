package com.edu.ks.pr;

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
import com.edu.ks.dao.XmlParse;
import com.edu.ks.dto.JanmeUcc_Item;

public class Ucc2 extends Activity{
	ListView lv;
	ArrayList<JanmeUcc_Item> ucc = new ArrayList<JanmeUcc_Item>();
	JanmeUcc_Item jucc = new JanmeUcc_Item();
	String m_Temp[];
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.sub_menu);
		Intro.gubunView = 3;
		
		XmlParse xml = new XmlParse();
		ucc = xml.getXml_janmeucclistAddr();
		lv = (ListView)findViewById(R.id.com_edu_ks_tab_sub_menu_lv01);
		TextView tv = (TextView)findViewById(R.id.sub_menu_textview);
		tv.setText("잔메 UCC");
		LifeListAdapter lva = new LifeListAdapter(
				this, ucc);
		lv.setAdapter(lva);
		
		// 게시글 클릭시 발생 이벤트 처리
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent i;
				jucc = ucc.get(position);
				// 잔메 UCC 클릭시
				i = new Intent(Intent.ACTION_VIEW, Uri.parse(jucc.getHttp()));
				startActivity(i);
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
		//TitleDTO mTitle = new TitleDTO();
		JanmeUcc_Item jucc = new JanmeUcc_Item();
		ArrayList<JanmeUcc_Item> ucc = new ArrayList<JanmeUcc_Item>();
		
		LifeListAdapter(Context context,
				ArrayList<JanmeUcc_Item> ucc) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			this.ucc = ucc;
		}

		public int getCount() {
			// TODO Auto-generated method stub
			return ucc.size();
		}

		public JanmeUcc_Item getItem(int position) {
			// TODO Auto-generated method stub
			return ucc.get(position);
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

			TextView tv_str1 = (TextView) v.findViewById(R.id.com_edu_ks_tab_sub_menu_row_tv01);
			ImageView iv_str1 = (ImageView) v.findViewById(R.id.com_edu_ks_tab_sub_menu_row_iv02);

			jucc = new JanmeUcc_Item();
			jucc = ucc.get(position);
			if (jucc != null) {
				iv_str1.setBackgroundResource(R.drawable.subicon_05);
				tv_str1.setText(jucc.getTitle()); // 글쓴시간
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
