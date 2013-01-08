package com.vacuumhead.bangalore;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CalculateFareActivity extends Activity {

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_calculate_fare);
			//View calcfareButton=findViewById(R.id.calculatefare_button);
			//calcfareButton.setOnClickListener(this);
			final Spinner sp3= (Spinner) findViewById(R.id.source_spinner);
			ArrayAdapter<CharSequence> adp3=ArrayAdapter.createFromResource(this,R.array.str2,android.R.layout.simple_spinner_item);
	        adp3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        sp3.setAdapter(adp3);
	        final Spinner sp2= (Spinner) findViewById(R.id.destination_spinner);
			ArrayAdapter<CharSequence> adp2=ArrayAdapter.createFromResource(this,R.array.str2,android.R.layout.simple_spinner_item);
	        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        sp2.setAdapter(adp2);
	        
	        Button calculateFareTokenButton = (Button) findViewById(R.id.fareBeginToken_button);
	        Button calculateFareVarshikButton = (Button) findViewById(R.id.fareBeginVarshik_button);
				
	        calculateFareTokenButton.setOnClickListener(mainMenuClickListener);		
	        calculateFareVarshikButton.setOnClickListener(mainMenuClickListener);
		}	
		OnClickListener mainMenuClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(v.getId()){
				
				case R.id.fareBeginToken_button:
					Intent intent = new Intent(CalculateFareActivity.this, TokenUser.class);
					startActivity(intent);
					break;
				case R.id.fareBeginVarshik_button:
					Intent intent1 = new Intent(CalculateFareActivity.this,VarshikUser.class);
					startActivity(intent1);
					break;
				}			
			}
		};
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_calculate_fare, menu);
			return true;
		} 
		

	}


