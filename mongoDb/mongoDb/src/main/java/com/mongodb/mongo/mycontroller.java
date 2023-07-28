package com.mongodb.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class mycontroller {

    @Autowired

    private Control control;

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/newStudent.html")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new student(0, null, null, null, null, 0));
        return "newStudent";
    }

    @PostMapping("/register")
    public String saveStudent(@ModelAttribute student student) {
        control.addstudent(student);
        return "home";
    }

    @GetMapping("/get")
    public ResponseEntity<List<student>> getAllStudents() {
        return control.getstudents();
    }

}
