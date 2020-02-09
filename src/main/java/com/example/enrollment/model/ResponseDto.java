package com.example.enrollment.model;

import java.io.Serializable;

public class ResponseDto<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String statusCode;
	private T response;
	private String errorDetail;
	
	public ResponseDto() {
		
	}

	public ResponseDto(String statusCode, T response, String errorDetail) {
		super();
		this.statusCode = statusCode;
		this.response = response;
		this.errorDetail = errorDetail;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	@Override
	public String toString() {
		return "ResponseDTO [statusCode=" + statusCode + ", response=" + response + ", errorDetail=" + errorDetail
				+ "]";
	}
}
