package com.vacuumhead.bangalore;

import com.vacuumhead.bangalore.constants.StationConstants;
import com.vacuumhead.bangalore.utils.MetroMapData;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TokenUserFareActivity extends Activity {
	public static final String Source="Source";
	public static final String Dest="Destination";
	private double fare=0;
	TextView V;
	@Override
	protected void onCreate(Bundle saved)
	{
		super.onCreate(saved);
		
		Bundle extras=getIntent().getExtras();
		String s=extras.getString(Source);
		String d=extras.getString(Dest);
		fare = MetroMapData.
				getTokenFareBetweenStations
				(StationConstants.getStationCode(s), 
						StationConstants.getStationCode(d));
		LinearLayout lView = new LinearLayout(this);
		V = new TextView(this);
		V.setTextSize(25);
		V.setText("Fare for Token Users is Rs. "+fare);
		lView.addView(V);
		setContentView(lView);
		 Toast.makeText(getBaseContext(), "Source!  "+ s+"\nDest!  "+d, Toast.LENGTH_SHORT).show();
	}
	

}
