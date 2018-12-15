package com.virtuoso.relationship;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenRelationship {
	private List<String> relDescList = new ArrayList<String>();
	
	public void setRelDescriptionList(String fileName) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileName));
		while (scanner.hasNextLine()) {
			relDescList.add(scanner.nextLine());
		}
		scanner.close();
	}
	public String genRandomRelDesc() {
		return relDescList.get((int)(Math.random() * relDescList.size() + 0));
	}
	
	public Relationship genRandomRel() {
		return new Relationship(relDescList.get((int)(Math.random() * relDescList.size() + 0)));
	}
}
