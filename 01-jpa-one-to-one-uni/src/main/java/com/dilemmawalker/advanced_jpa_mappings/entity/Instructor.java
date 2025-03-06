package com.dilemmawalker.advanced_jpa_mappings.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {

    //annotate class as an entity and map to db table

    //define the fields

//    Setup relationship b/w instructor & instructor detail here

    //annotate the fields with db column names

    //create constructors, getter/setter & toString methods

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    //This is one to one uni-directional type
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="instructor_detail_id")
//    private InstructorDetail instructorDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail instructorDetail;


    @Getter
    @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Course> courses;

    public void setCourses(Course tempCourse){
        if(courses == null){
            courses = new ArrayList<>();
        }
        courses.add(tempCourse);
        tempCourse.setInstructor(this);
    }

    public Instructor(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
