package com.flab.joohee.controller;

import com.flab.joohee.model.request.ReservationRequest;
import com.flab.joohee.model.response.JooHeeResponse;
import com.flab.joohee.model.response.ReservationResponse;
import com.flab.joohee.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/reservations")
@RequiredArgsConstructor
public class ReservationController {
	private final ReservationService reservationService;

	@GetMapping
	public JooHeeResponse<List<ReservationResponse>> getReservations(ReservationRequest request) {
		return new JooHeeResponse<>(reservationService.getReservations(request));
	}

	@GetMapping("/{reservationId}")
	public JooHeeResponse<ReservationResponse> getReservation(@PathVariable String reservationId) {
		return new JooHeeResponse<>(reservationService.getReservation(reservationId));
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public JooHeeResponse<ReservationResponse> createReservation(@RequestBody ReservationRequest request) {
		return new JooHeeResponse<>(reservationService.createReservation(request));
	}

	@PutMapping("/{reservationId}")
	public JooHeeResponse<ReservationResponse> updateReservation(@PathVariable String reservationId, @RequestBody ReservationRequest request) {
		return new JooHeeResponse<>(reservationService.updateReservation(reservationId, request));
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{reservationId}")
	public JooHeeResponse<ReservationResponse> deleteReservation(@PathVariable String reservationId) {
		return new JooHeeResponse<>(reservationService.deleteReservation(reservationId));
	}

}
