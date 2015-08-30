package com.edu.ks.introduce;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.ks.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class CampusItemizedOverlay extends ItemizedOverlay {

	private Context mContext;
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();

	public CampusItemizedOverlay(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return mOverlays.get(i);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mOverlays.size();
	}

	public void addOverlay(OverlayItem overlay) {
		mOverlays.add(overlay);
		populate();
	}

	@Override
	protected boolean onTap(int index) {
		OverlayItem item = mOverlays.get(index);
		int resourceID = 0;
		if(item.getSnippet().equals("���к���")){
			resourceID = R.drawable.map01;
		}
		if(item.getSnippet().equals("����")){
			resourceID = R.drawable.map02;
		}
		if(item.getSnippet().equals("â����")){
			resourceID = R.drawable.map03;
		}
		if(item.getSnippet().equals("�л�ȸ��")){
			resourceID = R.drawable.map04;
		}
		if(item.getSnippet().equals("������")){
			resourceID = R.drawable.map05;
		}
		if(item.getSnippet().equals("�Ϲε�����")){
			resourceID = R.drawable.map06;
		}
		if(item.getSnippet().equals("������")){
			resourceID = R.drawable.map07;
		}
		if(item.getSnippet().equals("�Ϲη�")){
			resourceID = R.drawable.map08;
		}
		if(item.getSnippet().equals("��Ƽ�̵���")){
			resourceID = R.drawable.map09;
		}
		if(item.getSnippet().equals("�����")){
			resourceID = R.drawable.map10;
		}
		if(item.getSnippet().equals("�λ�ܱ������б�")){
			resourceID = R.drawable.map11;
		}
		if(item.getSnippet().equals("����")){
			resourceID = R.drawable.map12;
		}
		if(item.getSnippet().equals("����")){
			resourceID = R.drawable.map13;
		}
		
		if(item.getSnippet().equals("����")){
			resourceID = R.drawable.map14;
		}
		
		if(item.getSnippet().equals("�ܸ޸���")){
			resourceID = R.drawable.map15;
		}
		
		if(item.getSnippet().equals("����������")){
			resourceID = R.drawable.map11;
		} 
		
		
		map_Popup(item.getSnippet(), resourceID);
		//Toast.makeText(mContext, item.getSnippet(), Toast.LENGTH_LONG).show();
		return true;
	}
	
	AlertDialog alertDialog;
	private void map_Popup(String contents, int resourceID) {
		
		// Ŀ���� ���̾�α׸� ��켼��.
		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
		//builder.setIcon(R.drawable.rhinoceros);
		builder.setTitle(contents);
		builder.setNeutralButton("�ݱ�", null);

		initCustom(contents, resourceID); // ���⼭ ȣ���ؾ� �Ѵ�.

		builder.setView(v);
		builder.show();
	}			
	
	private View v;
	private TextView ctv;
	private ImageView civ;
	
	void initCustom(String contents, int img) {
		v = View.inflate(mContext, R.layout.campus_map_dialog, null);
		ctv = (TextView)v.findViewById(R.id.campus_map_dialog_tv); // ����
		civ = (ImageView)v.findViewById(R.id.campus_map_dialog_iv); // ����
		//ctv.setText(contents);
		if(img != 0)
			civ.setImageResource(img);	 
	}

			
			

}
