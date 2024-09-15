package com.flab.joohee.model.request;

import com.flab.joohee.code.ReservationStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationRequest {
	@NotBlank
	private String userId;
	private String reservationName;
	private String reservationCode;
	private LocalDateTime reservationDate;
	private ReservationStatus status;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
}
