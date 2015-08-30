package com.edu.ks.admission;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;

public class GuideLine extends Activity {
	// m.bsks.ac.kr/server/pdsdown.asp?downfilename=BSKS2012.hwp
	Button bt;
	private WebView wv;
	private WebSettings ws;
	final Activity activity = this;
	ProgressDialog mProgress;

	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		}
		return false;
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.admission_guideline);
		Intro.gubunView = 4;

		bt = (Button) findViewById(R.id.admission_guideline_bt); // 다운로드
		bt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				progressbar();
				// TODO Auto-generated method stub
				/*try {
					//downloadFile("http://dalparan777.cafe24.com/apps/server/pdsdown.asp?downfilename=BSKS2012.hwp");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		});

		// 모집요강 사용
		if (isOnline() != false) {
			wv = (WebView) findViewById(R.id.admission_guideline_WebView01);
			ws = wv.getSettings();
			// Zoom을 지원할지 지정합니다. ws.setSupportZoom(true); // WebView에 내장된
			// zoom mechanism이 사용되고 있으면 treu를 돌려 줍니다.
			ws.setBuiltInZoomControls(true);
			ws.setUseWideViewPort(true);
			wv.getSettings().setJavaScriptEnabled(true);
			wv.setHorizontalScrollBarEnabled(false); //
			wv.setWebViewClient(new InfoWebViewClient()); // 중요
			String data = Intro.mainPath + "/tpl/yogang.html";
			Log.d("kimyongyeon", data);
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

	ProgressDialog dialog;

	public void progressbar(){
		Thread t =
			new Thread(new Runnable() {
				public void run() {
					try {
						//String path = "http://m.bsks.ac.kr/hwp/BSKS2012.pdf";
						String path = "http://dalparan777.cafe24.com/apps/hwp/BSKS2012.pdf";
						downloadFile(path);
						dialog.dismiss();
					} catch (Exception e) {
					}
				}

			});
		try{
			dialog = ProgressDialog.show(this, "다운로드", 
					"잠시만 기다려 주세요...!", true);
			t.start();
		}catch(Exception e){}
	}
	
	public void writeFile(InputStream is, OutputStream os) throws IOException {
		int c = 0;
		while ((c = is.read()) != -1){
			os.write(c);
		}
		
		os.flush();
	}

	private void downloadFile(String fileUrl) throws IOException {

		InputStream inputStream = new URL(fileUrl).openStream();
		FileOutputStream fos;
		String mPath = "/mnt/sdcard/ks.pdf";
		File f = new File(mPath);
		/*if (f.createNewFile()) {
			fos = new FileOutputStream(f);
			int read;
			while ((read = inputStream.read()) != -1) {
				fos.write(read);
			}
			fos.close();
		}*/
		OutputStream out = new FileOutputStream(f);
		//OutputStream out = this.openFileOutput("ks.pdf", Context.MODE_PRIVATE);
		writeFile(inputStream, out);
		out.close();

		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setDataAndType(Uri.fromFile(f), "application/pdf");
		try {
			startActivity(intent);
		} catch (ActivityNotFoundException e) {
			// kr.co.hancom.hancomviewer.androidmarket
			String str = "kr.co.hancom.hancomviewer.androidmarket";
			Uri uri = Uri.parse("market://details?id=" + str);
			intent = new Intent(Intent.ACTION_VIEW, uri);  
			startActivity(intent); 
			Toast.makeText(this, "한글뷰어를 설치하시오.", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
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
