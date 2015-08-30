package com.edu.ks;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;

import com.edu.ks.tab.Admission;
import com.edu.ks.tab.Introduce;
import com.edu.ks.tab.Job;
import com.edu.ks.tab.Life;
import com.edu.ks.tab.Main;
import com.edu.ks.tab.PR;

public class Tab extends TabActivity {

	TabHost tabHost;
	public static boolean tabFlag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.main_tab);

		tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		// 홈 
		intent = new Intent().setClass(this, Main.class);
		spec = tabHost.newTabSpec("tab1").setIndicator("홈",
				getResources().getDrawable(R.drawable.maintoorbaricon_home)).setContent(intent);
		tabHost.addTab(spec);

		// 대학소개 
		intent = new Intent().setClass(this, Introduce.class);
		spec = tabHost.newTabSpec("tab1").setIndicator("",
				getResources().getDrawable(R.drawable.maintoorbaricon_intro)).setContent(intent);
		tabHost.addTab(spec);
		
		// 대학생활 
		intent = new Intent().setClass(this, Life.class);
		spec = tabHost.newTabSpec("tab2").setIndicator("",
				getResources().getDrawable(R.drawable.maintoorbaricon_life)).setContent(intent);
		tabHost.addTab(spec);
		// 홍보관 
		intent = new Intent().setClass(this, PR.class);
		spec = tabHost.newTabSpec("tab3").setIndicator("",
				getResources().getDrawable(R.drawable.maintoorbaricon_promotion)).setContent(
				intent);
		tabHost.addTab(spec);
		
		// 입학안내 
		intent = new Intent().setClass(this, Admission.class);
		spec = tabHost.newTabSpec("tab4").setIndicator("",
				getResources().getDrawable(R.drawable.maintoorbaricon_hacksa)).setContent(
				intent);
		tabHost.addTab(spec);
		
		// 채용정보 
		intent = new Intent().setClass(this, Job.class);
		spec = tabHost.newTabSpec("tab5").setIndicator("",
				getResources().getDrawable(R.drawable.maintoorbaricon_career)).setContent(
				intent);
		tabHost.addTab(spec);

		// 시작탭 설정
		tabHost.setCurrentTab(Intro.gubunView);
	}
}

