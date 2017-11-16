package xFactor.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xFactor.base.Application;
import xFactor.infrastructure.model.JudgeFavourite;
import xFactor.infrastructure.model.Participant;
import xFactor.infrastructure.model.Stage;

@RestController
public class StageController {
	@Autowired
	Application app;

	@RequestMapping(value = "/number-of-stages", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody int getNumberOfStages() {
		app.setNumberOfStages(3);
		return app.getNumberOfStages();
	}

	Stage stage1;

	@RequestMapping(value = "/create-stage1", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void createStage1() {
		stage1 = app.createStage(1, 15);
	}

	@RequestMapping(value = "/favourites-stage1", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<JudgeFavourite> getFavourites() {
		app.addJudgesFavourites(stage1);
		return stage1.getJudgeFavourites();
	}

	@RequestMapping(value = "/participants-in-stage1", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Set<Participant> getParticipantsInStage1() {
		return stage1.getParticipantsInStage();
	}

	@RequestMapping(value = "/judges-vote-stage1", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void judgesVoteStage1() {
		app.judgesVote(stage1);
	}

	@RequestMapping(value = "/qualify-participants-stage1", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void qualifyParticipantsStage1() {
		app.qualifyParticipants(stage1, app.getJudges());
	}

	@RequestMapping(value = "/check-winner-stage1", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Participant checkForWinnerStage1() {
		return app.checkForWinner(stage1);
	}

	@RequestMapping(value = "/qualified-stage1", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Set<Participant> getQualifiedParticipantsStage1() {
		return app.getQualifiedParticipants(stage1);
	}

	Stage stage2;

	@RequestMapping(value = "/create-stage2", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void createStage2() {
		stage2 = app.createStage(2, 10);
		stage2.setParticipantsInStage(new HashSet<>());
		Set<Participant> participantsNext = app.getQualifiedParticipants(stage1);
		stage2.getParticipantsInStage().addAll(participantsNext);
	}
	
	@RequestMapping(value = "/participants-in-stage2", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Set<Participant> getParticipantsInStage2() {
		return stage2.getParticipantsInStage();
	}

	@RequestMapping(value = "/judges-vote-stage2", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void judgesVoteStage2() {
		app.judgesVote(stage2);
	}

	@RequestMapping(value = "/qualify-participants-stage2", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void qualifyParticipantsStage2() {
		app.qualifyParticipants(stage2, app.getJudges());
	}

	@RequestMapping(value = "/check-winner-stage2", method = RequestMethod.GET)
	public @ResponseBody Participant checkForWinnerStage2() {
		return app.checkForWinner(stage2);
	}

	@RequestMapping(value = "/qualified-stage2", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Set<Participant> getQualifiedParticipantsStage2() {
		return app.getQualifiedParticipants(stage2);
	}
	
	Stage stage3;

	@RequestMapping(value = "/create-stage3", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void createStage3() {
		stage3 = app.createStage(3, 10);
		stage3.setParticipantsInStage(new HashSet<>());
		Set<Participant> participantsNext = app.getQualifiedParticipants(stage2);
		stage3.getParticipantsInStage().addAll(participantsNext);
	}

	@RequestMapping(value = "/participants-in-stage3", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Set<Participant> getParticipantsInStage3() {
		return stage3.getParticipantsInStage();
	}
	
	@RequestMapping(value = "/judges-vote-stage3", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void judgesVoteStage3() {
		app.judgesVote(stage3);
	}

	@RequestMapping(value = "/qualify-participants-stage3", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void qualifyParticipantsStage3() {
		app.qualifyParticipants(stage3, app.getJudges());
	}

	@RequestMapping(value = "/check-winner-stage3", method = RequestMethod.GET)
	public @ResponseBody Participant checkForWinnerStage3() {
		return app.checkForWinner(stage3);
	}

	@RequestMapping(value = "/qualified-stage3", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Set<Participant> getQualifiedParticipantsStage3() {
		return app.getQualifiedParticipants(stage3);
	}
}