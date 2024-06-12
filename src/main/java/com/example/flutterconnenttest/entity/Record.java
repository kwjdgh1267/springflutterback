package com.example.flutterconnenttest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Record {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    @JsonIgnore
    private Exercise exercise;

    private double weight;

    private int year;

    private int count;
    private int sets;

    private int month;
    private int date;

    public Record(Exercise exercise, double weight, int count, int sets, int month, int date,int year) {
        this.exercise = exercise;
        this.weight = weight;
        this.count = count;
        this.sets = sets;
        this.month = month;
        this.date = date;
        this.year= year;
    }
}
