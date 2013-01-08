package com.vacuumhead.bangalore;


import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
	 private String source,dest,s;
	 private Map<String, Integer> map=new HashMap<String, Integer>();
		private String[][] adjMatrix;
		
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
			    	source=items[position];
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
			    	dest=items[position];
			    }

			    @Override
			    public void onNothingSelected(AdapterView<?> parentView) {
			        return;
			    }

			});
	        final Button calculateFareTokenButton = (Button) findViewById(R.id.fareBeginToken_button);
	        final Button calculateFareVarshikButton = (Button) findViewById(R.id.fareBeginVarshik_button);
	        final TextView textView1 = (TextView) findViewById(R.id.textView1);	
	        final TextView textView2 = (TextView) findViewById(R.id.textView2);
	        calculateFareTokenButton.setOnClickListener(new View.OnClickListener() {             
	            public void onClick(View v) {                 
	                // Perform action on click 
	                    textView1.setText(source+"  "+dest);

	                }         });
	        
	        //calculateFareVarshikButton.setOnClickListener(mainMenuClickListener);			
		}	

		
		
	//	AdjacencyMatrix adjMatrix;
	  //  String s=adjMatrix.func(source,dest);	
	
		String func(String sourceStation, String destinationStation)
		{
			
			map.put("Baiyyappanahalli",1);
			map.put("Swami Vivekananda Road",2);
			map.put("Indira Nagar",3);
			map.put("Halasuru",4);
			map.put("Trinity Circle",5);
			map.put("M.G Road",6);
			
			
			adjMatrix[1][1]="10";
			adjMatrix[1][2]="10";
			adjMatrix[1][3]="12";
			adjMatrix[1][4]="12";
			adjMatrix[1][5]="14";
			adjMatrix[1][6]="15";
			
			int sourceKey=(Integer)map.get(sourceStation);
			int destinationKey=(Integer)map.get(destinationStation);
					
			int count=Math.abs(destinationKey-sourceKey)+1;
			return adjMatrix[1][count];
		}
		
		
/*
	OnClickListener mainMenuClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(v.getId()){
				
				case R.id.fareBeginToken_button:
					Intent intent = new Intent(CalculateFareActivity.this,TokenUser.class);
					startActivity(intent);					
					break;
				case R.id.fareBeginVarshik_button:
					Intent intent1 = new Intent(CalculateFareActivity.this,VarshikUser.class);
					startActivity(intent1);
					break;
				}			
			}
<<<<<<< HEAD
		};*/
=======
		};
>>>>>>> a11997d36de8a5d8cc6e3762f5d4d3e461033c97
		

	}


/*
LinearLayout lView = new LinearLayout(this);

myText = new TextView(this);
myText.setText("My Text");

lView.addView(myText);

setContentView(lView);*/
