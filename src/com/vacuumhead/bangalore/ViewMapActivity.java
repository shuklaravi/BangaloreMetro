package com.vacuumhead.bangalore;


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
		webView.loadUrl("file:///android_asset/metro_map.html");
		
		webView.getSettings().setBuiltInZoomControls(true);		

		
//		webView.setWebChromeClient(new WebChromeClient() {
//			public boolean onJsAlert(final WebView webView, final String url, final String message, JsResult result) {
//				
//			}
//		});
	}
	
	public class AndroidBridge {
		public void callAndroid(final String msg) {
			handler.post(new Runnable() {

				@Override
				public void run() {
					Toast.makeText(getBaseContext(), 
			    			msg,
			    			Toast.LENGTH_SHORT).show();					
				}
				
			});
		}
	}
}
