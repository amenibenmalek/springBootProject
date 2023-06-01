package com.benmalek.springBootApp.Service;

import com.benmalek.springBootApp.Model.Course;

import java.util.List;

public interface CourseService {

  Course getCourse(Long id);

  Course saveCourse(Course course);

  void deleteCourse(Long id);

  List<Course> getCourses();

}
