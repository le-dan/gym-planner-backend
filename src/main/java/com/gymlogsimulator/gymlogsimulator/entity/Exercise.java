package com.gymlogsimulator.gymlogsimulator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "workout_table")
public class Exercise {

    @Id
    @GeneratedValue
    private int id;

    private String workout;
    private String exercise;
    private int repetitions;
    private int sets;
}
