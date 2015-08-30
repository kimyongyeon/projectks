package com.edu.ks.introduce;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.edu.ks.R;
import com.edu.ks.introduce.Phone_Info_Main.LifeListAdapter;

public class Phone_Info_Sub extends Activity{
	ListView lv;
	TitleDTO m_Name;
	ArrayList<TitleDTO> m_Arr = new ArrayList<TitleDTO>();
	private int m_Idx;
	private String m_Gubun;
	
	private String m_cateGory[] = {
			"본부", "학과", "종합인력센터","부속기관","관련기관"
	};
	
	// Title Class 
	class TitleDTO {
		String name;
		String tel;
		String telNumber;
	}
	
	private String m_phoneNumber1[];
	private String m_phoneNumber2[];
	private String m_phoneNumber3[];
	private String m_phoneNumber4[];
	private String m_phoneNumber5[];
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
		setContentView(R.layout.introduce_phone_info_list);
		TextView tv = (TextView)findViewById(R.id.introduce_phone_info_list_textview);
		
		// 0~4 | 5~12 | 13~25 | 26~40 | 41~42 
		String phoneName1[] = getResources().getStringArray(R.array.phone_headquarter);
		
		// 0~4 | 5~9 | 10~13 | 14~19 | 20~23 | 24~27 | 28~32 | 33~39 | 40~45 | 46~50 | 51~57
		// 58~61 | 62~67 | 68~75 | 76~82 | 83~86 | 87~91 | 92~96 | 97~100 | 101~104 | 105~111 | 112~116
		String phoneName2[] = getResources().getStringArray(R.array.phone_department);
		
		// 종합인력센터는 부메뉴가 존재하지 않으므로, 그냥 순서대로 뿌리면 됨.
		String phoneName3[] = getResources().getStringArray(R.array.phone_manpowercenter);
		
		// 0~7 | 8~17 | 18~22 | 23~28
		String phoneName4[] = getResources().getStringArray(R.array.phone_affiliate);
		
		// 0~5 | 6~10 | 11~15 | 16~19 | 20~27 | 28~29 | 30~41
		String phoneName5[] = getResources().getStringArray(R.array.phone_organization);
		
		String phoneNumber1[] = getResources().getStringArray(R.array.phone_headquarter_numbers);
		String phoneNumber2[] = getResources().getStringArray(R.array.phone_department_numbers);
		String phoneNumber3[] = getResources().getStringArray(R.array.phone_manpowercenter_numbers);
		String phoneNumber4[] = getResources().getStringArray(R.array.phone_affiliate_numbers);
		String phoneNumber5[] = getResources().getStringArray(R.array.phone_organization_numbers);
		
		m_phoneNumber1 = phoneNumber1;
		m_phoneNumber2 = phoneNumber2;
		m_phoneNumber3 = phoneNumber3;
		m_phoneNumber4 = phoneNumber4;
		m_phoneNumber5 = phoneNumber5;
		
		String value = getIntent().getStringExtra("Phone_Info_Main");
		//m_Idx = Integer.parseInt(value);
		String temp[] = value.split(",");
		String gubun = temp[0];
		m_Gubun = gubun;
		m_Idx = Integer.parseInt(temp[1]);
		lv = (ListView)findViewById(R.id.introduce_phone_info_list_lv);
		
