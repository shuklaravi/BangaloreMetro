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
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        
        TabHost tabHost = getTabHost();  
        TabHost.TabSpec spec;  
        Intent intent;  
        intent = new Intent().setClass(this, ViewMapActivity.class);
        spec = tabHost.newTabSpec("tabOne");  
        spec.setContent(intent);  
        spec.setIndicator("Interactive Map");  
        tabHost.addTab(spec);
        tabHost.getTabWidget().getChildAt(0).getLayoutParams().height = 30;
  
        intent = new Intent().setClass(this, GoogleMapActivity.class);
        spec = tabHost.newTabSpec("tabTwo");  
        spec.setContent(intent);  
        spec.setIndicator("Google Map");
        tabHost.addTab(spec);
        tabHost.getTabWidget().getChildAt(1).getLayoutParams().height = 30;
        tabHost.setCurrentTab(0);
    }
}
