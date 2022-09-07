package com.gymlogsimulator.gymlogsimulator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Exercise")
public class Exercise {

    @Id
    @GeneratedValue
    private int id;

    private String workout;
    private String exercise;
    private int repetitions;
    private int sets;
}
