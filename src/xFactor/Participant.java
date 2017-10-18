package xFactor;

public class Participant extends Person {
	private String quality = "Singing";
	
	public Participant(String fName, String lName, int age, String gender, String birthPlace) {
		super(fName, lName, age, gender, birthPlace);
		Competition.getParticipants().add(this);
	}
	
	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality += ", " + quality;
	}
}