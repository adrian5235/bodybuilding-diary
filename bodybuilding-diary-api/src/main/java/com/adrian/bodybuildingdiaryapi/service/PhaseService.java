package com.adrian.bodybuildingdiaryapi.service;

import com.adrian.bodybuildingdiaryapi.dto.PhaseDto;
import com.adrian.bodybuildingdiaryapi.mapper.PhaseMapper;
import com.adrian.bodybuildingdiaryapi.model.Day;
import com.adrian.bodybuildingdiaryapi.model.Phase;
import com.adrian.bodybuildingdiaryapi.model.Week;
import com.adrian.bodybuildingdiaryapi.repository.PhaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhaseService {

    private final PhaseRepository repository;
    private final PhaseMapper mapper;

    public Phase save(Phase phase) {
        return repository.save(phase);
    }

    public List<PhaseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public PhaseDto get(Integer id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }
}
