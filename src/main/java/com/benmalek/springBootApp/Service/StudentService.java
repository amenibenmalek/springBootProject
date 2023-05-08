package com.benmalek.springBootApp.Service;

import com.benmalek.springBootApp.Model.Student;

import java.util.List;


public interface StudentService {

  Student getStudent(Long id);

  Student saveStudent(Student student);

  List<Student> getStudents();

  void deleteStudent(Long id);
}
