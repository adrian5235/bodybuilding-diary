package com.adrian.bodybuildingdiaryapi.week;

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
