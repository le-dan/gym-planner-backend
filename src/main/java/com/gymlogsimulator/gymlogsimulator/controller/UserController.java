package com.gymlogsimulator.gymlogsimulator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    // Add exercise to {user}
    @PostMapping("/api/users/{username}/addExercise")
    public String addExercise(@PathVariable String username, @RequestBody Exercise exercise) {
        service.addExercise(username, exercise);
        return "Added " + exercise.getExercise() + " to user: " + username;
    }

    // Get list of all exercises from {user}
    @GetMapping("/api/users/{username}/exercises")
    public List<Exercise> getExercisesByWorkout(@PathVariable String username) {
        return service.getAllExercises(username);
    }

    // Create user
    @PostMapping("/api/addUser")
    public String createUser(@RequestBody User user) {
        repository.save(user);
        return "Added user: " + user.getUsername();
    }

    // Get list of exercises given userID and workout filter
    // @GetMapping("api/users/{userID}/workouts/{workout}")
    // public ResponseEntity<List<Exercise>>
    // getExerciseByUserIDAndWorkout(@PathVariable String userID,
    // @PathVariable String workout) {
    // return new
    // ResponseEntity<List<Exercise>>(repository.findByUsernameAndWorkout(userID,
    // workout),
    // HttpStatus.OK);
    // }

    // // Deletes exercise
    // @DeleteMapping("/exercises/{exercise}")
    // public String deleteExercise(@PathVariable String exercise) {
    // return exerciseService.deleteExercise(exercise);
    // }
}
