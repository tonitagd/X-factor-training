package xFactor;

import java.util.ArrayList;

public class Participant extends Person {
	private ArrayList<String> qualities = new ArrayList<String>();
	
	private Competition competition = new Competition();
	
	public Participant(String fName, String lName, int age, Gender gender, String birthPlace, int id) {
		super(fName, lName, age, gender, birthPlace, id);
		initializeParticipant();
	}
	
	private void initializeParticipant(){
		qualities.add("Singing");
		competition.getParticipants().add(this);
		
	}
	
	public ArrayList<String> getQualities() {
		return qualities;
	}

	public void addQuality(String quality) {
		this.qualities.add(quality);
	}
	
	public void printInfo() {
		System.out.printf("Name: %s\nAge: %d\nGender: %s\nCity: %s\nQuality: %s\n\n",
				this.getName(), this.getAge(), this.getValue(), this.getCity(), this.getQualities());
	}
}