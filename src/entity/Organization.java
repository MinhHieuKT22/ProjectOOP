package entity;

import java.util.List;

public class Organization extends Entity{
	private static int numberofOrganization = 1;
	private String headquarter;
	
	public Organization(String label, String detail,String headquarter, List<Source> source) {
		this.id = "Organization_" + Integer.toString(numberofOrganization);
		numberofOrganization += 1;
		this.label = label;
		this.detail = detail;
		this.source = source;
		this.headquarter = headquarter;
	}
	
	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}
	
	public String getHeadquarter() {
		return this.headquarter;
	}
	
	public static int getNoOrganization() {
		return numberofOrganization;
	}
}
