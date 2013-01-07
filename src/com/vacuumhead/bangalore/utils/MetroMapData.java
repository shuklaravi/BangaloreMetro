package com.vacuumhead.bangalore.utils;

import com.vacuumhead.bangalore.constants.StationConstants;

public class MetroMapData {

	private String greenLineStationGroup = "greenLineStationList";
	private String purpleLineStationGroup = "purpleLinestationList";
	
	public int getFareBetweenStations(int fromStation, int toStation) {
		
		return -1;
	}
	
	private double[][] createTokenUserAdjacencyMatrix() {
		int totalNumberOfStation = StationConstants.purpleLineStationList.values().length + 
				StationConstants.greenLineStationList.values().length;		
				
		double[][] tokenUser = {
			{0.00, 10.00, 12.00, 12.00, 14.00, 15.00},
			{10.00, 0.00, 10.00, 12.00, 12.00, 14.00},
			{12.00, 10.00, 0.00, 10.00, 12.00, 12.00},
			{12.00, 12.00, 10.00, 0.00, 10.00, 12.00},
			{14.00, 12.00, 12.00, 10.00, 0.00, 10.00},
			{15.00, 14.00, 12.00, 12.00, 10.00, 0.00}
		};
		return tokenUser;
	}
	
	private double[][] createVarshikUserAdjacencyMatrix() {
		int totalNumberOfStation = StationConstants.purpleLineStationList.values().length + 
				StationConstants.greenLineStationList.values().length;		
				
		double[][] varshikUser = {
			{0.00, 8.50, 10.20, 10.20, 11.90, 12.75},
			{8.50, 0.00, 8.50, 10.20, 10.20, 11.90},
			{10.20, 8.50, 0.00, 8.50, 10.20, 10.20},
			{10.20, 10.20, 8.50, 0.00, 8.50, 10.20},
			{11.90, 10.20, 10.20, 8.50, 0.00, 8.50},
			{12.75, 11.90, 10.20, 10.20, 8.50, 0.00}
		};
		return varshikUser;
	}
	
	public String[] getStationList() {		
		return null;		
	}
}
