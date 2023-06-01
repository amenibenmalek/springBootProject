package com.benmalek.springBootApp.Service;

import com.benmalek.springBootApp.Model.Course;
import com.benmalek.springBootApp.Repository.CourseRespository;
import com.benmalek.springBootApp.exception.CourseNotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

  CourseRespository courseRespository;

  @Override
  public Course getCourse(Long id) {
    try {
      return courseRespository.findById(id).isPresent() ? courseRespository.findById(id).get() : null;
    } catch (CourseNotFoundException e) {
      throw new CourseNotFoundException(id.toString());
    }
  }

  @Override
  public Course saveCourse(Course course) {
    return courseRespository.save(course);
  }

  @Override
  public void deleteCourse(Long id) {
    if (getCourse(id) != null) {
      courseRespository.deleteById(id);
    } else {
      throw new CourseNotFoundException(id.toString());
    }
  }

  @Override
  public List<Course> getCourses() {
    return (List<Course>) courseRespository.findAll();
  }
}
