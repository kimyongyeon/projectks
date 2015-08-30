package com.edu.ks.tab;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;
import com.edu.ks.introduce.Campus_Info;
import com.edu.ks.introduce.Greet;
import com.edu.ks.introduce.Hak_Info;
import com.edu.ks.introduce.Phone_Info;
import com.edu.ks.introduce.Vision;
import com.edu.ks.introduce.WebCam;

public class Introduce extends Activity {
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intro.gubunView = 0;
		Intent i = new Intent(getApplicationContext(), Tab.class);
		startActivity(i);
		finish();
	}

	ListView lv;
	TitleDTO t;
	ArrayList<TitleDTO> ar = new ArrayList<TitleDTO>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Ÿ��Ʋ�� ���ֱ�
		setContentView(R.layout.sub_menu);

		lv = (ListView) findViewById(R.id.com_edu_ks_tab_sub_menu_lv01);
		TextView tv = (TextView) findViewById(R.id.sub_menu_textview);
		tv.setText("���мҰ�");
		t = new TitleDTO();
		t.title = "�����λ縻";
		ar.add(t);
		t = new TitleDTO();
		t.title = "�����̳� �� ����";
		ar.add(t);
		t = new TitleDTO();
		t.title = "�а��ȳ�";
		ar.add(t);
		t = new TitleDTO();
		t.title = "ķ�۽� �ȳ�";
		ar.add(t);
		t = new TitleDTO();
		t.title = "��ȭ��ȣ �ȳ�";
		ar.add(t);
		/*t = new TitleDTO();
		t.title = "�ǽð� ��ķ";
		ar.add(t);*/

		LifeListAdapter lva = new LifeListAdapter(this, ar);
		lv.setAdapter(lva);

		// �Խñ� Ŭ���� �߻� �̺�Ʈ ó��
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent i;
				t = ar.get(position);
				// �������� Ŭ����
				if (t.title.equals("�����λ縻")) {
					i = new Intent(getApplicationContext(), Greet.class);
					startActivity(i);
					finish();
				} else if (t.title.equals("�����̳� �� ����")) {
					i = new Intent(getApplicationContext(), Vision.class);
					startActivity(i);
					finish();
				} else if (t.title.equals("�а��ȳ�")) {
					i = new Intent(getApplicationContext(), Hak_Info.class);
					startActivity(i);
					finish();
				} else if (t.title.equals("ķ�۽� �ȳ�")) {
					i = new Intent(getApplicationContext(), Campus_Info.class);
					startActivity(i);
					finish();
				} else if (t.title.equals("��ȭ��ȣ �ȳ�")) {
					i = new Intent(getApplicationContext(), Phone_Info.class);
					startActivity(i);
					finish();
				} /*else if (t.title.equals("�ǽð� ��ķ")) {
					i = new Intent(getApplicationContext(), WebCam.class);
					startActivity(i);
					finish();
				}*/
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

		LifeListAdapter(Context context, ArrayList<TitleDTO> arrTitle) {
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
				v = inflater.inflate(R.layout.sub_menu_row, parent, false);
			}

			// ImageView lv_img1 =
			// (ImageView)v.findViewById(R.id.com_edu_ks_tab_sub_menu_row_iv01);
			TextView tv_str1 = (TextView) v
					.findViewById(R.id.com_edu_ks_tab_sub_menu_row_tv01);
			ImageView lv_img1 = (ImageView) v
					.findViewById(R.id.com_edu_ks_tab_sub_menu_row_iv02);

			mTitle = new TitleDTO();
			mTitle = arrTitle.get(position);
			if (mTitle != null) {
				tv_str1.setText(mTitle.title);
				switch (position) {
				case 0:
					lv_img1.setImageResource(R.drawable.subicon_08);
					break;
				case 1:
					lv_img1.setImageResource(R.drawable.subicon_17);
					break;
				case 2:
					lv_img1.setImageResource(R.drawable.subicon_01);
					break;
				case 3:
					lv_img1.setImageResource(R.drawable.subicon_13);
					break;
				case 4:
					lv_img1.setImageResource(R.drawable.subicon_14);
					break;
				case 5:
					lv_img1.setImageResource(R.drawable.subicon_11);
					break;	
				}
			}

			return v;
		}

	}
}
