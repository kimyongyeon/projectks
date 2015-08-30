package com.edu.ks.pr;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;

public class Sns extends Activity implements OnClickListener{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.pr_sns);
		Intro.gubunView = 3;
		
		ImageView iv1 = (ImageView) findViewById(R.id.pr_sns_Iv01);
		ImageView iv2 = (ImageView) findViewById(R.id.pr_sns_Iv02);
		ImageView iv3 = (ImageView) findViewById(R.id.pr_sns_Iv03);
		ImageView iv4 = (ImageView) findViewById(R.id.pr_sns_Iv04);
		
		iv1.setOnClickListener(this);
		iv2.setOnClickListener(this);
		iv3.setOnClickListener(this);
		iv4.setOnClickListener(this);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent i = new Intent(getApplicationContext(), Tab.class);
		startActivity(i);
		finish();
	}
	Intent i;
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.pr_sns_Iv01:
			i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.twitter.com/yesbsks/"));
			startActivity(i);
			break;
		case R.id.pr_sns_Iv02:
			i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.facebook.com/pages/부산경상대학/212958718735226"));
			startActivity(i);
			break;
		case R.id.pr_sns_Iv03:
			i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.blog.naver.com"));
			startActivity(i);
			break;
		case R.id.pr_sns_Iv04:
			i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://town.cyworld.com"));
			startActivity(i);
			break;
		}
	}

}
