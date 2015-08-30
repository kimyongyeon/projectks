package com.edu.ks.introduce;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.edu.ks.Intro;
import com.edu.ks.R;

public class Hak_Info_Sub extends Activity {
	private WebView wv;
	private WebSettings ws;
	final Activity activity = this;
	ProgressDialog mProgress;
	private TextView tv;
	private Button bt1, bt2;
	private int m_Gubun;

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intro.gubunView = 1;
		Intent i = new Intent(getApplicationContext(), Hak_Info.class);
		startActivity(i);
		finish();
	}

	String strURL[] = {
			// 학과소개
			Intro.mainPath + "/tpl/depart_01.html", // 6
			Intro.mainPath + "/tpl/depart_02.html",
			Intro.mainPath + "/tpl/depart_03.html",
			Intro.mainPath + "/tpl/depart_04.html",
			Intro.mainPath + "/tpl/depart_05.html",
			Intro.mainPath + "/tpl/depart_06.html",
			Intro.mainPath + "/tpl/depart_07.html",
			Intro.mainPath + "/tpl/depart_08.html",
			Intro.mainPath + "/tpl/depart_09.html",
			Intro.mainPath + "/tpl/depart_10.html",
			Intro.mainPath + "/tpl/depart_11.html",
			Intro.mainPath + "/tpl/depart_12.html",
			Intro.mainPath + "/tpl/depart_13.html",
			Intro.mainPath + "/tpl/depart_14.html",
			Intro.mainPath + "/tpl/depart_15.html",
			Intro.mainPath + "/tpl/depart_16.html",
			Intro.mainPath + "/tpl/depart_17.html",
			Intro.mainPath + "/tpl/depart_18.html",
			Intro.mainPath + "/tpl/depart_19.html",
			Intro.mainPath + "/tpl/depart_20.html",
			Intro.mainPath + "/tpl/depart_21.html",
			Intro.mainPath + "/tpl/depart_22.html",
			Intro.mainPath + "/tpl/depart_23.html", };
	
	String strHomepage[] ={
			"http://biz.bsks.ac.kr/",
			"http://tax.bsks.ac.kr/",
			"http://itrade.bsks.ac.kr/",
			"http://sds.bsks.ac.kr/",
			"http://re.bsks.ac.kr/",
			"http://apr.bsks.ac.kr/",
			"http://chinese.bsks.ac.kr/",
			"http://kangaroo.bsks.ac.kr/",
			"http://police.bsks.ac.kr/",
			"http://119.bsks.ac.kr/",
			"http://mi.bsks.ac.kr/",
			"http://swpa.bsks.ac.kr/",
			"http://child.bsks.ac.kr/",
			"http://jp.bsks.ac.kr/",
			"http://eng.bsks.ac.kr/",
			"http://ht.bsks.ac.kr/",
			"http://magicbox.bsks.ac.kr/",
			"http://mc.bsks.ac.kr/zbxe/",
			"http://dv.bsks.ac.kr/",
			"http://star.bsks.ac.kr/",
			"http://sports.bsks.ac.kr/",
			"http://fnb.bsks.ac.kr/",
			"http://di.bsks.ac.kr/"
	};
	
	String strPhoneNumber[] = {
		"tel:051-850-1216",
		"tel:051-850-1217",
		"tel:051-850-1218",
		"tel:051-850-1306",
		"tel:051-850-1136",
		"tel:051-850-1105",
		"tel:051-850-1232",
		"tel:051-850-1133",
		"tel:051-850-1285",
		"tel:051-850-1116",
		"tel:051-850-1305",
		"tel:051-850-1220",
		"tel:051-850-1219",
		"tel:051-850-1221",
		"tel:051-850-1222",
		"tel:051-850-1223",
		"tel:051-850-1224",
		"tel:051-850-1226",
		"tel:051-850-1183",
		"tel:051-850-1000",
		"tel:051-850-1189",
		"tel:051-850-1308",
		"tel:051-850-1227"
	};

	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}
		return false;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.introduce_hak_info_sub);

		tv = (TextView) findViewById(R.id.introduce_hak_info_sub_textview);
		bt1 = (Button) findViewById(R.id.introduce_hak_info_sub_bt1);
		bt2 = (Button) findViewById(R.id.introduce_hak_info_sub_bt2);

		Intent i = getIntent();
		String temp = i.getStringExtra("Hak_Info");
		int gubun = Integer.parseInt(temp);
		m_Gubun = gubun;
		
		
		bt1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//홈페이지 이동
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(strHomepage[m_Gubun]));
				startActivity(i);																													
			}
		});
		
		bt2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 전화걸기
				Intent call_phone = new Intent(Intent.ACTION_VIEW, Uri.parse(strPhoneNumber[m_Gubun]));
			    startActivity(call_phone);
			}
		});

		if (isOnline() != false) {
			wv = (WebView) findViewById(R.id.introduce_hak_info_sub_WebView01);
			ws = wv.getSettings();
			ws.setBuiltInZoomControls(true);
			ws.setUseWideViewPort(true);
			wv.getSettings().setJavaScriptEnabled(true);
			wv.setHorizontalScrollBarEnabled(false); //
			wv.setWebViewClient(new InfoWebViewClient()); // 중요
			String data = "";
			tv.setText("학과소개");
			data = strURL[gubun];
			// Log.d("kimyongyeon", data);
			wv.loadUrl(data);
		}
	}

	class InfoWebViewClient extends WebViewClient {
		/**
		 * url 주소에 해당하는 웹페이지를 로딩
		 */

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return super.shouldOverrideUrlLoading(view, url);
		}

		@Override
		public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
			// TODO Auto-generated method stub
			finish();
			return super.shouldOverrideKeyEvent(view, event);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			if (mProgress.isShowing()) {
				mProgress.dismiss();
			}

		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			if (mProgress == null) {
				mProgress = new ProgressDialog(activity);
				mProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				mProgress.setTitle("Loading...");
				mProgress.setMessage("Please wait for few second...");
				mProgress.setCancelable(false);
				mProgress.setButton("Cancel",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int whichButton) {
								mProgress.dismiss();
							}
						});

			}
		}

		@Override
		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			// TODO Auto-generated method stub
			/*
			 * Toast.makeText(activity, "Loading Error" + description,
			 * Toast.LENGTH_SHORT).show();
			 */

			if (mProgress.isShowing()) {
				mProgress.dismiss();
			}

		}
	}
}
