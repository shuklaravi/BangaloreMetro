package com.vacuumhead.bangalore;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class CalculateFareActivity extends Activity {

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_calculate_fare);
			//View calcfareButton=findViewById(R.id.calculatefare_button);
			//calcfareButton.setOnClickListener(this);
			final Spinner sp3= (Spinner) findViewById(R.id.stations_spinner);
			ArrayAdapter<CharSequence> adp3=ArrayAdapter.createFromResource(this,R.array.str2,android.R.layout.simple_spinner_item);
	        adp3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        sp3.setAdapter(adp3);
	        final Spinner sp2= (Spinner) findViewById(R.id.stations1_spinner);
			ArrayAdapter<CharSequence> adp2=ArrayAdapter.createFromResource(this,R.array.str2,android.R.layout.simple_spinner_item);
	        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        sp2.setAdapter(adp2);
	       
		}	
		

	}


