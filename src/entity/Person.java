package entity;

import java.util.List;

public class Person extends Entity{
	private static int numberofPerson = 0;
	private int age;
	public Person(String label, String detail,int age, List<Source> source) throws InterruptedException {
		numberofPerson += 1;
		this.id = "Person_" + Integer.toString(numberofPerson);
		this.label = label;
		this.detail = detail;
		this.source = source;
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public static int getNoPerson() {
		return numberofPerson;
	}
}
