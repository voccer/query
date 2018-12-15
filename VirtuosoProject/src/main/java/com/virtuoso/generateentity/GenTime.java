package com.virtuoso.generateentity;

import java.util.ArrayList;
import java.util.List;

import com.virtuoso.entity.Time;

public class GenTime extends GenEntity{
	private List<String> timeLabelList = new ArrayList<>();
	private List<String> timeDescList = new ArrayList<>();
	
	@Override
	public void setLabelList(String fileName) {
		// TODO Auto-generated method stub
		setList(fileName, timeLabelList);
	}

	@Override
	public void setDescriptionList(String fileName) {
		// TODO Auto-generated method stub
		setList(fileName, timeDescList);
	}

	@Override
	public String getRandomLabel() {
		// TODO Auto-generated method stub
		return timeLabelList.get(RD.nextInt(timeLabelList.size()));
	}

	@Override
	public String getRandomDescription() {
		// TODO Auto-generated method stub
		return timeDescList.get(RD.nextInt(timeDescList.size()));
	}

	public Time genTime() {
		return new Time(this.getRandomLabel(), this.getRandomDescription(), getRandomLink(), getRandomDate());
	}
}
