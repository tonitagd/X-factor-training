package participant;

import java.util.ArrayList;

import judge.Judge;
import stage.Stage;

public interface ParticipantService {
	public void printVotes(Participant participant, Stage stage, ArrayList<Judge> judges);
	public ArrayList<Participant> removeParticipant(Participant participant, ArrayList<Participant> participants);
}