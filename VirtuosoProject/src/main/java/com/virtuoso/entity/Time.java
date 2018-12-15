package com.virtuoso.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Time extends Entity{
	private static final AtomicInteger count = new AtomicInteger(0);
	private int timeId;
	
	public Time(String label, String description, String link, String time) {
		super(label, description, link, time);
		// TODO Auto-generated constructor stub
		timeId = count.incrementAndGet();
	}

	public int getTimeId() {
		return timeId;
	}
	
}
