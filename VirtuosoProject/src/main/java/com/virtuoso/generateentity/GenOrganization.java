package com.virtuoso.generateentity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.virtuoso.entity.Organization;

public class GenOrganization extends GenEntity{
	private List<String> headquarterList = new ArrayList<>();
	private List<String> orgLabelList = new ArrayList<>();
	private List<String> orgDescList = new ArrayList<>();
	
	public void setHeadquarterList(String fileName) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileName));
		while (scanner.hasNextLine()) {
			headquarterList.add(scanner.nextLine());
		}
		scanner.close();
	}
	
	public String getRandomHeadquarter() {
		return headquarterList.get(RD.nextInt(headquarterList.size()));
	}
	
	@Override
	public void setLabelList(String fileName) {
		setList(fileName, orgLabelList);	
	}

	@Override
	public void setDescriptionList(String fileName) {
		setList(fileName, orgDescList);
	}

	@Override
	public String getRandomLabel() {
		// TODO Auto-generated method stub
		return orgLabelList.get(RD.nextInt(orgLabelList.size()));
	}

	@Override
	public String getRandomDescription() {
		// TODO Auto-generated method stub
		return orgDescList.get(RD.nextInt(orgDescList.size()));
	}

	public Organization genOrganization() {
		return new Organization(this.getRandomLabel(), this.getRandomDescription(), getRandomLink(), getRandomDate(), getRandomHeadquarter());
	}
}
