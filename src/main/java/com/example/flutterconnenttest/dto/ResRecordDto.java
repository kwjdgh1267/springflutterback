package com.example.flutterconnenttest.dto;

import com.example.flutterconnenttest.entity.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResRecordDto {
    private String exercise;

    private double weight;

    private int year;

    private int count;
    private int sets;

    private int month;
    private int date;

}
