package com.adrian.bodybuildingdiaryapi.dto;

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
