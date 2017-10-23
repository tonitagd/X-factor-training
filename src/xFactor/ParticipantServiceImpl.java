package xFactor;

import java.util.ArrayList;

public class ParticipantServiceImpl implements ParticipantService {
	private StageServiceImpl stageService;
	public ParticipantServiceImpl() {
		stageService = new StageServiceImpl();
	}
	
	@Override
	public void printVotes(Participant participant, Stage stage) {
		System.out.println("Judges who voted with \"YES\" for " + participant.getName() + ":");
		
		if(stageService.countVotes(stage).get(participant) == Competition.getJudgesSize()) {
		   	System.out.println("Everybody.");
		} else if(stageService.countVotes(stage).get(participant) != 0) {
			for (Vote vote : stage.getVotes()) {
				if(vote.getParticipant().equals(participant) && vote.getVote() == true) {
					System.out.println(vote.getJudge());
				}
			}
		} else {
			System.out.println("Nobody.");
		}
	}
	
	@Override
	public ArrayList<Participant> removeParticipant(Participant participant) {
		Competition.getParticipants().remove(participant);
		return Competition.getParticipants();
	}
	
	@Override
	public void printInfo(Participant participant) {
		System.out.printf("Name: %s\nAge: %d\nGender: %s\nCity: %s\nQuality: %s\n\n",
				participant.getName(), participant.getAge(), participant.getValue(), participant.getCity(), participant.getQualities());
	}
}