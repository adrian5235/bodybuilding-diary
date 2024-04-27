package com.adrian.bodybuildingdiaryapi.mapper;

import com.adrian.bodybuildingdiaryapi.dto.PhaseDto;
import com.adrian.bodybuildingdiaryapi.dto.WeekDto;
import com.adrian.bodybuildingdiaryapi.model.Phase;
import com.adrian.bodybuildingdiaryapi.model.Week;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PhaseMapper {

    private final WeekMapper weekMapper;

    public PhaseDto toDto(Phase phase) {
        int id = phase.getId();
        String name = phase.getName();
        List<WeekDto> weeks = phase.getWeeks()
                .stream()
                .map(weekMapper::toDto)
                .toList();

        return new PhaseDto(id, name, weeks);
    }

    public Phase toEntity(PhaseDto phaseDto) {
        int id = phaseDto.id();
        String name = phaseDto.name();
        List<Week> weeks = phaseDto.weeks()
                .stream()
                .map(weekMapper::toEntity)
                .toList();

        return new Phase(id, name, weeks);
    }
}
