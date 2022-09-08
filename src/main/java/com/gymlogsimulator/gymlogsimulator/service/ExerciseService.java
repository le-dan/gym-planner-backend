package com.gymlogsimulator.gymlogsimulator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymlogsimulator.gymlogsimulator.entity.Exercise;
import com.gymlogsimulator.gymlogsimulator.repository.ExerciseRepository;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository repository;

    public Exercise updateExercise(Exercise exercise) {
        Exercise oldExercise = null;
        if (repository.findByExercise(exercise.getExercise()) != null) {
            oldExercise = exercise;
            oldExercise.setUserID(exercise.getUserID());
            oldExercise.setWorkout(exercise.getWorkout());
            oldExercise.setExercise(exercise.getExercise());
            oldExercise.setRepetitions(exercise.getRepetitions());
            oldExercise.setSets(exercise.getSets());

            repository.save(oldExercise);
        } else {
            return new Exercise();
        }
        return oldExercise;
    }
}
