package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserAccountEntity;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long> {
//	検索メソッド
	Optional<UserAccountEntity> findByUsername(String username);
	
}