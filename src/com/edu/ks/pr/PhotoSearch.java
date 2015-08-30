package com.edu.ks.pr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;

public class PhotoSearch extends Activity{
	private Spinner sp;
	private Button bt, bt2;
	private EditText et;
	private String spItem[] = { "제목", "글쓴이" };
	private String titleGubun;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.pr_photosearch);
		
		sp = (Spinner) findViewById(R.id.pr_photosearch_spinner);
		bt = (Button) findViewById(R.id.pr_photosearch_button);
		et = (EditText) findViewById(R.id.pr_photosearch_edittext);
		
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, spItem);
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		sp.setAdapter(aa);
		sp.setPrompt("구분");

		sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				titleGubun = spItem[position];
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		if(Photo.GsearchGubun == 1){
			Intent i = new Intent(getApplicationContext(), Photo.class);
			startActivity(i);
			finish();
		}else{
			Intent i = new Intent(getApplicationContext(), User_PhotoList.class);
			startActivity(i);
			finish();
		}
	}
}
