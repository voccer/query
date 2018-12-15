package com.virtuoso.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Person extends Entity{
	private String status;
	private int personId;
	private static final AtomicInteger count = new AtomicInteger(0);

	public Person(String label, String description, String link, String time, String status) {
		super(label, description, link, time);
		// TODO Auto-generated constructor stub
		this.status = status;
		personId = count.incrementAndGet();
	}

	public int getPersonId() {
		return personId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
