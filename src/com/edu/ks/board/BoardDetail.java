package com.edu.ks.board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
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
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;
import com.edu.ks.introduce.Hak_Info;

public class BoardDetail extends Activity {
	private WebView wv;
	private WebSettings ws;
	final Activity activity = this;
	ProgressDialog mProgress;
	private TextView tv;
	private int m_Gubun;
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		if(m_Gubun == 6 && m_Gubun < 29){
			Intro.gubunView = 1;
			Intent i = new Intent(getApplicationContext(), Hak_Info.class);
			startActivity(i);
			finish();
		}else if(m_Gubun == 29){
			Intro.gubunView = 4;
			Intent i = new Intent(getApplicationContext(), Tab.class);
			startActivity(i);
			finish();
		}else{
			if(m_Gubun == 0){
				// ��������
				Intent i = new Intent(getApplicationContext(), com.edu.ks.life.Notice.class);
				i.putExtra("BoardDetail", "true");
				startActivity(i);
				finish();				
			}
			if(m_Gubun == 1){
				// ���а�������
				Intent i = new Intent(getApplicationContext(), com.edu.ks.admission.Notice.class);
				i.putExtra("BoardDetail", "true");
				startActivity(i);
				finish();							
			}
			if(m_Gubun == 2){
				// Q&A
				Intent i = new Intent(getApplicationContext(), com.edu.ks.admission.QnA.class);
				i.putExtra("BoardDetail", "true");
				startActivity(i);
				finish();				
			}
			if(m_Gubun == 3){
				// ķ�۽��ҽ�
				Intent i = new Intent(getApplicationContext(), com.edu.ks.life.Campus.class);
				i.putExtra("BoardDetail", "true");
				startActivity(i);
				finish();				
			}
			if(m_Gubun == 4){
				// �������
				Intent i = new Intent(getApplicationContext(), com.edu.ks.job.Jobinfo.class);
				i.putExtra("BoardDetail", "true");
				startActivity(i);
				finish();				
			}
			if(m_Gubun == 5){
				// ���䰶����
				Intent i = new Intent(getApplicationContext(), com.edu.ks.pr.Photo.class);
				startActivity(i);
				finish();				
			}
		}
	}

	String strURL[] = {
			// �󼼺���
			Intro.mainPath + "/server/app_common_view.asp?db=recom&num=",
			Intro.mainPath + "/server/app_common_view.asp?db=enternotice&num=",
			Intro.mainPath + "/server/app_common_view.asp?db=qna20&num=",
			Intro.mainPath + "/server/app_common_view.asp?db=newnlife&num=",
			Intro.mainPath + "/server/app_common_view.asp?db=career_recuruit&num=",
			Intro.mainPath + "/server/app_photo_view.asp?db=photo01&num=",

			// �а��Ұ�
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
			Intro.mainPath + "/tpl/depart_23.html",
			
			// �����䰭
			Intro.mainPath + "/tpl/yogang.html"
			
			/*
			// ��ȭ��ȣ
			Intro.mainPath + "/app_mobile/tpl/tel_01.html", // 29
			Intro.mainPath + "/app_mobile/tpl/tel_02.html",
			Intro.mainPath + "/app_mobile/tpl/tel_03.html",
			Intro.mainPath + "/app_mobile/tpl/tel_04.html",
			Intro.mainPath + "/app_mobile/tpl/tel_05.html"*/
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
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Ÿ��Ʋ�� ���ֱ�
		setContentView(R.layout.board_detail);
		
		tv = (TextView) findViewById(R.id.boardDetail_textview);
		
		Intent i = getIntent();
		String index = i.getStringExtra("Board");
		String temp[] = index.split(",");
		int gubun = Integer.parseInt(temp[1]);
		m_Gubun = gubun;
		String seq = temp[0];
		
		if (isOnline() != false) {
			wv = (WebView) findViewById(R.id.WebView01);
			ws = wv.getSettings();
			// Zoom�� �������� �����մϴ�. ws.setSupportZoom(true); // WebView�� �����
			// zoom mechanism�� ���ǰ� ������ treu�� ���� �ݴϴ�.
			ws.setBuiltInZoomControls(true);
			ws.setUseWideViewPort(true);
			wv.getSettings().setJavaScriptEnabled(true);
			wv.setHorizontalScrollBarEnabled(false); //
			wv.setWebViewClient(new InfoWebViewClient()); // �߿�
			String data="";
			if(gubun<6){
				tv.setText("�󼼺���");
				data = strURL[gubun] + seq + "&pageno=1&startpage=1";
			}else{
				if(gubun<29){
					tv.setText("�а��Ұ�");
					//Log.d("kimyongyeon", gubun + "");
					data = strURL[gubun];
				}else{
					//tv.setText("��ȭ��ȣ �ȳ�");
					//Log.d("kimyongyeon", gubun + "");
					//data = strURL[gubun];
					
					tv.setText("�����䰭");
					//Log.d("kimyongyeon", gubun + "");
					data = strURL[gubun];
				}
			}
			Log.d("kimyongyeon", data);
			wv.loadUrl(data);
		}
	}

	class InfoWebViewClient extends WebViewClient {
		/**
		 * url �ּҿ� �ش��ϴ� ���������� �ε�
		 */
		
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);

			// �ȵ���̵� ��ü WebView�� �ƴ� ���� ���� WebView ���� ����Ѵٰ� ���
			/*if (url.startsWith("tel:")) {
			    Intent call_phone = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			    startActivity(call_phone);
			    return true;
			}*/
			if (url.startsWith("http")) {
				try {
					downloadFile(url);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
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
	
	private void downloadFile(String fileUrl) throws MalformedURLException, IOException{
		
		InputStream inputStream = new URL(fileUrl).openStream();
		FileOutputStream fos;
		String mPath = "/mnt/sdcard/download/ks.hwp";
		File f = new File(mPath);
		//if (f.createNewFile()) {
		//	fos = new FileOutputStream(f);
		//	int read;
		//	while ((read = inputStream.read()) != -1) {
		//		fos.write(read);
		//	}
		//	fos.close();
		//}
		OutputStream out = new FileOutputStream(f);
		writeFile(inputStream, out);
		out.close();

		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setDataAndType(Uri.fromFile(f), "application/hwp");
		try {
			startActivity(intent);
		} catch (ActivityNotFoundException e) {
			// kr.co.hancom.hancomviewer.androidmarket
			/*String str = "kr.co.hancom.hancomviewer.androidmarket";
			Uri uri = Uri.parse("market://details?id=" + str);
			intent = new Intent(Intent.ACTION_VIEW, uri);  
			startActivity(intent); 
			Toast.makeText(this, "�ѱۺ� ��ġ�Ͻÿ�.", Toast.LENGTH_SHORT).show();*/
			e.printStackTrace();
		}
		
        /*URL myFileUrl =null;          
        try {
             myFileUrl= new URL(fileUrl);
        } catch (MalformedURLException e) {
             e.printStackTrace();
        }
        String path2="";
        File f = null;
        try {
             HttpURLConnection conn= (HttpURLConnection)myFileUrl.openConnection();
             conn.setDoInput(true);
             conn.connect();
             InputStream is = conn.getInputStream();

		 // �ٿ� �޴� ������ ��δ� sdcard/ �Ʒ� �̴�. ��, sdcard�� �����Ϸ��� uses-permission�� android.permission.WRITE_EXTERNAL_STORAGE�� �߰��ؾ��Ѵ�.
             String mPath = "/mnt/sdcard/download/ks.hwp";
             path2 = mPath;
             FileOutputStream fos;
             f = new File(mPath);
             if ( f.createNewFile() ) {
	                fos = new FileOutputStream(f);   
	                int read;
	                while ( (read =  is.read()) != -1) {
	             	    fos.write(read);
	                }
	                fos.close();
             }
             OutputStream out = new FileOutputStream(f);
     		 writeFile(is, out);
     		 out.close();

        } catch (IOException e) {
             e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), path2 + "��ġ���� ������ Ŭ���Ͽ� �Խÿ䰭�� ���ø� �˴ϴ�.", 0).show();

        //File hwp = new File(Environment.getExternalStorageDirectory()+ "/ks.hwp");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType( Uri.fromFile(f), "application/hwp");
        startActivity(intent);*/
   }
	
	public void writeFile(InputStream is, OutputStream os) throws IOException {
		int c = 0;
		while ((c = is.read()) != -1)
			os.write(c);
		os.flush();
	}



}
