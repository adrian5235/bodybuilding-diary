package com.adrian.bodybuildingdiaryapi.week;

import com.adrian.bodybuildingdiaryapi.day.DayDto;

import java.util.List;

public record WeekDto(
        int id,
        double averageWeight,
        int averageKcal,
        double weightDifference,
        int calculatedMaintenance,
        List<DayDto> days
) {
}
