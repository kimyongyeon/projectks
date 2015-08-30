package com.edu.ks.pr;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;
import com.edu.ks.board.BoardDetail;
import com.edu.ks.dao.PhotoBoard;
import com.edu.ks.dao.PhotoBoardAdapter;
import com.edu.ks.dto.Board_Param;
import com.edu.ks.dto.Photo_Board;

public class User_PhotoList extends Activity {
	private WebView wv;
	private WebSettings ws;
	final Activity activity = this;
	ProgressDialog mProgress;

	private TextView tv1;
	// ������
	//private Spinner sp;
	private Button bt, bt2;
	//private EditText et;
	//private String spItem[] = { "����", "�۾���" };
	private String titleGubun;

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
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Ÿ��Ʋ�� ���ֱ�
		setContentView(R.layout.pr_user_photolist);
		Intro.gubunView = 3;
		Photo.GsearchGubun = 2;
		tv1 = (TextView) findViewById(R.id.pr_user_photolist_textview);
		// ������
		//sp = (Spinner) findViewById(R.id.pr_user_photolist_spinner);
		//bt = (Button) findViewById(R.id.pr_user_photolist_button1);
		bt2 = (Button) findViewById(R.id.pr_user_photolist_button2);
		
		if (isOnline() != false) {
			wv = (WebView) findViewById(R.id.pr_user_photolist_Wv01);
			ws = wv.getSettings();
			// Zoom�� �������� �����մϴ�. ws.setSupportZoom(true); // WebView�� �����
			// zoom mechanism�� ���ǰ� ������ treu�� ���� �ݴϴ�.
			ws.setBuiltInZoomControls(true);
			ws.setUseWideViewPort(true);
			wv.getSettings().setJavaScriptEnabled(true);
			wv.setHorizontalScrollBarEnabled(false); //
			wv.setWebViewClient(new InfoWebViewClient()); // �߿�
			String data = "http://m.bsks.ac.kr/server/app_user_photo_list.asp?db=user_photo";
			Log.d("kimyongyeon", data);
			wv.loadUrl(data);
		}
		
		/*// �˻�
		bt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						PhotoSearch.class);
				startActivity(i);
				finish();
			}
		});*/
		

		// ����
		bt2.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						User_PhotoWrite.class);
				startActivity(i);
				finish();
			}
		});

		//et = (EditText) findViewById(R.id.pr_user_photolist_edittext);

		tv1.setText("BSKS �����̺�Ʈ!");

		/*ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, spItem);
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/
		
/*		bt.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				// Ű���� ����
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
			}
		});*/
	}

	class InfoWebViewClient extends WebViewClient {
		/**
		 * url �ּҿ� �ش��ϴ� ���������� �ε�
		 */

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);

			// �ȵ���̵� ��ü WebView�� �ƴ� ���� ���� WebView ���� ����Ѵٰ� ���
			/*
			 * if (url.startsWith("tel:")) { Intent call_phone = new
			 * Intent(Intent.ACTION_VIEW, Uri.parse(url));
			 * startActivity(call_phone); return true; }
			 */
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

/*	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent i = new Intent(getApplicationContext(), Tab.class);
		startActivity(i);
		finish();
	}*/
}
