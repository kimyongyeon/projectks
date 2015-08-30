package com.edu.ks.pr;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.edu.ks.dao.PhotoBoard;
import com.edu.ks.dao.PhotoBoardAdapter;
import com.edu.ks.dao.PhotoBoardArrayAdapter;
import com.edu.ks.dto.Board_Param;
import com.edu.ks.dto.Com_Board;
import com.edu.ks.dto.Photo_Board;

public class Photo2 extends Activity{
	private int mPageNo = 1;
	ArrayList<Photo_Board> m_ArrayPhotoBoard = new ArrayList<Photo_Board>();
	Photo_Board m_PhotoBoard;
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
	// yongyeon.kim : S, scroll loading add
	boolean loadingMore = false;
	BoardAdapter sa;
	PhotoBoardArrayAdapter arraysa;
	// yongyeon.kim : E, scroll loading add
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.photoboard_list);
		Intro.gubunView = 3;
		lv1 = (ListView) findViewById(R.id.photoboard_listview);
		tv1 = (TextView) findViewById(R.id.photoboard_textview);
		sp = (Spinner) findViewById(R.id.photoboard_spinner);
		bt = (Button) findViewById(R.id.photoboard_button);
		et = (EditText) findViewById(R.id.photoboard_edittext);
		
		tv1.setText("포토갤러리");
		try {
			boardList(mPageNo);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
				if(position > m_ArrayPhotoBoard.size()-1)
					return;
				m_PhotoBoard = m_ArrayPhotoBoard.get(position);
				Integer idx = Integer.parseInt(m_PhotoBoard.getSeq());
				//boardDetail_Dialog(idx);
				Intent i = new Intent(getApplication(), BoardDetail.class);
				i.putExtra("Board", m_PhotoBoard.getSeq() + "," + "5");
				startActivity(i);
			}
		});
		
		/*bt.setOnClickListener(new View.OnClickListener() {
			
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
		});*/
	}
	
	//Runnable to load the items 
    private Runnable loadMoreListItems = new Runnable() {			
		public void run() {
			//Set flag so we cant load new items 2 at the same time
			loadingMore = true;
			
			//Reset the array that holds the new items
	    	//myListItems = new ArrayList<String>();
	    	
			//Simulate a delay, delete this on a production environment!
	    	try { Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			//Get 15 new listitems
	    	/*for (int i = 0; i < itemsPerPage; i++) {		
				//Fill the item with some bogus information
	        	//myListItems.add("Date: " + (d.get(Calendar.MONTH)+ 1) + "/" + d.get(Calendar.DATE) + "/" + d.get(Calendar.YEAR) );          	
				
				// +1 day :-D
	        	d.add(Calendar.DATE, 1);
				
			}*/
			
			PhotoBoard b = new PhotoBoard();
			Board_Param bp = new Board_Param();
			mPageNo++;
			bp.setPageno(mPageNo+"");
			bp.setIndex(0);
			try {
				m_ArrayPhotoBoard = b.boardList(bp);
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
			if(m_ArrayPhotoBoard != null && m_ArrayPhotoBoard.size() > 0){
                for(int i=0;i<m_ArrayPhotoBoard.size();i++)
                	arraysa.add(m_ArrayPhotoBoard.get(i));
            }
        	
			//Update the Application title
        	//setTitle(String.valueOf(sa.getCount()) + " items");
        	
			
			//Tell to the adapter that changes have been made, this will cause the list to refresh
        	arraysa.notifyDataSetChanged();
			
			//Done loading more.
            loadingMore = false;
        }
    };
    
 // yongyeon.kim : S, scroll loading add
    private void boardAdapter(ArrayList<Photo_Board> ArrayComBoard){
		//sa = new BoardAdapter(this, ArrayComBoard);
    	arraysa = new PhotoBoardArrayAdapter(this, R.layout.photoboard_list_row, ArrayComBoard);
		//add the footer before adding the adapter, else the footer will nod load!
		//View footerView = ((LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.listfooter, null, false);
		View footerView = getLayoutInflater().inflate(R.layout.listfooter, null, false);
		lv1.addFooterView(footerView);
		//lv1.setAdapter(sa);
		lv1.setAdapter(arraysa);
    }
	// yongyeon.kim : E, scroll loading add	
	
	private void boardSearch(String gubun, String keyword, int pageno) throws UnsupportedEncodingException{
		PhotoBoard b = new PhotoBoard();
		Board_Param bp = new Board_Param();
		bp.setPageno(pageno+"");
		bp.setIndex(0);
		bp.setGubun(gubun);
		bp.setKeyword(keyword);
		m_ArrayPhotoBoard = b.boardSearch(bp);
		
		if(m_ArrayPhotoBoard.size() == 0){
			Toast.makeText(this, "검색 정보가 없습니다.", 0).show();
			return;
		}
		
		boardAdapter(m_ArrayPhotoBoard);
		/*
		PhotoBoardAdapter sa = new PhotoBoardAdapter(this, m_ArrayPhotoBoard);
		lv1.setAdapter(sa);
		*/
	}
	
	private void boardList(int pageno) throws UnsupportedEncodingException{
		PhotoBoard b = new PhotoBoard();
		Board_Param bp = new Board_Param();
		bp.setPageno(pageno+"");
		bp.setIndex(0);
		m_ArrayPhotoBoard = b.boardList(bp);
		
		if(m_ArrayPhotoBoard.size() == 0){
			Toast.makeText(this, "마지막 페이지 입니다.", 0).show();
			return;
		}
		boardAdapter(m_ArrayPhotoBoard);
		/*
		PhotoBoardAdapter sa = new PhotoBoardAdapter(this, m_ArrayPhotoBoard);
		lv1.setAdapter(sa);
		*/
	}
	
	private void boardDeatail(int key){
		m_PhotoBoard = new Photo_Board();
		PhotoBoard b = new PhotoBoard();
		Board_Param bp = new Board_Param();
		bp.setNum(key);
		bp.setIndex(0);
		m_PhotoBoard = b.boardDeatail(bp);
		
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

		cet1.setText(m_PhotoBoard.getName());
		cet2.setText(m_PhotoBoard.getTitle());
		cet3.setText(m_PhotoBoard.getContents());

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
