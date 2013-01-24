package com.vacuumhead.bangalore;

import java.util.Vector;

import com.vacuumhead.bangalore.utils.MetroMapData;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class IntermediateStations extends Activity {

	public static final String Source="Source";
	public static final String Dest="Destination";
	private Vector<String> stations;
	protected void onCreate(Bundle saved)
	{
		super.onCreate(saved);
		Bundle extras=getIntent().getExtras();
		String s=extras.getString(Source);
		String d=extras.getString(Dest);
		
		//Toast.makeText(getBaseContext(), "Source!  "+ s+"\nDest!  "+d+dd, Toast.LENGTH_SHORT).show();
}
}