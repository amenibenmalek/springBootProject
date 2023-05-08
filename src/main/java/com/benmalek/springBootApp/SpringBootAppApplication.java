package com.benmalek.springBootApp;

import com.benmalek.springBootApp.Model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {

    Student student = new Student();
    student.getId();
	  SpringApplication.run(SpringBootAppApplication.class, args);

	}

}
