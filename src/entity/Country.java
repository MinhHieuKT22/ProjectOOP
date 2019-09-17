package entity;

import java.util.List;

public class Country extends Entity {
	private static int numberofCountry = 1;
	
	public Country(String label, String detail, List<Source> source) {
		numberofCountry += 1;
		this.id = "Country_" + Integer.toString(numberofCountry);
		this.label = label;
		this.detail = detail;
		this.source = source;
	}
	
	public static int getNoCountry() {
		return numberofCountry;
	}
}
