package xFactor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StageServiceImpl implements StageService {
	private Competition competition = new Competition();
	
	@Override
	public Set<Participant> qualifyParticipants(Stage stage) {
		double halfJudgeSize = competition.getJudgesSize() / 2;
		Map<Participant, Integer> helper = countVotes(stage);
		Set<Participant> qualified = stage.getQualifiedParticipants();
		
		for (Map.Entry<Participant, Integer> entry : helper.entrySet()) {
			int value = entry.getValue();
			Participant key = entry.getKey();
		    if(value > halfJudgeSize) {
		    	qualified.add(key);
		    } else if(value == halfJudgeSize) {
		    	for(Vote vote : stage.getVotes()) {
					if(vote.getParticipant() == key && vote.getJudge().isSpecial()) {
						qualified.add(key);
						break;
					}
				}
		    }
		}
		
		for(Map.Entry<Judge, Set<Participant>> entry : stage.getJudgeFavourites().entrySet()) {			
			for(Participant participant : entry.getValue()) {
				qualified.add(participant);
			}
		}
		
		return qualified;
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