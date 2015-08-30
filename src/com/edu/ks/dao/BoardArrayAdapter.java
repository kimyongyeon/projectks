package com.edu.ks.dao;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.edu.ks.R;
import com.edu.ks.dto.Com_Board;

public class BoardArrayAdapter extends ArrayAdapter<Com_Board>{
	ArrayList<Com_Board> items;
	Context context;
	public BoardArrayAdapter(Context context, int textViewResourceId,
			ArrayList<Com_Board> items) {
		super(context, textViewResourceId, items);
		// TODO Auto-generated constructor stub
		this.items = items;
		this.context = context;
	}

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            Com_Board cb = items.get(position);
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // 답변용
                if(cb.getWriter().equals("상담자")){
                	v = vi.inflate(R.layout.board_list_row3, null);
                    TextView t1 = (TextView) v.findViewById(R.id.boardlistRow3_Tv01); // 제목
                    TextView t2 = (TextView) v.findViewById(R.id.boardlistRow3_Tv02); // 날짜 / 글쓴이
                    if (t1 != null){
                    	t1.setText(cb.getSubject());                  
                    }
                    if(t2 != null){
                    	String date = cb.getReg_date();
                    	date = date.substring(0, 10);
                    	t2.setText(date+"\n         "+cb.getWriter());
                    }
                    
                }else{ // 일반용
                	v = vi.inflate(R.layout.board_list_row, null);
                	TextView t1 = (TextView) v.findViewById(R.id.boardlistRow_Tv01); // 제목
                    TextView t2 = (TextView) v.findViewById(R.id.boardlistRow_Tv02); // 날짜
                    if (t1 != null){
                    	t1.setText(cb.getSubject());                  
                    }
                    if(t2 != null){
                    	String date = cb.getReg_date();
                    	date = date.substring(0, 10);
                    	t2.setText(date+"\n"+cb.getWriter());
                    }
                }
            }
            //Com_Board cb = items.get(position);
            /*if (cb != null) {
                    TextView t1 = (TextView) v.findViewById(R.id.boardlistRow3_Tv01); // 제목
                    TextView t2 = (TextView) v.findViewById(R.id.boardlistRow3_Tv02); // 날짜
                    TextView t3 = (TextView) v.findViewById(R.id.boardlistRow3_Tv03); // 글쓴이
                    if (t1 != null){
                    	t1.setText(cb.getSubject());                  
                    }
                    if(t2 != null){
                    	t2.setText(cb.getWriter());
                    }
                    if(t3 != null){
                    	t3.setText(cb.getReg_date());
                    }
            }*/
            return v;
    }
}
