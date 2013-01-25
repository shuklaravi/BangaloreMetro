package com.vacuumhead.bangalore;

import java.util.Vector;

import com.vacuumhead.bangalore.constants.StationConstants;
import com.vacuumhead.bangalore.utils.MetroMapData;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class IntermediateStations extends Activity {

	public static final String Source="Source";
	public static final String Dest="Destination";
	
	protected void onCreate(Bundle saved)
	{
		super.onCreate(saved);
		setContentView(R.layout.activity_intermediate_station); 
		
		Bundle extras=getIntent().getExtras();
		String s=extras.getString(Source);
		String d=extras.getString(Dest);
		
		Vector<String> intermediateStation = MetroMapData.applyBFS(s, d);
		LayoutInflater tableInflator = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);		
		
		TableLayout table = (TableLayout) findViewById(R.id.intermediateTable);
		
		for(int i = 0; i < intermediateStation.size(); ++i) {
			View tableRow = tableInflator.inflate(R.layout.intermediate_each_station, null);
			TextView name = (TextView) tableRow.findViewById(R.id.stationName);
			name.setText(intermediateStation.get(i));
			
			table.addView(tableRow, i);
			
		}
				
}
}