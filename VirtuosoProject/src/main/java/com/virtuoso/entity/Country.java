package com.virtuoso.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Country extends Entity{
	private static final AtomicInteger count = new AtomicInteger(0);
	private int countryId;
	private String continent;
	
	public Country(String label, String description, String link, String time, String continent) {
		super(label, description, link, time);
		// TODO Auto-generated constructor stub
		this.continent = continent;
		countryId = count.incrementAndGet();
	}

	public String getContinent() {
		return continent;
	}
	
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	public int getCountryId() {
		return countryId;
	}
	
}
