package entity;

public class Person {

	private String name;
	
	private String email;
	
	private gender gender;

	public Person(String name, String email, entity.gender gender) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public gender getGender() {
		return gender;
	}

	public void setGender(gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", gender=" + gender + "]";
	}
	
	
}
