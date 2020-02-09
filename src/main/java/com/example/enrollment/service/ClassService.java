package com.example.enrollment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.enrollment.model.ClassDto;
import com.example.enrollment.model.ResponseDto;

@Service
public class ClassService {

	private static Logger logger = LoggerFactory.getLogger(ClassService.class);

	/**
	 * This method persist the class after validating the title.
	 * 
	 * @param classDto
	 * @param userHeader
	 * @param hostHeader
	 * @return
	 */
	@Transactional
	public ResponseDto<Integer> persistClass(ClassDto classDto, String userHeader, String hostHeader) {
		logger.trace("The user {} is creating the class {}", userHeader, classDto);
		ResponseDto<Integer> responseDto = null;

		// Validating some data
		if (StringUtils.isBlank(classDto.getTitle())) {
			responseDto = new ResponseDto<Integer>("MSEN-0101", null, "The value for title is required.");
			return responseDto;
		}

		try {
			// TODO: persist
		} catch (Exception e) {
			responseDto = new ResponseDto<Integer>("MSEN-0500", null, "Error persisting class.");
			return responseDto;
		}

		// Mock response of id queried to the database
		Random random = new Random();
		Integer id = random.nextInt() & Integer.MAX_VALUE;
		responseDto = new ResponseDto<Integer>("MSEN-0000", id, null);
		return responseDto;
	}

	/**
	 * This method allow the edition of a class with code {@code classCode}
	 * 
	 * @param classCode
	 * @param classDto
	 * @param userHeader
	 * @param hostHeader
	 * @return
	 */
	public ResponseDto<Integer> editClass(String classCode, ClassDto classDto, String userHeader,
			String hostHeader) {
		logger.trace("The user {} is editing the class {}", userHeader, classDto);
		ResponseDto<Integer> responseDto = null;
		// Validating some data
		if (StringUtils.isBlank(classDto.getTitle())) {
			responseDto = new ResponseDto<Integer>("MSEN-0101", null, "The value for title is required.");
			return responseDto;
		}

		try {
			// TODO: persist
		} catch (Exception e) {
			responseDto = new ResponseDto<Integer>("MSEN-0500", null, "Error persisting class.");
			return responseDto;
		}

		// Mock response of id queried to the database
		Random random = new Random();
		Integer id = random.nextInt() & Integer.MAX_VALUE;
		responseDto = new ResponseDto<Integer>("MSEN-0000", id, null);
		return responseDto;
	}

	/**
	 * This method allows to delete a class with code {@code classCode}
	 * 
	 * @param classCode
	 * @param userHeader
	 * @param hostHeader
	 * @return
	 */
	public ResponseDto<Integer> deleteClass(String classCode, String userHeader, String hostHeader) {
		logger.trace("The user {} is deleting the class with code {}", userHeader, classCode);
		ResponseDto<Integer> responseDto = null;

		// Mock response of id queried to the database
		Random random = new Random();
		Integer id = random.nextInt() & Integer.MAX_VALUE;

		try {
			// TODO: persist
		} catch (Exception e) {
			responseDto = new ResponseDto<Integer>("MSEN-0500", null, "Error deleting class.");
			return responseDto;
		}

		responseDto = new ResponseDto<Integer>("MSEN-0000", id, null);
		return responseDto;
	}

	/**
	 * This method allows to list all classes 
	 * 
	 * @param userHeader
	 * @param hostHeader
	 * @return
	 */
	public ResponseDto<List<ClassDto>> listClasses(String userHeader, String hostHeader) {
		logger.trace("The user {} is listing all the classes", userHeader);
		ResponseDto<List<ClassDto>> responseDto = null;

		// Mock response
		List<ClassDto> classes = new ArrayList<ClassDto>();
		Random random = new Random();
		ClassDto classDto1 = new ClassDto((random.nextInt() & Integer.MAX_VALUE), "INF-190", "INTRODUCCIÓN A LA PROGRAMACIÓN", "DESCRIPCIÓN 1");
		ClassDto classDto2 = new ClassDto((random.nextInt() & Integer.MAX_VALUE), "MAT-123", "MATEMÁTICA DISCRETA", "DESCRIPCIÓN 2");
		ClassDto classDto3 = new ClassDto((random.nextInt() & Integer.MAX_VALUE), "INF-162", "ANÁLISIS DE BASE DE DATOS", "DESCRIPCIÓN 3");

		classes.add(classDto1);
		classes.add(classDto2);
		classes.add(classDto3);

		try {
			// TODO: persist
		} catch (Exception e) {
			responseDto = new ResponseDto<List<ClassDto>>("MSEN-0500", null, "Error listing classes.");
			return responseDto;
		}

		responseDto = new ResponseDto<List<ClassDto>>("MSEN-0000", classes, null);
		return responseDto;
	}

}
