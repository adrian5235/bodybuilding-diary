package com.adrian.bodybuildingdiaryapi.mapper;

import com.adrian.bodybuildingdiaryapi.dto.DayDto;
import com.adrian.bodybuildingdiaryapi.model.Day;
import com.adrian.bodybuildingdiaryapi.model.Week;
import com.adrian.bodybuildingdiaryapi.repository.WeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DayMapper {

    private final WeekRepository weekRepository;

    public DayDto toDto(Day day) {
        int id = day.getId();
        double weight = day.getWeight();
        int kcal = day.getKcal();
        int weekId = day.getWeek().getId();

        return new DayDto(id, weight, kcal, weekId);
    }

    public Day toEntity(DayDto dayDto) {
        int id = dayDto.id();
        double weight = dayDto.weight();
        int kcal = dayDto.kcal();
        // TODO handle exception
        Week week = weekRepository.findById(dayDto.weekId())
                .orElseThrow();

        return new Day(id, weight, kcal, week);
    }
}
