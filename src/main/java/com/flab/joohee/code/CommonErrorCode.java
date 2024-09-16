package com.flab.joohee.code;

import org.springframework.http.HttpStatus;

public interface CommonErrorCode {
	ErrorCode BAD_REQUEST =
			new ErrorCode("400", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
	ErrorCode UNAUTHORIZED =
			new ErrorCode("401", HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
	ErrorCode FORBIDDEN =
			new ErrorCode("403", HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
	ErrorCode NOT_FOUND =
			new ErrorCode("404", HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
	ErrorCode METHOD_NOT_ALLOWED =
			new ErrorCode("405", HttpStatus.METHOD_NOT_ALLOWED.value(),
					HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
	ErrorCode INTERNAL_SERVER_ERROR =
			new ErrorCode("500", HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

}
