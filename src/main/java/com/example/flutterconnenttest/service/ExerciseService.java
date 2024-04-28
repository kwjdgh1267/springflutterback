package com.example.flutterconnenttest.service;

import com.example.flutterconnenttest.dto.ExerciseDto;
import com.example.flutterconnenttest.entity.Exercise;
import com.example.flutterconnenttest.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ResponseEntity<ExerciseDto> saveExercise(String title) {

        Exercise savedExercise = exerciseRepository.save(new Exercise(title));
        ExerciseDto exerciseDto= new ExerciseDto(savedExercise.getId(), savedExercise.getTitle());

        if(savedExercise==null){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok().body(exerciseDto);
        }

    }

    public ResponseEntity<List<ExerciseDto>> showAllExercise() {
        List<Exercise> exercises = exerciseRepository.findAll();
        List<ExerciseDto> dtos= exercises.stream()
                .map((exercise)->new ExerciseDto(exercise.getId(), exercise.getTitle())).collect(Collectors.toList());

        return ResponseEntity.ok().body(dtos);
    }
}
