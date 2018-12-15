package com.virtuoso.connectdb;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.impl.TreeModel;

import com.virtuoso.entity.Entity;
import com.virtuoso.generateentity.GenRandomEntity;
import com.virtuoso.relationship.GenRelationship;

public class DBGeneration {
	private static int numberOfEntities = 0;
	private static int numberOfRelationships = 0;

	private static int numberOfLinks = 10000;
	private static int numberOfDates = 10000;

	final static Random RD = new Random();

	private static ConstantsFileName fileName = new ConstantsFileName();

	private CreateEntitiesIRI entitiesIRI = new CreateEntitiesIRI();
	private GenRandomEntity genRandomEntity = new GenRandomEntity();
	private GenRelationship genRelationship = new GenRelationship();

	private List<IRI> entityIRIList;

	public DBGeneration() throws FileNotFoundException {
		genRandomEntity.setEntities(numberOfLinks, numberOfDates);
		genRandomEntity.setPeople(fileName.PERSON_LABEL, fileName.PERSON_DESCRIPTION, fileName.PERSON_STATUS);
		genRandomEntity.setOrganizations(fileName.ORGANIZATION_LABEL, fileName.ORGANIZATION_DESCRIPTION,
				fileName.ORGANIZATION_HEADQUARTER);
		genRandomEntity.setCountries(fileName.COUNTRY_LABEL, fileName.COUNTRY_DESCRIPTION, fileName.COUNTRY_CONTINENT);
		genRandomEntity.setLocations(fileName.LOCATION_LABEL, fileName.LOCATION_DESCRIPTION);
		genRandomEntity.setTime(fileName.TIME_LABEL, fileName.LOCATION_DESCRIPTION);
		genRandomEntity.setEvents(fileName.EVENT_LABEL, fileName.EVENT_DESCRIPTION);

		genRelationship.setRelDescriptionList(fileName.RELATIONSHIP_DESCRIPTION);

		// virtuosoReposchema.createSchema();

		entityIRIList = new ArrayList<>();
	}

	private void genEntities(int nEntitites) {
		int count = 0;
		if(nEntitites > numberOfEntities) {
			Entity entity = null;
			int end = (nEntitites - numberOfEntities);
			int quarter = end/4;
			// chay tu 0 toi 1/4 sau do add va giai phong bo nho
			{
				Model modelEntities = new TreeModel();
				for(int i = 0; i < quarter; i++) {
					entity = genRandomEntity.genRandomEntity();
					entityIRIList.add(entitiesIRI.createEntityIRI(entity, modelEntities));
					System.out.println(count);
					count++;
				}
				entitiesIRI.getConnection().add(modelEntities);
				entitiesIRI.clear();
			}
			
			// chay tu 1/4 -> 1/2 sau do giai phong bo nho
			int middle = 2 * quarter;
			{
				Model modelEntities = new TreeModel();
				for(int i = quarter; i < middle; i++) {
					entity = genRandomEntity.genRandomEntity();
					entityIRIList.add(entitiesIRI.createEntityIRI(entity, modelEntities));
					
					System.out.println(count);
					count++;
				}
				entitiesIRI.getConnection().add(modelEntities);
				entitiesIRI.clear();
			}
			
			//chay tu 1/2 ->3/4 sau do giai phong bo nho
			int threeQuarter = 3 * quarter;
			{
				Model modelEntities = new TreeModel();
				for(int i = middle; i < threeQuarter ; i++) {
					entity = genRandomEntity.genRandomEntity();
					entityIRIList.add(entitiesIRI.createEntityIRI(entity, modelEntities));
					
					System.out.println(count);
					count++;
				}
				entitiesIRI.getConnection().add(modelEntities);
				entitiesIRI.clear();
			}
			
			// chay tu 3/4 toi het
			{
				Model modelEntities = new TreeModel();
				
				for(int i = threeQuarter; i < end ; i++) {
					entity = genRandomEntity.genRandomEntity();
					entityIRIList.add(entitiesIRI.createEntityIRI(entity, modelEntities));
					
					System.out.println(count);
					count++;
				}
				entitiesIRI.getConnection().add(modelEntities);
				entitiesIRI.clear();
			}
		}
		numberOfEntities = nEntitites;
	}
	

	private void genRelationships(int nRels) {

		if (nRels > numberOfRelationships) {
			IRI entity1 = null;
			IRI entity2 = null;
			IRI relationship = null;
			int end = nRels - numberOfRelationships;

			// add tu 0 toi 1/2 sau do giai phong
			int middle = end / 2;
			{
				Model modelRel = new TreeModel();
				for (int i = 0; i < middle; i++) {
					entity1 = entityIRIList.get(RD.nextInt(numberOfEntities));
					entity2 = entityIRIList.get(RD.nextInt(numberOfEntities));
	
					relationship = entitiesIRI.createRelIRI(genRelationship.genRandomRelDesc());
					entitiesIRI.addStatement(entity1, relationship, entity2, modelRel);
	
				}
				entitiesIRI.getConnection().add(modelRel);
				entitiesIRI.clear();
			}
			// add tu 1/2 sau
			{
				Model modelRel = new TreeModel();

				for (int i = middle; i < end; i++) {
					entity1 = entityIRIList.get(RD.nextInt(numberOfEntities));
					entity2 = entityIRIList.get(RD.nextInt(numberOfEntities));
	
					relationship = entitiesIRI.createRelIRI(genRelationship.genRandomRelDesc());
					entitiesIRI.addStatement(entity1, relationship, entity2, modelRel);
					entitiesIRI.getConnection().add(modelRel);
					entitiesIRI.clear();
				}
			}

		}
		numberOfRelationships = nRels;
	}

	public void genDB(int nEntities, int nRels) {
		genEntities(nEntities);
		System.out.println("rel");
		//genRelationships(nRels);
		System.out.println("nghi rel");


	}

	public CreateEntitiesIRI getDatabaseConnect() {
		return entitiesIRI;
	}

}
