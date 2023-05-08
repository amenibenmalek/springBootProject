package com.benmalek.springBootApp.Service;

import com.benmalek.springBootApp.Model.Student;
import com.benmalek.springBootApp.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSeviceImpl implements StudentService {


  @Qualifier("studentRepository")
  @Autowired
  private StudentRepository studentRepository;

  @Override
  public Student getStudent(Long id) {
    return studentRepository.findById(id).orElse(null);
  }

  @Override
  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public List<Student> getStudents() {
    return (List<Student>) studentRepository.findAll();
  }

  @Override
  public void deleteStudent(Long id) {
  studentRepository.deleteById(id);
  }

}
