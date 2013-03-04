package com.vacuumhead.bangalore;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class AboutUsActivity extends Activity {

	WebView webView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        webView = (WebView) findViewById(R.id.aboutWebView);
        webView.loadUrl("file:///android_asset/aboutus.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_about_us, menu);
        return true;
    }
}
