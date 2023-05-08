package com.benmalek.springBootApp.Repository;


import com.benmalek.springBootApp.Model.Student;
import org.springframework.data.repository.CrudRepository;


/**
 * No need to add @Repository cause spring boot going to create an implementation
 * of this interface
 * and that implementation with exist as a been
 */
public interface StudentRepository extends CrudRepository<Student,Long> {
}
