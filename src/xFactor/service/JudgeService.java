package xFactor.service;

import xFactor.infrastructure.model.Judge;
import xFactor.infrastructure.model.Participant;
import xFactor.infrastructure.model.Stage;

public interface JudgeService {
	public void removeFavourite(Participant participant, Judge judge, Stage stage);
}