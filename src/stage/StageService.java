package stage;

import java.util.ArrayList;
import java.util.Set;

import judge.Judge;
import participant.Participant;

public interface StageService {
	public Set<Participant> qualifyParticipants(Stage stage, ArrayList<Judge> judges);
}