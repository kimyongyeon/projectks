package com.edu.ks.introduce;

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
import com.edu.ks.board.BoardDetail;

public class Phone_Info extends Activity{
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
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Ÿ��Ʋ�� ���ֱ�
		setContentView(R.layout.introduce_phone_info_menu);
		Intro.gubunView = 1;
		lv = (ListView)findViewById(R.id.introduce_phone_info_menu_lv01);
		String item[] = getResources().getStringArray(R.array.phone_title);
		for(int i=0; i<item.length; i++){
			t = new TitleDTO();
			t.title = item[i];
			ar.add(t);
		}
		LifeListAdapter lva = new LifeListAdapter(this, ar);
		lv.setAdapter(lva);
		
		// �Խñ� Ŭ���� �߻� �̺�Ʈ ó��
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent intent = new Intent(getApplication(), Phone_Info_Main.class);
				intent.putExtra("Phone_Info", position+"");
				startActivity(intent);
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
						R.layout.introduce_phone_info_menu_row, parent,
						false);
			}

			//ImageView lv_img1 = (ImageView)v.findViewById(R.id.LifeRow_Iv01);
			TextView tv_str1 = (TextView) v.findViewById(R.id.introduce_phone_info_menu_row_tv01);
			//ImageView lv_img2 = (ImageView)v.findViewById(R.id.LifeRow_Iv02);

			mTitle = new TitleDTO();
			mTitle = arrTitle.get(position);
			if (mTitle != null) {
				//lv_img1.setImageResource(R.drawable.no_image); // ����
				tv_str1.setText(mTitle.title); // �۾��ð�
				//lv_img2.setImageResource(R.drawable.no_image); // ��ȭ�ϱ�
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
