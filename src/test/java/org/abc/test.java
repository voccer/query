package org.abc;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.model.vocabulary.XMLSchema;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryResults;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;

import virtuoso.rdf4j.driver.VirtuosoRepository;

public class test {
	public static void main(String[] args) {
		
		Repository myRepository = new VirtuosoRepository("jdbc:virtuoso://localhost:1111", "dba", "dba");
		
		
		RepositoryConnection conn = myRepository.getConnection();
		
		String namespace = "http://example.org/";
		long start = System.currentTimeMillis();
		ValueFactory f = myRepository.getValueFactory();
		
		IRI huynh1 = f.createIRI(namespace, "huynh1");
		
		IRI huynh2 = f.createIRI(namespace, "huynh2");
		
		for(int i = 0; i < 1000; i++) {
			conn.add(huynh1, huynh2, f.createLiteral("huynh" +i));
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
