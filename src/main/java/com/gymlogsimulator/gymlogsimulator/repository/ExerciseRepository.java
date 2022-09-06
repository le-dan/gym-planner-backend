package com.gymlogsimulator.gymlogsimulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymlogsimulator.gymlogsimulator.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    List<Exercise> findByWorkout(String workout);

    Exercise findByExercise(String exercise);
}
