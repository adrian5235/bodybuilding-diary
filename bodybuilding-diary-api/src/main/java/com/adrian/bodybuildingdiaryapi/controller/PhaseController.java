package com.adrian.bodybuildingdiaryapi.controller;

import com.adrian.bodybuildingdiaryapi.dto.PhaseDto;
import com.adrian.bodybuildingdiaryapi.model.Phase;
import com.adrian.bodybuildingdiaryapi.service.PhaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/phases")
public class PhaseController {

    private final PhaseService service;

    @PostMapping
    public Phase save(@RequestBody Phase phase) {
        return service.save(phase);
    }

    @GetMapping
    public List<PhaseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PhaseDto get(@PathVariable Integer id) {
        return service.get(id);
    }
}
