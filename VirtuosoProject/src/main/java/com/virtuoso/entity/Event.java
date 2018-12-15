package com.virtuoso.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Event extends Entity{
	private static final AtomicInteger count = new AtomicInteger(0);
	private int eventId;
	
	public int getEventId() {
		return eventId;
	}

	public Event(String label, String description, String link, String time) {
		super(label, description, link, time);
		// TODO Auto-generated constructor stub
		eventId = count.incrementAndGet();
	}
}
