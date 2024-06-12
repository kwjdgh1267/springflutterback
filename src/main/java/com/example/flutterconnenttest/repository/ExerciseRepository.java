package com.example.flutterconnenttest.repository;

import com.example.flutterconnenttest.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise,Long> {
    Exercise findByTitle(String title);
    List<Exercise> findAllByTypeOrTitleContaining(String type,String title);
}
