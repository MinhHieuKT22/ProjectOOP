package entity;

import java.util.List;

public class Event extends Entity{
	private static int numberofEvent = 1;
	public Event(String label, String detail, List<Source> source) {
		numberofEvent += 1;
		this.id = "Event_" + Integer.toString(numberofEvent);
		this.label = label;
		this.detail = detail;
		this.source = source;
	}
	
	public static int getNoEvent() {
		return numberofEvent;
	}
}
