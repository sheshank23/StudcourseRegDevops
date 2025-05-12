package com.StudCourReg.app.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.StudCourReg.app.Service.StudentService;
import com.StudCourReg.app.models.Student;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudentWithEnrollments(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Student>> getStudent() {
        List<Student> students= studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("getByEmail/{email}")
    public ResponseEntity<List<Student>> getStudentByEmail(@PathVariable String email) {
        List<Student> student = studentService.findByEmail(email);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudentMajor(@PathVariable Long id, @RequestParam String major) {
        Student updated = studentService.updateMajor(id, major);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student record deleted",HttpStatus.OK);
    }
    
}

