package com.vacuumhead.bangalore;


import com.vacuumhead.bangalore.constants.StationConstants;
import com.vacuumhead.bangalore.utils.MetroMapData;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.graphics.Color;

public class ViewMapActivity extends Activity {

	private WebView webView;
	private final Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_menu);  
		
		webView = (WebView) findViewById(R.id.mapWebView);
		
		webView.getSettings().setJavaScriptEnabled(true);
		webView.addJavascriptInterface(new AndroidBridge(), "android");
		webView.loadUrl("file:///android_asset/svgg.html");
		
		webView.getSettings().setBuiltInZoomControls(true);		

		
//		webView.setWebChromeClient(new WebChromeClient() {
//			public boolean onJsAlert(final WebView webView, final String url, final String message, JsResult result) {
//				
//			}
//		});
	}
	
	public class AndroidBridge {
		
		public void getRouteDetails(final String from, final String to) {
			handler.post(new Runnable() {

				@Override
				public void run() {
					int fromId = StationConstants.getStationCode(from);
					int toId = StationConstants.getStationCode(to);
					
					Toast.makeText(getBaseContext(), 
			    			"Fare from " + from + " to " + to + "is \r\n" +
			    					"1) Token User: Rs. " + 
			    					MetroMapData.getTokenFareBetweenStations
			    						(fromId, toId) + " \r\n" +
			    					"2) Varshik User: Rs. " +
			    					MetroMapData.getVarshikFareBetweenStations
			    						(fromId, toId),
			    			Toast.LENGTH_SHORT).show();
					
				}
				
			});
		}
		public void setSourceStation(final String from) {
			handler.post(new Runnable() {

				@Override
				public void run() {
					Toast.makeText(getBaseContext(), 
			    			"Source station set as " + from,
			    			Toast.LENGTH_SHORT).show();					
				}
				
			});
		}
	}
}
