package com.benmalek.springBootApp;

import com.benmalek.springBootApp.Model.Grade;
import com.benmalek.springBootApp.Model.Student;
import com.benmalek.springBootApp.Repository.GradeRepository;
import com.benmalek.springBootApp.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringBootAppApplication implements CommandLineRunner {

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  GradeRepository gradeRepository;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootAppApplication.class, args);
  }

  @Override
  public void run(String... agrs) throws Exception {
    Student student = new Student();
    student.getId();
    Student[] studentList = new Student[]{
      new Student("Harry", LocalDate.parse("1989-12-12")),
      new Student("Ameni", LocalDate.parse("1995-05-12")),
      new Student("Uber", LocalDate.parse("1989-12-12")),
      new Student("Quentin", LocalDate.parse("1999-02-19"))
    };

    for (Student student1 : studentList) {
      studentRepository.save(student1);
    }

    Grade grade = new Grade(1L, "A+", studentList[0]);
    gradeRepository.save(grade);

  }

}
