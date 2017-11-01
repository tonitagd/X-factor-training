package xFactor.service;

import java.util.ArrayList;

import xFactor.infrastructure.model.Judge;
import xFactor.infrastructure.model.Participant;
import xFactor.infrastructure.model.Stage;

public interface ParticipantService {
	public void printVotes(Participant participant, Stage stage, ArrayList<Judge> judges);

	public ArrayList<Participant> removeParticipant(Participant participant, ArrayList<Participant> participants);
}