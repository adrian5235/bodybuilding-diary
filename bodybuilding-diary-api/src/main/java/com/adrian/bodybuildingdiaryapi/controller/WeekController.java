package com.adrian.bodybuildingdiaryapi.controller;

import com.adrian.bodybuildingdiaryapi.dto.WeekDto;
import com.adrian.bodybuildingdiaryapi.model.Week;
import com.adrian.bodybuildingdiaryapi.service.WeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/weeks")
public class WeekController {

    private final WeekService service;

    @PostMapping
    public Week save(@RequestBody Week week) {
        return service.save(week);
    }

    @GetMapping
    public List<WeekDto> getAll() {
        return service.getAll();
    }
}
