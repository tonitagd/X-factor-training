package xFactor.service.impl;

import xFactor.infrastructure.model.Judge;
import xFactor.infrastructure.model.JudgeFavourite;
import xFactor.infrastructure.model.Participant;
import xFactor.infrastructure.model.Stage;
import xFactor.service.JudgeService;

public class JudgeServiceImpl implements JudgeService {
	@Override
	public void removeFavourite(Participant participant, Judge judge, Stage stage) {
		for(JudgeFavourite fav : stage.getJudgeFavourites()) {
			if(fav.getJudge().equals(judge)) {
				fav.getFavourites().remove(participant);
			}
		}
	}
}