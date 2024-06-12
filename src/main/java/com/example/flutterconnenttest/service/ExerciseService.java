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

    public ResponseEntity<ExerciseDto> saveExercise(String title,String type) {
        Exercise savedExercise = exerciseRepository.save(new Exercise(title,type));
        ExerciseDto exerciseDto= new ExerciseDto(savedExercise.getId(), savedExercise.getTitle(), savedExercise.getType());
        if(savedExercise==null){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok().body(exerciseDto);
        }
    }
    public ResponseEntity<List<ExerciseDto>> showAllExercise() {
        List<Exercise> exercises = exerciseRepository.findAll();
        List<ExerciseDto> dtos= exercises.stream()
                .map((exercise)->new ExerciseDto(exercise.getId(), exercise.getTitle(), exercise.getType())).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }
    public ResponseEntity<List<ExerciseDto>> showExerciseByType(String type) {
        List<Exercise> exercises = exerciseRepository.findAllByTypeOrTitleContaining(type,type);
        List<ExerciseDto> dtos =exercises.stream()
                .map((exercise)->new ExerciseDto(exercise.getId(), exercise.getTitle(), exercise.getType())).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }
}
