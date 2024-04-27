package com.adrian.bodybuildingdiaryapi.model;

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
@Table(name = "phases")
public class Phase {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "phase")
    private List<Week> weeks = new ArrayList<>();
}
