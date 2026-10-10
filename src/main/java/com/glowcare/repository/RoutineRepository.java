package com.glowcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glowcare.entity.Routine;

public interface RoutineRepository extends JpaRepository<Routine, Long> {

    List<Routine> findByUserId(Long userId);
}