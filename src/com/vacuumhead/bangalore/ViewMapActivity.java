package com.vacuumhead.bangalore;


import com.vacuumhead.bangalore.constants.StationConstants;
import com.vacuumhead.bangalore.utils.MetroMapData;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebSettings.ZoomDensity;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.Activity;

@SuppressLint("SetJavaScriptEnabled")
public class ViewMapActivity extends Activity {

	private WebView webView;
	private TextView messagePaneView;
	private final Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_menu);  
		
		webView = (WebView) findViewById(R.id.mapWebView);
		messagePaneView = (TextView) findViewById(R.id.messagePanelView);
		
		webView.getSettings().setJavaScriptEnabled(true);
		webView.addJavascriptInterface(new AndroidBridge(), "android");
		webView.loadUrl("file:///android_asset/metro_map.html");
		
		webView.getSettings().setBuiltInZoomControls(true);		
		webView.getSettings().setDefaultZoom(ZoomDensity.FAR);
		
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
					messagePaneView.setText("Fare from " + from + " to " + to + " is" +
					"1) Token Users: Rs. " + MetroMapData.getTokenFareBetweenStations
					(fromId, toId) + " \r\n2) Varshik User: Rs. " + MetroMapData.getVarshikFareBetweenStations(fromId, toId));
				}
				
			});
		}
		public void setSourceStation(final String from) {
			handler.post(new Runnable() {

				@Override
				public void run() {
					messagePaneView.setText("Source station set as " + from + "\r\nPlease select a destination station");
				}
				
			});
		}
	}
}
