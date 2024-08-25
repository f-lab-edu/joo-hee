package com.flab.joohee.config;

import com.flab.joohee.exception.handler.JooHeeAccessDeniedHandler;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class JooHeeJWTSecurityConfig {

	private final JooHeeAuthEntryPointConfig jooHeeAuthEntryPointConfig;
	private final JooHeeAccessDeniedHandler jooHeeAccessDeniedHandler;

	@Bean
	public SecurityFilterChain jwtTemplatesFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(AbstractHttpConfigurer::disable)
				.formLogin(AbstractHttpConfigurer::disable)
				.sessionManagement(sessionManagement
						-> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.exceptionHandling((ExceptionHandlingConfigurer<HttpSecurity> exceptionHandling) -> {
					exceptionHandling.authenticationEntryPoint(jooHeeAuthEntryPointConfig);
					exceptionHandling.accessDeniedHandler(jooHeeAccessDeniedHandler);
				})
				.authorizeHttpRequests(
						(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorize) -> {
							authorize.dispatcherTypeMatchers(DispatcherType.ERROR).permitAll();
							authorize.requestMatchers("/**/*").permitAll();
							authorize.requestMatchers("/**/*").hasAnyAuthority("admin", "user");
							authorize.anyRequest().authenticated();
						})
				.build();
	}
}
