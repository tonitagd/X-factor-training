package judge;

import participant.Participant;
import stage.Stage;

public interface JudgeService {
	public void removeFavourite(Participant participant, Judge judge, Stage stage);
}