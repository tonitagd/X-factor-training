package xFactor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Stage {
	private int stageNumber;
	private int maxParticipants;
	private Set<Participant> participantsInStage = new HashSet<Participant>();
	private Set<Participant> qualifiedParticipants = new HashSet<Participant>();
	private ArrayList<Vote> votes = new ArrayList<Vote>();
	
	StageServiceImpl service = new StageServiceImpl();
	
	public Stage(int stageNum, int max) throws IllegalArgumentException {
		this.stageNumber = stageNum;
		Competition.stageCountInstances++;
		service.initializeInstance(max, stageNum, this);
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
		if(participantsInStage.size() == 1) {
			System.out.print("The winner of X-Factor is: ");
			return participantsInStage;
		}
		
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
}