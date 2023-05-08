package com.benmalek.springBootApp.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name" , nullable = false)
  private String name;

  @Column(name = "birth_date" , nullable = false)
  private LocalDate birthDate;


}
