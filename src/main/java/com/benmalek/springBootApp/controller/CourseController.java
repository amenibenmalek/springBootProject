package com.benmalek.springBootApp.controller;


import com.benmalek.springBootApp.Model.Course;
import com.benmalek.springBootApp.Service.CourseService;
import com.benmalek.springBootApp.exception.ContactNotFoundException;
import com.benmalek.springBootApp.exception.CourseNotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {


  //@Autowired
  private CourseService courseService;

  @GetMapping("")
  @ResponseBody
  public ResponseEntity<List<Course>> getCourses() {
    return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
  }

  @Tag(name = "Get Details", description = "Get the details of each entity of type course")
  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Course> getCourse(@PathVariable Long id) {
    try {
      Course course = courseService.getCourse(id);
      return new ResponseEntity<>(course, HttpStatus.OK);
    } catch (CourseNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("")
  @ResponseBody
  public ResponseEntity<Course> addCourse(@Valid @RequestBody Course course) {
    Course newCourse = courseService.saveCourse(course);
    return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
    try {
      courseService.deleteCourse(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (ContactNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
