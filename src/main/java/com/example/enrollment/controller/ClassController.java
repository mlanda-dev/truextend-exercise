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
import org.springframework.web.bind.annotation.RestController;

import com.example.enrollment.model.ClassDto;
import com.example.enrollment.model.ResponseDto;
import com.example.enrollment.service.ClassService;

@RestController
@RequestMapping(value = "/v1/class")
public class ClassController {

	private static Logger logger = LoggerFactory.getLogger(ClassController.class);

	@Autowired
	private ClassService classService;

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity<ResponseDto> createClass(@RequestHeader("x-audit-host") String hostHeader,
			@RequestHeader("x-audit-user") String userHeader, @RequestBody ClassDto classDto) {
		logger.info("Creating class with class code: {}", classDto.getCode());
		ResponseDto<Integer> response = classService.persistClass(classDto, userHeader, hostHeader);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(path = "/{classCode}")
	public ResponseEntity<ResponseDto> editClass(@RequestHeader("x-audit-host") String hostHeader,
			@RequestHeader("x-audit-user") String userHeader, @PathVariable String classCode,
			@RequestBody ClassDto classDto) {
		logger.info("Editing class with class code: {}", classCode);
		ResponseDto<Integer> response = classService.editClass(classCode, classDto, userHeader, hostHeader);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping(path = "/{classCode}")
	public ResponseEntity<ResponseDto> deleteClass(@RequestHeader("x-audit-host") String hostHeader,
			@RequestHeader("x-audit-user") String userHeader, @PathVariable String classCode) {
		logger.info("Deleting class with class code: {}", classCode);
		ResponseDto<Integer> response = classService.deleteClass(classCode, userHeader, hostHeader);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping
	public ResponseEntity<ResponseDto> listClasss(@RequestHeader("x-audit-host") String hostHeader,
			@RequestHeader("x-audit-user") String userHeader) {
		logger.info("Listing all classs");
		ResponseDto<List<ClassDto>> response = classService.listClasses(userHeader, hostHeader);
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

}
