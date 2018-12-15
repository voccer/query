package com.virtuoso.connectdb;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.repository.RepositoryResult;

import com.virtuoso.entity.Country;
import com.virtuoso.entity.Entity;
import com.virtuoso.entity.Event;
import com.virtuoso.entity.Location;
import com.virtuoso.entity.Organization;
import com.virtuoso.entity.Person;
import com.virtuoso.entity.Time;

public class CreateEntitiesIRI extends VirtuosoRepoSchema {

	public CreateEntitiesIRI() {
		super();
		// TODO Auto-generated constructor stub
	}

	Literal label = null;
	Literal desc = null;
	Literal link = null;
	Literal date = null;
	Literal status = null;
	Literal continent = null;
	Literal headquarter = null;

	IRI entityIRI = null;

	public IRI createPersonIRI(Person person, Model modelEntities) {
		entityIRI = valueFactory.createIRI(PERSON.toString(), Integer.toString(person.getPersonId()));

		label = valueFactory.createLiteral(person.getLabel());
		desc = valueFactory.createLiteral(person.getDescription());
		link = valueFactory.createLiteral(person.getLink());
		date = valueFactory.createLiteral(person.getDate());
		status = valueFactory.createLiteral(person.getStatus());

		// add new statement to database
		modelEntities.add(entityIRI, RDF.TYPE, PERSON);
		modelEntities.add(entityIRI, LABEL, label);
		modelEntities.add(entityIRI, DESCRIPTION, desc);
		modelEntities.add(entityIRI, DATE, date);
		modelEntities.add(entityIRI, LINK, link);
		modelEntities.add(entityIRI, STATUS, status);

		return entityIRI;
	}

	public IRI createCountryIRI(Country country, Model modelEntities) {
		entityIRI = valueFactory.createIRI(COUNTRY.toString(), Integer.toString(country.getCountryId()));

		label = valueFactory.createLiteral(country.getLabel());
		desc = valueFactory.createLiteral(country.getDescription());
		link = valueFactory.createLiteral(country.getLink());
		date = valueFactory.createLiteral(country.getDate());
		continent = valueFactory.createLiteral(country.getContinent());

		// add new statement to database
		modelEntities.add(entityIRI, RDF.TYPE, COUNTRY);
		modelEntities.add(entityIRI, LABEL, label);
		modelEntities.add(entityIRI, DESCRIPTION, desc);
		modelEntities.add(entityIRI, DATE, date);
		modelEntities.add(entityIRI, LINK, link);
		modelEntities.add(entityIRI, STATUS, continent);

		return entityIRI;
	}

	public IRI createEventIRI(Event event,  Model modelEntities) {
		entityIRI = valueFactory.createIRI(EVENT.toString(), Integer.toString(event.getEventId()));

		label = valueFactory.createLiteral(event.getLabel());
		desc = valueFactory.createLiteral(event.getDescription());
		link = valueFactory.createLiteral(event.getLink());
		date = valueFactory.createLiteral(event.getDate());

		// add new statement to database
		modelEntities.add(entityIRI, RDF.TYPE, EVENT);
		modelEntities.add(entityIRI, LABEL, label);
		modelEntities.add(entityIRI, DESCRIPTION, desc);
		modelEntities.add(entityIRI, DATE, date);
		modelEntities.add(entityIRI, LINK, link);

		return entityIRI;
	}

	public IRI createOrganizationIRI(Organization organization,  Model modelEntities) {
		entityIRI = valueFactory.createIRI(ORGANIZATION.toString(), Integer.toString(organization.getOrganizationId()));

		label = valueFactory.createLiteral(organization.getLabel());
		desc = valueFactory.createLiteral(organization.getDescription());
		link = valueFactory.createLiteral(organization.getLink());
		date = valueFactory.createLiteral(organization.getDate());
		headquarter = valueFactory.createLiteral(organization.getHeadquarter());

		// add new statement to database
		modelEntities.add(entityIRI, RDF.TYPE, ORGANIZATION);
		modelEntities.add(entityIRI, LABEL, label);
		modelEntities.add(entityIRI, DESCRIPTION, desc);
		modelEntities.add(entityIRI, DATE, date);
		modelEntities.add(entityIRI, LINK, link);
		modelEntities.add(entityIRI, HEADQUARTER, headquarter);

		return entityIRI;
	}

	public IRI createTimeIRI(Time time,  Model modelEntities) {
		entityIRI = valueFactory.createIRI(TIME.toString(), Integer.toString(time.getTimeId()));

		label = valueFactory.createLiteral(time.getLabel());
		desc = valueFactory.createLiteral(time.getDescription());
		link = valueFactory.createLiteral(time.getLink());
		date = valueFactory.createLiteral(time.getDate());

		// add new statement to database
		modelEntities.add(entityIRI, RDF.TYPE, TIME);
		modelEntities.add(entityIRI, LABEL, label);
		modelEntities.add(entityIRI, DESCRIPTION, desc);
		modelEntities.add(entityIRI, DATE, date);
		modelEntities.add(entityIRI, LINK, link);

		return entityIRI;
	}

	public IRI createLocationIRI(Location location,  Model modelEntities) {
		entityIRI = valueFactory.createIRI(LOCATION.toString(), Integer.toString(location.getLocationId()));

		label = valueFactory.createLiteral(location.getLabel());
		desc = valueFactory.createLiteral(location.getDescription());
		link = valueFactory.createLiteral(location.getLink());
		date = valueFactory.createLiteral(location.getDate());

		// add new statement to database
		modelEntities.add(entityIRI, RDF.TYPE, LOCATION);
		modelEntities.add(entityIRI, LABEL, label);
		modelEntities.add(entityIRI, DESCRIPTION, desc);
		modelEntities.add(entityIRI, DATE, date);
		modelEntities.add(entityIRI, LINK, link);

		return entityIRI;
	}

	public IRI createEntityIRI(Entity entity, Model modelEntities) {
		if (entity instanceof Person) {
			return createPersonIRI((Person) entity, modelEntities);
		} else if (entity instanceof Organization) {
			return createOrganizationIRI((Organization) entity, modelEntities);
		} else if (entity instanceof Location) {
			return createLocationIRI((Location) entity, modelEntities);
		} else if (entity instanceof Country) {
			return createCountryIRI((Country) entity, modelEntities);
		} else if (entity instanceof Time) {
			return createTimeIRI((Time) entity, modelEntities);
		} else if (entity instanceof Event) {
			return createEventIRI((Event) entity, modelEntities);
		}
		return null;
	}

	public IRI createRelIRI(String relDesc) {
		IRI relIRI = valueFactory.createIRI(RELATIONSHIP.toString(), relDesc);
		return relIRI;
	}

	public void addStatement(IRI entity1, IRI rel, IRI entity2, Model modelRel) {
		modelRel.add(entity1, rel, entity2);
	}

	public long queryStatementTime(IRI subject, IRI predicate, IRI object, Resource context) {
		long startTime = System.currentTimeMillis();
		RepositoryResult<Statement> statements = conn.getStatements(subject, predicate, object, context);

		long endTime = System.currentTimeMillis();
		statements.close();
		return endTime - startTime;
	}
}
