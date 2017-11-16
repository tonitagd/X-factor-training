package xFactor.service;

import java.util.ArrayList;

import xFactor.infrastructure.model.Participant;

public interface ParticipantService {
	public ArrayList<Participant> removeParticipant(Participant participant, ArrayList<Participant> participants);
}