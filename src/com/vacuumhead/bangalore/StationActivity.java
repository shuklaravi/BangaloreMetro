package com.vacuumhead.bangalore;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class StationActivity extends Activity {

	public String[] items;
	public WebView webView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);
        
        Resources res = getResources();
        items = res.getStringArray(R.array.stationName);
        
        webView = (WebView) findViewById(R.id.stationDataWebView);
        Spinner stationSpinner = (Spinner) findViewById(R.id.selectStationSpinner);
        ArrayAdapter<String> adapterSource = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        adapterSource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stationSpinner.setAdapter(adapterSource);        
        
		stationSpinner.setOnItemSelectedListener(selectedStationListener);
		stationSpinner.setSelection(0);
    }
    
    OnItemSelectedListener selectedStationListener = new AdapterView.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			String htmlUrl = "file:///android_asset/station/";
			htmlUrl += (items[position] + ".html");
			webView.loadUrl(htmlUrl);
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_station, menu);
        return true;
    }
}
