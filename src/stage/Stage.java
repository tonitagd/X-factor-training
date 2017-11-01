package stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import judge.Judge;
import participant.Participant;
import vote.Vote;

public class Stage {
	private int stageNumber;
	private int maxParticipants;
	private Set<Participant> participantsInStage = new HashSet<Participant>();
	private Set<Participant> qualifiedParticipants = new HashSet<Participant>();
	private Map<Judge, Set<Participant>> judgeFavourites = new HashMap<Judge, Set<Participant>>();
	private ArrayList<Vote> votes = new ArrayList<Vote>();
	
	public Stage() {}
	
	public Stage(int stageNum, int max) throws IllegalArgumentException {
		this.stageNumber = stageNum;
	}
	
	public int getStageNumber() {
		return stageNumber;
	}

	public void setStageNumber(int stageNumber) {
		this.stageNumber = stageNumber;
	}
	
	public int getMaxParticipants() {
		return maxParticipants;
	}
	
	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
	
	public Set<Participant> getParticipantsInStage() {
		return participantsInStage;
	}
	
	public void setParticipantsInStage(Set<Participant> participantsInStage) {
		this.participantsInStage = participantsInStage;
	}
	
	public Set<Participant> getQualifiedParticipants() {
		return qualifiedParticipants;
	}

	public void setQualifiedParticipants(Set<Participant> qualifiedParticipants) {
		this.qualifiedParticipants = qualifiedParticipants;
	}
	
	public Map<Judge, Set<Participant>> getJudgeFavourites() {
		return judgeFavourites;
	}

	public void setJudgeFavourites(Map<Judge, Set<Participant>> judgeFavourites) {
		this.judgeFavourites = judgeFavourites;
	}

	public ArrayList<Vote> getVotes() {
		return votes;
	}

	public void setVotes(ArrayList<Vote> votes) {
		this.votes = votes;
	}
	
	public void vote(Participant participant, boolean voteValue, Judge judge) {
		this.getVotes().add(new Vote(participant, judge, voteValue));
	}
	
	public void checkForWinner() {
		if(this.getQualifiedParticipants().size() == 1) {
			System.out.println("Winner of X-Factor is:" + "\n" + this.getQualifiedParticipants());
		}
	}
	
	public void addFavourite(Participant participant, Judge judge) {
		Set<Participant> favourites = new HashSet<Participant>();
		favourites.add(participant);

		if(this.getJudgeFavourites().get(judge) == null) {
			this.getJudgeFavourites().put(judge, favourites);
		} else if(this.getJudgeFavourites().get(judge).size() < judge.getMaxFavourites()) {
			this.getJudgeFavourites().get(judge).add(participant);
		} else {
			System.out.println("Your list of favourites is full. Cannot add " + participant.getName() + ".");
		}
	}
}