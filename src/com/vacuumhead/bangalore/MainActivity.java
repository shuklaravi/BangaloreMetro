package com.vacuumhead.bangalore;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	final public String mapDataFile = "mapData";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Button calculateFareButton = (Button) findViewById(R.id.calculateFareButton);
		//Button exitButton = (Button) findViewById(R.id.applicationExitButton);
		Button exitButton1 = (Button) findViewById(R.id.applicationExitButton1);
		Button calculateFareButton1 = (Button) findViewById(R.id.calculateFareButton1);
		//Button viewMapButton = (Button) findViewById(R.id.viewMapButton);
		Button viewMapButton1 = (Button) findViewById(R.id.viewMapButton1);	
		//calculateFareButton.setOnClickListener(mainMenuClickListener);		
		calculateFareButton1.setOnClickListener(mainMenuClickListener);
		Button viewGoogleMap = (Button) findViewById(R.id.viewGoogleMapButton);
		//calculateFareButton1.setBackgroundColor(Integer.parseInt("bdbdbd", 16)+0xFF000000);
		//exitButton.setOnClickListener(mainMenuClickListener);
		//viewMapButton.setOnClickListener(mainMenuClickListener);
		viewGoogleMap.setOnClickListener(mainMenuClickListener);
		viewMapButton1.setOnClickListener(mainMenuClickListener);
		exitButton1.setOnClickListener(mainMenuClickListener);
	
	}
	
	OnClickListener mainMenuClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			
			//case R.id.calculateFareButton:
				//Intent intent = new Intent(MainActivity.this, CalculateFareActivity.class);
				//startActivity(intent);
				//break;
			//case R.id.viewMapButton:
				//Intent intent1 = new Intent(MainActivity.this, ViewMapActivity.class);
				//startActivity(intent1);
				//break;
			case R.id.calculateFareButton1:
				Intent intent2 = new Intent(MainActivity.this, CalculateFareActivity.class);
				startActivity(intent2);
				break;
			case R.id.viewMapButton1:
				Intent intent3 = new Intent(MainActivity.this, ViewMapActivity.class);
				startActivity(intent3);
				break;	
			case R.id.viewGoogleMapButton:
				Intent intent4 = new Intent(MainActivity.this, GoogleMapActivity.class);
				startActivity(intent4);
				break;
			//case R.id.applicationExitButton:
				//finish();
			//	break;
			case R.id.applicationExitButton1:
				finish();
				break;	
			}			
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}