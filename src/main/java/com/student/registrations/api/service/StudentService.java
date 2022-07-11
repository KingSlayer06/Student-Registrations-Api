package com.student.registrations.api.service;

import com.student.registrations.api.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();

    public Student findById(int id);

    public void save(Student employee);

    public void deleteById(int id);
}
