package com.adrian.bodybuildingdiaryapi.week;

import com.adrian.bodybuildingdiaryapi.day.Day;
import com.adrian.bodybuildingdiaryapi.phase.Phase;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "weeks")
public class Week {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private double averageWeight;
    private int averageKcal;
    private double weightDifference;
    private int calculatedMaintenance;

    @ManyToOne
    @JoinColumn(name = "phaseId")
    private Phase phase;

    @OneToMany(mappedBy = "week")
    private List<Day> days = new ArrayList<>();

    public Week(int id, double averageWeight, int averageKcal, double weightDifference, int calculatedMaintenance, List<Day> days) {
        this.id = id;
        this.averageWeight = averageWeight;
        this.averageKcal = averageKcal;
        this.weightDifference = weightDifference;
        this.calculatedMaintenance = calculatedMaintenance;
        this.days = days;
    }

    public void addDay(Day day) {
        days.add(day);
    }
}
