package com.example.enrollment.model;

import java.io.Serializable;
import java.util.List;

public class StudentDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String studentId;
	private String lastName;
	private String firstName;
	private List<ClassDto> classes;
	
	public StudentDto() {
	}

	public StudentDto(Long id, String studentId, String lastName, String firstName) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public List<ClassDto> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassDto> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentId=" + studentId + ", lastName=" + lastName + ", firstName=" + firstName
				+ "]";
	}

}
