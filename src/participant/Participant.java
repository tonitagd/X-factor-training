package participant;

import java.util.ArrayList;

import person.Person;

public class Participant extends Person {
	private ArrayList<String> qualities = new ArrayList<String>();
	
	public Participant() {}
	
	public Participant(String fName, String lName, int age, Gender gender, String birthPlace, int id) {
		super(fName, lName, age, gender, birthPlace, id);
		qualities.add("Singing");
	}
	
	public ArrayList<String> getQualities() {
		return qualities;
	}
	
	public void setQualities(ArrayList<String> qualities) {
		this.qualities = qualities;
	}

	public void addQuality(String quality) {
		if(quality != null) {
			this.qualities.add(quality);
		}
	}
	
	public void printInfo() {
		System.out.printf("Name: %s\nAge: %d\nGender: %s\nCity: %s\nQuality: %s\n\n",
				this.getName(), this.getAge(), this.getValue(), this.getCity(), this.getQualities());
	}
}