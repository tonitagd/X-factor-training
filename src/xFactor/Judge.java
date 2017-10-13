package xFactor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Judge extends Person {
	private int maxFavourites;
	private int vote;
	private boolean isSpecial;
	private Set<Participant> favourites = new HashSet<Participant>();
	private HashMap<Participant, Integer> votes = new HashMap<Participant, Integer>();
	
	public Judge(String fName, String lName, int age, String gender, String birthPlace, int max) {
		super(fName, lName, age, gender, birthPlace);
		Competition.numberOfJudges++;
		Competition.getJudges().add(this);
		this.maxFavourites = max;
	}
	
	public int getVote() {
		return vote;
	}
	
	public void setVote(int vote) {
		this.vote = vote;
	}
	
	public int getMaxFavourites() {
		return maxFavourites;
	}

	public void setMaxFavourites(int maxFavourites) {
		this.maxFavourites = maxFavourites;
	}
	
	public boolean isSpecial() {
		return isSpecial;
	}
	
	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}
	
	public Set<Participant> getFavourites() {
		return favourites;
	}

	public HashMap<Participant, Integer> getVotes() {
		return votes;
	}
}