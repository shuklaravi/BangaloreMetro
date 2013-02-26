package com.vacuumhead.bangalore;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class GoogleMapActivity extends Activity {

    private WebView webView;
    private final Handler handler = new Handler();
    public String s;
    public String d;
    public static final String Source = "Source";
    public static final String Dest = "Destination";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        final AndroidBridge androidBridge = new AndroidBridge(this);
        webView = (WebView) findViewById(R.id.googleMapWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(androidBridge, "android");
        webView.loadUrl("file:///android_asset/googlemap.html");
        
        
        Bundle extras = getIntent().getExtras();
        s = extras.getString(Source);
        d = extras.getString(Dest);
        
        webView.setWebViewClient(new WebViewClient() {
        	@Override
        	public void onPageFinished(WebView view, String url) {
        		
        		webView.loadUrl("javascript:forceSet(\"" + s + "\",\"" + d + "\")");
        	}
        });
    	    
        
    
        
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_google_map, menu);
        return true;
    }

    public class AndroidBridge {
    	Context context;
    	AndroidBridge(Context c) {
            context = c;
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

        public void getRouteDetails(final String from, final String to) {
            handler.post(new Runnable() {

                @Override
                public void run() {


                }

            });
        }
    }
}
