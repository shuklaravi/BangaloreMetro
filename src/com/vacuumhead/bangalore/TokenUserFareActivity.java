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

public class TokenUserFareActivity extends Activity {
	public static final String Source="Source";
	public static final String Dest="Destination";
	public String s,d;
	private double fare=0;
	TextView V;
	@Override
	protected void onCreate(Bundle saved)
	{
		super.onCreate(saved);
		setContentView(R.layout.token_user_fare);
		Bundle extras=getIntent().getExtras();
		s=extras.getString(Source);
		d=extras.getString(Dest);
		fare = MetroMapData.
				getTokenFareBetweenStations
				(StationConstants.getStationCode(s), 
						StationConstants.getStationCode(d));
		TextView V=(TextView)findViewById(R.id.tokenText);
		Button intermediateStationsButton=(Button)findViewById(R.id.intermediateStationsButton);
		Button viewOnMapButton=(Button)findViewById(R.id.viewOnMapButton);
		intermediateStationsButton.setOnClickListener(mainMenuClickListener);
		viewOnMapButton.setOnClickListener(mainMenuClickListener);	
		V.setText("Fare for Token Users is Rs. "+fare);
		//Toast.makeText(getBaseContext(), "Source!  "+ s+"\nDest!  "+d, Toast.LENGTH_SHORT).show();
	}
OnClickListener mainMenuClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			switch(v.getId()){
			case R.id.viewOnMapButton:
				Intent intent2 = new Intent(TokenUserFareActivity.this, LocationActivity.class);
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
	 
	  Intent intent=new Intent(TokenUserFareActivity.this,ViewMapActivity.class);
	  //bundle.putString(ViewMapActivity.Source,s);
	  //bundle.putString(ViewMapActivity.Dest,d);
	  intent.putExtras(bundle);
	  startActivityForResult(intent, 0);
	}
	private void startIntermediateStations()
	{
	 
	  Intent intent=new Intent(TokenUserFareActivity.this,IntermediateStations.class);
	  bundle.putString(IntermediateStations.Source,s);
	  bundle.putString(IntermediateStations.Dest,d);
	  intent.putExtras(bundle);
	  startActivityForResult(intent, 0);
	}
}
