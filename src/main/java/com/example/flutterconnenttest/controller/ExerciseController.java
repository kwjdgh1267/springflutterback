package com.example.flutterconnenttest.controller;

import com.example.flutterconnenttest.dto.ExerciseDto;
import com.example.flutterconnenttest.entity.Exercise;
import com.example.flutterconnenttest.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ExerciseController {//운동 엔티티에 어디 운동인지 추가해야함
    private final ExerciseService exerciseService;

    @PostMapping("/exercise")
    public ResponseEntity<ExerciseDto> saveExercise(@RequestParam(name = "title") String title, @RequestParam(name = "type") String type){
        return exerciseService.saveExercise(title,type);
    }

    @GetMapping("/exercise")
    public ResponseEntity<List<ExerciseDto>> showExercise(@RequestParam(name = "type",required = false)String type){
        if(type != null){
            return exerciseService.showExerciseByType(type);
        }else{
            return exerciseService.showAllExercise();
        }
    }

}
