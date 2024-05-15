package com.adrian.bodybuildingdiaryapi.day;

import com.adrian.bodybuildingdiaryapi.week.Week;
import com.adrian.bodybuildingdiaryapi.week.WeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
        Optional<Week> optionalWeek = weekRepository.findById(dayDto.weekId());
        Week week = optionalWeek.orElse(null);

        return new Day(id, weight, kcal, week);
    }
}
