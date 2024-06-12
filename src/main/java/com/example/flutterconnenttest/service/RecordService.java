package com.example.flutterconnenttest.service;

import com.example.flutterconnenttest.dto.ReqRecordDto;
import com.example.flutterconnenttest.dto.ResRecordDto;
import com.example.flutterconnenttest.entity.Exercise;
import com.example.flutterconnenttest.entity.Record;
import com.example.flutterconnenttest.repository.ExerciseRepository;
import com.example.flutterconnenttest.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository recordRepository;
    private final ExerciseRepository exerciseRepository;
    public ResponseEntity<Record> saveRecord(ReqRecordDto dto) {
        Exercise foundExercise = exerciseRepository.findByTitle(dto.getExercise());
        Record savedRecord = recordRepository.save(new Record(foundExercise, dto.getWeight(), dto.getCount(), dto.getSets(), dto.getMonth(), dto.getDate(),dto.getYear()));
        return ResponseEntity.ok().body(savedRecord);
    }

    public ResponseEntity<List<ResRecordDto>> findRecordByYearMonthDate(int year, int month, int date) {
        List<Record> foundRecords = recordRepository.findAllByYearAndMonthAndDate(year, month, date);
        List<ResRecordDto> dtos = foundRecords.stream()
                .map((record)-> new ResRecordDto(record.getId(),record.getExercise().getTitle(), record.getExercise().getType(),
                        record.getWeight(), record.getYear(), record.getCount(),
                        record.getSets(), record.getMonth(), record.getDate() )).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    public ResponseEntity<Record> deleteRecord(Long id) {
        Record found = recordRepository.findById(id).orElseThrow();
        recordRepository.delete(found);
        return ResponseEntity.ok().body(found);
    }
}
