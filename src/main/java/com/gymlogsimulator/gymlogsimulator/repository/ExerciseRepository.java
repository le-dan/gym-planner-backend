package com.gymlogsimulator.gymlogsimulator.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gymlogsimulator.gymlogsimulator.entity.Exercise;

public interface ExerciseRepository extends MongoRepository<Exercise, Integer> {
    // Find list of all exercises given userID
    public List<Exercise> findByUserID(String userID);

    // Find list of all workouts given userID
    public List<Exercise> findByUserIDAndWorkout(String userID, String workout);

    public Exercise findByExercise(String exercise);
}
