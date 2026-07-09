package com.example.demo.mapper;

import java.time.LocalDate;
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
        entity.setTaskStatus(false);
        entity.setTaskUpdate(now);
        entity.setTaskDelete(now);

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
        entity.setTaskUpdate(reservation.getTaskUpdate());
        entity.setTaskDelete(reservation.getTaskDelete());
        entity.setTaskUser(reservation.getTaskUser());
        entity.setTaskStatus(reservation.getTaskStatus());
        entity.setUserId(reservation.getUserId());
    }
    
    public Reservation toModel(ReservationForm reservationForm, LocalDate preferredDate) {
        Reservation reservation = new Reservation();

        reservation.setTaskName(reservationForm.getTaskName());
        reservation.setTaskContents(reservationForm.getTaskContents());
        reservation.setTaskLimitdate(reservationForm.getTaskLimitdate());
        reservation.setTaskUpdate(reservationForm.getTaskUpdate());
        reservation.setTaskDelete(reservationForm.getTaskDelete());
        reservation.setTaskUser(reservationForm.getTaskUser());
        reservation.setTaskStatus(reservationForm.getTaskStatus());
        reservation.setUserId(reservationForm.getUserId());

        return reservation;
    }
}