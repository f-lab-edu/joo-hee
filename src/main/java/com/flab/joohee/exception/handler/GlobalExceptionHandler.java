package com.flab.joohee.exception.handler;

import com.flab.joohee.code.CommonErrorCode;
import com.flab.joohee.code.ErrorCode;
import com.flab.joohee.exception.JooHeeException;
import com.flab.joohee.model.response.JooHeeResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@Getter
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<JooHeeResponse<ErrorCode>> exceptionHandler(Throwable throwable) {
		final JooHeeResponse<ErrorCode> errorResponse =
				new JooHeeResponse<>("GlobalException", HttpStatus.INTERNAL_SERVER_ERROR.value(), throwable.getMessage());

		log.error(errorResponse.toMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
	}

	@ExceptionHandler(JooHeeException.class)
	public ResponseEntity<JooHeeResponse<ErrorCode>> jooHeeExceptionHandler(Throwable throwable) {
		final JooHeeException jooHeeException = (JooHeeException) throwable;
		final JooHeeResponse<ErrorCode> errorResponse = new JooHeeResponse<>(jooHeeException.getErrorCode());

		log.error(errorResponse.toMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
	}

	// todo - exception 개별 처리

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<JooHeeResponse<ErrorCode>> notFoundExceptionHandler(
			Throwable cause) {
		final JooHeeResponse<ErrorCode> errorResponse = new JooHeeResponse<>(CommonErrorCode.NOT_FOUND);

		log.error(cause.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
	}


	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<JooHeeResponse<ErrorCode>> httpRequestMethodNotSupportedExceptionHandler(
			HttpRequestMethodNotSupportedException exception) {
		final JooHeeResponse<ErrorCode> errorResponse = new JooHeeResponse<>(CommonErrorCode.METHOD_NOT_ALLOWED);

		log.error(exception.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
	}

}
