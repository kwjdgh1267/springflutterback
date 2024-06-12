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
public class ExerciseController {//운동과 관련된 요청을 처리하는 컨트롤러
    private final ExerciseService exerciseService;

    @PostMapping("/exercise")//운동 저장 기능으로 클라이언트에게는 공개되지 않음
    public ResponseEntity<ExerciseDto> saveExercise(@RequestParam(name = "title") String title, @RequestParam(name = "type") String type){
        return exerciseService.saveExercise(title,type);
    }

    @GetMapping("/exercise")//검색 조건이 없다면 모두 조회, 있다면 해당 조건에 운동만 보여주는 기능
    public ResponseEntity<List<ExerciseDto>> showExercise(@RequestParam(name = "type",required = false)String type){
        if(type != null){
            return exerciseService.showExerciseByType(type);
        }else{
            return exerciseService.showAllExercise();
        }
    }

}
