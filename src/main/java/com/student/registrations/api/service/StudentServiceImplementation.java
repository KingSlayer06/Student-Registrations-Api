package com.student.registrations.api.service;

import com.student.registrations.api.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentServiceImplementation implements StudentService {

    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public StudentServiceImplementation(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
    }

    @Transactional
    public List<Student> findAll() {
        Transaction transaction = session.beginTransaction();
        List<Student> students = session.createQuery("from Student ").list();
        transaction.commit();
        return students;
    }

    @Transactional
    public Student findById(int id) {
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        transaction.commit();
        return student;
    }

    @Transactional
    public void save(Student student) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(student);
        System.out.println("Added New Customer to Database: " + student);
        transaction.commit();
    }

    @Transactional
    public void deleteById(int id) {
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        System.out.println("Deleted Customer from Database: " + student);
        transaction.commit();
    }
}
