package com.example.enrollment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enrollment.model.ClassDto;
import com.example.enrollment.model.ResponseDto;
import com.example.enrollment.model.StudentDto;
import com.example.enrollment.service.EnrollmentService;

@RestController
@RequestMapping(value = "/v1/enrollment")
public class EnrollmentController {

	private static Logger logger = LoggerFactory.getLogger(EnrollmentController.class);

	@Autowired
	private EnrollmentService enrollmentService;

	@SuppressWarnings("rawtypes")
	@GetMapping(path = "/class/{classCode}/students")
	public ResponseEntity<ResponseDto> listAllStudentsAssignedToClass(@RequestHeader("x-audit-host") String hostHeader,
			@RequestHeader("x-audit-user") String userHeader, @PathVariable String classCode) {
		logger.info("Listing all students assigned to class {}", classCode);
		ResponseDto<ClassDto> response = enrollmentService.listStudentsAssignedToClass(userHeader, hostHeader, classCode);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(path = "/student/{studentId}/classes")
	public ResponseEntity<ResponseDto> listAllClassesAssignedToStudent(@RequestHeader("x-audit-host") String hostHeader,
			@RequestHeader("x-audit-user") String userHeader, @PathVariable String studentId) {
		logger.info("Listing all classes assigned to student {}",studentId);
		ResponseDto<StudentDto> response = enrollmentService.listClassesAssignedToStudent(userHeader, hostHeader, studentId);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}
}
