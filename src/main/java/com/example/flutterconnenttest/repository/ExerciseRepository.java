package com.example.flutterconnenttest.repository;

import com.example.flutterconnenttest.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise,Long> {
    Exercise findByTitle(String title); //운동 이름으로 검색. 이름중에 특정 키워드가 들어가는 운동들 반환
    List<Exercise> findAllByTypeOrTitleContaining(String type,String title);// 이름이나 어느 부위 운동인지가 검색조건임
}
