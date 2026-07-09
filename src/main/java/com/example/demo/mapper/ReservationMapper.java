package com.example.demo.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.demo.entity.ReservationEntity;
import com.example.demo.form.ReservationForm;
import com.example.demo.model.Reservation;

@Component
public class ReservationMapper {

    // Model → Entity：新規登録用
    public ReservationEntity toEntity(Reservation reservation) {
        ReservationEntity entity = new ReservationEntity();

        copyReservationFields(reservation, entity);

        LocalDateTime now = LocalDateTime.now();
        entity.setTaskUpdate(now);
        entity.setTaskDelete(null);

        return entity;
    }

    // Model → Entity：更新用
    public void updateEntity(Reservation updatedReservation, ReservationEntity existingReservation) {
        copyReservationFields(updatedReservation, existingReservation);
        existingReservation.setTaskUpdate(LocalDateTime.now());
    }

    // 共通項目コピー
    private void copyReservationFields(Reservation reservation, ReservationEntity entity) {
        entity.setTaskName(reservation.getTaskName());
        entity.setTaskContents(reservation.getTaskContents());
        entity.setTaskLimitdate(reservation.getTaskLimitdate());
        entity.setTaskUser(reservation.getTaskUser());
        entity.setTaskStatus(reservation.getTaskStatus());
        entity.setUserId(reservation.getUserId());
    }

    // Form → Model
    public Reservation toModel(ReservationForm reservationForm, String userId) {
        Reservation reservation = new Reservation();

        reservation.setTaskName(reservationForm.getTaskName());
        reservation.setTaskContents(reservationForm.getTaskContents());
        reservation.setTaskLimitdate(reservationForm.getTaskLimitdate());
        reservation.setTaskUser(reservationForm.getTaskUser());
        reservation.setTaskStatus(reservationForm.getTaskStatus());
        reservation.setUserId(userId);

        return reservation;
    }

    // Entity → Form：変更画面表示用
    public ReservationForm toForm(ReservationEntity entity) {
        ReservationForm form = new ReservationForm();

        form.setTaskName(entity.getTaskName());
        form.setTaskContents(entity.getTaskContents());
        form.setTaskLimitdate(entity.getTaskLimitdate());
        form.setTaskUser(entity.getTaskUser());
        form.setTaskStatus(entity.getTaskStatus());

        return form;
    }
}