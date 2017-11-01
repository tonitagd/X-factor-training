package xFactor.infrastructure.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person implements Serializable {

	private static final long serialVersionUID = 8024592318895271883L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column
	private int age;
	@Column
	private String city;
	@Column
	private Gender gender;

	public enum Gender {
		Male, Female
	}

	public Person() {
	}

	public Person(String fName, String lName, int age, Gender gender, String city, int id) {
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.id = id;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public void setName(String fName, String lName) {
		this.firstName = fName;
		this.lastName = lName;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender value) {
		this.gender = value;
	}

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