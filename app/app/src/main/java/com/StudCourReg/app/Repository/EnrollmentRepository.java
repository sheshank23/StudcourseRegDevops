package com.StudCourReg.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudCourReg.app.models.Enrollment;

public interface EnrollmentRepository extends  JpaRepository<Enrollment, Long> {


}
