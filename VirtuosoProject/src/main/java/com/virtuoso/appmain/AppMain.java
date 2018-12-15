package com.virtuoso.appmain;


import java.io.FileNotFoundException;



import com.virtuoso.connectdb.DBGeneration;

public class AppMain {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Begin");
		
		int[] n = { 1000, 100000, 1000000, 10000000};
		int[] m = {5000, 500000, 5000000, 10000000};
		
		DBGeneration genDB = new DBGeneration();

		for(int i = 3; i < 4; i++) {
			long startTime = System.currentTimeMillis();
			
			genDB.genDB(n[i], m[i]);
			long endTime = System.currentTimeMillis();
			
			//long time = genDB.getDatabaseConnect().queryStatementTime(null, RDF.TYPE, genDB.getDatabaseConnect().getPERSON(), null);
			
			System.out.println("Time to gen for " + n[i] + " entities and " + m[i] + " relationship is " + (endTime - startTime));
		}
		System.out.println("End");
	}
}
