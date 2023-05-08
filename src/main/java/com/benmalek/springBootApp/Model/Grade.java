package com.benmalek.springBootApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "grade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Grade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "score", nullable = false)
  private String score;

  @ManyToOne(optional = false)
  @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
  private Student student;
}
