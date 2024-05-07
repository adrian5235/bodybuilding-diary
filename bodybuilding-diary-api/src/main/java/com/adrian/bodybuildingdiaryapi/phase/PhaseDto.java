package com.adrian.bodybuildingdiaryapi.phase;

import com.adrian.bodybuildingdiaryapi.week.WeekDto;

import java.util.List;

public record PhaseDto(
        int id,
        String name,
        List<WeekDto> weeks
) {
}
