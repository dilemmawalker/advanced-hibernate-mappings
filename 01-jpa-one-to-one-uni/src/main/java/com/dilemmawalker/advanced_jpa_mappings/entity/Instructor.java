package com.dilemmawalker.advanced_jpa_mappings.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="instructor")
@Getter
@Setter
@ToString
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail instructorDetail;

    public Instructor(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
