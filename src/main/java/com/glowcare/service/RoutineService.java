package com.glowcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glowcare.dto.RoutineDto;
import com.glowcare.entity.Routine;
import com.glowcare.repository.RoutineRepository;

@Service
public class RoutineService {

    @Autowired
    private RoutineRepository routineRepository;

    public RoutineDto addRoutine(RoutineDto dto) {

        Routine routine = new Routine();

        routine.setUserId(dto.getUserId());
        routine.setName(dto.getName());
        routine.setMorningRoutine(dto.getMorningRoutine());
        routine.setNightRoutine(dto.getNightRoutine());
        routine.setStatus(dto.getStatus());

        Routine savedRoutine = routineRepository.save(routine);

        return convertToDto(savedRoutine);
    }

    public List<RoutineDto> getAllRoutines() {

        List<Routine> routines = routineRepository.findAll();
        List<RoutineDto> result = new ArrayList<>();

        for (Routine routine : routines) {
            result.add(convertToDto(routine));
        }

        return result;
    }

    public List<RoutineDto> getUserRoutines(Long userId) {

        List<Routine> routines = routineRepository.findByUserId(userId);
        List<RoutineDto> result = new ArrayList<>();

        for (Routine routine : routines) {
            result.add(convertToDto(routine));
        }

        return result;
    }

    public RoutineDto updateRoutine(Long id, RoutineDto dto) {

        Routine routine = routineRepository.findById(id).orElse(null);

        if (routine == null) {
            return null;
        }

        routine.setUserId(dto.getUserId());
        routine.setName(dto.getName());
        routine.setMorningRoutine(dto.getMorningRoutine());
        routine.setNightRoutine(dto.getNightRoutine());
        routine.setStatus(dto.getStatus());

        Routine updatedRoutine = routineRepository.save(routine);

        return convertToDto(updatedRoutine);
    }

    public void deleteRoutine(Long id) {
        routineRepository.deleteById(id);
    }

    private RoutineDto convertToDto(Routine routine) {

        RoutineDto dto = new RoutineDto();

        dto.setId(routine.getId());
        dto.setUserId(routine.getUserId());
        dto.setName(routine.getName());
        dto.setMorningRoutine(routine.getMorningRoutine());
        dto.setNightRoutine(routine.getNightRoutine());
        dto.setStatus(routine.getStatus());

        return dto;
    }
}