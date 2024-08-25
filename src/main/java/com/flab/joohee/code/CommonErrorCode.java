package com.flab.joohee.code;

import org.springframework.http.HttpStatus;

public interface CommonErrorCode {
	ErrorCode BAD_REQUEST =
			new ErrorCode("400", HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST.value());
	ErrorCode UNAUTHORIZED =
			new ErrorCode("401", HttpStatus.UNAUTHORIZED.getReasonPhrase(), HttpStatus.UNAUTHORIZED.value());
	ErrorCode FORBIDDEN =
			new ErrorCode("403", HttpStatus.FORBIDDEN.getReasonPhrase(), HttpStatus.FORBIDDEN.value());
	ErrorCode NOT_FOUND =
			new ErrorCode("404", HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND.value());
	ErrorCode METHOD_NOT_ALLOWED =
			new ErrorCode("405", HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(),
					HttpStatus.METHOD_NOT_ALLOWED.value());
	ErrorCode INTERNAL_SERVER_ERROR =
			new ErrorCode("500", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR.value());

}
