package com.example.flutterconnenttest.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ReqRecordDto {
    private String exercise;
    private double weight;
    private int count;
    private int sets;

    private int month;
    private int date;

    private int year;

}
