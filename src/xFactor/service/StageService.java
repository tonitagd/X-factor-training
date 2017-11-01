package xFactor.service;

import java.util.ArrayList;
import java.util.Set;

import xFactor.infrastructure.model.Judge;
import xFactor.infrastructure.model.Participant;
import xFactor.infrastructure.model.Stage;

public interface StageService {
	public Set<Participant> qualifyParticipants(Stage stage, ArrayList<Judge> judges);
}