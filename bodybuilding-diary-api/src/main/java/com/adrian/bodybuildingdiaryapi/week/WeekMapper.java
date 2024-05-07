package com.adrian.bodybuildingdiaryapi.week;

import com.adrian.bodybuildingdiaryapi.day.DayDto;
import com.adrian.bodybuildingdiaryapi.day.DayMapper;
import com.adrian.bodybuildingdiaryapi.day.Day;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WeekMapper {

    private final DayMapper dayMapper;

    public WeekDto toDto(Week week) {
        int id = week.getId();
        double averageWeight = week.getAverageWeight();
        int averageKcal = week.getAverageKcal();
        double weightDifference = week.getWeightDifference();
        int calculatedMaintenance = week.getCalculatedMaintenance();
        List<DayDto> days = week.getDays()
                .stream()
                .map(dayMapper::toDto)
                .toList();

        return new WeekDto(id, averageWeight, averageKcal, weightDifference, calculatedMaintenance, days);
    }

    public Week toEntity(WeekDto weekDto) {
        int id = weekDto.id();
        double averageWeight = weekDto.averageWeight();
        int averageKcal = weekDto.averageKcal();
        double weightDifference = weekDto.weightDifference();
        int calculatedMaintenance = weekDto.calculatedMaintenance();
        List<Day> days = weekDto.days()
                .stream()
                .map(dayMapper::toEntity)
                .toList();

        return new Week(id, averageWeight, averageKcal, weightDifference, calculatedMaintenance, days);
    }
}
