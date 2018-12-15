package com.virtuoso.generateentity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.virtuoso.entity.Country;

public class GenCountry extends GenEntity{
	private List<String> continentList = new ArrayList<String>();
	private List<String> couLabelList =  new ArrayList<>();
	private List<String> couDescList = new ArrayList<>();
	
	public void setContinentList(String fileName) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileName));
		while (scanner.hasNextLine()) {
			continentList.add(scanner.nextLine());
		}
		scanner.close();
	}
	
	public String getRandomContinent() {
		return continentList.get(RD.nextInt(continentList.size()));
	}
	
	@Override
	public void setLabelList(String fileName) {
		// TODO Auto-generated method stub
		setList(fileName, couLabelList);
	}

	@Override
	public void setDescriptionList(String fileName) {
		// TODO Auto-generated method stub
		setList(fileName, couDescList);
	}

	@Override
	public String getRandomLabel() {
		// TODO Auto-generated method stub
		return couLabelList.get(RD.nextInt(couLabelList.size()));
	}

	@Override
	public String getRandomDescription() {
		// TODO Auto-generated method stub
		return couDescList.get(RD.nextInt(couDescList.size()));
	}

	public Country genCountry() {
		return new Country(this.getRandomLabel(), this.getRandomDescription(), getRandomLink(), getRandomDate(), getRandomContinent());
	}
}
