package xFactor;

import java.util.ArrayList;

public class Participant extends Person {
	private String quality;
	private ArrayList<Judge> positiveVotes = new ArrayList<Judge>();
	
	public Participant(String fName, String lName, int age, String gender, String birthPlace) {
		super(fName, lName, age, gender, birthPlace);
		Competition.getParticipants().add(this);
	}
	
	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	public ArrayList<Judge> getPositiveVotes() {
		return positiveVotes;
	}
}