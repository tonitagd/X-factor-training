package xFactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Stage {
	private int stageNumber;
	private int maxParticipants;
	private Set<Participant> participantsInStage = new HashSet<Participant>();
	private Set<Participant> qualifiedParticipants = new HashSet<Participant>();
	private Map<Judge, Set<Participant>> judgeFavourites = new HashMap<Judge, Set<Participant>>();
	private ArrayList<Vote> votes = new ArrayList<Vote>();
	
	public Stage(int stageNum, int max) throws IllegalArgumentException {
		this.stageNumber = stageNum;
		Competition.stageCountInstances++;
		this.initializeInstance(stageNum, max);
	}
	
	public int getStageNumber() {
		return stageNumber;
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

	public ArrayList<Vote> getVotes() {
		return votes;
	}

	public void setVotes(ArrayList<Vote> votes) {
		this.votes = votes;
	}
	
	public Map<Judge, Set<Participant>> getJudgeFavourites() {
		return judgeFavourites;
	}
	
	public void vote(Participant participant, boolean voteValue, Judge judge) {
		this.getVotes().add(new Vote(participant, judge, voteValue));
	}
	
	public void checkForWinner() {
		if(this.getQualifiedParticipants().size() == 1) {
			System.out.println("Winner of X-Factor is:" + "\n" + this.getQualifiedParticipants());
		}
	}
	
	public void initializeInstance(int stageNum, int max) {
		if(stageNum < 1 || stageNum > Competition.numberOfStages) {
			throw new IllegalArgumentException("The number of stage must be between 1 and " + Competition.numberOfStages);
		}
		
		if(Competition.stageCountInstances - 1 == Competition.numberOfStages) {
			throw new IllegalArgumentException("Maximum number of stages reached! Cannot create a new one.");
		} else if(Competition.stageCountInstances == 1) {
			this.setMaxParticipants(Competition.getParticipants().size());
			this.getParticipantsInStage().addAll(Competition.getParticipants());
		} else {
			this.setMaxParticipants(max);
		}
	}
}