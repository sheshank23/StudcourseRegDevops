package com.StudCourReg.app.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.StudCourReg.app.models.Course;
import com.StudCourReg.app.models.Enrollment;
import com.StudCourReg.app.models.Student;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI studentCourseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student Course Registration API")
                        .description("API for managing students, courses, and enrollments")
                        .version("1.0"))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
                .components(new Components()
                        .addSecuritySchemes("basicAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("basic"))
                        .addSchemas("Student", new Schema<Student>().example(getStudentExample()))
                        .addSchemas("Course", new Schema<Course>().example(getCourseExample()))
                        .addSchemas("Enrollment", new Schema<Enrollment>().example(getEnrollmentExample())));
    }

    private Student getStudentExample() {
        Student s = new Student();
        s.setId(1L);
        s.setName("Alice");
        s.setEmail("alice@example.com");
        return s;
    }

    private Course getCourseExample() {
        Course c = new Course();
        c.setId(101);
        c.setTitle("Math 101");
        return c;
    }

    private Enrollment getEnrollmentExample() {
    Enrollment e = new Enrollment();
    e.setId(1001);
    e.setEnrollmentDate(LocalDate.of(2024, 9, 1));

    Student s = new Student();
    s.setId(1L);
    s.setName("Alice");
    s.setEmail("alice@example.com");

    Course c = new Course();
    c.setId(101);
    c.setTitle("Math 101");

    e.setStudent(s);
    e.setCourse(c);

    return e;
}

}
