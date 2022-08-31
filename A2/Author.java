public class Author {

	private String firstName;
	private String lastName;
	private int age;
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = 0;
	}
	
	public Author(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public boolean equals(Author other) {
		return this.firstName.equals(other.getFirstName())
			&& this.lastName.equals(other.getLastName())
				&& this.age == other.getAge();
	}
	
	public boolean olderThan(Author other) {
		return this.age > other.getAge();
	}
}