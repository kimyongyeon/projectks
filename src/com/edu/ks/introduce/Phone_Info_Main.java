package com.edu.ks.introduce;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.edu.ks.R;
import com.edu.ks.board.BoardDetail;
import com.edu.ks.introduce.Hak_Info.LifeListAdapter;

public class Phone_Info_Main extends Activity{
	ListView lv;
	TitleDTO t;
	ArrayList<TitleDTO> m_arrayTc = new ArrayList<TitleDTO>();
	TitleDTO m_Tc;
	private int m_Idx;
	private String m_cateGory[] = {
			"본부", "학과", "종합인력센터","부속기관","관련기관"
	};
	private String m_cateGorySelect = "";

	// Title Class 
	class TitleDTO {
		String title;
		String content;
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.introduce_phone_info_main_list);
		
		String value = getIntent().getStringExtra("Phone_Info");
		m_Idx = Integer.parseInt(value);
		
		lv = (ListView)findViewById(R.id.introduce_phone_info_main_list_Lv01);
		TextView tv = (TextView)findViewById(R.id.introduce_phone_info_main_textview);
		
		switch(m_Idx){
		case 0 : // 본부
			tv.setText("본부");
			m_cateGorySelect = m_cateGory[0];
			m_Tc = new TitleDTO(); // 0
			m_Tc.title = getResources().getString(R.string.phone_headquarter_subtitle1);
			m_Tc.content = getResources().getString(R.string.phone_headquarter_subtitle1_contents);
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO(); // 1 
			m_Tc.title = getResources().getString(R.string.phone_headquarter_subtitle2);
			m_Tc.content = getResources().getString(R.string.phone_headquarter_subtitle2_contents);
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO(); // 2
			m_Tc.title = getResources().getString(R.string.phone_headquarter_subtitle3);
			m_Tc.content = getResources().getString(R.string.phone_headquarter_subtitle3_contents);
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO(); // 3
			m_Tc.title = getResources().getString(R.string.phone_headquarter_subtitle4);
			m_Tc.content = getResources().getString(R.string.phone_headquarter_subtitle4_contents);
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO(); // 4
			m_Tc.title = getResources().getString(R.string.phone_headquarter_subtitle5);
			m_Tc.content = getResources().getString(R.string.phone_headquarter_subtitle5_contents);;
			m_arrayTc.add(m_Tc);
			break;
		case 1 : // 학과
			tv.setText("학과");
			m_cateGorySelect = m_cateGory[1];
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle1);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle2);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle3);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle4);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle5);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle6);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle7);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle8);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle9);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle10);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle11);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle12);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle13);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle14);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle15);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle16);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle17);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle18);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle19);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle20);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle21);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_department_subtitle22);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			break;
		case 2 : // 종합인력개발센터
			tv.setText("종합인력개발센터");
			m_cateGorySelect = m_cateGory[2];
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_manpowercenter_subtitle1);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			break;
		case 3 : // 부속기관
			tv.setText("부속기관");
			m_cateGorySelect = m_cateGory[3];
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_affiliate_subtitle1);
			m_Tc.content = getResources().getString(R.string.phone_affiliate_subtitle1_contents);
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_affiliate_subtitle2);
			m_Tc.content = getResources().getString(R.string.phone_affiliate_subtitle2_contents);
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_affiliate_subtitle3);
			m_Tc.content = getResources().getString(R.string.phone_affiliate_subtitle3_contents);
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_affiliate_subtitle4);
			m_Tc.content = getResources().getString(R.string.phone_affiliate_subtitle4_contents);
			m_arrayTc.add(m_Tc);
			break;
		case 4 : // 관련기관
			tv.setText("관련기관");
			m_cateGorySelect = m_cateGory[4];
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_organization_subtitle1);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_organization_subtitle2);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_organization_subtitle3);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_organization_subtitle4);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_organization_subtitle5);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_organization_subtitle6);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			
			m_Tc = new TitleDTO();
			m_Tc.title = getResources().getString(R.string.phone_organization_subtitle7);
			m_Tc.content = "";
			m_arrayTc.add(m_Tc);
			break;
		}
		
		LifeListAdapter lva = new LifeListAdapter(this, m_arrayTc);
		lv.setAdapter(lva);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				switch(m_Idx){
				case 0:
					for(int i=0; i<m_cateGory.length; i++){
						if(m_cateGorySelect.equals(m_cateGory[0])){
							Intent i2 = new Intent(getApplication(), Phone_Info_Sub.class);
							i2.putExtra("Phone_Info_Main", m_cateGorySelect+","+position);
							startActivity(i2);
							break;
						}
					}
					break;
				case 1:
					for(int i=0; i<m_cateGory.length; i++){
						if(m_cateGorySelect.equals(m_cateGory[1])){
							Intent i2 = new Intent(getApplication(), Phone_Info_Sub.class);
							i2.putExtra("Phone_Info_Main", m_cateGorySelect+","+position);
							startActivity(i2);
							break;
						}
					}
					break;
				case 2:
					for(int i=0; i<m_cateGory.length; i++){
						if(m_cateGorySelect.equals(m_cateGory[2])){
							Intent i2 = new Intent(getApplication(), Phone_Info_Sub.class);
							i2.putExtra("Phone_Info_Main", m_cateGorySelect+","+position);
							startActivity(i2);
							break;
						}
					}
					break;
				case 3:
					for(int i=0; i<m_cateGory.length; i++){
						if(m_cateGorySelect.equals(m_cateGory[3])){
							Intent i2 = new Intent(getApplication(), Phone_Info_Sub.class);
							i2.putExtra("Phone_Info_Main", m_cateGorySelect+","+position);
							startActivity(i2);
							break;
						}
					}
					break;
				case 4:
					for(int i=0; i<m_cateGory.length; i++){
						if(m_cateGorySelect.equals(m_cateGory[4])){
							Intent i2 = new Intent(getApplication(), Phone_Info_Sub.class);
							i2.putExtra("Phone_Info_Main", m_cateGorySelect+","+position);
							startActivity(i2);
							break;
						}
					}
					break;
				}
				
			}
		});
	}
	
	class LifeListAdapter extends BaseAdapter {
		private LayoutInflater inflater;
		ArrayList<TitleDTO> m_arrayTc = new ArrayList<TitleDTO>();
		TitleDTO m_Tc;
		
		LifeListAdapter(Context context,
				ArrayList<TitleDTO> m_arrayTc) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			this.m_arrayTc = m_arrayTc;
		}

		public int getCount() {
			// TODO Auto-generated method stub
			return m_arrayTc.size();
		}

		public TitleDTO getItem(int position) {
			// TODO Auto-generated method stub
			return m_arrayTc.get(position);
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public View getView(int position, View v, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			if (v == null) {
				if(m_Idx==0 || m_Idx==3){
					v = inflater.inflate(
							R.layout.introduce_phone_info_main_list_row, parent,
							false);
				}else{
					v = inflater.inflate(
							R.layout.introduce_phone_info_main_list_row2, parent,
							false);
				}
			}
				
			m_Tc = new TitleDTO();
			m_Tc = m_arrayTc.get(position);
			
			if(m_Idx==0 || m_Idx==3){
				TextView tv_str1 = (TextView) v.findViewById(R.id.introduce_phone_info_main_list_row_tv01);
				TextView tv_str2 = (TextView) v.findViewById(R.id.introduce_phone_info_main_list_row_tv02);
				if(tv_str1 != null || tv_str2 != null){
					tv_str1.setText(" " + m_Tc.title ); // 타이틀
					tv_str2.setText(m_Tc.content); // 내용
				}
			}else{
				m_Tc = new TitleDTO();
				m_Tc = m_arrayTc.get(position);
				TextView tv_str3 = (TextView) v.findViewById(R.id.introduce_phone_info_main_list_row_tv03);	
				tv_str3.setText(m_Tc.title); // 타이틀
			}

			return v;
		}
	}
}
