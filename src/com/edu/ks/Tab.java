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
		requestWindowFeature(Window.FEATURE_NO_TITLE); // Ÿ��Ʋ�� ���ֱ�
		setContentView(R.layout.main_tab);

		tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		// Ȩ 
		intent = new Intent().setClass(this, Main.class);
		spec = tabHost.newTabSpec("tab1").setIndicator("Ȩ",
				getResources().getDrawable(R.drawable.maintoorbaricon_home)).setContent(intent);
		tabHost.addTab(spec);

		// ���мҰ� 
		intent = new Intent().setClass(this, Introduce.class);
		spec = tabHost.newTabSpec("tab1").setIndicator("",
				getResources().getDrawable(R.drawable.maintoorbaricon_intro)).setContent(intent);
		tabHost.addTab(spec);
		
		// ���л�Ȱ 
		intent = new Intent().setClass(this, Life.class);
		spec = tabHost.newTabSpec("tab2").setIndicator("",
				getResources().getDrawable(R.drawable.maintoorbaricon_life)).setContent(intent);
		tabHost.addTab(spec);
		// ȫ���� 
		intent = new Intent().setClass(this, PR.class);
		spec = tabHost.newTabSpec("tab3").setIndicator("",
				getResources().getDrawable(R.drawable.maintoorbaricon_promotion)).setContent(
				intent);
		tabHost.addTab(spec);
		
		// ���оȳ� 
		intent = new Intent().setClass(this, Admission.class);
		spec = tabHost.newTabSpec("tab4").setIndicator("",
				getResources().getDrawable(R.drawable.maintoorbaricon_hacksa)).setContent(
				intent);
		tabHost.addTab(spec);
		
		// ä������ 
		intent = new Intent().setClass(this, Job.class);
		spec = tabHost.newTabSpec("tab5").setIndicator("",
				getResources().getDrawable(R.drawable.maintoorbaricon_career)).setContent(
				intent);
		tabHost.addTab(spec);

		// ������ ����
		tabHost.setCurrentTab(Intro.gubunView);
	}
}

