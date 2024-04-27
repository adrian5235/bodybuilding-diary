package com.adrian.bodybuildingdiaryapi.repository;

import com.adrian.bodybuildingdiaryapi.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day, Integer> {
}
