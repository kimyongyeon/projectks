package com.edu.ks.introduce;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class Greet extends Activity{
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
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.introduce_greet);
		TextView tv = (TextView) findViewById(R.id.intro_greet_textview);
		tv.setText("총장 인사말");
		
	}
}
