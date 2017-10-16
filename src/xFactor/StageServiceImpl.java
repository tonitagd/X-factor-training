package xFactor;

import java.util.ArrayList;

public class StageServiceImpl implements StageService {
	
	protected StageServiceImpl() {};

	private static ArrayList<Participant> tempArray = new ArrayList<Participant>();
	
	@Override
	public void initializeInstance(int max, int stageNum, Stage stage) {
		if(stageNum < 1 || stageNum > Competition.numberOfStages) {
			throw new IllegalArgumentException("The number of stage must be between 1 and " + Competition.numberOfStages);
		}
		
		if(Competition.stageCountInstances - 1 == Competition.numberOfStages) {
			throw new IllegalArgumentException("Maximum number of stages reached! Cannot create a new one.");
		}
		
		if(Competition.stageCountInstances == 1) {
			stage.setMaxParticipants(Competition.getParticipants().size());
			System.out.println("Participants in stage " + stageNum + ":");
			stage.getParticipantsInStage().addAll(Competition.getParticipants());
		} else {
			stage.setMaxParticipants(max);
			stage.setParticipantsInStage(tempArray);
		}
		
		for(Participant p : Competition.getParticipants()) {
			p.getPositiveVotes().clear();
		}
	}
	
	@Override
	public ArrayList<Participant> qualifyParticipant(Participant participant, Stage stage) {
		JudgeServiceImpl js = new JudgeServiceImpl();
		for(Judge j : Competition.getJudges()) {
			js.vote(participant, j.getVote(), j);
		}
		
		int size = participant.getPositiveVotes().size();
		int halfJudgeSize = Competition.getJudgesSize() / 2;
		boolean isEven = Competition.getJudgesSize() % 2 == 0;
		
		if(size > halfJudgeSize) {
			stage.getQualifiedParticipants().add(participant);
		} else if(size == halfJudgeSize && isEven) {
			for(Judge j : participant.getPositiveVotes()) {
				if(j.isSpecial() == true) {
					stage.getQualifiedParticipants().add(participant);
					break;
				}
			}
		}
		
		for(Judge j : Competition.getJudges()) {
			for(Participant p : j.getFavourites()) {
				stage.getQualifiedParticipants().add(p);
			}
		}
		
		tempArray = stage.getQualifiedParticipants();
		return stage.getQualifiedParticipants();
	}
}
