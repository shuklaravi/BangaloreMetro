package com.vacuumhead.bangalore;

import java.util.HashMap;
import java.util.Map;

public class AdjacencyMatrix {
	private Map<String, Integer> map=new HashMap<String, Integer>();
	private String[][] adjMatrix;
	
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
	

}
