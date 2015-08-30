package com.edu.ks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.edu.ks.tab.Main;

public class Intro extends Activity {
	ImageView iv;
	public static String mainPath = "http://m.bsks.ac.kr/";
    /** Called when the activity is first created. */
	public static int gubunView = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
        setContentView(R.layout.main_intro);
        
        iv = (ImageView) findViewById(R.id.Intro_Iv01);
        
        iv.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Tab.class);
		        startActivity(i);
		        finish();
			}
		});
    }
}