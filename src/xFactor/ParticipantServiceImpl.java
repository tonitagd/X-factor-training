package xFactor;

import java.util.ArrayList;
import java.util.Map;

public class ParticipantServiceImpl implements ParticipantService {
	private StageServiceImpl stageService;
	private Competition competition = new Competition();
	
	public ParticipantServiceImpl() {
		stageService = new StageServiceImpl();
	}
	
	@Override
	public void printVotes(Participant participant, Stage stage) {
		System.out.println("Judges who voted with \"YES\" for " + participant.getName() + ":");
		
		Map<Participant, Integer> votes = stageService.countVotes(stage);
		if(votes.get(participant) == competition.getJudgesSize()) {
		   	System.out.println("Everybody.");
		} else if(votes.get(participant) != 0) {
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
		competition.getParticipants().remove(participant);
		return competition.getParticipants();
	}
}