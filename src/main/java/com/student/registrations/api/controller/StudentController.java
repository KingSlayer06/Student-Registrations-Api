package com.student.registrations.api.controller;

import com.student.registrations.api.entity.Student;
import com.student.registrations.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/home")
    public String homePage(Model model) {
        getAllStudents(model);
        return "home-page";
    }

    @RequestMapping("/getStudents")
    public void getAllStudents(Model model) {
        List<Student> customers = studentService.findAll();
        model.addAttribute("Students", customers);
    }

    @RequestMapping("/addStudent")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("Student", student);
        return "student-form";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(@RequestParam("id") int id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("Student", student);
        return "student-form";
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") int id) {
        studentService.deleteById(id);
        return "redirect:/students/home";
    }

    @RequestMapping ("/saveStudent")
    public String saveStudent(Model model, @RequestParam("id") int id,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("course") String course,
                               @RequestParam("country") String country) {
        Student student;
        if (id != 0) {
            student = studentService.findById(id);
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setCourse(course);
            student.setCountry(country);
        } else {
            student = new Student(firstName, lastName, course, country);
        }
        studentService.save(student);
        getAllStudents(model);
        return "redirect:/students/home";
    }
}
