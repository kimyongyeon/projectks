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
	Bitmap bmImg; // ��Ʈ����ó���� ������ �����մϴ�.

	// �̹����� �ٿ�ε��ϴ� �Լ��Դϴ�. �Ķ���ʹ� String��
	// fileUrl �� ���ϴ�.
	public Bitmap downloadFile(String fileUrl) {
		URL myFileUrl = null; // URL Ÿ���� myFileUrl�� NULL�� �ʱ�ȭ �����ݴϴ�.

		try {
			myFileUrl = new URL(fileUrl); // �Ķ���ͷ� �Ѿ�� Url�� myFileUrl�� �����մϴ�.

		} catch (MalformedURLException e) // ����ó���� ���ݴϴ�.
		{
			// Todo Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// �������� ����� �̷������ �κ��Դϴ�.
			// myFileUrl �� ������ �õ��մϴ�.
			HttpURLConnection conn = (HttpURLConnection) myFileUrl
					.openConnection();
			conn.setDoInput(true);
			conn.connect();
			int length = conn.getContentLength(); // �޾ƿ� �������� ���̸� length ������
													// �����մϴ�.
			InputStream is = conn.getInputStream(); // InputStream is ������ �޾ƿ�
													// InputStream�� �����մϴ�.
			//File f = fileMake(is);
			//bmImg = decodeFile(f);
			bmImg = BitmapFactory.decodeStream(is); // �޾ƿ� �̹����� bmImg�� �־�Ӵϴ�.
			return bmImg;
			// imView.setImageBitmap(bmImg); // imView�� �̹����� �����մϴ�.
		} catch (IOException e) // ����ó���� ���ݴϴ�.
		{
			e.printStackTrace();
		}

		return bmImg;
	}

	private File fileMake(InputStream inputStream) {
		// ����� ���ϸ�� �о���� ���ϸ��������Ѵ�.
		File file = new File("temp.jpg");
		try {
			OutputStream outStream = new FileOutputStream(file);
			// �о���� ����ũ�⸦ �޸𸮿� ����
			byte[] buf = new byte[1024];
			int len = 0;
			// ������ �о���̸鼭 File ��ü�� ������� ����
			while ((len = inputStream.read(buf)) > 0) {
				outStream.write(buf, 0, len);
			}
			// Stream ��ü�� ��� �ݴ´�.
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
