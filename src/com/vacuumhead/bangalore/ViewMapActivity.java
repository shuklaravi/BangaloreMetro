package com.vacuumhead.bangalore;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Color;

public class ViewMapActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_menu);  
		
		  final LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout);
		  final TextView text = (TextView) findViewById(R.id.text);
		 
		  ll.setOnTouchListener(new View.OnTouchListener() {
		        public boolean onTouch(View VV,MotionEvent event) {
		        	text.setTextColor(Color.BLACK);
		        	text.setText("Event captured !");
		 
		                return true;
		        }

		    });
		  
	}
}
