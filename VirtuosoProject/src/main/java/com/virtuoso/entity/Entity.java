package com.virtuoso.entity;

public abstract class  Entity {
	private String label;
	private String description;
	private String link;
	private String date;
	
	public Entity() {
		
	}
	
	public Entity(String label, String description, String link, String date) {
		this.label = label;
		this.description = description;
		this.link = link;
		this.date = date;
	}
	
	public String getLabel() {	
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
