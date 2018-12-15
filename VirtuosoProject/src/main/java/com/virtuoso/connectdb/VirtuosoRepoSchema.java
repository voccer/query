package com.virtuoso.connectdb;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import virtuoso.rdf4j.driver.VirtuosoRepository;

public class VirtuosoRepoSchema {
	
	private static final String URL = "jdbc:virtuoso://localhost:1111/";
	private static final String USERNAME = "dba";
	private static final String PASSWORD = "dba";
	
	final String NAMESPACE = "http://example.com/virtuoso#";
	
	
	Repository myRepository = new VirtuosoRepository(URL, USERNAME, PASSWORD);
	RepositoryConnection conn = myRepository.getConnection();
	

	ValueFactory valueFactory =  conn.getValueFactory();
	
	protected IRI LABEL;
	protected IRI DESCRIPTION;
	protected IRI DATE;
	protected IRI LINK;
	protected IRI STATUS;
	protected IRI CONTINENT;
	protected IRI HEADQUARTER;
	
	protected IRI PERSON;
	protected IRI COUNTRY;
	protected IRI EVENT;
	protected IRI TIME;
	protected IRI LOCATION;
	protected IRI ORGANIZATION;
	protected IRI RELATIONSHIP;
	
	public  VirtuosoRepoSchema() {
		LABEL = valueFactory.createIRI(NAMESPACE, "label");
		DESCRIPTION = valueFactory.createIRI(NAMESPACE, "description");
		DATE = valueFactory.createIRI(NAMESPACE, "date");
		LINK = valueFactory.createIRI(NAMESPACE, "link");
		STATUS = valueFactory.createIRI(NAMESPACE, "status");
		CONTINENT = valueFactory.createIRI(NAMESPACE, "continent");
		HEADQUARTER = valueFactory.createIRI(NAMESPACE, "headquarter");
		
		PERSON = valueFactory.createIRI(NAMESPACE, "Person");
		COUNTRY = valueFactory.createIRI(NAMESPACE, "Country");
		EVENT = valueFactory.createIRI(NAMESPACE, "Event");
		TIME = valueFactory.createIRI(NAMESPACE, "Time");
		LOCATION = valueFactory.createIRI(NAMESPACE, "Location");
		ORGANIZATION = valueFactory.createIRI(NAMESPACE, "Organization");
		
		
		RELATIONSHIP = valueFactory.createIRI(NAMESPACE, "Relationship#");
	}
	
	public RepositoryConnection getConnection() {
		return conn;
	}
	
	public void closeConnection() {
		if(conn != null) {
			conn.close();
		}
	}
	
	public void clear() {
		if(conn != null) {
			//conn.clear();
		}

	}



	public IRI getLABEL() {
		return LABEL;
	}

	public IRI getDESCRIPTION() {
		return DESCRIPTION;
	}

	public IRI getDATE() {
		return DATE;
	}

	public IRI getLINK() {
		return LINK;
	}

	public IRI getSTATUS() {
		return STATUS;
	}

	public IRI getCONTINENT() {
		return CONTINENT;
	}

	public IRI getHEADQUARTER() {
		return HEADQUARTER;
	}

	public IRI getPERSON() {
		return PERSON;
	}

	public IRI getCOUNTRY() {
		return COUNTRY;
	}

	public IRI getEVENT() {
		return EVENT;
	}

	public IRI getTIME() {
		return TIME;
	}

	public IRI getLOCATION() {
		return LOCATION;
	}

	public IRI getORGANIZATION() {
		return ORGANIZATION;
	}

	public IRI getRELATIONSHIP() {
		return RELATIONSHIP;
	}
	
}
