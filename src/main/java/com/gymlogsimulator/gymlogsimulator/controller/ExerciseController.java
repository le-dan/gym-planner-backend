package com.gymlogsimulator.gymlogsimulator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gymlogsimulator.gymlogsimulator.entity.Exercise;
import com.gymlogsimulator.gymlogsimulator.repository.ExerciseRepository;
import com.gymlogsimulator.gymlogsimulator.service.ExerciseService;

@RestController
public class ExerciseController {
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    ExerciseService exerciseService;

    // Add exercise (using JSON put)
    @PostMapping("/addExercise")
    public Exercise addExercise(@RequestBody Exercise exercise) {
        return exerciseService.createExercise(exercise);
    }

    // Add exercises (using JSON put)
    @PostMapping("/addExercises")
    public List<Exercise> addExercises(@RequestBody List<Exercise> exercises) {
        return exerciseService.createExercises(exercises);
    }

    // Gets all of the exercises, ex: localhost:8080/exercises
    @GetMapping("/exercises")
    public List<Exercise> getExercises() {
        return exerciseService.getExercises();
    }

    // Get exercise by name, ex: localhost:8080/exercises/[pushups]
    @GetMapping("/exercises/{exercise}")
    public ResponseEntity<Exercise> getExerciseByName(@PathVariable String exercise) {
        return new ResponseEntity<Exercise>(exerciseRepository.findByExercise(exercise), HttpStatus.OK);
    }

    // Gets list of exercises based from workout
    // localhost:8080/workouts/[push]
    @GetMapping("/workouts/{name}")
    public ResponseEntity<List<Exercise>> getExercisesByWorkout(@PathVariable String name) {
        return new ResponseEntity<List<Exercise>>(exerciseRepository.findByWorkout(name), HttpStatus.OK);
    }

    @PutMapping("/updateExercise")
    public Exercise updateExercise(@RequestBody Exercise exercise) {
        return exerciseService.updateExercise(exercise);
    }
}
