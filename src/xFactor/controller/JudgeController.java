package xFactor.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xFactor.base.Application;
import xFactor.infrastructure.model.Judge;

@RestController
public class JudgeController {
	@Autowired
	Application app;

	@RequestMapping(value = "/judges", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ArrayList<Judge> getJudges() {
		app.createJudges(4);
		return app.getJudges();
	}

	@RequestMapping(value = "/special", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Judge getSpecialJudge() {
		app.giveSpecialVote(3);
		return app.getSpecialJudge();
	}
}