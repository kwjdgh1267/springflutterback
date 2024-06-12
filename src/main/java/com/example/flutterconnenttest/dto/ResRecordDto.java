package com.example.flutterconnenttest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResRecordDto {
    private Long id;
    private String exercise;

    private String type;

    private double weight;

    private int year;

    private int count;
    private int sets;

    private int month;
    private int date;

}
