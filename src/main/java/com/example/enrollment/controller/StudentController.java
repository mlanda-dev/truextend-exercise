package com.example.enrollment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.enrollment.model.ResponseDto;
import com.example.enrollment.model.StudentDto;
import com.example.enrollment.service.StudentService;

@RestController
@RequestMapping(value = "/v1/student")
public class StudentController {

	private static Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity<ResponseDto> createStudent(@RequestHeader("x-audit-host") String hostHeader,
			@RequestHeader("x-audit-user") String userHeader, @RequestBody StudentDto studentDto) {
		logger.info("Creating student with student id: {}", studentDto.getStudentId());
		ResponseDto<Long> response = studentService.persistStudent(studentDto, userHeader, hostHeader);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(path = "/{studentId}")
	public ResponseEntity<ResponseDto> editStudent(@RequestHeader("x-audit-host") String hostHeader,
			@RequestHeader("x-audit-user") String userHeader, @PathVariable String studentId,
			@RequestBody StudentDto studentDto) {
		logger.info("Editing student with student id: {}", studentId);
		ResponseDto<Long> response = studentService.editStudent(studentId, studentDto, userHeader, hostHeader);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping(path = "/{studentId}")
	public ResponseEntity<ResponseDto> deleteStudent(@RequestHeader("x-audit-host") String hostHeader,
			@RequestHeader("x-audit-user") String userHeader, @PathVariable String studentId) {
		logger.info("Deleting student with student id: {}", studentId);
		ResponseDto<Long> response = studentService.deleteStudent(studentId, userHeader, hostHeader);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping
	public ResponseEntity<ResponseDto> listStudents(@RequestHeader("x-audit-host") String hostHeader,
			@RequestHeader("x-audit-user") String userHeader) {
		logger.info("Listing all students");
		ResponseDto<List<StudentDto>> response = studentService.listStudents(userHeader, hostHeader);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

}
