package xFactor.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xFactor.infrastructure.dao.ParticipantDao;
import xFactor.infrastructure.model.Participant;
import xFactor.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {
	@Autowired
	private StageServiceImpl stageService;

	@Autowired
	ParticipantDao participantDao;

	public ParticipantServiceImpl() {
		stageService = new StageServiceImpl();
	}

	@Override
	public ArrayList<Participant> removeParticipant(Participant participant, ArrayList<Participant> participants) {
		participants.remove(participant);
		participantDao.remove(participant);
		return participants;
	}
}