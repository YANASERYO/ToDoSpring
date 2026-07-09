//DBに保存するために必要なクラス（主キー：Long）
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
	
	List<ReservationEntity> findByUserIdOrderByIdAsc(String userId);

}
