package com.school.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.school.entities.Student;
import com.school.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

//    @PostMapping("/post")
//    public Student createStudent(@RequestBody Student student) {
//        return studentService.addStudent(student);
//    } 
    
    @PostMapping("/post")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.addStudent(student);
        return ResponseEntity.ok(createdStudent);
    }


    @GetMapping("/all")
    public Iterable<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Student getSingleStudent(@PathVariable int id) {
        return studentService.getSingleStudent(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateSingleStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSingleStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
