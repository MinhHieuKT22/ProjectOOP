package entity;

import java.util.List;

public class Location extends Entity {
	private static int numberofLocation = 1;
	
	public Location(String label, String detail, List<Source> source) {
		numberofLocation += 1;
		this.id = "Location_" + Integer.toString(numberofLocation);
		this.label = label;
		this.detail = detail;
		this.source = source;
	}
	
	public static int getNoLocation() {
		return numberofLocation;
	}
}
