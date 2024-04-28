package com.example.flutterconnenttest.controller;

import com.example.flutterconnenttest.dto.ExerciseDto;
import com.example.flutterconnenttest.entity.Exercise;
import com.example.flutterconnenttest.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExerciseController {//운동 엔티티에 어디 운동인지 추가해야함
    private final ExerciseService exerciseService;

    @PostMapping("/exercise")
    public ResponseEntity<ExerciseDto> saveExercise(@RequestParam(name = "title") String title){
        return exerciseService.saveExercise(title);
    }

    @GetMapping("/exercise")
    public ResponseEntity<List<ExerciseDto>> showAllExercise(){
        return exerciseService.showAllExercise();
    }

}
