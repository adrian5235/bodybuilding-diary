package com.adrian.bodybuildingdiaryapi.dto;

public record DayDto(
        int id,
        double weight,
        int kcal,
        int weekId
) {
}
