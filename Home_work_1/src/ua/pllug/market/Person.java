package ua.pllug.market;

public class Person {
	// клас Person - описує загальні дані про користувача
	
	private int person_id;       // id
	private String person_name;	 // ім'я особи
	private int person_age;      // вік особи
	
	public Person(int person_id, String person_name, int person_age) {
		this.person_id = person_id;
		this.person_name = person_name;
		this.person_age = person_age;
	}
	
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public int getPerson_age() {
		return person_age;
	}
	public void setPerson_age(int person_age) {
		this.person_age = person_age;
	}

}
