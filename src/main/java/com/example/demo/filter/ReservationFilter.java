package com.example.demo.filter;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.entity.ReservationEntity;


	@Component
	public class ReservationFilter {
		public List<ReservationEntity> filter(List<ReservationEntity> reservations, String filter) {
		    LocalDate today = LocalDate.now();
		    
		    if ("future".equals(filter)) {
	            return reservations.stream()
	                    .filter(r -> !isCompleted(r))
	                    .filter(r -> r.getTaskLimitdate() != null)
	                    .filter(r -> r.getTaskLimitdate().isAfter(today))
	                    .sorted(reservationSortOrder())
	                    .collect(Collectors.toList());
	        }

	        if ("overdue".equals(filter)) {
	            return reservations.stream()
	                    .filter(r -> !isCompleted(r))
	                    .filter(r -> r.getTaskLimitdate() != null)
	                    .filter(r -> r.getTaskLimitdate().isBefore(today))
	                    .sorted(reservationSortOrder())
	                    .collect(Collectors.toList());
	        }

	        if ("completed".equals(filter)) {
	            return reservations.stream()
	                    .filter(this::isCompleted)
	                    .sorted(reservationSortOrder())
	                    .collect(Collectors.toList());
	        }

	        if ("all".equals(filter)) {
	            return reservations.stream()
	                    .sorted(reservationSortOrder())
	                    .collect(Collectors.toList());
	        }

	        // デフォルト：今日が期限の未完了タスク
	        return reservations.stream()
	                .filter(r -> !isCompleted(r))
	                .filter(r -> today.equals(r.getTaskLimitdate()))
	                .sorted(reservationSortOrder())
	                .collect(Collectors.toList());
	    }

	    // taskStatus = 9 を完了扱いにする
	    private boolean isCompleted(ReservationEntity reservation) {
	        return Integer.valueOf(9).equals(reservation.getTaskStatus());
	    }

	    private Comparator<ReservationEntity> reservationSortOrder() {
	        return Comparator
	                .comparing(
	                        ReservationEntity::getTaskLimitdate,
	                        Comparator.nullsLast(Comparator.naturalOrder())
	                )
	                .thenComparing(
	                        ReservationEntity::getId,
	                        Comparator.nullsLast(Comparator.naturalOrder())
	                );
	    }
}


