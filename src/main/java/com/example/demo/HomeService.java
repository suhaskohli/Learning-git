package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class HomeService {
    private HomeRepository homeRepository;
    @Autowired
    public HomeService(HomeRepository homeRepository){
        this.homeRepository = homeRepository;
    }
    public List<Student> getStudents(){
        return homeRepository.findAll();
    }
    public void addNewStudent(Student student){
        String s =student.getEmail();
        Optional<Student> student1 = homeRepository.findStudentByEmail(s);
        if(student1.isEmpty()){
            homeRepository.save(student);
        }
        else{
            throw new IllegalStateException("email already exists");
        }
    }

    public void deleteStudentById(int sid) {
        boolean b = homeRepository.existsById(sid);
        if(b==true){
            homeRepository.deleteById(sid);
        }
        else{
            throw new IllegalStateException("student is not present to delete");
        }
    }

    @Transactional
    public void updateStudentById(int sid,String name,String email) {
        Student s = homeRepository.findById(sid);
        if(name!=null && !Objects.equals(s.getName(),name)){
            s.setName(name);
        }
        if(email!=null && !Objects.equals(s.getEmail(),email)){

            Optional<Student> op = homeRepository.findStudentByEmail(email);
            if(op.isPresent()){
                throw new IllegalStateException("email exists");
            }
            else {
                s.setEmail(email);
            }
        }
    }
}
