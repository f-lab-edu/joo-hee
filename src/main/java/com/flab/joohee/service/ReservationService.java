package com.flab.joohee.service;

import com.flab.joohee.domain.Reservation;
import com.flab.joohee.model.request.ReservationRequest;
import com.flab.joohee.model.response.ReservationResponse;
import com.flab.joohee.repository.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
	private final ReservationMapper reservationMapper;

	/**
	 * 예약 조회 시
	 * 1. 예약 코드로 예약 정보 조회
	 */
	public List<ReservationResponse> getReservations(ReservationRequest request) {
		List<Reservation> reservations = reservationMapper.getReservations(request);
		return new ArrayList<>();
	}

	public ReservationResponse getReservation(String reservationId) {
		Reservation reservation = reservationMapper.getReservation(reservationId);
		return new ReservationResponse();
	}

	/**
	 * 예약 등록 시
	 * 1. 클래스 아이디가 유효한지 확인
	 * 2. 예약을 시도하는 사용자의 아이디가 유효한지 확인 400 bad req / 401 unauth
	 * 3. 예약 수량이 적절한지 확인
	 * 4. 클래스의 예약 오픈 시간 이전인지 확인 (예약 가능 시간인지)
	 * 5. 클래스의 정원을 초과하지 않았는지 확인
	 * 6. 중복 예약인지 확인
	 * <p>
	 * 다른 사용자가 같은 클래스를 예약해서 정원 초과되는 문제 고려...
	 * 1. select update ... database lock 낙관적/비관적
	 */
	public ReservationResponse createReservation(ReservationRequest request) {
		reservationMapper.createReservation(request);
		return new ReservationResponse();
	}

	/**
	 * 예약 변경 시
	 * 1. 클래스 아이디가 유효한지 확인
	 * 2. 예약을 시도하는 사용자의 아이디가 유효한지 확인
	 * 3. 기존 예약이 존재하는지 확인
	 * 4. 새로운 클래스에 예약이 가능한지 확인
	 * 5.
	 */
	public ReservationResponse updateReservation(String reservationId, ReservationRequest request) {
		reservationMapper.updateReservation(reservationId, request);
		return new ReservationResponse();
	}

	/**
	 * 예약 취소 시
	 * 1. 기 존재하는 예약이 있는지 확인
	 * 2. 클래스 시작 시간 전인지 확인(또는 예약 취소 가능 기간 이내인지)
	 * 3. 이미 취소된 예약인지 확인
	 */
	public ReservationResponse deleteReservation(String reservationId) {
		return new ReservationResponse();
	}

}
