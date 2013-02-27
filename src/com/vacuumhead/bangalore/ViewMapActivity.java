package com.vacuumhead.bangalore;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vacuumhead.bangalore.constants.StationConstants;
import com.vacuumhead.bangalore.utils.MetroMapData;

@SuppressLint("SetJavaScriptEnabled")
public class ViewMapActivity extends Activity {

	private WebView webView;
	private TextView messagePaneView;
	private Button clearMap;
	private final Handler handler = new Handler();
	public static final String Source="Source";
	public static final String Dest="Destination";
	public String s;
	public String d;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_view_map);  
		
		webView = (WebView) findViewById(R.id.mapWebView);
		messagePaneView = (TextView) findViewById(R.id.messagePanelView);
		
		webView.getSettings().setJavaScriptEnabled(true);
		webView.addJavascriptInterface(new AndroidBridge(), "android");
		webView.loadUrl("file:///android_asset/metro_map.html");
		
		webView.getSettings().setBuiltInZoomControls(true);					
		webView.setInitialScale(90);		
		
		clearMap = (Button) findViewById(R.id.clearSelection);
		clearMap.setOnClickListener(clearMapListener);
		
		Bundle extras = getIntent().getExtras();
        if(extras != null) {
			s=extras.getString(Source);
			d=extras.getString(Dest);
			
			webView.setWebViewClient(new WebViewClient() {
	        	@Override
	        	public void onPageFinished(WebView view, String url) {
	        		
	        		webView.loadUrl("javascript:forceSet(\"" + s + "\",\"" + d + "\")");
	        	}
	        });
		}
		
	}
	OnClickListener clearMapListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			webView.loadUrl("javascript:clear()");		
			webView.bringToFront();
			messagePaneView.setText(R.string.viewMapDefaultMessage);
		}
	}; 
	
	public class AndroidBridge {
		
		public void getRouteDetails(final String from, final String to) {
			handler.post(new Runnable() {

				@Override
				public void run() {
					int fromId = StationConstants.getStationCode(from);
					int toId = StationConstants.getStationCode(to);
					messagePaneView.setText("Fare from " + from + " to " + to + " is\n" + 
					"Token Users: Rs. " + MetroMapData.getTokenFareBetweenStations
					(fromId, toId) + " \r\nVarshik User: Rs. " + MetroMapData.getVarshikFareBetweenStations(fromId, toId));
					clearMap.bringToFront();
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
		public void alert(final String msg) {
			handler.post(new Runnable() {

				@Override
				public void run() {
					Toast.makeText(getApplicationContext(),
                            msg,
                            Toast.LENGTH_SHORT).show();
				}
				
			});
		}
	}

	
}
