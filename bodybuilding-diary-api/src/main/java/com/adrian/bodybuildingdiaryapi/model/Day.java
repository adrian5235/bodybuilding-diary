package com.adrian.bodybuildingdiaryapi.model;

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
