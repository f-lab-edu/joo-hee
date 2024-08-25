package com.flab.joohee.code;

import org.springframework.http.HttpStatus;

public class JooHeeErrorCode implements CommonErrorCode {
	ErrorCode INVALID_CLASS_ID =
			new ErrorCode(400 + "001", "invalid class id", HttpStatus.BAD_REQUEST.value());
}
