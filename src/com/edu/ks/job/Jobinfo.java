package com.edu.ks.job;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;
import com.edu.ks.board.BoardDetail;
import com.edu.ks.dao.Board;
import com.edu.ks.dao.BoardAdapter;
import com.edu.ks.dao.BoardArrayAdapter;
import com.edu.ks.dto.Board_Param;
import com.edu.ks.dto.Com_Board;

public class Jobinfo extends Activity{
	private int mPageNo = 1;
	private ArrayList<Com_Board> m_ArrayComBoard = new ArrayList<Com_Board>();
	private ArrayList<Com_Board> m_ArrayComBoard2 = new ArrayList<Com_Board>();
	private Com_Board m_ComBoard;
	private ListView lv1;
	private TextView tv1;
	private Spinner sp;
	private Button bt;
	private EditText et;
	private String spItem[] = {"제목", "글쓴이"};
	private AlertDialog alertDialog;
	private EditText cet1;
	private EditText cet2;
	private EditText cet3;
	private String titleGubun;
	private Button next, prev;
	// yongyeon.kim : S, scroll loading add
	boolean loadingMore = false;
	BoardAdapter sa;
	BoardArrayAdapter arraysa;
	// yongyeon.kim : E, scroll loading add
	
	public static final String KEY_PAGENO_PREFERENCE = "key_pageno_preference"; 
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		String temp = getIntent().getStringExtra("BoardDetail");
		if(temp != null){
			SharedPreferences prefs = getSharedPreferences("mPageNo", MODE_PRIVATE); 
	   	    String pageno = prefs.getString(KEY_PAGENO_PREFERENCE, "");
	   	    if(!pageno.equals(""))
	   	    	mPageNo = Integer.parseInt(pageno); 
	   	    else
	   	    	mPageNo = 1;
	   	    
	   	    try {
				boardList(mPageNo);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.board_list);
		Intro.gubunView = 5;
		lv1 = (ListView) findViewById(R.id.board_listview);
		tv1 = (TextView) findViewById(R.id.board_textview);
		sp = (Spinner) findViewById(R.id.board_spinner);
		bt = (Button) findViewById(R.id.board_button);
		next = (Button) findViewById(R.id.board_next_bt);
		prev = (Button) findViewById(R.id.board_prev_bt);
		
		et = (EditText) findViewById(R.id.board_edittext);
		
		tv1.setText("취업정보 게시판");
		try {
			boardList(mPageNo);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 다음
		next.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(m_ArrayComBoard.size() > 0){
					mPageNo++;
					Log.d("kimyongyeon", "next : " + mPageNo+"");
					try {
						boardList(mPageNo);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					Toast.makeText(getApplicationContext(), "마지막 페이지 입니다.", 0).show();
				}
			}
		});
		
