package org.abc;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.repository.Repository;

import virtuoso.rdf4j.driver.VirtuosoRepository;
import virtuoso.rdf4j.driver.VirtuosoRepositoryConnection;

public class CheckModel {

	public CheckModel() {
		// TODO Auto-generated constructor stub
	}
	
	public static String namespace = "http://example.com/";
	
	public static void main(String[] args) {
		Repository rep = new VirtuosoRepository("jdbc:virtuoso://localhost:1111", "dba", "dba");
		
		int j = 0;
		int a = 1000;
//		try (VirtuosoRepositoryConnection conn = (VirtuosoRepositoryConnection) rep.getConnection()) {
//			System.out.println("begin");
//					
//			ValueFactory vf = rep.getValueFactory();
//			
//			IRI demo1 = vf.createIRI(namespace, "abc");
//			IRI demo2 = vf.createIRI(namespace, "xyz");
//			Model model = new TreeModel();
//			int i;
//			long startTime = System.currentTimeMillis();
//			for(i = j; i < j + a; i++) { 
//					
//				model.add(demo1, demo2, vf.createLiteral(i));
//				
//			}
//			long endTime = System.currentTimeMillis();
//			
//			System.out.println("Time is:" + (endTime - startTime));
//			j = i;
//			startTime = System.currentTimeMillis();
//			conn.add(demo1, demo2, vf.createLiteral("demo"));
//			endTime = System.currentTimeMillis();
//			System.out.println("Time is:" + (endTime - startTime));
//			conn.close();
//		}
//		
//		

		try (VirtuosoRepositoryConnection conn = (VirtuosoRepositoryConnection) rep.getConnection()) {
			System.out.println("begin");
				
			ValueFactory vf = rep.getValueFactory();
			
			
			//Model model = new TreeModel();
			
			int i;
			IRI demo1, demo3; 
			long startTime = System.currentTimeMillis();	
			for(i = j; i < j + a; i++) { 
				demo1 = vf.createIRI(namespace, Iteger.toString());
				demo2 = vf.createIRI(namespace, i);
				conn.add(demo1, demo2, vf.createLiteral(i));		
			}
		
			long endTime = System.currentTimeMillis();
			System.out.println("Time is:" + (endTime - startTime));
			conn.close();
		}

//		try (VirtuosoRepositoryConnection conn = (VirtuosoRepositoryConnection) rep.getConnection()) {
//			System.out.println("begin");
//			long startTime = System.currentTimeMillis();		
//			ValueFactory vf = rep.getValueFactory();
//			
//			IRI demo1 = vf.createIRI(namespace, "abc");
//			IRI demo2 = vf.createIRI(namespace, "xyz");
//			Model model = new TreeModel();
//			int i;
//			int z = 0;
//			System.out.println(j);
//			System.out.println(j+a);
//			for( i = j; i < j + a/3; i++) { 
//				model.add(demo1, demo2, vf.createLiteral(i));
//				z = i;
//				
//			}
//			conn.add(model);
//			model.clear();
//			System.out.println(z);
//			
//			for (int k = z + 1; k < j + a; k++) {
//				model.add(demo1, demo2, vf.createLiteral(i));
//			}
//			conn.add(model);
//			
//			j = i;
//
//			long endTime = System.currentTimeMillis();
//			System.out.println("Time is:" + (endTime - startTime));
//			conn.close();
//		}
	
	
		
		
	}

}
