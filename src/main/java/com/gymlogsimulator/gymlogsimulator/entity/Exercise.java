package com.gymlogsimulator.gymlogsimulator.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Exercise")
public class Exercise {
    @Id
    private int id;

    private String workout;
    private String exercise;
    private int repetitions;
    private int sets;
}
