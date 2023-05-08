package com.benmalek.springBootApp.Repository;

import com.benmalek.springBootApp.Model.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {

  Grade findByStudentId(Long StudentId);
}
