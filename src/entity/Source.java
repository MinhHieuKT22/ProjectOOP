package entity;

public class Source {
	private String link;
	private String date;
	
	public Source(String link, String date) {
		this.link = link;
		this.date = date;
	}
	
	public String getLink() {
		return this.link;
	}
	
	public String getDate() {
		return this.date;
	}
}
