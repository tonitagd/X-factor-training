package xFactor;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String city;
	
	public Person(String fName, String lName, int age, String gender, String city) {
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
		this.gender = gender;
		this.city = city;
	}
	
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
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return getName();
	}
}