package com.example.flutterconnenttest.repository;
import com.example.flutterconnenttest.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record,Long> {
    List<Record> findAllByYearAndMonthAndDate(int year, int month, int date);

}
