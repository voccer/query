package com.virtuoso.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Location extends Entity{
	private static final AtomicInteger count = new AtomicInteger(0);
	private int locationId;

	public Location(String label, String description, String link, String time) {
		super(label, description, link, time);
		// TODO Auto-generated constructor stub
		locationId = count.incrementAndGet();
	}

	public int getLocationId() {
		return locationId;
	}
	
}
