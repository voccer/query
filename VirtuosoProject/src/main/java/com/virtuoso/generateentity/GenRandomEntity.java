package com.virtuoso.generateentity;


import java.io.FileNotFoundException;

import com.virtuoso.entity.Entity;

public class GenRandomEntity {
	private static GenEntity entities = new GenEntity();
	private static final GenCountry COUNTRIES = new GenCountry();
	private static final GenEvent EVENTS = new GenEvent();
	private static final GenLocation LOCATIONS = new GenLocation();
	private static final GenOrganization ORGANIZATIONS = new GenOrganization();
	private static final GenPerson PEOPLE = new GenPerson();
	private static final GenTime TIME_LIST = new GenTime();
//	
//	public GenRandomEntity() {
//	}

	public void setEntities(int numberOfLinks, int numberOfDates) {
		entities.setDateList(numberOfDates);
		entities.setLinkList(numberOfLinks);	
	}
	
	public void setPeople(String personLabelFileName, String personDescriptionFileName, String personStatusFileName) {
		try {
			PEOPLE.setDescriptionList(personDescriptionFileName);
			PEOPLE.setLabelList(personLabelFileName);
			PEOPLE.setStatusList(personStatusFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setOrganizations(String organizationLabelFileName, String organizationDescriptionFileName, String headquarterFileName){
		try {
			ORGANIZATIONS.setLabelList(organizationLabelFileName);
			ORGANIZATIONS.setDescriptionList(organizationDescriptionFileName);
			ORGANIZATIONS.setHeadquarterList(headquarterFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setLocations(String locationLabelFileName, String locationDescriptionFileName) {
		LOCATIONS.setDescriptionList(locationDescriptionFileName);
		LOCATIONS.setLabelList(locationLabelFileName);	
	}

	public void setTime(String timeLabelFileName, String timeDescriptionFileName) {
		TIME_LIST.setDescriptionList(timeDescriptionFileName);
		TIME_LIST.setLabelList(timeLabelFileName);	
	}

	public void setEvents(String eventLabelFileName, String eventDescriptionFileName) {
		EVENTS.setDescriptionList(eventDescriptionFileName);
		EVENTS.setLabelList(eventLabelFileName);	
	}
	
	// Thiếu Continent file, bổ sung continent file thì thêm tham số vào đây.
	
	public void setCountries(String countryLabelFileName, String countryDescriptionFileName, String countryContinentFileName) {
		try {
			COUNTRIES.setLabelList(countryLabelFileName);
			COUNTRIES.setDescriptionList(countryDescriptionFileName);
			COUNTRIES.setContinentList(countryContinentFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Entity genRandomEntity() {
		int random = (int) (Math.random() * 6 + 0);
		
		switch (random) {
		case 0:
			return PEOPLE.genPerson();
		case 1:
			return ORGANIZATIONS.genOrganization();
		case 2:
			return LOCATIONS.genLocation();
		case 3:
			return TIME_LIST.genTime();
		case 4:
			return EVENTS.genEvent();
		case 5:
			return COUNTRIES.genCountry();
		default:
			break;
		}
		return null;
	}
}
