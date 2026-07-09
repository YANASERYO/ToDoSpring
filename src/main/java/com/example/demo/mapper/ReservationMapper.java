package com.example.demo.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.demo.entity.ReservationEntity;
import com.example.demo.form.ReservationForm;
import com.example.demo.model.Reservation;

@Component
public class ReservationMapper {

    public ReservationEntity toEntity(Reservation reservation) {
        ReservationEntity entity = new ReservationEntity();

        copyReservationFields(reservation, entity);

        LocalDateTime now = LocalDateTime.now();
        entity.setTaskStatus(0);
        entity.setTaskUpdate(now);
        entity.setTaskDelete(null);

        return entity;
    }

    public void updateEntity(Reservation updatedReservation, ReservationEntity existingReservation) {
        copyReservationFields(updatedReservation, existingReservation);
        existingReservation.setTaskUpdate(LocalDateTime.now());
    }

    private void copyReservationFields(Reservation reservation, ReservationEntity entity) {
        entity.setTaskName(reservation.getTaskName());
        entity.setTaskContents(reservation.getTaskContents());
        entity.setTaskLimitdate(reservation.getTaskLimitdate());
        entity.setTaskUser(reservation.getTaskUser());
        entity.setUserId(reservation.getUserId());
    }
    
    public Reservation toModel(ReservationForm reservationForm) {
        Reservation reservation = new Reservation();

        reservation.setTaskName(reservationForm.getTaskName());
        reservation.setTaskContents(reservationForm.getTaskContents());
        reservation.setTaskUser(reservationForm.getTaskUser());
        reservation.setUserId(reservationForm.getUserId());
        reservation.setTaskStatus(false);

        return reservation;
    }
}