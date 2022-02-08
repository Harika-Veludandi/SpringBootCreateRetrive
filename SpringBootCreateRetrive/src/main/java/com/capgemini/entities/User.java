package com.capgemini.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class User {
	
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Length(min = 3 , max = 20 , message = "name length should be between 3 and 20")
	private String name;
	private int age;
	private float salary;
	
	public User() {
		super();
	}
	
	public User(int userId, String name, int age, float salary) {
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
