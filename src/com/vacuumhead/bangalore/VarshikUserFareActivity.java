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

public class VarshikUserFareActivity extends Activity {
	public static final String Source="Source";
	public static final String Dest="Destination";
	public String s,d;
	private double fare=0;
	TextView V;
	@Override
	protected void onCreate(Bundle saved)
	{
		super.onCreate(saved);
		//Log.d(TAG,"onCreate");
		setContentView(R.layout.varshik_user_fare);
		Bundle extras=getIntent().getExtras();
		s=extras.getString(Source);
		d=extras.getString(Dest);

		fare = MetroMapData.
				getVarshikFareBetweenStations
				(StationConstants.getStationCode(s), 
						StationConstants.getStationCode(d));
		
		TextView V=(TextView)findViewById(R.id.varshikText);
		Button intermediateStationsButton=(Button)findViewById(R.id.intermediateStationsButton);
		Button viewOnMapButton=(Button)findViewById(R.id.viewOnMapButton);
		intermediateStationsButton.setOnClickListener(mainMenuClickListener);
		viewOnMapButton.setOnClickListener(mainMenuClickListener);
		V.setText("Fare for Varshik Users is Rs. "+fare);
		Toast.makeText(getBaseContext(), "Source!  "+ s+"\nDest!  "+d, Toast.LENGTH_SHORT).show();
	}
OnClickListener mainMenuClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.viewOnMapButton:
				startViewOnMap();
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
	 
	  Intent intent=new Intent(VarshikUserFareActivity.this,ViewMapActivity.class);
	  //bundle.putString(ViewMapActivity.Source,s);
	  //bundle.putString(ViewMapActivity.Dest,d);
	  intent.putExtras(bundle);
	  startActivity(intent);
	}
	private void startIntermediateStations()
	{
	 
	  Intent intent=new Intent(VarshikUserFareActivity.this,IntermediateStations.class);
	  bundle.putString(IntermediateStations.Source,s);
	  bundle.putString(IntermediateStations.Dest,d);
	  intent.putExtras(bundle);
	  startActivity(intent);	  
	}
}
