package com.vacuumhead.bangalore;


import com.vacuumhead.bangalore.constants.StationConstants;
import com.vacuumhead.bangalore.utils.MetroMapData;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
		Button calculateFareButton = (Button) findViewById(R.id.calculateFareButton);
		Button exitButton = (Button) findViewById(R.id.applicationExitButton);
			
		calculateFareButton.setOnClickListener(mainMenuClickListener);		
		exitButton.setOnClickListener(mainMenuClickListener);
		
		
	
	}
	
	OnClickListener mainMenuClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			
			case R.id.calculateFareButton:
				Intent intent = new Intent(MainActivity.this, CalculateFareActivity.class);
				startActivity(intent);
				break;
			case R.id.applicationExitButton:
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