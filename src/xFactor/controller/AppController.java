package xFactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xFactor.base.Application;

@RestController
public class AppController {
	@Autowired
	Application app;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String appName() {
		app.setName("X-Factor");
		return "Welcome to " + app.getName() + "!";
	}
}