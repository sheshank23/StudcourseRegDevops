package com.StudCourReg.app.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.StudCourReg.app.Exception.StudentNotFoundException;
import com.StudCourReg.app.Repository.StudentRepository;
import com.StudCourReg.app.models.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentWithEnrollments(Long studentId) {
        return studentRepository.findById(studentId)
            .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public Student updateMajor(Long studentId, String major) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new StudentNotFoundException("Student not found"));
        student.setMajor(major);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException("Student not found");
        }
        studentRepository.deleteById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}

