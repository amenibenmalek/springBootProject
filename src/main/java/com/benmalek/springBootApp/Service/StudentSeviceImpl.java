package com.benmalek.springBootApp.Service;

import com.benmalek.springBootApp.Model.Grade;
import com.benmalek.springBootApp.Model.Student;
import com.benmalek.springBootApp.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentSeviceImpl implements StudentService {


  @Qualifier("studentRepository")
  //@Autowired
  private StudentRepository studentRepository;

  @Override
  public Student getStudent(Long id) {
    printGrades(studentRepository.findById(id).get());
    return studentRepository.findById(id).get();
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

  void printGrades(Student student) {
    for (Grade grade : student.getGradeList()
    ) {
      System.out.println("---------- Score --------- : " + grade.getScore());
    }
  }
}
