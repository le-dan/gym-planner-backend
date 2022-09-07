package com.gymlogsimulator.gymlogsimulator.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Exercise")
public class Exercise {
    // username for individual
    private String userID;

    private String workout;
    private String exercise;
    private int repetitions;
    private int sets;
}