		if(gubun.equals(m_cateGory[0])){
			switch(m_Idx){
			case 0: // 교무처
				tv.setText("교무처");
				for(int i=0; i<5; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName1[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber1[i];
					m_Arr.add(m_Name);
				}
				break;
			case 1: // 입시기획실
				tv.setText("입시기획실");
				for(int i=5; i<13; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName1[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber1[i];
					m_Arr.add(m_Name);
				}
				break;
			case 2: // 산학처
				tv.setText("산학처");
				for(int i=13; i<26; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName1[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber1[i];
					m_Arr.add(m_Name);
				}
				break;
			case 3: // 사무처
				tv.setText("사무처");
				for(int i=26; i<41; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName1[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber1[i];
					m_Arr.add(m_Name);
				}
				break;	
			case 4: // 교수학습지원센터
				tv.setText("교수학습지원센터");
				for(int i=41; i<43; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName1[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber1[i];
					m_Arr.add(m_Name);
				}
				break;	
			}
		}
		if(gubun.equals(m_cateGory[1])){
			
			switch(m_Idx){
			case 0: 
				tv.setText("비즈니스 / 경영과");
				for(int i=0; i<5; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 1: 
				tv.setText("비즈니스 / 세무정보과");
				for(int i=5; i<10; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 2: 
				tv.setText("비즈니스 / 유통물류과");
				for(int i=10; i<14; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 3: 
				tv.setText("비즈니스 / 부동산경영과");
				for(int i=14; i<20; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;	
			case 4: 
				tv.setText("비즈니스 / 광고•마케팅과");
				for(int i=20; i<24; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;	
				
			case 5: 
				tv.setText("비즈니스 / 중국비즈니스과");
				for(int i=24; i<28; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 6: 
				tv.setText("행정교육 / 유아교육과");
				for(int i=28; i<33; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 7: 
				tv.setText("행정교육/경찰•경호 행정과");
				for(int i=33; i<40; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 8: 
				tv.setText("행정교육 / 소방안전계열");
				for(int i=40; i<46; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
				
			case 9: 
				tv.setText("보건복지 / 보건의료행정과");
				for(int i=46; i<51; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 10: 
				tv.setText("보건복지 / 사회복지행정과");
				for(int i=51; i<58; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 11: 
				tv.setText("보건복지 / 아동복지보육과");
				for(int i=58; i<62; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 12: 
				tv.setText("관광외국어/관광일어과");
				for(int i=62; i<68; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
				
			case 13: 
				tv.setText("관광외국어/호텔관광영어과");
				for(int i=68; i<76; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 14: 
				tv.setText("관광외국어/호텔관광경영과");
				for(int i=76; i<83; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 15: 
				tv.setText("관광외국어/항공•비서과");
				for(int i=83; i<87; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 16: 
				tv.setText("멀티미디어/멀티미디어계열");
				for(int i=87; i<92; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
				
			case 17: 
				tv.setText("예체능/방송영상•영화과");
				for(int i=92; i<97; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 18: 
				tv.setText("예체능/방송엔터테이너•모델계열");
				for(int i=97; i<101; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 19: 
				tv.setText("예체능/스포츠건강관리과");
				for(int i=101; i<105; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 20: 
				tv.setText("패션뷰티디자인/패션•뷰티계열");
				for(int i=105; i<112; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			case 21: 
				tv.setText("패션뷰티디자인/광고•인테리어 디자인과");
				for(int i=112; i<117; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;
			/*case 22: 
				for(int i=112; i<117; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName2[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber2[i];
					m_Arr.add(m_Name);
				}
				break;*/	
			}
		}
		if(gubun.equals(m_cateGory[2])){
			tv.setText("종합인력개발센터");
			for(int i=0; i<phoneName3.length; i++){
				m_Name = new TitleDTO();
				String strTemp[] = phoneName3[i].split(",");
				m_Name.name = strTemp[0]; // 이름
				m_Name.tel = strTemp[1]; // 번호
				m_Name.telNumber = phoneNumber3[i];
				m_Arr.add(m_Name);
			}
		}
		if(gubun.equals(m_cateGory[3])){
			// 0~7 | 8~17 | 18~22 | 23~28
			switch(m_Idx){
			case 0: 
				tv.setText("일민도서관");
				for(int i=0; i<8; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName4[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber4[i];
					m_Arr.add(m_Name);
				}
				break;
			case 1:
				tv.setText("교육정보원");
				for(int i=8; i<18; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName4[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber4[i];
					m_Arr.add(m_Name);
				}
				break;
			case 2: 
				tv.setText("사회교육원");
				for(int i=18; i<23; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName4[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber4[i];
					m_Arr.add(m_Name);
				}
				break;
			case 3: 
				tv.setText("언론사");
				for(int i=23; i<29; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName4[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber4[i];
					m_Arr.add(m_Name);
				}
				break;	
			}
		}
		if(gubun.equals(m_cateGory[4])){
			// 0~5 | 6~10 | 11~15 | 16~19 | 20~27 | 28~29 | 30~41
			switch(m_Idx){
			case 0: 
				tv.setText("외래교수실");
				for(int i=0; i<6; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName5[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber5[i];
					m_Arr.add(m_Name);
				}
				break;
			case 1:
				tv.setText("학생회");
				for(int i=6; i<11; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName5[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber5[i];
					m_Arr.add(m_Name);
				}
				break;
			case 2: 
				tv.setText("실습실관리");
				for(int i=11; i<16; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName5[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber5[i];
					m_Arr.add(m_Name);
				}
				break;
			case 3: 
				tv.setText("복지시설");
				for(int i=16; i<20; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName5[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber5[i];
					m_Arr.add(m_Name);
				}
				break;	
			case 4: 
				tv.setText("부속시설");
				for(int i=20; i<28; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName5[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber5[i];
					m_Arr.add(m_Name);
				}
				break;	
			case 5: 
				tv.setText("건설·소방·방재기술연구소");
				for(int i=28; i<30; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName5[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber5[i];
					m_Arr.add(m_Name);
				}
				break;	
			case 6: 
				tv.setText("수위실(관리실)");
				for(int i=30; i<42; i++){
					m_Name = new TitleDTO();
					String strTemp[] = phoneName5[i].split(",");
					m_Name.name = strTemp[0]; // 이름
					m_Name.tel = strTemp[1]; // 번호
					m_Name.telNumber = phoneNumber5[i];
					m_Arr.add(m_Name);
				}
				break;		
			}
		}
		
		LifeListAdapter lva = new LifeListAdapter(this, m_Arr);
		lv.setAdapter(lva);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				
				if(m_Gubun.equals(m_cateGory[0])){
					m_Name = m_Arr.get(position);
					String url = "tel:" + m_Name.telNumber;
					 Intent call_phone = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					    startActivity(call_phone);
				}
				if(m_Gubun.equals(m_cateGory[1])){
					m_Name = m_Arr.get(position);
					String url = "tel:" + m_Name.telNumber;
					 Intent call_phone = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					    startActivity(call_phone);
				}
				if(m_Gubun.equals(m_cateGory[2])){
					m_Name = m_Arr.get(position);
					String url = "tel:" + m_Name.telNumber;
					 Intent call_phone = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					    startActivity(call_phone);
				}
				if(m_Gubun.equals(m_cateGory[3])){
					m_Name = m_Arr.get(position);
					String url = "tel:" + m_Name.telNumber;
					 Intent call_phone = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					    startActivity(call_phone);
				}
				if(m_Gubun.equals(m_cateGory[4])){
					m_Name = m_Arr.get(position);
					String url = "tel:" + m_Name.telNumber;
					 Intent call_phone = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					    startActivity(call_phone);
				}
			}
		});
	}
	
	class LifeListAdapter extends BaseAdapter {
		private LayoutInflater inflater;
		TitleDTO mTitle = new TitleDTO();
		ArrayList<TitleDTO> arrTitle = new ArrayList<TitleDTO>();
		
		LifeListAdapter(Context context,
				ArrayList<TitleDTO> arrTitle) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			this.arrTitle = arrTitle;
		}

		public int getCount() {
			// TODO Auto-generated method stub
			return arrTitle.size();
		}

		public TitleDTO getItem(int position) {
			// TODO Auto-generated method stub
			return arrTitle.get(position);
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public View getView(int position, View v, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (v == null) {
				v = inflater.inflate(
						R.layout.introduce_phone_info_list_row, parent,
						false);
			}

			TextView tv_str1 = (TextView) v.findViewById(R.id.introduce_phone_info_list_row_tv10);  // 이름
			TextView tv_str2 = (TextView) v.findViewById(R.id.introduce_phone_info_list_row_tv11);  // 전화번호

			mTitle = new TitleDTO();
			mTitle = arrTitle.get(position);
			if (mTitle != null) {
				tv_str1.setText(mTitle.name); 
				tv_str2.setText(mTitle.tel); 
				//lv_img2.setImageResource(R.drawable.icon);
			}

			return v;
		}
	}
}
