package com.edu.ks.dao;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.ks.R;
import com.edu.ks.dto.Photo_Board;
import com.edu.ks.lib.HttpFileDownload;

public class PhotoBoardArrayAdapter extends ArrayAdapter<Photo_Board>{
	ArrayList<Photo_Board> items;
	Context context;
	public PhotoBoardArrayAdapter(Context context, int textViewResourceId,
			ArrayList<Photo_Board> items) {
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
                v = vi.inflate(R.layout.photoboard_list_row, null);
            }
            Photo_Board cb = items.get(position);
            if(cb != null){
        		TextView tv_str1 = (TextView) v.findViewById(R.id.photoboardlistRow_Tv01);
        		TextView tv_str2 = (TextView) v.findViewById(R.id.photoboardlistRow_Tv02);
        		ImageView iv = (ImageView) v.findViewById(R.id.photoboardlistRow_Iv01);
        		
    			if(cb.getTitle().length() > 10){
    				String temp = cb.getTitle()+"";
    				temp = temp.substring(0, 8) + "...";
    				tv_str1.setText(temp);
    			}else{
    				tv_str1.setText(cb.getTitle()+"");	
    			}
    			tv_str2.setText(cb.getDate()+"");
    			HttpFileDownload imgDown = new HttpFileDownload();
    			Bitmap bmImg = imgDown.downloadFile(cb.getAttchimage());
    			iv.setImageBitmap(bmImg);
    		}
            return v;
    }
}
