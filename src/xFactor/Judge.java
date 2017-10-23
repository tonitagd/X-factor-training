package xFactor;

import java.util.HashSet;
import java.util.Set;

public class Judge extends Person {
	private int maxFavourites;
	private boolean isSpecial;
	
	public Judge(String fName, String lName, int age, Gender male, String birthPlace, int max) {
		super(fName, lName, age, male, birthPlace);
		Competition.numberOfJudges++;
		Competition.getJudges().add(this);
		this.maxFavourites = max;
	}
	
	public int getMaxFavourites() {
		return maxFavourites;
	}
	
	public boolean isSpecial() {
		return isSpecial;
	}
	
	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}
	
	public void addFavourite(Participant participant, Stage stage) {
		Set<Participant> participants = new HashSet<Participant>();
		participants.add(participant);

		if(stage.getJudgeFavourites().get(this) == null) {
			stage.getJudgeFavourites().put(this, participants);
		} else if(stage.getJudgeFavourites().get(this).size() < this.getMaxFavourites()) {
			stage.getJudgeFavourites().get(this).add(participant);
		} else {
			System.out.println("Your list of favourites is full. Cannot add " + participant.getName() + ".");
		}
	}
}