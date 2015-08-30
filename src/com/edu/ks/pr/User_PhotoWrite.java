package com.edu.ks.pr;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.MediaColumns;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.ks.R;

public class User_PhotoWrite extends Activity {
	private static final int REQ_CODE_PICK_IMAGE = 0; 
	String filelocation;

	String lineEnd = "\r\n";
	String twoHyphens = "--";
	String boundary = "*****";
	Button bt1, bt2, bt3;
	EditText et1, et2, et3;

	public void postScript(String urlString, String fileName, String title,
			String contents) {
		try {
			// 파일 이름
			String data = URLEncoder.encode("Filename", "UTF-8") + "="
					+ URLEncoder.encode(fileName, "UTF-8") + "&";
			// 제목
			data += URLEncoder.encode("Title", "UTF-8") + "="
					+ URLEncoder.encode(title, "UTF-8") + "&";
			// 내용
			data += URLEncoder.encode("Contents", "UTF-8") + "="
					+ URLEncoder.encode(contents, "UTF-8");

			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn
					.getOutputStream());
			wr.write(data);
			wr.flush();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn
					.getInputStream()));
			String line;
			StringBuilder strRead = new StringBuilder();
			while ((line = rd.readLine()) != null) {
				strRead.append(line); // 결과 얻어오기
			}
			Log.e("Test", "param result = " + strRead);
			wr.close();
			rd.close();
		} catch (Exception e) {
		}
	}

	public void HttpFileUpload(String urlString, String params, String fileName) {
		try {
			// test
			int lastIndex = fileName.lastIndexOf("/");
			String strFileName = fileName.substring(lastIndex + 1, fileName
					.length());
			String strTitle = "";
			String strContents = "";

			FileInputStream mFileInputStream = new FileInputStream(fileName);
			URL connectUrl = new URL(urlString);
			Log.d("Test", "mFileInputStream  is " + mFileInputStream);

			// open connection
			HttpURLConnection conn = (HttpURLConnection) connectUrl
					.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");

			if (et1.getText().toString().equals("")
					&& et2.getText().toString().equals("")) {
				Toast.makeText(this, "제목 및 내용을 입력하세요.", 0).show();
				return;
			} else {
				strTitle = et1.getText().toString();
				strContents = et2.getText().toString();
			}
			// DB쓰기
			String url = "http://m.bsks.ac.kr/server/photo_db_write_script.asp";
			
			//Date today = new Date();
			Calendar cal = Calendar.getInstance();
			String dateString = String.format("%04d-%02d-%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
			String timeString = String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
			String today = dateString.replace("-", ".") + "." + timeString.replace(":", ".");
			Log.d("kimyongyeon", today);
			strFileName = today.toString() + "." + strFileName;
			
			postScript(url, strFileName, strTitle, strContents);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);
			// write data
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			dos.writeBytes(twoHyphens + boundary + lineEnd);
			dos.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\""
							+ strFileName + "\"" + lineEnd);
			dos.writeBytes(lineEnd);

			int bytesAvailable = mFileInputStream.available();
			int maxBufferSize = 1024;
			int bufferSize = Math.min(bytesAvailable, maxBufferSize);

			byte[] buffer = new byte[bufferSize];
			int bytesRead = mFileInputStream.read(buffer, 0, bufferSize);

			Log.d("Test", "image byte is " + bytesRead);

			// read image
			while (bytesRead > 0) {
				dos.write(buffer, 0, bufferSize);
				bytesAvailable = mFileInputStream.available();
				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				bytesRead = mFileInputStream.read(buffer, 0, bufferSize);
			}

			dos.writeBytes(lineEnd);
			dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

			// close streams
			Log.e("Test", "File is written");
			mFileInputStream.close();
			dos.flush(); // finish upload...

			// get response
			int ch;
			InputStream is = conn.getInputStream();
			StringBuffer b = new StringBuffer();
			while ((ch = is.read()) != -1) {
				b.append((char) ch);
			}
			String s = b.toString();
			Log.e("Test", "result = " + s);
			// mEdityEntry.setText(s);
			dos.close();

		} catch (Exception e) {
			Log.d("Test", "exception " + e.getMessage());
			// TODO: handle exception
		}
	}

	public void DoFileUpload(String apiUrl, String absolutePath) {
		HttpFileUpload(apiUrl, "", absolutePath);
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.pr_user_photowrite);

		bt1 = (Button) findViewById(R.id.pr_user_photowrite_bt1);
		bt2 = (Button) findViewById(R.id.pr_user_photowrite_bt2);
		bt3 = (Button) findViewById(R.id.pr_user_photowrite_bt3);

		et1 = (EditText) findViewById(R.id.pr_user_photowrite_et1);
		et2 = (EditText) findViewById(R.id.pr_user_photowrite_et2);
		et3 = (EditText) findViewById(R.id.pr_user_photowrite_et3);

		// 찾아보기
		bt1.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				getImagesFromSDCard();
			}
		});

		// 완료
		bt2.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				fileupload();
				Intent i = new Intent(getApplicationContext(),
						User_PhotoList.class);
				startActivity(i);
				finish();
			}
		});

		// 취소
		bt3.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						User_PhotoList.class);
				startActivity(i);
				finish();
			}
		});
	}

	private void fileupload() {
		Uri selPhotoUri = new Intent().getData();

		/*
		 * //나중에 이미지뷰에 뿌려주기 위해 담아놓음. try { Bitmap selPhoto =
		 * Images.Media.getBitmap( getContentResolver(), selPhotoUri ); } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */Log.e("kimyongyeon", "전송시작");

		String urlString = "http://m.bsks.ac.kr/server/photo_write_script.asp";

		// 절대경로를 획득한다!!! 중요~
		// Cursor c =
		// getContentResolver().query(Uri.parse(selPhotoUri.toString()),
		// null,null,null,null);
		// c.moveToNext();
		// String absolutePath =
		// c.getString(c.getColumnIndex(MediaStore.MediaColumns.DATA));
		//String absolutePath = "sdcard/DCIM/Camera/PHOTO_0130.jpg";
		//absolutePath = et3.getText().toString().trim();

		// 파일 업로드 시작!
		DoFileUpload(urlString, filelocation);
	}
	void getImagesFromSDCard() {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT, // ACTION_PICK
				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		intent.setType("image/*"); // all images
		startActivityForResult(intent, REQ_CODE_PICK_IMAGE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent imageData) {
		super.onActivityResult(requestCode, resultCode, imageData);

		switch (requestCode) {
		case REQ_CODE_PICK_IMAGE:
			if (resultCode == RESULT_OK) {

				if (imageData != null) {
					Uri photoUri = imageData.getData();

					filelocation = (getRealImagePath(photoUri));// 파일 패스를 얻는다
					int lastIndex = filelocation.lastIndexOf("/");

					String fileName = filelocation.substring(lastIndex + 1);
					// showMsg("a= "+fileName);
					//et3.setText(fileName);
					et3.setText(fileName);
					//showMsg("선택한 파일 위치: " + filelocation);

					// File file = new File(filelocation);
					// Long fileSize = file.length();
				}
			}
		}
	}

	public String getRealImagePath(Uri uriPath) {
		String[] proj = { MediaColumns.DATA };
		Cursor cursor = managedQuery(uriPath, proj, null, null, null);
		int index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);

		cursor.moveToFirst();

		String path = cursor.getString(index);
		path = path.substring(5);

		return path;
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent i = new Intent(getApplicationContext(), User_PhotoList.class);
		startActivity(i);
		finish();
	}
}
