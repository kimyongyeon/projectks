package com.edu.ks.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class HttpFileDownload {
	Bitmap bmImg; // 비트맵을처리할 변수를 생성합니다.

	// 이미지를 다운로드하는 함수입니다. 파라미터는 String형
	// fileUrl 이 들어갑니다.
	public Bitmap downloadFile(String fileUrl) {
		URL myFileUrl = null; // URL 타입의 myFileUrl을 NULL로 초기화 시켜줍니다.

		try {
			myFileUrl = new URL(fileUrl); // 파라미터로 넘어온 Url을 myFileUrl에 대입합니다.

		} catch (MalformedURLException e) // 예외처리를 해줍니다.
		{
			// Todo Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// 실질적인 통신이 이루어지는 부분입니다.
			// myFileUrl 로 접속을 시도합니다.
			HttpURLConnection conn = (HttpURLConnection) myFileUrl
					.openConnection();
			conn.setDoInput(true);
			conn.connect();
			int length = conn.getContentLength(); // 받아온 컨텐츠의 길이를 length 변수에
													// 저장합니다.
			InputStream is = conn.getInputStream(); // InputStream is 변수에 받아온
													// InputStream을 저장합니다.
			//File f = fileMake(is);
			//bmImg = decodeFile(f);
			bmImg = BitmapFactory.decodeStream(is); // 받아온 이미지를 bmImg에 넣어둡니다.
			return bmImg;
			// imView.setImageBitmap(bmImg); // imView에 이미지를 셋팅합니다.
		} catch (IOException e) // 예외처리를 해줍니다.
		{
			e.printStackTrace();
		}

		return bmImg;
	}

	private File fileMake(InputStream inputStream) {
		// 출력할 파일명과 읽어들일 파일명을지정한다.
		File file = new File("temp.jpg");
		try {
			OutputStream outStream = new FileOutputStream(file);
			// 읽어들일 버퍼크기를 메모리에 생성
			byte[] buf = new byte[1024];
			int len = 0;
			// 끝까지 읽어들이면서 File 객체에 내용들을 쓴다
			while ((len = inputStream.read(buf)) > 0) {
				outStream.write(buf, 0, len);
			}
			// Stream 객체를 모두 닫는다.
			outStream.close();
			inputStream.close();
			return file;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	private Bitmap decodeFile(File f) {
		try {
			// Decode image size
			BitmapFactory.Options o = new BitmapFactory.Options();
			o.inJustDecodeBounds = true;
			BitmapFactory.decodeStream(new FileInputStream(f), null, o);
			// The new size we want to scale to
			final int REQUIRED_SIZE = 70;
			// Find the correct scale value. It should be the power of 2.
			int width_tmp = o.outWidth, height_tmp = o.outHeight;
			int scale = 1;
			while (true) {
				if (width_tmp / 2 < REQUIRED_SIZE
						|| height_tmp / 2 < REQUIRED_SIZE)
					break;
				width_tmp /= 2;
				height_tmp /= 2;
				scale *= 2;
			}
			// Decode with inSampleSize
			BitmapFactory.Options o2 = new BitmapFactory.Options();
			o2.inSampleSize = scale;
			return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
		} catch (FileNotFoundException e) {
		}
		return null;
	}
}
