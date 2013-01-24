package com.vacuumhead.bangalore.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.vacuumhead.bangalore.constants.StationConstants;
import com.vacuumhead.bangalore.constants.UserConstants;

public class MetroMapData {
	
	public static double[][] tokenPurple = {
		{0.00, 10.00, 12.00, 12.00, 14.00, 15.00},
		{10.00, 0.00, 10.00, 12.00, 12.00, 14.00},
		{12.00, 10.00, 0.00, 10.00, 12.00, 12.00},
		{12.00, 12.00, 10.00, 0.00, 10.00, 12.00},
		{14.00, 12.00, 12.00, 10.00, 0.00, 10.00},
		{15.00, 14.00, 12.00, 12.00, 10.00, 0.00}
	};
	
	public static double[][] varshikPurple = {
		{0.00, 8.50, 10.20, 10.20, 11.90, 12.75},
		{8.50, 0.00, 8.50, 10.20, 10.20, 11.90},
		{10.20, 8.50, 0.00, 8.50, 10.20, 10.20},
		{10.20, 10.20, 8.50, 0.00, 8.50, 10.20},
		{11.90, 10.20, 10.20, 8.50, 0.00, 8.50},
		{12.75, 11.90, 10.20, 10.20, 8.50, 0.00}
	};
	
	public static Map<String, Double> getFareBetweenStations(int fromStation, int toStation) {
		Map<String, Double> map = new HashMap<String, Double>();
		map.put(UserConstants.tokenUser, getTokenFareBetweenStations(fromStation, toStation));
		map.put(UserConstants.varshikUser, getVarshikFareBetweenStations(fromStation, toStation));
		
		return map;
		
	}
	
	public static double getVarshikFareBetweenStations(int fromStation, int toStation) {
		
		return varshikPurple[fromStation][toStation];
	}
	
	public static double getTokenFareBetweenStations(int fromStation, int toStation) {
	
		return tokenPurple[fromStation][toStation];
	}
	
	
	
}
