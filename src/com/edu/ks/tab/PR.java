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
import com.edu.ks.pr.Janmain;
import com.edu.ks.pr.Photo;
import com.edu.ks.pr.Sns;
import com.edu.ks.pr.Ucc2;
import com.edu.ks.pr.User_PhotoList;

public class PR extends Activity {
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
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Ÿ��Ʋ�� ���ֱ�
		setContentView(R.layout.sub_menu);

		lv = (ListView) findViewById(R.id.com_edu_ks_tab_sub_menu_lv01);
		TextView tv = (TextView) findViewById(R.id.sub_menu_textview);
		tv.setText("ȫ����");
		t = new TitleDTO();
		t.title = "ȫ��������";
		ar.add(t);
		t = new TitleDTO();
		t.title = "���䰶����";
		ar.add(t);
		t = new TitleDTO();
		t.title = "BSKS �����̺�Ʈ!";
		ar.add(t);
		t = new TitleDTO();
		t.title = "�ڶ����� �ܸ���";
		ar.add(t);
		t = new TitleDTO();
		t.title = "�ܸ� UCC";
		ar.add(t);
		t = new TitleDTO();
		t.title = "SNS";
		ar.add(t);

		LifeListAdapter lva = new LifeListAdapter(this, ar);
		lv.setAdapter(lva);

		// �Խñ� Ŭ���� �߻� �̺�Ʈ ó��
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent i;
				t = ar.get(position);
				// �������� Ŭ����
				if (t.title.equals("ȫ��������")) {
					// i = new Intent(getApplicationContext(), Video.class);
					// startActivity(i);
					// finish();
					i = new Intent(Intent.ACTION_VIEW, Uri
							.parse("http://www.youtube.com/embed/fmACrBQDa48"));
					startActivity(i);
					// "http://www.youtube.com/embed/fmACrBQDa48"
				} else if (t.title.equals("���䰶����")) {
					i = new Intent(getApplicationContext(), Photo.class);
					startActivity(i);
					finish();
				} else if (t.title.equals("BSKS �����̺�Ʈ!")) {
					i = new Intent(getApplicationContext(),
							User_PhotoList.class);
					startActivity(i);
					finish();
				} else if (t.title.equals("�ڶ����� �ܸ���")) {
					i = new Intent(getApplicationContext(), Janmain.class);
					startActivity(i);
					finish();
				} else if (t.title.equals("�ܸ� UCC")) {
					i = new Intent(getApplicationContext(), com.edu.ks.pr.Ucc2.class);
					startActivity(i);
					finish();
				} else if (t.title.equals("SNS")) {
					i = new Intent(getApplicationContext(), Sns.class);
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

			ImageView lv_img1 = (ImageView) v
					.findViewById(R.id.com_edu_ks_tab_sub_menu_row_iv02);
			TextView tv_str1 = (TextView) v
					.findViewById(R.id.com_edu_ks_tab_sub_menu_row_tv01);

			mTitle = new TitleDTO();
			mTitle = arrTitle.get(position);
			if (mTitle != null) {
				tv_str1.setText(mTitle.title);
				switch (position) {
				case 0:
					lv_img1.setImageResource(R.drawable.subicon_06);
					break;
				case 1:
					lv_img1.setImageResource(R.drawable.gallery);
					break;
				case 2:
					lv_img1.setImageResource(R.drawable.subicon_15);
					break;
				case 3:
					lv_img1.setImageResource(R.drawable.subicon_05);
					break;
				case 4:
					lv_img1.setImageResource(R.drawable.subicon_11);
					break;
				case 5:
					lv_img1.setImageResource(R.drawable.subicon_19);
					break;	
				}
			}

			return v;
		}

	}
}
