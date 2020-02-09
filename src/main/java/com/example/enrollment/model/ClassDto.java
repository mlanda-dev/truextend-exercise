package com.example.enrollment.model;

import java.io.Serializable;
import java.util.List;

public class ClassDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String code;
	private String title;
	private String description;
	private List<StudentDto> students;

	public ClassDto() {
	}

	public ClassDto(Integer id, String code, String title, String description) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<StudentDto> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDto> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", code=" + code + ", title=" + title + ", description=" + description + "]";
	}
}
