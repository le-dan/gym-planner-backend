package com.gymlogsimulator.gymlogsimulator.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Exercise {
    private String workout;
    private String exercise;
    private int repetitions;
    private int sets;
}
