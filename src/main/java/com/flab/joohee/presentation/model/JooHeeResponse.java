package com.flab.joohee.presentation.model;

import com.flab.joohee.code.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JooHeeResponse {
	private String code;
	private int status;
	private Object message;

	public JooHeeResponse(String code, int status, Object message) {
		this.code = code;
		this.status = status;
		this.message = message;
	}

	public JooHeeResponse(ErrorCode errorCode) {
		this(errorCode.code(), errorCode.status(), errorCode.errorMsg());
	}

	public String toMessage() {
		return String.format("%d : [%s] - %s", status, code, message);
	}
}
