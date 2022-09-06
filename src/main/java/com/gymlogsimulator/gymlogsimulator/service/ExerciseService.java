package com.gymlogsimulator.gymlogsimulator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymlogsimulator.gymlogsimulator.entity.Exercise;
import com.gymlogsimulator.gymlogsimulator.repository.ExerciseRepository;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public List<Exercise> createExercises(List<Exercise> exercises) {
        return exerciseRepository.saveAll(exercises);
    }

    public List<Exercise> getExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise updateExercise(Exercise exercise) {
        Exercise oldExercise = null;
        if (exerciseRepository.findById(exercise.getId()).orElse(null) != null) {
            oldExercise = exercise;
            oldExercise.setWorkout(exercise.getWorkout());
            oldExercise.setExercise(exercise.getExercise());
            oldExercise.setRepetitions(exercise.getRepetitions());
            oldExercise.setSets(exercise.getSets());

            exerciseRepository.save(oldExercise);
        } else {
            return new Exercise();
        }
        return oldExercise;
    }
}
