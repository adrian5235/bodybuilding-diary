package com.adrian.bodybuildingdiaryapi.day;

public record DayDto(
        int id,
        double weight,
        int kcal,
        int weekId
) {
}
