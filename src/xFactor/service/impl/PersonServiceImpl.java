package xFactor.service.impl;

import org.springframework.stereotype.Service;

import xFactor.infrastructure.model.Person;

@Service
public class PersonServiceImpl {
	public void printInfo(Person person) {
		System.out.printf("Name: %s\nAge: %d\nGender: %s\nCity: %s\n\n", person.getName(), person.getAge(),
				person.getGender(), person.getCity());
	}
}