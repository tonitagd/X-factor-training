package xFactor;

import java.util.ArrayList;
import java.util.HashMap;

public class Judge extends Person {
	private int maxFavourites;
	private static int countInstances;
	private int vote;
	private boolean isSpecial;
	private ArrayList<Participant> favourites = new ArrayList<Participant>(maxFavourites);
	private HashMap<Participant, Integer> votes = new HashMap<Participant, Integer>();
	public static int numberOfJudges = 4;
	
	public int getVote() {
		return vote;
	}
	
	public static ArrayList<Judge> getJudges() {
		return Competition.judges;
	}
	
	public static int getJudgesSize() {
		return Competition.judges.size();
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
	
	public Judge(String fName, String lName, int age, String gender, String birthPlace) {
		super(fName, lName, age, gender, birthPlace);
		
		if(countInstances == numberOfJudges) {
			throw new IllegalArgumentException("Judges must be " + numberOfJudges);
		}

		Competition.judges.add(this);
		countInstances++;
	}
	
	public void addFavourite(Participant participant) {
		if(favourites.size() < maxFavourites) {
			for(Participant part : favourites) {
				if(participant.equals(part)) {
					System.out.printf("%s is already in your list of favourites.", participant.getName());
					return;
				}
			}
			favourites.add(participant);
			return;
		}
		System.out.println("Your list of favourites is full.");
	}
	
	public void removeFavourite(Participant participant) {
		favourites.remove(participant);
	}
	
	public void printFavourites() {
		if(favourites.size() > 0) {
			System.out.println(favourites);
			return;
		}
		System.out.println("Your list of favourites is empty.");
	}
	
	public void clearFavourites() {
		favourites.clear();
		printFavourites();
	}
	
	public void vote(Participant participant, int vote) {
		this.votes.put(participant, vote);
		
		if(vote == 1) {
			participant.getPositiveVotes().add(this);
			return;
		}
		
		this.vote = vote;
	}
}