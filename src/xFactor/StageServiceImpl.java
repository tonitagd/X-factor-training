package xFactor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StageServiceImpl implements StageService {
	Set<Participant> tempArray = new HashSet<Participant>();
	
	protected StageServiceImpl() {};
	
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
			stage.getParticipantsInStage().addAll(Competition.getParticipants());
		} else {
			stage.setMaxParticipants(max);
		}
		
		for(Judge j : Competition.getJudges()) {
			j.getFavourites().clear();
		}
	}
	
	@Override
	public Set<Participant> qualifyParticipants(Stage stage) {
		double halfJudgeSize = Competition.getJudgesSize() / 2;
		Map<Participant, Integer> helper = countVotes(stage);
		
		for (Map.Entry<Participant, Integer> entry : helper.entrySet()) {
		    if(entry.getValue() > halfJudgeSize) {
		    	stage.getQualifiedParticipants().add(entry.getKey());
		    } else if(entry.getValue() == halfJudgeSize) {
		    	for(Vote v : stage.getVotes()) {
					if(v.getParticipant() == entry.getKey() && v.getJudge().isSpecial()) {
						stage.getQualifiedParticipants().add(entry.getKey());
						break;
					}
				}
		    }
		}
		
		for(Judge j : Competition.getJudges()) {
			for(Participant p : j.getFavourites()) {
				stage.getQualifiedParticipants().add(p);
			}
		}
		
		return stage.getQualifiedParticipants();
	}
	
	public Map<Participant, Integer> countVotes(Stage stage) {
		Map<Participant, Integer> map = new HashMap<Participant, Integer>();
		for(Vote v : stage.getVotes()) {
			if(map.get(v.getParticipant()) == null) {
				map.put(v.getParticipant(), v.getVote());
			} else {
				int value = map.get(v.getParticipant());
				if(v.getVote() == 1) {
					value++;
					map.put(v.getParticipant(), value);
				}
			}
		}
		
		return map;
	}
}