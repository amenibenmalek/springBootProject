package com.benmalek.springBootApp.controller;

import com.benmalek.springBootApp.Model.Student;
import com.benmalek.springBootApp.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


  @Autowired
  private StudentService studentService;

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudent(@PathVariable Long id){
    return new ResponseEntity<>(studentService.getStudent(id),HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Student> saveStudent(@RequestBody Student student){
    return new ResponseEntity<>(studentService.saveStudent(student),HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
    studentService.deleteStudent(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

 @GetMapping("/all")
  public ResponseEntity<List<Student>> getStudents(){
    return new ResponseEntity<>(studentService.getStudents(),HttpStatus.OK);
  }



}
