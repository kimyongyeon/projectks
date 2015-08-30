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
import com.edu.ks.Tab;
import com.edu.ks.dao.XmlParse;
import com.edu.ks.dto.FoodMenu_Item;

public class FoodMenu extends Activity{
	ListView lv;
	TitleDTO t;
	ArrayList<TitleDTO> ar = new ArrayList<TitleDTO>();
	
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
		setContentView(R.layout.life_foodmenu);
		Intro.gubunView = 2;
		
		lv = (ListView)findViewById(R.id.life_foodmenu_lv01);
		
		XmlParse xml = new XmlParse();
		ArrayList<FoodMenu_Item> arrayFm = xml.getXml_foodMenulistAddr();
		FoodMenu_Item fm;
		for(int i=0; i<arrayFm.size(); i++){
			fm = new FoodMenu_Item();
			fm = arrayFm.get(i);
			if(fm.getDay() != null && 
			   fm.getReg_date() != null && 
			   fm.getContent() != null){
				t = new TitleDTO();
				t.title = fm.getDay() + "   (" + fm.getReg_date() +")";
				t.contents = fm.getContent();
				ar.add(t);
			}
		}
		
		LifeListAdapter lva = new LifeListAdapter(this, ar);
		lv.setAdapter(lva);
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
						R.layout.life_foodmenu_row, parent,
						false);
			}

			TextView tv_str1 = (TextView) v.findViewById(R.id.life_foodmenu_row_tv01);
			TextView tv_str2 = (TextView) v.findViewById(R.id.life_foodmenu_row_tv02);

			mTitle = new TitleDTO();
			mTitle = arrTitle.get(position);
			if (mTitle != null) {
				tv_str1.setText(mTitle.title); 
				String temp = mTitle.contents.replace("<br>", "\n");
				tv_str2.setText(temp);
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
