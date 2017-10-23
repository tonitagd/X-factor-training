package xFactor;

public class PersonServiceImpl {
	public void printInfo(Person person) {
		System.out.printf("Name: %s\nAge: %d\nGender: %s\nCity: %s\n\n", 
				person.getName(), person.getAge(), person.getValue(), person.getCity());
	}
}
