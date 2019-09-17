package entity;

import java.util.List;

public class Time extends Entity{
	private static int numberofTime = 1;
	
	public Time(String label, String detail, List<Source> source) {
		numberofTime += 1;
		this.id = "Time_" + Integer.toString(numberofTime);
		this.label = label;
		this.detail = detail;
		this.source = source;
	}
	
	public static int getNoTime() {
		return numberofTime;
	}
}
