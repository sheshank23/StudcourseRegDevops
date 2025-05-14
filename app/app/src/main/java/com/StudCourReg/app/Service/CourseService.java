package com.StudCourReg.app.Service;

import java.util.List;

// import java.util.List;

import org.springframework.stereotype.Service;

import com.StudCourReg.app.Repository.CourseRepository;
import com.StudCourReg.app.models.Course;

// import com.StudCourReg.app.Repository.CourseRepository;
// import com.StudCourReg.app.models.Course;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository repo;
    public  List<Course>  getAllCourses() {
        return repo.findAll();
    }

    // private final CourseRepository courseRepository;

    public  List<Course> findByCourseCode(String coursecode) {
    
    return repo.findByCourseCode(coursecode);
    }

     public Course createCourse(Course course) {
        return repo.save(course);
    }

}
