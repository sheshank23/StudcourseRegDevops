package com.StudCourReg.app.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;


import com.StudCourReg.app.Service.CourseService;
// import com.StudCourReg.app.models.Course;
import com.StudCourReg.app.models.Course;


@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("createCourse")
    public ResponseEntity<Course> createStudent(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @GetMapping("getCourses")
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }
    
    //  private final CourseService courseService;
    @GetMapping("getByCourseCode/{coursecode}")
    public List<Course> getMethodName(@PathVariable String coursecode) {
        
        return courseService.findByCourseCode(coursecode);
    }
    
}
