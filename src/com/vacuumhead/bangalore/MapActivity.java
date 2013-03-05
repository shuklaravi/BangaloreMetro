package com.vacuumhead.bangalore;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class MapActivity extends TabActivity {
	public static final String Source="Source";
	public static final String Dest="Destination";
	public String s;
	public String d;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Intent intent1,intent2;
        intent1 = new Intent().setClass(this, ViewMapActivity.class);
        intent2 = new Intent().setClass(this, GoogleMapActivity.class);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
        	Bundle bundle = new Bundle();
			s=extras.getString(Source);
			d=extras.getString(Dest);
			bundle.putString(ViewMapActivity.Source, s);
	        bundle.putString(ViewMapActivity.Dest, d);
	        bundle.putString(GoogleMapActivity.Source, s);
	        bundle.putString(GoogleMapActivity.Dest, d);
	        intent1.putExtras(bundle);
	        intent2.putExtras(bundle);
	        }
			
        TabHost tabHost = getTabHost();  
        TabHost.TabSpec spec;  
          
        
        spec = tabHost.newTabSpec("tabOne");  
        spec.setContent(intent1);  
        spec.setIndicator("Interactive Map");  
        tabHost.addTab(spec);
        tabHost.getTabWidget().getChildAt(0).getLayoutParams().height = 40;
        
        
        spec = tabHost.newTabSpec("tabTwo");  
        spec.setContent(intent2);  
        spec.setIndicator("Google Map");
        tabHost.addTab(spec);
        tabHost.getTabWidget().getChildAt(1).getLayoutParams().height = 40;
        tabHost.setCurrentTab(0);
        
        
    }
}
