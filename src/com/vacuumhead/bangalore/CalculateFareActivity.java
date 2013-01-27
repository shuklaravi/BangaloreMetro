package com.vacuumhead.bangalore;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public  class CalculateFareActivity extends Activity  {

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
			
	        final Button calculateFareButton = (Button) findViewById(R.id.fareBeginbutton);
	        final Button intermediateStationsButton = (Button) findViewById(R.id.intermediateStationsButton);
	        final Button viewOnMapButton = (Button) findViewById(R.id.viewOnMapButton);
	        calculateFareButton.setOnClickListener(mainMenuClickListener);
	        intermediateStationsButton.setOnClickListener(mainMenuClickListener);
	        viewOnMapButton.setOnClickListener(mainMenuClickListener);	        			
		}	

		
	OnClickListener mainMenuClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(v.getId()){
				
				case R.id.fareBeginbutton:
					startTokenFare();
					break;
				case R.id.viewOnMapButton:
					Intent intent2 = new Intent(CalculateFareActivity.this, LocationActivity.class);
					startActivity(intent2);
					break;
				case R.id.intermediateStationsButton:
					startIntermediateStations();
					break;		
				}			
			}
	};	
	
Bundle bundle=new Bundle();
  private void startViewOnMap()
   {
 
  Intent intent=new Intent(CalculateFareActivity.this,ViewMapActivity.class);
  //bundle.putString(ViewMapActivity.Source,s);
  //bundle.putString(ViewMapActivity.Dest,d);
  intent.putExtras(bundle);
  startActivityForResult(intent, 0);
   }
  private void startIntermediateStations()
  {
 
  Intent intent=new Intent(CalculateFareActivity.this,IntermediateStations.class);
  bundle.putString(IntermediateStations.Source,source);
  bundle.putString(IntermediateStations.Dest,dest);
  intent.putExtras(bundle);
  startActivityForResult(intent, 0);
   }

	private void startTokenFare()
	{
	 
	  Intent intent=new Intent(CalculateFareActivity.this,UserFareActivity.class);
	  bundle.putString(UserFareActivity.Source,source);
	  bundle.putString(UserFareActivity.Dest,dest);
	  intent.putExtras(bundle);
	  startActivityForResult(intent, 0);
	}
	
	
}
