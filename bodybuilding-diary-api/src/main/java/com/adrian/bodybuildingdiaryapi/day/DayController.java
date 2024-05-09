package com.adrian.bodybuildingdiaryapi.day;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/days")
public class DayController {

    private final DayService service;

    @PostMapping
    public DayDto save(
            @RequestBody DayDto dayDto
    ) {
        return service.save(dayDto);
    }

    @GetMapping
    public List<DayDto> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Integer id
    ) {
        service.delete(id);
    }
}
