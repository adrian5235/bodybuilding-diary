package com.adrian.bodybuildingdiaryapi.repository;

import com.adrian.bodybuildingdiaryapi.model.Phase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhaseRepository extends JpaRepository<Phase, Integer> {
}
