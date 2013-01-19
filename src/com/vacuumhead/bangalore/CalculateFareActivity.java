package com.vacuumhead.bangalore;


import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public  class CalculateFareActivity extends Activity  {

	private TextView myText;
	 private final String TAG="BMetro";
	 public String source,dest; 
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_calculate_fare);
			//View calcfareButton=findViewById(R.id.calculatefare_button);
			//calcfareButton.setOnClickListener(this);
			Resources res = getResources();
			final String[] items = res.getStringArray(R.array.stationName);
			final Spinner spinnerSource= (Spinner) findViewById(R.id.source_spinner);
			ArrayAdapter<String> adapterSource=new  ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
			adapterSource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinnerSource.setAdapter(adapterSource);
			//spinnerSource.setOnItemSelectedListener((OnItemSelectedListener) this);
	        final Spinner spinnerDest= (Spinner) findViewById(R.id.destination_spinner);
			ArrayAdapter<String> adapterDest=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
			adapterDest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinnerDest.setAdapter(adapterDest);
			//spinnerDest.setOnItemSelectedListener((OnItemSelectedListener) this);
			spinnerSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			
			    @Override
			    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) 
			    {
			    	Toast.makeText(parentView.getContext(), 
			    			"Source : " + parentView.getItemAtPosition(position).toString(),
			    			Toast.LENGTH_SHORT).show();
			    	source=parentView.getItemAtPosition(position).toString();
			    }

			    @Override
			    public void onNothingSelected(AdapterView<?> parentView) {
			        return;
			    }

			});
			
			spinnerDest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				
			    @Override
			    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) 
			    {
			    	Toast.makeText(parentView.getContext(), 
			    			"Destination : " + parentView.getItemAtPosition(position).toString(),
			    			Toast.LENGTH_SHORT).show();
			    	dest=parentView.getItemAtPosition(position).toString();
			    }

			    @Override
			    public void onNothingSelected(AdapterView<?> parentView) {
			        return;
			    }

			});
			
	        final Button calculateFareTokenButton = (Button) findViewById(R.id.fareBeginToken_button);
	        final Button calculateFareVarshikButton = (Button) findViewById(R.id.fareBeginVarshik_button);
	    /*    final TextView textView1 = (TextView) findViewById(R.id.textView1);	
	        final TextView textView2 = (TextView) findViewById(R.id.textView2);
	        calculateFareTokenButton.setOnClickListener(new View.OnClickListener() {             
	            public void onClick(View v) {                 
	                // Perform action on click 
	                    textView1.setText(source+"  "+dest);

	                }         });*/
	        calculateFareTokenButton.setOnClickListener(mainMenuClickListener);
	        calculateFareVarshikButton.setOnClickListener(mainMenuClickListener);
	        			
		}	

		
	OnClickListener mainMenuClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(v.getId()){
				
				case R.id.fareBeginToken_button:
					startTokenFare();
					break;
				case R.id.fareBeginVarshik_button:
					startVarshikFare();
					break;
				}			
			}
	};	
	
	Bundle bundle=new Bundle();
	private void startTokenFare()
	{
	 
	  Intent intent=new Intent(CalculateFareActivity.this,TokenUserFareActivity.class);
	  bundle.putString(TokenUserFareActivity.Source,source);
	  bundle.putString(TokenUserFareActivity.Dest,dest);
	  intent.putExtras(bundle);
	  startActivityForResult(intent, 0);
	}
	private void startVarshikFare()
	{
	 
	  Intent intent=new Intent(CalculateFareActivity.this,VarshikUserFareActivity.class);
	  bundle.putString(VarshikUserFareActivity.Source,source);
	  bundle.putString(VarshikUserFareActivity.Dest,dest);
	  intent.putExtras(bundle);
	  startActivityForResult(intent, 0);
	}
	
}
