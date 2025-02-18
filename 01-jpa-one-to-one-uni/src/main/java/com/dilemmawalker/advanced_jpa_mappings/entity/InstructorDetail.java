package com.dilemmawalker.advanced_jpa_mappings.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="instructor_detail")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDetail {

    //annotate class as an entity and map to db table

    //define the fields

    //annotate the fields with db column names

    //create constructors, getter/setter & toString methods

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="youtube_channel")
    private String youtubeChannel;

    @Column(name="hobby")
    private String hobby;

    public InstructorDetail(String youtubeChannel, String hobby){
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
}
