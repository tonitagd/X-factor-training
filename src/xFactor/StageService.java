package xFactor;

import java.util.Set;

public interface StageService {
	public void initializeInstance(int max, int stageNum, Stage stage);
	public Set<Participant> qualifyParticipants(Stage stage);
}