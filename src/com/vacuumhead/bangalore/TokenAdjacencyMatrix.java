package com.vacuumhead.bangalore;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TokenAdjacencyMatrix extends Activity {
	public static final String Source="Source";
	public static final String Dest="Destination";
	private int fare=0;
	TextView V;
	@Override
	protected void onCreate(Bundle saved)
	{
		super.onCreate(saved);
		//Log.d(TAG,"onCreate");
		Bundle extras=getIntent().getExtras();
		String s=extras.getString(Source);
		String d=extras.getString(Dest);
		fare=func(s,d);
		LinearLayout lView = new LinearLayout(this);
		V = new TextView(this);
		V.setTextSize(25);
		V.setText("Fare for Token Users is: ₹"+fare);
		lView.addView(V);
		setContentView(lView);
//		 Toast.makeText(getBaseContext(), "Source!  "+ s+"\nDest!  "+d+"\n==  "+fare, Toast.LENGTH_SHORT).show();
	}
	
	
	private int func(String sourceStation, String destinationStation)
	{
		Map<String, Integer> map=new HashMap<String, Integer>();
		int[][] adjMatrix =new int[100][100];
		
		map.put("Baiyyappanahalli",0);
		map.put("Swami Vivekananda Road",1);
		map.put("Indira Nagar",2);
		map.put("Halasuru",3);
		map.put("Trinity Circle",4);
		map.put("M.G Road",5);
		
		
		adjMatrix[0][0]=10;
		adjMatrix[0][1]=10;
		adjMatrix[0][2]=12;
		adjMatrix[0][3]=12;
		adjMatrix[0][4]=14;
		adjMatrix[0][5]=15;
		
		int sourceKey=(Integer)map.get(sourceStation);
		int destinationKey=(Integer)map.get(destinationStation);
				
		int count=Math.abs(destinationKey-sourceKey);
		return adjMatrix[0][count];
	}
	

}
