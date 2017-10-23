package xFactor;

import java.util.ArrayList;

public class Participant extends Person {
	private ArrayList<String> qualities = new ArrayList<String>();
	
	public Participant(String fName, String lName, int age, Gender gender, String birthPlace) {
		super(fName, lName, age, gender, birthPlace);
		qualities.add("Singing");
		Competition.getParticipants().add(this);
	}
	
	public ArrayList<String> getQualities() {
		return qualities;
	}

	public void addQuality(String quality) {
		this.qualities.add(quality);
	}
}