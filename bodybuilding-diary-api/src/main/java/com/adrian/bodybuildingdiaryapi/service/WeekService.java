package com.adrian.bodybuildingdiaryapi.service;

import com.adrian.bodybuildingdiaryapi.dto.WeekDto;
import com.adrian.bodybuildingdiaryapi.mapper.WeekMapper;
import com.adrian.bodybuildingdiaryapi.model.Day;
import com.adrian.bodybuildingdiaryapi.model.Phase;
import com.adrian.bodybuildingdiaryapi.model.Week;
import com.adrian.bodybuildingdiaryapi.repository.WeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeekService {

    private final WeekRepository repository;
    private final WeekMapper mapper;

    public Week save(Week week) {
        return repository.save(week);
    }

    public List<WeekDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
