package com.example.flutterconnenttest.controller;

import com.example.flutterconnenttest.dto.ReqRecordDto;
import com.example.flutterconnenttest.dto.ResRecordDto;
import com.example.flutterconnenttest.entity.Record;
import com.example.flutterconnenttest.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class RecordController {
    private final RecordService recordService;

    @PostMapping("/record")
    public ResponseEntity<Record> saveRecord(@RequestBody ReqRecordDto dto){
        return recordService.saveRecord(dto);
    }
    @GetMapping("/record")
    public ResponseEntity<List<ResRecordDto>> findRecordByYearMonthDate(@RequestParam(name = "year") int year, @RequestParam(name = "month") int month
            , @RequestParam(name = "date") int date){
        return recordService.findRecordByYearMonthDate(year, month,date);
    }

    @DeleteMapping("/record/{id}")
    public ResponseEntity<Record> deleteRecord(@PathVariable("id")Long id){
        return recordService.deleteRecord(id);
    }

}
