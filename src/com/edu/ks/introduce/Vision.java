package com.edu.ks.introduce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;

public class Vision extends Activity{
	@Override
	
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intro.gubunView = 1;
		Intent i = new Intent(getApplicationContext(), Tab.class);
		startActivity(i);
		finish();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Å¸ÀÌÆ²¹Ù ¾ø¾Ö±â
		setContentView(R.layout.introduce_vision);
		TextView tv = (TextView) findViewById(R.id.intro_vision_textview);
		tv.setText("±³À° ÀÌ³ä ¹× ÇÐÈÆ");
	}
}
