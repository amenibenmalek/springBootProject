package com.benmalek.springBootApp.Repository;

import com.benmalek.springBootApp.Model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRespository extends CrudRepository<Course, Long> {
}
