package com.StudCourReg.app.Service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.StudCourReg.app.Exception.CourseNotFoundException;
import com.StudCourReg.app.Exception.StudentNotFoundException;
import com.StudCourReg.app.Repository.CourseRepository;
import com.StudCourReg.app.Repository.EnrollmentRepository;
import com.StudCourReg.app.Repository.StudentRepository;
import com.StudCourReg.app.models.Course;
import com.StudCourReg.app.models.Enrollment;
import com.StudCourReg.app.models.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    // Enroll a student in a course
    public Enrollment enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new StudentNotFoundException("Student not found"));

        Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new CourseNotFoundException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.now());

        return enrollmentRepository.save(enrollment);
    }
}

