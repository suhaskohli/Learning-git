package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/")
public class HomeController {
    private final HomeService hs;
    @Autowired
    public HomeController(HomeService hs){
        this.hs = hs;
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return hs.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        hs.addNewStudent(student);
    }
    @DeleteMapping("{sid}")
    public void deleteStudentById(@PathVariable int sid){
        hs.deleteStudentById(sid);
    }
    @PutMapping("{sid}")
    public void updateStudentById(@PathVariable int sid,@RequestParam(required = false) String name,@RequestParam(required = false) String email){
        hs.updateStudentById(sid,name,email);
    }

}
