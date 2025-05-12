package com.StudCourReg.app.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Course {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer id;
        
            private String courseCode;
            private String Credits;
            private String Title;
        
            public Integer getId() {
                return id;
            }
        
            // Add setters and getters for name and email too
            public void setId(Integer id) {
                this.id = id;
            }
        
            public String getCourseCode() {
                return courseCode;
            }
        
            public void setCourseCode(String CourseCode) {
                this.courseCode = CourseCode;
            }
        
            public String getCredits() {
                return Credits;
            }
        
            public void setCredits(String Credits) {
                this.Credits = Credits;
            }
            public String getTitle()
            {
                return Title;
            }
    
            public void setTitle(String Title)
            {
                this.Title=Title;
            }
    
}
