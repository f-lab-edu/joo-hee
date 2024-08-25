package com.flab.joohee.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.joohee.code.CommonErrorCode;
import com.flab.joohee.presentation.model.JooHeeResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JooHeeAuthEntryPointConfig implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
		final JooHeeResponse errorResponse = new JooHeeResponse(CommonErrorCode.UNAUTHORIZED);

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
	}
}
