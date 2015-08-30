package com.edu.ks.introduce;

import java.util.List;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.edu.ks.Intro;
import com.edu.ks.R;
import com.edu.ks.Tab;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class Campus_Info extends MapActivity{
	private List<Overlay> mapOverlays;
	private Drawable drawable;
	private CampusItemizedOverlay itemizedOverlay;
    private MapView mapView;
    private MapController mc;
    
    @Override
    protected boolean isRouteDisplayed() {
        // TODO Auto-generated method stub
        return false;
    }
    
    public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intro.gubunView = 1;
		Intent i = new Intent(getApplicationContext(), Tab.class);
		startActivity(i);
		finish();
	}
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기
        setContentView(R.layout.introduce_campus);
        TextView tv = (TextView) findViewById(R.id.intro_campus_textview);
		tv.setText("캠퍼스 안내");
        mapView = (MapView)findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapView.setSatellite(false);

        mc = mapView.getController();
        mc.animateTo(new GeoPoint(35184584,129100031));
        mc.setZoom(18);
        
        mapOverlays = mapView.getOverlays();
        drawable = this.getResources().getDrawable(R.drawable.green_flag);
        itemizedOverlay = new CampusItemizedOverlay(drawable, this);
       
        OverlayItem overlayitem1 = new OverlayItem(new GeoPoint(35184584,129100031), "대학본관","대학본관");
        OverlayItem overlayitem2 = new OverlayItem(new GeoPoint(35185202,129098947), "경상관","경상관");
        OverlayItem overlayitem3 = new OverlayItem(new GeoPoint(35185419,129098392), "창조관","창조관");
        OverlayItem overlayitem4 = new OverlayItem(new GeoPoint(35185465,129100532), "학생회관","학생회관");
        OverlayItem overlayitem5 = new OverlayItem(new GeoPoint(35183604,129098904), "예술관","예술관");
        OverlayItem overlayitem6 = new OverlayItem(new GeoPoint(35184132,129099510), "일민도서관","일민도서관");
        OverlayItem overlayitem7 = new OverlayItem(new GeoPoint(35183845,129100983), "진리관","진리관");
        OverlayItem overlayitem8 = new OverlayItem(new GeoPoint(35183643,129100116), "일민루","일민루");
        OverlayItem overlayitem9 = new OverlayItem(new GeoPoint(35182626,129098647), "멀티미디어관","멀티미디어관");
        OverlayItem overlayitem10 = new OverlayItem(new GeoPoint(35185114,129102026), "기숙사","기숙사");
        OverlayItem overlayitem11 = new OverlayItem(new GeoPoint(35183667,129097560), "부산외국어고등학교","부산외국어고등학교");
        OverlayItem overlayitem12 = new OverlayItem(new GeoPoint(3518555,1291011090), "정문","정문");
        OverlayItem overlayitem13 = new OverlayItem(new GeoPoint(35185482,129098083), "서문","서문");
        OverlayItem overlayitem14 = new OverlayItem(new GeoPoint(35183709,129101970), "동문","동문");
        OverlayItem overlayitem15 = new OverlayItem(new GeoPoint(35185796,129103137), "잔메마루","잔메마루");
        OverlayItem overlayitem16 = new OverlayItem(new GeoPoint(3518623,1291022170), "전용주차장","전용주차장");
        

        
        itemizedOverlay.addOverlay(overlayitem1);
        itemizedOverlay.addOverlay(overlayitem2);
        itemizedOverlay.addOverlay(overlayitem3);
        itemizedOverlay.addOverlay(overlayitem4);
        itemizedOverlay.addOverlay(overlayitem5);
        itemizedOverlay.addOverlay(overlayitem6);
        itemizedOverlay.addOverlay(overlayitem7);
        itemizedOverlay.addOverlay(overlayitem8);
        itemizedOverlay.addOverlay(overlayitem9);
        itemizedOverlay.addOverlay(overlayitem10);
        itemizedOverlay.addOverlay(overlayitem11);
        itemizedOverlay.addOverlay(overlayitem12);
        itemizedOverlay.addOverlay(overlayitem13);
        itemizedOverlay.addOverlay(overlayitem14);
        itemizedOverlay.addOverlay(overlayitem15);
        itemizedOverlay.addOverlay(overlayitem16);
        
        mapOverlays.add(itemizedOverlay);
    }


}
