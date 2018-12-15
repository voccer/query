package org.example;

import java.util.List;

import org.eclipse.rdf4j.query.BindingSet;

import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;

import virtuoso.rdf4j.driver.VirtuosoRepository;
import virtuoso.rdf4j.driver.VirtuosoRepositoryConnection;

public class HelloRDF4J {
	public static String filterResult(String str) {
		if (str.contains("http://")) {
			int lastIndex = str.lastIndexOf("#");
			return str.substring(lastIndex + 1);
		} else if (str.contains("^^")) {
			return str;
		} else {
			return str;
		}

	}

	public static void main(String[] args) {
		int count = 0;
		Repository rep = new VirtuosoRepository("jdbc:virtuoso://localhost:1111", "dba", "dba");

		try (VirtuosoRepositoryConnection conn = (VirtuosoRepositoryConnection) rep.getConnection()) {
			/*
			 * System.out.println("begin"); RepositoryResult<Statement> statements1 =
			 * conn.getStatements(null, null, null); Model model =
			 * QueryResults.asModel(statements1); Rio.write(model, System.out,
			 * RDFFormat.TURTLE); System.exit(1) ;
			 */
			String queryString = null;
			Query query = new Query();

			queryString = query.queryStatistical[6];
			queryString = query.querySimple[5];
			
			
			System.out.println(queryString);
			System.out.println("begin querying");
			
			long startTime = System.currentTimeMillis();
			TupleQuery tupleQuery = conn.prepareTupleQuery(queryString);
			long endTime = System.currentTimeMillis();
			System.out.println("Time to query this queryString is: " + (endTime - startTime) + " miliseconds. ");
			
			try (TupleQueryResult result = tupleQuery.evaluate()) {
				System.out.println("begin showing result...");
				List<String> bindingNames = result.getBindingNames();
				int size = bindingNames.size();
				while (result.hasNext()) {
					BindingSet solution = result.next();
					count++;
					for (int i = 0; i < size; i++) {
						System.out.println("value " + i + ": " + solution.getValue(bindingNames.get(i)));
					}
					System.out.println("/");
				}
				result.close();
			}
			System.out.println("end");
			System.out.println(count);

			

		}
	}
}
