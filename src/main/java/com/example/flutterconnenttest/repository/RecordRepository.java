package com.example.flutterconnenttest.repository;
import com.example.flutterconnenttest.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record,Long> {
    //달력에서 선택한 날짜에 해당하는 운동 기록들을 가져옴
    List<Record> findAllByYearAndMonthAndDate(int year, int month, int date);

}
