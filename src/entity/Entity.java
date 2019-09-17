package entity;

import java.util.List;

public class Entity {
	protected String id;
	protected String label;
	protected String detail;
	protected List<Source> source;
	
	public void setLabel(String label) {
		this.label = label;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}	
	public void setSource(List<Source> source) {
		this.source = source;
	}
	
	public void addSource(Source source) {
		this.source.add(source);
	}
	
	public String getId() {
		return this.id;
	}
	public String getLabel() {
		return this.label;
	}
	public String getDetail() {
		return this.detail;
	}
	public List<Source> getSource() {
		return this.source;
	}

}

