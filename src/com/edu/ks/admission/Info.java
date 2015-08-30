package com.edu.ks.admission;

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

public class Info extends Activity{
	ListView lv;
	TitleDTO t;
	ArrayList<TitleDTO> ar = new ArrayList<TitleDTO>();
	
	// Title Class 
	class TitleDTO {
		String title;
		String tel;
		String url;
	}
	
	String m_Temp[];
	String m_Tel[];
	String m_Url[];
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Ÿ��Ʋ�� ���ֱ�
		setContentView(R.layout.admission_info_menu);
		Intro.gubunView = 4;
		
		lv = (ListView)findViewById(R.id.admission_info_Lv01);
		
		m_Temp = getResources().getStringArray(R.array.han_title);
		m_Url = getResources().getStringArray(R.array.han_url);
		m_Tel = getResources().getStringArray(R.array.han_tel);
		
		for(int i=0; i<m_Url.length; i++){
			t = new TitleDTO();
			t.title = m_Temp[i];
			t.tel = m_Tel[i];
			t.url = m_Url[i];
			ar.add(t);
		}
		
		LifeListAdapter lva = new LifeListAdapter(this, ar);
		lv.setAdapter(lva);
		
		/*// �Խñ� Ŭ���� �߻� �̺�Ʈ ó��
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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
						R.layout.admission_info_menu_row, parent,
						false);
			}

			TextView tv_str1 = (TextView) v.findViewById(R.id.admission_info_row_Tv01);
			ImageView lv_img1 = (ImageView)v.findViewById(R.id.admission_info_row_Iv01);

			mTitle = new TitleDTO();
			mTitle = arrTitle.get(position);
			
			if (mTitle != null) {
				lv_img1.setImageResource(R.drawable.telicon); 
				tv_str1.setText(mTitle.title);
				
				tv_str1.setTag(position);
				lv_img1.setTag(position);
				
				tv_str1.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Ȩ������ �̵�
						mTitle = arrTitle.get((Integer)v.getTag());
						Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(mTitle.url));
						startActivity(i);
					}
				});
				
				lv_img1.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// ��ȭ�ɱ�
						mTitle = arrTitle.get((Integer)v.getTag());
						String tel = "tel:" + mTitle.tel;
						Intent call_phone = new Intent(Intent.ACTION_VIEW, Uri.parse(tel));
					    startActivity(call_phone);
						
					}
				});
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
