package com.StudCourReg.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudCourReg.app.models.Student;
import java.util.List;




public interface StudentRepository extends  JpaRepository<Student, Long>{
    List<Student> findByEmail(String email);
}
