package com.flab.joohee.exception;

import com.flab.joohee.code.ErrorCode;
import lombok.Getter;

@Getter
public class JooHeeException extends RuntimeException {
	private final transient ErrorCode errorCode;

	public JooHeeException(ErrorCode errorCode) {
		this(errorCode, null);
	}

	public JooHeeException(ErrorCode errorCode, Throwable cause) {
		super(errorCode.errorMsg(), cause);
		this.errorCode = errorCode;
	}

}
