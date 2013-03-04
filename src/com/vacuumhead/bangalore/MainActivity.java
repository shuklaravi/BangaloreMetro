package com.vacuumhead.bangalore;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;

public class MainActivity extends Activity {

	final public String mapDataFile = "mapData";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button exitButton1 = (Button) findViewById(R.id.applicationExitButton1);
		Button calculateFareButton1 = (Button) findViewById(R.id.calculateFareButton1);
		Button viewMapButton1 = (Button) findViewById(R.id.viewMapButton1);
		calculateFareButton1.setOnClickListener(mainMenuClickListener);
		Button viewStation = (Button) findViewById(R.id.viewStationButton);
		viewStation.setOnClickListener(mainMenuClickListener);
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
				Intent intent3 = new Intent(MainActivity.this, MapActivity.class);
				startActivity(intent3);
				break;	
			case R.id.viewStationButton:
				Intent intent5 = new Intent(MainActivity.this, StationActivity.class);
				startActivity(intent5);
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