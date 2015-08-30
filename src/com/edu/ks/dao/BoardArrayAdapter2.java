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

public class BoardArrayAdapter2 extends ArrayAdapter<Com_Board>{
	ArrayList<Com_Board> items;
	Context context;
	public BoardArrayAdapter2(Context context, int textViewResourceId,
			ArrayList<Com_Board> items) {
		super(context, textViewResourceId, items);
		// TODO Auto-generated constructor stub
		this.items = items;
		this.context = context;
	}

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.board_list_row2, null);
            }
            Com_Board cb = items.get(position);
            if (cb != null) {
                    TextView tt1 = (TextView) v.findViewById(R.id.boardlistRow2_Tv01);
                    TextView tt2 = (TextView) v.findViewById(R.id.boardlistRow2_Tv02);
                    TextView tt3 = (TextView) v.findViewById(R.id.boardlistRow2_Tv03);
                    TextView tt4 = (TextView) v.findViewById(R.id.boardlistRow2_Tv04);
                    if (tt1 != null){
                    	String title = cb.getSubject().replace("<c>", ",");
                    	tt1.setText(title);                            
                    }
                    if(tt2 != null){
                    	tt2.setText(cb.getReg_date());
                    }
                    if (tt3 != null){
                    	tt3.setText("글쓴이 : " + cb.getWriter());                            
                    }
                    if(tt4 != null){
                    	tt4.setText("조회수 : " + cb.getVisited());
                    }
            }
            return v;
    }
}
