package com.gymlogsimulator.gymlogsimulator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gymlogsimulator.gymlogsimulator.entity.Exercise;
import com.gymlogsimulator.gymlogsimulator.entity.User;
import com.gymlogsimulator.gymlogsimulator.repository.UserRepository;
import com.gymlogsimulator.gymlogsimulator.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    UserService service;

    /*
     * Create user example:
     * {
     * "username": "test"
     * "exercises": []
     * }
     */
    @PostMapping("/api/addUser")
    public String createUser(@RequestBody User user) {
        repository.save(user);
        return "Added user: " + user.getUsername();
    }

    // Add exercise to {user}
    @PostMapping("/api/users/{username}/addExercise")
    public String addExercise(@PathVariable String username, @RequestBody Exercise exercise) {
        return service.addExercise(username, exercise);

    }

    // Add list of exercises to {user}
    @PostMapping("/api/users/{username}/addExercises")
    public String addExercises(@PathVariable String username, @RequestBody List<Exercise> exercises) {
        return service.addExercises(username, exercises);
    }

    // Get exercise from user
    @GetMapping("/api/users/{username}/exercises/{exercise}")
    public Exercise getExercise(@PathVariable String username, @PathVariable String exercise) {
        return service.getUser(username).getExercises().stream()
                .filter(exerciseFromList -> exerciseFromList.getExercise().equals(exercise)).findFirst().get();
    }

    // Get list of all exercises from {user}
    @GetMapping("/api/users/{username}/exercises")
    public List<Exercise> getExercisesFromUser(@PathVariable String username) {
        return service.getAllExercises(username);
    }

    // Get list of exercises based on workout from {user}
    @GetMapping("/api/users/{username}/workouts/{workout}")
    public List<Exercise> getExercisesFromWorkout(@PathVariable String username, @PathVariable String workout) {
        return service.getExercisesFromWorkout(username, workout);
    }

    // Update exercise from {user}
    @PutMapping("/api/users/{username}/exercises/{exercise}/updateExercise")
    public String updateExercise(@PathVariable String username, @PathVariable String exercise,
            @RequestBody Exercise exerciseFromUser) {
        return service.updateExercise(username, exercise, exerciseFromUser);
    }

    // Remove exercise from {user}
    @DeleteMapping("/api/users/{username}/removeExercise/{exercise}")
    public String removeExerciseFromUser(@PathVariable String username, @PathVariable String exercise) {
        service.deleteExercise(username, exercise);
        return "Removed " + exercise + " from user: " + username;
    }

    // Get all users
    @GetMapping("/api/users")
    public List<User> getUsers() {
        return repository.findAll();
    }
}
