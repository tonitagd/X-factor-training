package xFactor;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String birthPlace;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public void setName(String fName, String lName) {
		this.firstName = fName;
		this.lastName = lName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getBirthPlace() {
		return birthPlace;
	}
	
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	public void printInfo() {
		System.out.printf("Name: %s\nAge: %d\nGender: %s\nPlace of birth: %s\n",
				this.getName(), this.getAge(), this.getGender(), this.getBirthPlace());
	}
	
	public Person(String fName, String lName, int age, String gender, String birthPlace) {
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
		this.gender = gender;
		this.birthPlace = birthPlace;
	}

	@Override
	public String toString() {
		return getName();
	}
}