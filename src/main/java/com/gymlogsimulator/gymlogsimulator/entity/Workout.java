package com.gymlogsimulator.gymlogsimulator.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Workout {
    private String workoutName;
    private List<Exercise> exercises;

    public Exercise getExercise(String exerciseName) {
        for (Exercise exercise : exercises) {
            if (exercise.getExerciseName().equals(exerciseName)) {
                return exercise;
            }
        }
        return null;
    }
}