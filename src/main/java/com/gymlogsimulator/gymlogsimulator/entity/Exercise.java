package com.gymlogsimulator.gymlogsimulator.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Exercise {
    private String exerciseName;
    private int repetitions;
    private int sets;
}
