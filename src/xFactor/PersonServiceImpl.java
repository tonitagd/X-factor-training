package xFactor;

public class PersonServiceImpl implements PersonService {
	
	protected PersonServiceImpl() {};
	
	@Override
	public void printInfo(Person person) {
		System.out.printf("Name: %s\nAge: %d\nGender: %s\nCity: %s\n",
				person.getName(), person.getAge(), person.getGender(), person.getCity());
	}
}
