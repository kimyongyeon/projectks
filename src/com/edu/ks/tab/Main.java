package com.edu.ks.tab;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;

public class Main extends Activity implements OnClickListener{
	ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11, iv12, iv13, iv14;
	Intent i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Ÿ��Ʋ�� ���ֱ�
		setContentView(R.layout.main);
		iv1 = (ImageView) findViewById(R.id.imageView1);
		iv2 = (ImageView) findViewById(R.id.imageView2);
		iv3 = (ImageView) findViewById(R.id.imageView3);
		iv4 = (ImageView) findViewById(R.id.imageView4);
		iv5 = (ImageView) findViewById(R.id.imageView5);
		iv6 = (ImageView) findViewById(R.id.imageView6);
		iv7 = (ImageView) findViewById(R.id.imageView7);
		iv8 = (ImageView) findViewById(R.id.imageView8);
		iv9 = (ImageView) findViewById(R.id.imageView9);
		iv10 = (ImageView) findViewById(R.id.imageView10);
		iv11 = (ImageView) findViewById(R.id.imageView11);
		iv12 = (ImageView) findViewById(R.id.imageView12);
		iv13 = (ImageView) findViewById(R.id.imageView13);
		iv14 = (ImageView) findViewById(R.id.imageView14);
		
		iv1.setOnClickListener(this);
		iv2.setOnClickListener(this);
		iv3.setOnClickListener(this);
		iv4.setOnClickListener(this);
		iv5.setOnClickListener(this);
		iv6.setOnClickListener(this);
		iv7.setOnClickListener(this);
		iv8.setOnClickListener(this);
		iv9.setOnClickListener(this);
		iv10.setOnClickListener(this);
		iv11.setOnClickListener(this);
		iv12.setOnClickListener(this);
		iv13.setOnClickListener(this);
		iv14.setOnClickListener(this);
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
			case R.id.imageView1: // �а��ȳ�
				i = new Intent(getApplicationContext(), com.edu.ks.introduce.Hak_Info.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
				finish();
				break;
			case R.id.imageView2: // ��������
				i = new Intent(getApplicationContext(), com.edu.ks.life.Notice.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
				finish();
				break;
			case R.id.imageView3: // ķ�۽� �ҽ�
				i = new Intent(getApplicationContext(), com.edu.ks.life.Campus.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
				finish();
				break;
			case R.id.imageView4: // �л�����
				i = new Intent(getApplicationContext(), com.edu.ks.life.Schedule.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
				finish();
				break;
			case R.id.imageView5: // CTL
				i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ctl.bsks.ac.kr"));
				startActivity(i);
				break;
			case R.id.imageView6: // �л�����
				i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://daekan.bsgs.ac.kr/its/login.asp"));
				startActivity(i);
				break;
			case R.id.imageView7: // e�д�
				i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lms.bsks.ac.kr"));
				startActivity(i);
				break;
			case R.id.imageView8: // �Ϲε�����
				i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lib.bsks.ac.kr"));
				startActivity(i);
				break;
			case R.id.imageView9: // ķ�۽� ��
				i = new Intent(getApplicationContext(), com.edu.ks.introduce.Campus_Info.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
				finish();
				break;
			case R.id.imageView10: // ��ȭ��ȣ
				i = new Intent(getApplicationContext(), com.edu.ks.introduce.Phone_Info.class);
				startActivity(i);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				finish();
				break;
			case R.id.imageView11: // ���䰶����
				i = new Intent(getApplicationContext(), com.edu.ks.pr.Photo.class);
				startActivity(i);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				finish();
				break;
			case R.id.imageView12: // ��Ʋ����
				i = new Intent(getApplicationContext(), com.edu.ks.life.Bus.class);
				startActivity(i);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				finish();
				break;
			case R.id.imageView13: // �Ĵ�޴�
				i = new Intent(getApplicationContext(), com.edu.ks.life.FoodMenu.class);
				startActivity(i);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				finish();
				break;
			case R.id.imageView14: // �������
				i = new Intent(getApplicationContext(), com.edu.ks.job.Jobinfo.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
				finish();
				break;	
		}
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		end_Dialog();
	}
	
	// ���� ���̾�α�
	private void end_Dialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(getParent());
		builder.setTitle("����");
		builder.setMessage("�����Ͻðڽ��ϱ�?");
		DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// showMsg("which : "+ which);
				if (which == -1) {
					 finish();
				} else {

				}
			}
		};

		builder.setPositiveButton("��", listener);
		builder.setNegativeButton("�ƴϿ�", listener);
		builder.show();
	}
}
