package Model;

import java.util.Date;

public class Dog {

	String name;
	int id;
	int age;
	String race;
	Date birth;

	public Dog(int id, String name, int age, String race, Date birth) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.race = race;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
