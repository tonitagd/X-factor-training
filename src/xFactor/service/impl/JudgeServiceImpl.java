package xFactor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xFactor.infrastructure.dao.JudgeFavouriteDao;
import xFactor.infrastructure.model.Judge;
import xFactor.infrastructure.model.JudgeFavourite;
import xFactor.infrastructure.model.Participant;
import xFactor.infrastructure.model.Stage;
import xFactor.service.JudgeService;

@Service
public class JudgeServiceImpl implements JudgeService {
	@Autowired
	private JudgeFavouriteDao judgeFavouriteDao;
	
	@Override
	public void removeFavourite(Participant participant, Judge judge, Stage stage) {
		for(JudgeFavourite fav : stage.getJudgeFavourites()) {
			if(fav.getJudge().equals(judge)) {
				fav.getFavourites().remove(participant);
				judgeFavouriteDao.remove(fav);
			}
		}
	}
}