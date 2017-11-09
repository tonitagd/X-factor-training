package xFactor.infrastructure.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "participants")
public class Participant extends Person {

	private static final long serialVersionUID = 2745731738707326330L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int participantId;

	@ElementCollection
	private List<String> qualities = new ArrayList<String>();

	public Participant() {
	}

	public Participant(String fName, String lName, int age, Gender gender, String birthPlace) {
		super(fName, lName, age, gender, birthPlace);
		qualities.add("Singing");
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public List<String> getQualities() {
		return qualities;
	}

	public void setQualities(List<String> qualities) {
		this.qualities = qualities;
	}

	public void addQuality(String quality) {
		if (quality != null) {
			this.qualities.add(quality);
		}
	}

	public void printInfo() {
		System.out.printf("Name: %s\nAge: %d\nGender: %s\nCity: %s\nQuality: %s\n\n", this.getName(), this.getAge(),
				this.getGender(), this.getCity(), this.getQualities());
	}
}