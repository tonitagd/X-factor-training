package xFactor.service.impl;

import java.util.Map;
import java.util.Set;

import xFactor.infrastructure.model.Judge;
import xFactor.infrastructure.model.Participant;
import xFactor.infrastructure.model.Stage;
import xFactor.service.JudgeService;

public class JudgeServiceImpl implements JudgeService {
	@Override
	public void removeFavourite(Participant participant, Judge judge, Stage stage) {
		for (Map.Entry<Judge, Set<Participant>> entry : stage.getJudgeFavourites().entrySet()) {
			if (entry.getKey().equals(judge)) {
				entry.getValue().remove(participant);
			}
		}
	}
}