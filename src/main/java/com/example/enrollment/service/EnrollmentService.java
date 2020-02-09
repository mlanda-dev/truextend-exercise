package com.example.enrollment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.enrollment.model.ClassDto;
import com.example.enrollment.model.ResponseDto;
import com.example.enrollment.model.StudentDto;

@Service
public class EnrollmentService {

	private static Logger logger = LoggerFactory.getLogger(EnrollmentService.class);

	/**
	 * List all students assigned to a class.
	 * 
	 * @param userHeader
	 * @param hostHeader
	 * @param classCode
	 * @return
	 */
	public ResponseDto<ClassDto> listStudentsAssignedToClass(String userHeader, String hostHeader, String classCode) {
		logger.trace("The user {} is listing all the students assigned to class {}", userHeader, classCode);
		ResponseDto<ClassDto> responseDto = null;

		if (StringUtils.isBlank(classCode)) {
			responseDto = new ResponseDto<ClassDto>("MSEN-0101", null, "The value for class code is required.");
			return responseDto;
		}
		// Mock response
		Random randomc = new Random();
		ClassDto classDto1 = new ClassDto((randomc.nextInt() & Integer.MAX_VALUE), "INF-190",
				"INTRODUCCIÓN A LA PROGRAMACIÓN", "DESCRIPCIÓN 1");
		List<StudentDto> students = new ArrayList<StudentDto>();

		classDto1.setStudents(students);

		if (!classCode.trim().equalsIgnoreCase("INF-190")) {
			responseDto = new ResponseDto<ClassDto>("MSEN-0101", classDto1, "null");
			return responseDto;
		} else {
			// Mock students assigned to INF-190
			Random randoms = new Random();
			StudentDto studentDto1 = new StudentDto((randoms.nextLong() & Long.MAX_VALUE), "LLM151186", "LANDA",
					"MELANY");
			StudentDto studentDto2 = new StudentDto((randoms.nextLong() & Long.MAX_VALUE), "RMJ111180", "ROJAS",
					"JUAN");
			students.add(studentDto1);
			students.add(studentDto2);

			responseDto = new ResponseDto<ClassDto>("MSEN-0000", classDto1, null);
			return responseDto;
		}
	}

	/**
	 * List all classes assigned to a student.
	 * 
	 * @param userHeader
	 * @param hostHeader
	 * @param studentId
	 * @return
	 */
	public ResponseDto<StudentDto> listClassesAssignedToStudent(String userHeader, String hostHeader,
			String studentId) {
		logger.trace("The user {} is listing all classes assigned to student {}", userHeader, studentId);
		ResponseDto<StudentDto> responseDto = null;

		if (StringUtils.isBlank(studentId)) {
			responseDto = new ResponseDto<StudentDto>("MSEN-0101", null, "The value for student id is required.");
			return responseDto;
		}
		// Mock response
		Random randoms = new Random();
		StudentDto studentDto1 = new StudentDto((randoms.nextLong() & Long.MAX_VALUE), "LLM151186", "LANDA", "MELANY");
		List<ClassDto> classes = new ArrayList<ClassDto>();

		if (!studentId.trim().equalsIgnoreCase("LLM151186")) {
			responseDto = new ResponseDto<StudentDto>("MSEN-0101", studentDto1, "null");
			return responseDto;
		} else {
			// Mock students assigned to INF-190
			Random randomc = new Random();
			ClassDto classDto1 = new ClassDto((randomc.nextInt() & Integer.MAX_VALUE), "INF-190",
					"INTRODUCCIÓN A LA PROGRAMACIÓN", "DESCRIPCIÓN 1");
			ClassDto classDto2 = new ClassDto((randomc.nextInt() & Integer.MAX_VALUE), "MAT-123", "MATEMÁTICA DISCRETA",
					"DESCRIPCIÓN 2");
			classes.add(classDto1);
			classes.add(classDto2);
			studentDto1.setClasses(classes);
			
			responseDto = new ResponseDto<StudentDto>("MSEN-0000", studentDto1, null);
			return responseDto;
		}
	}
}
