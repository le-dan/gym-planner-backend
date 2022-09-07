package com.gymlogsimulator.gymlogsimulator.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gymlogsimulator.gymlogsimulator.entity.Exercise;

public interface ExerciseRepository extends MongoRepository<Exercise, Integer> {
    List<Exercise> findByWorkout(String workout);

    Exercise findByExercise(String exercise);
}
