package com.capgemini.dto;

public class UserDto {
	
	private int userId;
	private String name;
	private int age;
	private float salary;
	
	public UserDto() {
		super();
	}
	
	public UserDto(int userId, String name, int age, float salary) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	
	
	


}
