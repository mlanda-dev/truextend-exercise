package com.example.enrollment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.enrollment.model.ResponseDto;
import com.example.enrollment.model.StudentDto;

/**
 * @author MEL
 *
 */
@Service
public class StudentService {

	private static Logger logger = LoggerFactory.getLogger(StudentService.class);

	/**
	 * This method allows to persist a student
	 * 
	 * @param studentDto
	 * @param userHeader
	 * @param hostHeader
	 * @return
	 */
	@Transactional
	public ResponseDto<Long> persistStudent(StudentDto studentDto, String userHeader, String hostHeader) {
		logger.trace("The user {} is creating the student {}", userHeader, studentDto);
		ResponseDto<Long> responseDto = null;

		// Validating some data
		if (StringUtils.isBlank(studentDto.getLastName())) {
			responseDto = new ResponseDto<Long>("MSEN-0101", null, "The value for last name is required.");
			return responseDto;
		}

		try {
			// TODO: persist
		} catch (Exception e) {
			responseDto = new ResponseDto<Long>("MSEN-0500", null, "Error persisting student.");
			return responseDto;
		}

		// Mock response of id queried to the database
		Random random = new Random();
		Long id = random.nextLong() & Long.MAX_VALUE;
		responseDto = new ResponseDto<Long>("MSEN-0000", id, null);
		return responseDto;
	}

	/**
	 * This method allows to edit a student with id {@code studentId}
	 *  
	 * @param studentId
	 * @param studentDto
	 * @param userHeader
	 * @param hostHeader
	 * @return
	 */
	@Transactional
	public ResponseDto<Long> editStudent(String studentId, StudentDto studentDto, String userHeader,
			String hostHeader) {
		logger.trace("The user {} is editing the student {}", userHeader, studentDto);
		ResponseDto<Long> responseDto = null;
		// Validating some data
		if (StringUtils.isBlank(studentDto.getLastName())) {
			responseDto = new ResponseDto<Long>("MSEN-0101", null, "The value for last name is required.");
			return responseDto;
		}

		try {
			// TODO: persist
		} catch (Exception e) {
			responseDto = new ResponseDto<Long>("MSEN-0500", null, "Error persisting student.");
			return responseDto;
		}

		// Mock response of id queried to the database
		Random random = new Random();
		Long id = random.nextLong() & Long.MAX_VALUE;
		responseDto = new ResponseDto<Long>("MSEN-0000", id, null);
		return responseDto;
	}

	/**
	 * This method allows to delete a student with id {@code studentId}
	 * 
	 * @param studentId
	 * @param userHeader
	 * @param hostHeader
	 * @return
	 */
	@Transactional
	public ResponseDto<Long> deleteStudent(String studentId, String userHeader, String hostHeader) {
		logger.trace("The user {} is deleting the student with id{}", userHeader, studentId);
		ResponseDto<Long> responseDto = null;

		// Mock response of id queried to the database
		Random random = new Random();
		Long id = random.nextLong() & Long.MAX_VALUE;

		try {
			// TODO: persist
		} catch (Exception e) {
			responseDto = new ResponseDto<Long>("MSEN-0500", null, "Error deleting student.");
			return responseDto;
		}

		responseDto = new ResponseDto<Long>("MSEN-0000", id, null);
		return responseDto;
	}

	/**
	 * This method list all students
	 * 
	 * @param userHeader
	 * @param hostHeader
	 * @return
	 */
	public ResponseDto<List<StudentDto>> listStudents(String userHeader, String hostHeader) {
		logger.trace("The user {} is listing all the students", userHeader);
		ResponseDto<List<StudentDto>> responseDto = null;

		// Mock response
		List<StudentDto> students = new ArrayList<StudentDto>();
		Random random = new Random();
		StudentDto studentDto1 = new StudentDto((random.nextLong() & Long.MAX_VALUE), "LLM151186", "LANDA", "MELANY");
		StudentDto studentDto2 = new StudentDto((random.nextLong() & Long.MAX_VALUE), "RMJ111180", "ROJAS", "JUAN");
		StudentDto studentDto3 = new StudentDto((random.nextLong() & Long.MAX_VALUE), "PTH050182", "PEREZ", "HUGO");

		students.add(studentDto1);
		students.add(studentDto2);
		students.add(studentDto3);

		try {
			// TODO: persist
		} catch (Exception e) {
			responseDto = new ResponseDto<List<StudentDto>>("MSEN-0500", null, "Error listing students.");
			return responseDto;
		}

		responseDto = new ResponseDto<List<StudentDto>>("MSEN-0000", students, null);
		return responseDto;
	}

}
