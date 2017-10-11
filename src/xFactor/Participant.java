package xFactor;

import java.util.ArrayList;

public class Participant extends Person {
	private static int countParticipants;
	private static ArrayList<Participant> allParticipants = new ArrayList<Participant>();
	private String quality;
	private ArrayList<Judge> positiveVotes = new ArrayList<Judge>();
	
	public String getQuality() {
		if(quality == null) {
			return "This participant has no qualities.";
		}
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	public static int getCountParticipants() {
		return countParticipants;
	}
	
	public ArrayList<Judge> getPositiveVotes() {
		return positiveVotes;
	}
	
	public static ArrayList<Participant> getAllParticipants() {
		return allParticipants;
	}
	
	public Participant(String fName, String lName, int age, String gender, String birthPlace) {
		super(fName, lName, age, gender, birthPlace);
		countParticipants++;
		allParticipants.add(this);
	}
	
	public ArrayList<Participant> removeParticipant(Participant participant) {
		allParticipants.remove(participant);
		return allParticipants;
	}
	
	public void printVotes() {
		System.out.println("Judges who voted with \"YES\" for " + this.getName() + ":");
		
		if(positiveVotes.size() > 0 && positiveVotes.size() != Judge.getJudgesSize()) {
			for(int i = 0; i < positiveVotes.size(); i++) {
				System.out.println(positiveVotes.get(i));
			}
		} else if(positiveVotes.size() == Judge.getJudgesSize()) {
			System.out.println("Everybody.");
		} else {
			System.out.println("Nobody.");
		}
	}
}