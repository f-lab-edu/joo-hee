package com.flab.joohee.exception.controller;

import com.flab.joohee.presentation.model.JooHeeResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class JooHeeErrorController extends DefaultErrorAttributes implements ErrorController {

	@RequestMapping("/error")
	public ResponseEntity<JooHeeResponse> error(WebRequest webRequest, HttpServletResponse response) {
		final Map<String, Object> errorAttrMap = getErrorAttributes(
				webRequest,
				ErrorAttributeOptions.defaults().including(
						ErrorAttributeOptions.Include.MESSAGE,
						ErrorAttributeOptions.Include.STACK_TRACE
				));
		final String errorMsg = errorAttrMap.get("message") + " - " + errorAttrMap.get("error");
		return new ResponseEntity<>(new JooHeeResponse("ErrorController", response.getStatus(), errorMsg),
				HttpStatus.valueOf(response.getStatus()));
	}
}
