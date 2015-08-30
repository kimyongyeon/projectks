package com.edu.ks.pr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

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
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;
import com.edu.ks.introduce.Campus_Info;
import com.edu.ks.introduce.Greet;
import com.edu.ks.introduce.Hak_Info;
import com.edu.ks.introduce.Vision;
import com.edu.ks.introduce.WebCam;

public class Ucc extends Activity{
	private WebView wv;
	private WebSettings ws;
	final Activity activity = this;
	ProgressDialog mProgress;
	
	public boolean onKeyDown(int keyCode, KeyEvent event) { 
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) { 
        	wv.goBack(); 
            return true; 
        }else{
        	Intent i = new Intent(getApplicationContext(), Tab.class);
			startActivity(i);
			finish();
        }
        return super.onKeyDown(keyCode, event); 
    } 

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
		setContentView(R.layout.ucc);
		Intro.gubunView = 3;
		
		//tv = (TextView) findViewById(R.id.boardDetail_textview);
		
		if (isOnline() != false) {
			wv = (WebView) findViewById(R.id.Ucc_WebView01);
			ws = wv.getSettings();
			// Zoom을 지원할지 지정합니다. ws.setSupportZoom(true); // WebView에 내장된
			// zoom mechanism이 사용되고 있으면 treu를 돌려 줍니다.
			ws.setBuiltInZoomControls(true);
			ws.setUseWideViewPort(true);
			wv.getSettings().setJavaScriptEnabled(true);
			wv.setHorizontalScrollBarEnabled(false); //
			wv.setWebViewClient(new InfoWebViewClient()); // 중요
			String data="http://m.bsks.ac.kr/server/app_promotion_ucc.html";
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

			// 안드로이드 자체 WebView가 아닌 내가 만든 WebView 직접 사용한다고 명시
			if (url.startsWith("http://")) {
				Uri uri = Uri.parse(url);
			    Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			    it.setDataAndType(uri, "video/mp4");
			    startActivity(it);
			    return true;
			}
			/*if (url.startsWith("http")) {
				downloadFile(url);	
			}*/
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
			/*Toast.makeText(activity, "Loading Error" + description,
					Toast.LENGTH_SHORT).show();*/

			if (mProgress.isShowing()) {
				mProgress.dismiss();
			}

		}
	}
	
	private void downloadFile(String fileUrl){
        URL myFileUrl =null;          
        try {
             myFileUrl= new URL(fileUrl);
        } catch (MalformedURLException e) {
             e.printStackTrace();
        }
        String path2="";
        try {
             HttpURLConnection conn= (HttpURLConnection)myFileUrl.openConnection();
             conn.setDoInput(true);
             conn.connect();
             InputStream is = conn.getInputStream();

		 // 다운 받는 파일의 경로는 sdcard/ 아래 이다. 단, sdcard에 접근하려면 uses-permission에 android.permission.WRITE_EXTERNAL_STORAGE을 추가해야한다.
             String mPath = "download/ks.hwp";
             path2 = mPath;
             FileOutputStream fos;
             File f = new File(mPath);
             if ( f.createNewFile() ) {
	                fos = new FileOutputStream(mPath);   
	                int read;
	                while ( (read =  is.read()) != -1) {
	             	    fos.write(read);
	                }
	                fos.close();
             }

        } catch (IOException e) {
             e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), path2 + "위치에서 파일을 클릭하여 입시요강을 보시면 됩니다.", 0).show();

        File hwp = new File(Environment.getExternalStorageDirectory()+ "/ks.hwp");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType( Uri.fromFile(hwp), "application/vnd.android.package-archive");
        startActivity(intent);
   }

}
