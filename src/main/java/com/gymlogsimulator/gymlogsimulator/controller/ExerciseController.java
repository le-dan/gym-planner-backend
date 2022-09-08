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
    private ExerciseRepository repository;
    @Autowired
    ExerciseService exerciseService;

    // Add exercise (using JSON put)
    @PostMapping("/api/addExercise")
    public String addExercise(@RequestBody Exercise exercise) {
        repository.save(exercise);
        return "Added exercise: " + exercise.getExercise();
    }

    // Add exercises (using JSON put)
    @PostMapping("/api/addExercises")
    public String addExercises(@RequestBody List<Exercise> exercises) {
        repository.saveAll(exercises);
        String output = "Added these exercises:\n\n";
        for (Exercise exercise : exercises) {
            output += String.format("User: %s | Exercise: %s | Workout: %s | Reps: %d | Sets: %d\n",
                    exercise.getUserID(),
                    exercise.getExercise(), exercise.getWorkout(), exercise.getRepetitions(), exercise.getSets());
        }
        return output;
    }

    // Gets all of the exercises, ex: localhost:8080/api/exercises
    @GetMapping("/api/allExercises")
    public List<Exercise> getExercises() {
        return repository.findAll();
    }

    // Get list of exercises given userID and workout filter
    @GetMapping("api/users/{userID}/workouts/{workout}")
    public ResponseEntity<List<Exercise>> getExerciseByUserIDAndWorkout(@PathVariable String userID,
            @PathVariable String workout) {
        return new ResponseEntity<List<Exercise>>(repository.findByUserIDAndWorkout(userID, workout),
                HttpStatus.OK);
    }

    // Get list of exercises of userID, ex: localhost:8080/api/{userID}/exercises
    @GetMapping("/api/users/{userID}/exercises")
    public ResponseEntity<List<Exercise>> getExercisesByWorkout(@PathVariable String userID) {
        return new ResponseEntity<List<Exercise>>(repository.findByUserID(userID), HttpStatus.OK);
    }

    // Updates exercise
    @PutMapping("api/updateExercise")
    public Exercise updateExercise(@RequestBody Exercise exercise) {
        return exerciseService.updateExercise(exercise);
    }

    // // Deletes exercise
    // @DeleteMapping("/exercises/{exercise}")
    // public String deleteExercise(@PathVariable String exercise) {
    // return exerciseService.deleteExercise(exercise);
    // }
}
