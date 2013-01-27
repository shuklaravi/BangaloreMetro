package com.vacuumhead.bangalore;

import com.vacuumhead.bangalore.constants.StationConstants;
import com.vacuumhead.bangalore.utils.MetroMapData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UserFareActivity extends Activity {
	public static final String Source="Source";
	public static final String Dest="Destination";
	public String s,d;
	private double fareT=0,fareV=0;
	TextView V;
	@Override
	protected void onCreate(Bundle saved)
	{
		super.onCreate(saved);
		setContentView(R.layout.user_fare);
		Bundle extras=getIntent().getExtras();
		s=extras.getString(Source);
		d=extras.getString(Dest);
		fareT = MetroMapData.
				getTokenFareBetweenStations
				(StationConstants.getStationCode(s), 
						StationConstants.getStationCode(d));
		fareV = MetroMapData.
				getVarshikFareBetweenStations
				(StationConstants.getStationCode(s), 
						StationConstants.getStationCode(d));
		TextView V=(TextView)findViewById(R.id.tokenText);
		V.setText("Fare for Token Users is Rs. "+fareT);
		TextView V1=(TextView)findViewById(R.id.varshikText);
		V1.setText("Fare for Varshik Users is Rs. "+fareV);
		//Toast.makeText(getBaseContext(), "Source!  "+ s+"\nDest!  "+d, Toast.LENGTH_SHORT).show();
	}
	
}
