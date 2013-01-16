package com.vacuumhead.bangalore;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.graphics.Color;

public class ViewMapActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_menu);  
		
		  final LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout);
		  ll.setOnTouchListener(new View.OnTouchListener() {
		        public boolean onTouch(View V,MotionEvent event) {
		        	float x=event.getX();float y=event.getY();

		        	if(x>=50&&x<=65&&y>=165&&y<=200){
		        		Toast.makeText(
			                    getApplicationContext(), 
			                    "Mahatma Gandhi Road", 
			                    Toast.LENGTH_LONG).show();}
		        	if(x>=88&&x<=103&&y>=185&&y<=217){
		        		Toast.makeText(
			                    getApplicationContext(), 
			                    "Trinity", 
			                    Toast.LENGTH_LONG).show();}
		        	if(x>=130&&x<=144&&y>=165&&y<=198){
		        		Toast.makeText(
			                    getApplicationContext(), 
			                    "Halasuru", 
			                    Toast.LENGTH_LONG).show();}
		        	if(x>=180&&x<=194&&y>=157&&y<=188){
		        		Toast.makeText(
			                    getApplicationContext(), 
			                    "Indiranagar", 
			                    Toast.LENGTH_LONG).show();}
		        	if(x>=205&&x<=217&&y>=109&&y<=139){
		        		Toast.makeText(
			                    getApplicationContext(), 
			                    "Swami Vivekananda Road", 
			                    Toast.LENGTH_LONG).show();}
		        	if(x>=247&&x<=261&&y>=73&&y<=106){
		        		Toast.makeText(getApplicationContext(), 
			                    "Baiyyappanahalli", 
			                    Toast.LENGTH_LONG).show();}
		        	
		                return true;
		        }

		    });
		  
	}
}
