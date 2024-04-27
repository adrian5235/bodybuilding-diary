package com.adrian.bodybuildingdiaryapi.service;

import com.adrian.bodybuildingdiaryapi.dto.DayDto;
import com.adrian.bodybuildingdiaryapi.mapper.DayMapper;
import com.adrian.bodybuildingdiaryapi.model.Day;
import com.adrian.bodybuildingdiaryapi.model.Phase;
import com.adrian.bodybuildingdiaryapi.model.Week;
import com.adrian.bodybuildingdiaryapi.repository.DayRepository;
import com.adrian.bodybuildingdiaryapi.repository.WeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DayService {

    private final DayRepository repository;
    private final WeekRepository weekRepository;
    private final DayMapper mapper;

    public DayDto save(DayDto dayDto) {
        Day day = mapper.toEntity(dayDto);

        day = repository.save(day);

        // TODO handle exception
        Week week = weekRepository.findById(day.getWeek().getId())
                .orElseThrow();
        updateWeekStats(week);

        return mapper.toDto(day);
    }

    public List<DayDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    private void updateWeekStats(Week week) {
        double averageWeight = 0;
        int averageKcal = 0;
        double weightDifference;
        int maintenance;

        List<Day> days = week.getDays();

        for (Day day : days) {
            averageWeight += day.getWeight();
            averageKcal += day.getKcal();
        }

        averageWeight /= days.size();
        week.setAverageWeight(round(averageWeight, 1));
        averageKcal /= days.size();
        week.setAverageKcal(averageKcal);

        Phase phase = week.getPhase();
        List<Week> weeks = phase.getWeeks();
        int index = weeks.indexOf(week);

        if (index != 0) {
            weightDifference = weeks.get(index - 1).getAverageWeight() - weeks.get(index).getAverageWeight();
            week.setWeightDifference(round(weightDifference, 1));
            maintenance = (int) (week.getAverageKcal() + weightDifference * 7700 / 7);
            week.setCalculatedMaintenance(maintenance);
        }

        weekRepository.save(week);
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void delete(Integer id) {
        // TODO handle exception
        Day day = repository.findById(id)
                .orElseThrow();

        repository.delete(day);

        // TODO handle exception
        Week week = weekRepository.findById(day.getWeek().getId())
                .orElseThrow();
        updateWeekStats(week);
    }
}
