package com.adrian.bodybuildingdiaryapi.repository;

import com.adrian.bodybuildingdiaryapi.model.Week;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekRepository extends JpaRepository<Week, Integer> {
}
