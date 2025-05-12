package com.StudCourReg.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudCourReg.app.models.Course;
// import java.util.List;



public interface CourseRepository extends  JpaRepository<Course, Long>{

        List<Course> findByCourseCode(String coursecode);

}
