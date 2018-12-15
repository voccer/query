package com.virtuoso.generateentity;

import java.util.ArrayList;
import java.util.List;

import com.virtuoso.entity.Event;

public class GenEvent extends GenEntity{
	private List<String> eventLabelList = new ArrayList<>();
	private List<String> eventDescList = new ArrayList<>();
	
	@Override
	public void setLabelList(String fileName) {
		// TODO Auto-generated method stub
		setList(fileName, eventLabelList);
	}

	@Override
	public void setDescriptionList(String fileName) {
		// TODO Auto-generated method stub
		setList(fileName, eventDescList);
	}

	@Override
	public String getRandomLabel() {
		// TODO Auto-generated method stub
		return eventLabelList.get(RD.nextInt(eventLabelList.size()));
	}

	@Override
	public String getRandomDescription() {
		// TODO Auto-generated method stub
		return eventDescList.get(RD.nextInt(eventDescList.size()));
	}

	public Event genEvent() {
		return new Event(this.getRandomLabel(), this.getRandomDescription(), getRandomLink(), getRandomDate());
	}
}
