package com.benmalek.springBootApp.Service;


import com.benmalek.springBootApp.Model.Grade;
import com.benmalek.springBootApp.Model.Student;
import com.benmalek.springBootApp.Repository.GradeRepository;
import com.benmalek.springBootApp.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {


  /**
   * We can use Autowired to inject dependencies or inject it with ctor
   */
  /*@Autowired*/
  private GradeRepository gradeRepository;

  /*@Autowired*/
  private StudentRepository studentRepository;

  @Override
  public Grade getGrade(Long studentId, Long courseId) {
    return gradeRepository.findByStudentId(studentId);
  }

  @Override
  public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
    Student student = studentRepository.findById(studentId).isPresent() ? studentRepository.findById(studentId).get() : null;
    grade.setStudent(student);
    return gradeRepository.save(grade);
  }

  @Override
  public Grade updateGrade(String score, Long studentId, Long courseId) {
    return null;
  }

  @Override
  public void deleteGrade(Long studentId, Long courseId) {

  }

  @Override
  public List<Grade> getStudentGrades(Long studentId) {
    return null;
  }

  @Override
  public List<Grade> getCourseGrades(Long courseId) {
    return null;
  }

  @Override
  public List<Grade> getAllGrades() {
    return null;
  }
}
