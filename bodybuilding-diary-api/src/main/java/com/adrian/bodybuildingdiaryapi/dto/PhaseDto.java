package com.adrian.bodybuildingdiaryapi.dto;

import java.util.List;

public record PhaseDto(
        int id,
        String name,
        List<WeekDto> weeks
) {
}
