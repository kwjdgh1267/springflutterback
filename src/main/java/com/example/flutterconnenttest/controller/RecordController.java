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

    @PostMapping("/record")//운동 계획 등록시 저장하는 역할
    public ResponseEntity<Record> saveRecord(@RequestBody ReqRecordDto dto){
        return recordService.saveRecord(dto);
    }
    @GetMapping("/record")//해당 날짜에 등록된 운동 기록들을 반환
    public ResponseEntity<List<ResRecordDto>> findRecordByYearMonthDate(@RequestParam(name = "year") int year, @RequestParam(name = "month") int month
            , @RequestParam(name = "date") int date){
        return recordService.findRecordByYearMonthDate(year, month,date);
    }

    @DeleteMapping("/record/{id}")//운동 기록 삭제 요청시 실행
    public ResponseEntity<Record> deleteRecord(@PathVariable("id")Long id){
        return recordService.deleteRecord(id);
    }

}
