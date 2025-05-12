package com.StudCourReg.app.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.StudCourReg.app.models.EnrollmentRequest;
import com.StudCourReg.app.Service.EnrollmentService;
import com.StudCourReg.app.models.Enrollment;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<Enrollment> enrollStudent(@RequestBody EnrollmentRequest request) {
        Enrollment enrollment = enrollmentService.enrollStudent(request.getStudentId(), request.getCourseId());
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollment);
    }
}

