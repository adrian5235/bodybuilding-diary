package com.adrian.bodybuildingdiaryapi.day;

import com.adrian.bodybuildingdiaryapi.week.Week;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "days")
public class Day {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private double weight;
    private int kcal;

    @ManyToOne
    @JoinColumn(name = "weekId")
    private Week week;
}
