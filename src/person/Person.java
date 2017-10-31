package person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private String city;
	private Gender value;
	private int id;
	public enum Gender {
		Male, Female
	}
	
	public Person() {}
	
	public Person(String fName, String lName, int age, Gender gender, String city, int id) {
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
		this.value = gender;
		this.city = city;
		this.id = id;
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

	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public Gender getValue() {
        return value;
    }
	
	public void setValue(Gender e) {
        this.value = e; 
    }

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}