		// 이전
		prev.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(mPageNo > 1){
					mPageNo--;
					Log.d("kimyongyeon", "prev : " + mPageNo+"");
					try {
						boardList(mPageNo);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					Toast.makeText(getApplicationContext(), "첫 페이지 입니다.", 0).show();
				}
			}
		});
		
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,	android.R.layout.simple_list_item_1, spItem);
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
		
		lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// 상세페이지 클릭시 해당 페이지를 기억하기 위해 사용
				SharedPreferences prefs = getSharedPreferences("mPageNo", MODE_PRIVATE); 
				SharedPreferences.Editor editor = prefs.edit(); 
				editor.putString(KEY_PAGENO_PREFERENCE, mPageNo+""); 
				editor.commit();
				
				if(position > m_ArrayComBoard.size()-1)
					return;
				m_ComBoard = m_ArrayComBoard.get(position);
				
				//Integer idx = Integer.parseInt(m_ComBoard.getNum());
				//http://dalparan777.cafe24.com/apps/server/ks02_life_notice_view.asp?db=recom&num=1997&pageno=1&startpage=1
				Intent i = new Intent(getApplication(), BoardDetail.class);
				i.putExtra("Board", m_ComBoard.getNum() + "," + "4");
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(i);
				finish();
			}
		});
		
		bt.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String gubun = "";
				if(titleGubun.equals("글쓴이")){
					gubun = "writer";
				}else{
					gubun = "title";
				}
				String keyword = et.getText().toString().trim();
				mPageNo = 1;
				try {
					boardSearch(gubun, keyword, mPageNo);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 키보드 내림
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
			}
		});
		
		/*lv1.setOnScrollListener(new OnScrollListener(){
			
			
			//useless here, skip!
			public void onScrollStateChanged(AbsListView view, int scrollState) {}
			
			//dumdumdum			
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				
				
				//what is the bottom iten that is visible
				int lastInScreen = firstVisibleItem + visibleItemCount;				
				
				
				//is the bottom item visible & not loading more already ? Load more !
				if((lastInScreen == totalItemCount) && !(loadingMore)){	
					Log.e("dddd","aaaaaa");
					Thread thread =  new Thread(null, loadMoreListItems);
			        thread.start();
				}
			}
		});*/
	}
	
	/*//Runnable to load the items 
    private Runnable loadMoreListItems = new Runnable() {			
		public void run() {
			//Set flag so we cant load new items 2 at the same time
			loadingMore = true;
			
			//Simulate a delay, delete this on a production environment!
	    	try { Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			Board b = new Board();
			Board_Param bp = new Board_Param();
			bp.setPageno(mPageNo+"");
			bp.setIndex(0);
			try {
				m_ArrayComBoard = b.boardList(bp);
				mPageNo++;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			//Done! now continue on the UI thread
	        runOnUiThread(returnRes);
	        
		}
	};	
	
    
	//Since we cant update our UI from a thread this Runnable takes care of that! 
    private Runnable returnRes = new Runnable() {
        public void run() {
        	
			//Loop thru the new items and add them to the adapter
			if(m_ArrayComBoard != null && m_ArrayComBoard.size() > 0){
                for(int i=0;i<m_ArrayComBoard.size();i++){
                	arraysa.add(m_ArrayComBoard.get(i));
                }
            }
			
        	arraysa.notifyDataSetChanged();
        	
			//Done loading more.
            loadingMore = false;
        }
    };*/
    // yongyeon.kim : S, scroll loading add
    private void boardAdapter(ArrayList<Com_Board> ArrayComBoard){
    	arraysa = new BoardArrayAdapter(this, R.layout.board_list_row, ArrayComBoard);
		//View footerView = getLayoutInflater().inflate(R.layout.listfooter, null, false);
		//lv1.addFooterView(footerView);
		lv1.setAdapter(arraysa);
    }
	// yongyeon.kim : E, scroll loading add	
	private void boardSearch(String gubun, String keyword, int pageno) throws UnsupportedEncodingException{
		Board b = new Board();
		Board_Param bp = new Board_Param();
		bp.setPageno(pageno+"");
		bp.setIndex(4);
		bp.setGubun(gubun);
		bp.setKeyword(keyword);
		m_ArrayComBoard = b.boardSearch(bp);

        if(m_ArrayComBoard.size() == 0){
			Toast.makeText(this, "검색 정보가 없습니다.", 0).show();
			return;
		}

		boardAdapter(m_ArrayComBoard);
		/*sa = new BoardAdapter(this, m_ArrayComBoard);
		lv1.setAdapter(sa);*/
	}
	
	private void boardList(int pageno) throws UnsupportedEncodingException{
		Board b = new Board();
		Board_Param bp = new Board_Param();
		bp.setPageno(pageno+"");
		bp.setIndex(4);
		m_ArrayComBoard = b.boardList(bp);
		
		if(m_ArrayComBoard.size() == 0){
			mPageNo--;
			bp.setPageno(mPageNo+"");
			bp.setIndex(4);
			m_ArrayComBoard = b.boardList(bp);
			Toast.makeText(this, "마지막 페이지 입니다.", 0).show();
			return;
		}
		
		boardAdapter(m_ArrayComBoard); // UI Display
		/*sa = new BoardAdapter(this, m_ArrayComBoard);
		
		// yongyeon.kim : S, scroll loading add 
		//add the footer before adding the adapter, else the footer will nod load!
		View footerView = ((LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.listfooter, null, false);
		lv1.addFooterView(footerView);
		// yongyeon.kim : E, scroll loading add
		lv1.setAdapter(sa);*/
	}
	
	private void boardDeatail(int key){
		m_ComBoard = new Com_Board();
		Board b = new Board();
		Board_Param bp = new Board_Param();
		bp.setNum(key);
		bp.setIndex(4);
		m_ComBoard = b.boardDeatail(bp);
	}
	
	private void boardDetail_Dialog(int key) {
		AlertDialog.Builder builder;
		Context mContext = this;
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.board_list_dialog,
				(ViewGroup) findViewById(R.id.boardDetail_Ll01));

		cet1 = (EditText) v.findViewById(R.id.boardDetail_Et01); // 글쓴이
		cet2 = (EditText) v.findViewById(R.id.boardDetail_Et02); // 제목
		cet3 = (EditText) v.findViewById(R.id.boardDetail_Et03); // 내용
		
		boardDeatail(key);

		cet1.setText(m_ComBoard.getWriter());
		cet2.setText(m_ComBoard.getSubject());
		cet3.setText(m_ComBoard.getContents());

		Button cbt2 = (Button) v.findViewById(R.id.boardDetail_Bt02); // 닫기
		
		cbt2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				alertDialog.dismiss();
			}
		});

		builder = new AlertDialog.Builder(mContext);
		builder.setView(v);
		alertDialog = builder.create();
		alertDialog.show();
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent i = new Intent(getApplicationContext(), Tab.class);
		startActivity(i);
		finish();
	}

}
