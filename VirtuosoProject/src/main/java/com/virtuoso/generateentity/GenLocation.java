package com.virtuoso.generateentity;

import java.util.ArrayList;
import java.util.List;

import com.virtuoso.entity.Location;

public class GenLocation extends GenEntity{
	private List<String> locLabelList =  new ArrayList<>();
	private List<String> locDescList = new ArrayList<>();
	
	@Override
	public void setLabelList(String fileName) {
		// TODO Auto-generated method stub
		setList(fileName, locLabelList);	
	}


	@Override
	public void setDescriptionList(String fileName) {
		// TODO Auto-generated method stub
		setList(fileName, locDescList);	
	}


	@Override
	public String getRandomLabel() {
		// TODO Auto-generated method stub
		return locLabelList.get(RD.nextInt(locLabelList.size()));
	}


	@Override
	public String getRandomDescription() {
		// TODO Auto-generated method stub
		return locDescList.get(RD.nextInt(locDescList.size()));
	}


	public Location genLocation() {
		return new Location(getRandomLabel(), getRandomDescription(), getRandomLink(), getRandomDate());
	}
}
