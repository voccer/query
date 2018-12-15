package com.virtuoso.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Organization extends Entity{
	private static final AtomicInteger count = new AtomicInteger(0);
	private int organizationId;
	private String headquarter;
	
	public Organization(String label, String description, String link, String time, String headquarter) {
		super(label, description, link, time);
		// TODO Auto-generated constructor stub
		this.headquarter = headquarter;
		organizationId = count.incrementAndGet();
	}

	public String getHeadquarter() {
		return headquarter;
	}
	
	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}
	
	public int getOrganizationId() {
		return organizationId;
	}
	
	
}
