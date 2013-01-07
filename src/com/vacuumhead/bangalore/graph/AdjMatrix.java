package com.vacuumhead.bangalore.graph;

public class AdjMatrix {
	public String name;
	public int numberOfStations;
	public int[][] adjMatrix;
	
	AdjMatrix(String _name, int _numberOfStations) {
		this.name = _name;
		this.numberOfStations = _numberOfStations;
		adjMatrix = new int[_numberOfStations][_numberOfStations];
	}	
}
