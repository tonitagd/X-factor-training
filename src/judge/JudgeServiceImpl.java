package judge;

import java.util.Map;
import java.util.Set;

import participant.Participant;
import stage.Stage;

public class JudgeServiceImpl implements JudgeService {
	@Override
	public void removeFavourite(Participant participant, Judge judge, Stage stage) {
		for(Map.Entry<Judge, Set<Participant>> entry : stage.getJudgeFavourites().entrySet()) {
			if(entry.getKey().equals(judge)) {
				entry.getValue().remove(participant);
			}
 		}
	}
}