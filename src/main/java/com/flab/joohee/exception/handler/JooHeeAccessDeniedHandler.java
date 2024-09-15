package com.flab.joohee.exception.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.joohee.code.CommonErrorCode;
import com.flab.joohee.code.ErrorCode;
import com.flab.joohee.model.response.JooHeeResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JooHeeAccessDeniedHandler implements AccessDeniedHandler {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException {
		final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
		final JooHeeResponse<ErrorCode> errorResponse = new JooHeeResponse<>(CommonErrorCode.FORBIDDEN);

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
	}
}
