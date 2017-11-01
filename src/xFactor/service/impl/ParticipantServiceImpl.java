package xFactor.service.impl;

import java.util.ArrayList;
import java.util.Map;

import xFactor.infrastructure.model.Judge;
import xFactor.infrastructure.model.Participant;
import xFactor.infrastructure.model.Stage;
import xFactor.infrastructure.model.Vote;
import xFactor.service.ParticipantService;

public class ParticipantServiceImpl implements ParticipantService {
	private StageServiceImpl stageService;

	public ParticipantServiceImpl() {
		stageService = new StageServiceImpl();
	}

	@Override
	public void printVotes(Participant participant, Stage stage, ArrayList<Judge> judges) {
		System.out.println("Judges who voted with \"YES\" for " + participant.getName() + ":");

		Map<Participant, Integer> votes = stageService.countVotes(stage);
		if (votes.get(participant) == judges.size()) {
			System.out.println("Everybody.");
		} else if (votes.get(participant) != 0) {
			for (Vote vote : stage.getVotes()) {
				if (vote.getParticipant().equals(participant) && vote.getVote() == true) {
					System.out.println(vote.getJudge());
				}
			}
		} else {
			System.out.println("Nobody.");
		}
	}

	@Override
	public ArrayList<Participant> removeParticipant(Participant participant, ArrayList<Participant> participants) {
		participants.remove(participant);
		return participants;
	}
}