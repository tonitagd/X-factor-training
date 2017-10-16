package xFactor;

import java.util.ArrayList;

public interface StageService {
	public void initializeInstance(int max, int stageNum, Stage stage);
	public ArrayList<Participant> qualifyParticipant(Participant participant, Stage stage);
}