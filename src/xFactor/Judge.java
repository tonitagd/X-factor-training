package xFactor;

import java.util.ArrayList;
import java.util.HashMap;

public class Judge extends Person {
	private static int maxFavourites;
	private static int numberOfJudges;
	private static int countInstances;
	private static ArrayList<Judge> judges = new ArrayList<Judge>(numberOfJudges);
	private int vote;
	private boolean isSpecial;
	private ArrayList<Participant> favourites = new ArrayList<Participant>(maxFavourites);
	private HashMap<Participant, Integer> votes = new HashMap<Participant, Integer>();
	
	public int getVote() {
		return vote;
	}
	
	public static ArrayList<Judge> getJudges() {
		return Judge.judges;
	}
	
	public static int getJudgesSize() {
		return judges.size();
	}
	
	public static int getMaxFavourites() {
		return maxFavourites;
	}

	public static void setMaxFavourites(int maxFavourites) {
		Judge.maxFavourites = maxFavourites;
	}

	public static int getNumberOfJudges() {
		return numberOfJudges;
	}

	public static void setNumberOfJudges(int numberOfJudges) {
		Judge.numberOfJudges = numberOfJudges;
	}
	
	public boolean isSpecial() {
		return isSpecial;
	}
	
	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}
	
	public Judge(String fName, String lName, int age, String gender, String birthPlace) {
		super(fName, lName, age, gender, birthPlace);
		judges.add(this);
		
		if(countInstances == numberOfJudges) {
			throw new IllegalArgumentException("Judges must be " + numberOfJudges);
		}
		
		countInstances++;
	}
	
	public void addFavourite(Participant participant) {
		if(favourites.size() < maxFavourites) {
			for(Participant part : favourites) {
				if(participant.equals(part)) {
					System.out.println("This participant is already in your list of favourites.");
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