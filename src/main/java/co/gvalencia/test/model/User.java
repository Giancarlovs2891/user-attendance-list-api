package co.gvalencia.test.model;

public class User {

	private String id;
	private String name;
	private String lastName;
	private Integer age;
	private String position;
	private Double salary;
	private String birthdate;
	private String companyEntryDate;
	private UserStatus status;

	public User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getCompanyEntryDate() {
		return companyEntryDate;
	}

	public void setCompanyEntryDate(String companyEntryDate) {
		this.companyEntryDate = companyEntryDate;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public enum UserStatus {
		ACTIVE, INACTIVE
	}

}
