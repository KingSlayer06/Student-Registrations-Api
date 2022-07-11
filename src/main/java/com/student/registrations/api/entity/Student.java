package com.student.registrations.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "course")
    private String course;

    @Column(name = "country")
    private String country;

    public Student(String firstName, String lastName, String course, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.country = country;
    }
}
