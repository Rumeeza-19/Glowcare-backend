package com.glowcare.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String name;
    private String morningRoutine;
    private String nightRoutine;
    private String status;

    public Routine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMorningRoutine() {
        return morningRoutine;
    }

    public void setMorningRoutine(String morningRoutine) {
        this.morningRoutine = morningRoutine;
    }

    public String getNightRoutine() {
        return nightRoutine;
    }

    public void setNightRoutine(String nightRoutine) {
        this.nightRoutine = nightRoutine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}