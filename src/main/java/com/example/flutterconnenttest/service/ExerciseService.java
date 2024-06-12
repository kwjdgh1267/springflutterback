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
        if(savedExercise==null){//저장이 안됐다면 에러
            return ResponseEntity.badRequest().build();
        }else{//저장이 됐다면 200 반환
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
        List<Exercise> exercises = exerciseRepository.findAllByTypeOrTitleContaining(type,type);//운동 종류나 이름에 특정 키워드가 들어가는것 반환
        List<ExerciseDto> dtos =exercises.stream()
                .map((exercise)->new ExerciseDto(exercise.getId(), exercise.getTitle(), exercise.getType())).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }
}
