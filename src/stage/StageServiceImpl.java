package stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import judge.Judge;
import participant.Participant;
import vote.Vote;

public class StageServiceImpl implements StageService {	
	@Override
	public Set<Participant> qualifyParticipants(Stage stage, ArrayList<Judge> judges) {		
		double halfJudgeSize = judges.size() / 2;
		Map<Participant, Integer> helper = countVotes(stage);
		Set<Participant> qualifiedParticipants = stage.getQualifiedParticipants();
		
		for (Map.Entry<Participant, Integer> entry : helper.entrySet()) {
			int value = entry.getValue();
			Participant key = entry.getKey();
		    if(value > halfJudgeSize) {
		    	qualifiedParticipants.add(key);
		    } else if(value == halfJudgeSize) {
		    	for(Vote vote : stage.getVotes()) {
					if(vote.getParticipant() == key && vote.getJudge().isSpecial()) {
						qualifiedParticipants.add(key);
						break;
					}
				}
		    }
		}
		
		for(Map.Entry<Judge, Set<Participant>> entry : stage.getJudgeFavourites().entrySet()) {			
			for(Participant participant : entry.getValue()) {
				qualifiedParticipants.add(participant);
			}
		}
		
		return qualifiedParticipants;
	}
	
	public Map<Participant, Integer> countVotes(Stage stage) {
		int count = 0;
		Map<Participant, Integer> map = new HashMap<Participant, Integer>();
		for(Vote vote : stage.getVotes()) {
			if(map.get(vote.getParticipant()) == null) {
				count = 0;
				if(vote.getVote() == false) {
					map.put(vote.getParticipant(), count);
				} else {
					map.put(vote.getParticipant(), ++count);
				}
			} else {
				if(vote.getVote() == true) {
					int currentValue = map.get(vote.getParticipant());
					map.put(vote.getParticipant(), ++currentValue);
				}
			}
		}
		
		return map;
	}
}