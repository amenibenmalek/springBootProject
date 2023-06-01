package com.benmalek.springBootApp.controller;

import com.benmalek.springBootApp.Model.Grade;
import com.benmalek.springBootApp.Service.GradeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/grade")
public class GradeController {

  //@Autowired
  GradeService gradeService;

  @Tag(name = "Get Details")
  @GetMapping("/student/{studentId}/course/{courseId}")
  public ResponseEntity<Grade> getGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
    return new ResponseEntity<>(gradeService.getGrade(studentId, courseId), HttpStatus.CREATED);
  }

  @PostMapping("/student/{studentId}/course/{courseId}")
  public ResponseEntity<Grade> addGrade(@RequestBody Grade grade, @PathVariable Long studentId, @PathVariable Long courseId) {
    return new ResponseEntity<>(gradeService.saveGrade(grade, studentId, courseId), HttpStatus.CREATED);
  }


}
