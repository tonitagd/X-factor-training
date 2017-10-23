package xFactor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StageServiceImpl implements StageService {		
	@Override
	public Set<Participant> qualifyParticipants(Stage stage) {
		double halfJudgeSize = Competition.getJudgesSize() / 2;
		Map<Participant, Integer> helper = countVotes(stage);
		
		for (Map.Entry<Participant, Integer> entry : helper.entrySet()) {
		    if(entry.getValue() > halfJudgeSize) {
		    	stage.getQualifiedParticipants().add(entry.getKey());
		    } else if(entry.getValue() == halfJudgeSize) {
		    	for(Vote vote : stage.getVotes()) {
					if(vote.getParticipant() == entry.getKey() && vote.getJudge().isSpecial()) {
						stage.getQualifiedParticipants().add(entry.getKey());
						break;
					}
				}
		    }
		}
		
		for(Map.Entry<Judge, Set<Participant>> entry : stage.getJudgeFavourites().entrySet()) {			
			for(Participant participant : entry.getValue()) {
				stage.getQualifiedParticipants().add(participant);
			}
		}
		
		return stage.getQualifiedParticipants();
	}
	
	public Map<Participant, Integer> countVotes(Stage stage) {
		int count = 0;
		Map<Participant, Integer> map = new HashMap<Participant, Integer>();
		for(Vote vote : stage.getVotes()) {
			if(map.get(vote.getParticipant()) == null) {
				count = 0;
				if(vote.getVote() == false){
					map.put(vote.getParticipant(), count);
				} else {
					map.put(vote.getParticipant(), ++count);
				}
			} else {
				if(vote.getVote() == true) {
					map.put(vote.getParticipant(), ++count);
				}
			}
		}
		
		return map;
	}
}