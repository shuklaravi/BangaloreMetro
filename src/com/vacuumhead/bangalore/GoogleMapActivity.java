package com.vacuumhead.bangalore;

import com.vacuumhead.bangalore.ViewMapActivity.AndroidBridge;
import com.vacuumhead.bangalore.constants.StationConstants;
import com.vacuumhead.bangalore.utils.MetroMapData;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GoogleMapActivity extends Activity {

    private WebView webView;
    private final Handler handler = new Handler();
    private Button clearGoogleMap;
    public String s;
    public String d;
    private TextView messagePaneView;
    public static final String Source = "Source";
    public static final String Dest = "Destination";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);		
        
        messagePaneView = (TextView) findViewById(R.id.messageGooglePanelView);
        webView = (WebView) findViewById(R.id.googleMapWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new AndroidBridge(), "androidGoogleMap");
        webView.loadUrl("file:///android_asset/googlemap.html");
        if(!isNetworkAvailable()) {
        	messagePaneView.setText("You need to be connected to the internet to view it on Google Maps");
        }
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
        
        s = extras.getString(Source);
        d = extras.getString(Dest);
        
        clearGoogleMap = (Button) findViewById(R.id.clearGoogleSelection);
		clearGoogleMap.setOnClickListener(clearMapListener);
		
        webView.setWebViewClient(new WebViewClient() {
        	@Override
        	public void onPageFinished(WebView view, String url) {
        		
        		webView.loadUrl("javascript:forceSet(\"" + s + "\",\"" + d + "\")");
        	}
        });
        }
        
    }
    
    public boolean isNetworkAvailable() {
		
    	ConnectivityManager cm =
    	        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
    	        return true;
    	    }
    	    return false;
	}
	
    
    OnClickListener clearMapListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			webView.loadUrl("javascript:clearMap()");		
			webView.bringToFront();
			messagePaneView.setText(R.string.viewMapDefaultMessage);
		}
	}; 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_google_map, menu);
        return true;
    }

    public class AndroidBridge {

    	public void getRouteDetails(final String from, final String to) {
			handler.post(new Runnable() {

				@Override
				public void run() {
					  
					int fromId = StationConstants.getStationCode(from);
					int toId = StationConstants.getStationCode(to);
					messagePaneView.setText("Fare from " + from + " to " + to + "\n" + 
					"Token Users: Rs. " + MetroMapData.getTokenFareBetweenStations
					(fromId, toId) + " \r\nVarshik User: Rs. " + MetroMapData.getVarshikFareBetweenStations(fromId, toId));
					clearGoogleMap = (Button) findViewById(R.id.clearGoogleSelection);
					clearGoogleMap.setOnClickListener(clearMapListener);
					clearGoogleMap.bringToFront();
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
