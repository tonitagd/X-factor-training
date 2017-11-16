package xFactor.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xFactor.base.Application;
import xFactor.infrastructure.model.Participant;

@RestController
public class ParticipantController {
	@Autowired
	Application app;

	@RequestMapping(value = "/participants", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ArrayList<Participant> getParticipants() {
		app.createParticipants(15);
		app.addQualitiesForParticipants();
		return app.getParticipants();
	}
}