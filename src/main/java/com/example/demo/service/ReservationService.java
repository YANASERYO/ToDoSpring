package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ReservationEntity;
import com.example.demo.mapper.ReservationMapper;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(
            ReservationRepository reservationRepository,
            ReservationMapper reservationMapper
    ) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    // ToDo新規登録
    public ReservationEntity createReservation(Reservation reservation) {
        ReservationEntity entity = reservationMapper.toEntity(reservation);
        return reservationRepository.save(entity);
    }

    // 全件取得
    public List<ReservationEntity> findAllReservations() {
        return reservationRepository.findAll();
    }

    // ログインユーザーのToDoだけ取得
    public List<ReservationEntity> findReservationsByUserId(String userId) {
        return reservationRepository.findByUserIdOrderByIdAsc(userId);
    }

    // IDで1件取得
    public ReservationEntity findReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    // ToDo更新
    public ReservationEntity updateReservation(Long id, Reservation updatedReservation) {
        ReservationEntity existingReservation = reservationRepository.findById(id).orElse(null);

        if (existingReservation == null) {
            return null;
        }

        reservationMapper.updateEntity(updatedReservation, existingReservation);
        return reservationRepository.save(existingReservation);
    }

    // 論理削除
    public void deleteReservation(Long id) {
        ReservationEntity reservation = reservationRepository.findById(id).orElse(null);

        if (reservation == null) {
            return;
        }

        reservation.setTaskDelete(LocalDateTime.now());
        reservation.setTaskUpdate(LocalDateTime.now());

        reservationRepository.save(reservation);
    }

    // 削除できるか判定
    public boolean canDelete(ReservationEntity reservation) {
        Integer status = reservation.getTaskStatus();

        return reservation.getTaskDelete() == null
                && (Integer.valueOf(0).equals(status)
                || Integer.valueOf(1).equals(status)
                || Integer.valueOf(2).equals(status));
    }
}