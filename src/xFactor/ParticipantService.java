package xFactor;

import java.util.ArrayList;

public interface ParticipantService {
	public void printVotes(Participant participant, Stage stage);
	public ArrayList<Participant> removeParticipant(Participant participant);
	public void printInfo(Participant participant);
}