package com.gymlogsimulator.gymlogsimulator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gymlogsimulator.gymlogsimulator.entity.Exercise;
import com.gymlogsimulator.gymlogsimulator.entity.User;
import com.gymlogsimulator.gymlogsimulator.entity.Workout;
import com.gymlogsimulator.gymlogsimulator.repository.UserRepository;
import com.gymlogsimulator.gymlogsimulator.service.UserService;

@CrossOrigin(origins = "*")
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
     * "workouts": [
     * {
     * "name": "push",
     * "exercises": [
     * {
     * "exercise": "bench press",
     * "repetitions": 8,
     * "sets": 3}]
     * },
     * {"name": "pull",
     * "exercises": []}
     * ]
     * }
     */
    @PostMapping("/api/addUser")
    public String createUser(@RequestBody User user) {
        repository.save(user);
        return "Added user: " + user.getUsername();
    }

    // Add workout to {user}
    @PostMapping("/api/users/{user}/addWorkout")
    public String addWorkout(@PathVariable String user, @RequestBody Workout workout) {
        return service.addWorkout(user, workout);
    }

    // Add exercise to workout from {user}
    @PostMapping("/api/users/{username}/workouts/{workout}/addExercise")
    public String addExerciseToWorkout(@PathVariable String username, @PathVariable String workout,
            @RequestBody Exercise exercise) {
        return service.addExerciseToWorkout(username, workout, exercise);
    }

    // Add list of exercises to {workouts} from {user}
    @PostMapping("/api/users/{username}/workouts/{workout}/addExercises")
    public String addExerciseToWorkout(@PathVariable String username, @PathVariable String workout,
            @RequestBody List<Exercise> exercises) {
        return service.addExerciseToWorkout(username, workout, exercises);
    }

    // Get exercise from {workout} from {user}
    @GetMapping("/api/users/{username}/workouts/{workout}/{exercise}")
    public Exercise getExerciseFromWorkout(@PathVariable String username, @PathVariable String workout,
            @PathVariable String exercise) {
        return service.getExerciseFromWorkout(username, workout, exercise);
    }

    // Get list of exercises based on workout from {user}
    @GetMapping("/api/users/{username}/workouts/{workout}/exercises")
    public List<Exercise> getExercisesFromWorkout(@PathVariable String username, @PathVariable String workout) {
        return service.getExercisesFromWorkout(username, workout);
    }

    // Get workout based on {user}
    @GetMapping("/api/users/{username}/workouts/{workout}")
    public Workout getWorkout(@PathVariable String username, @PathVariable String workout) {
        return service.getWorkout(username, workout);
    }

    // Get list of workouts based on {user}
    @GetMapping("/api/users/{username}/workouts")
    public List<Workout> getWorkoutsFromUser(@PathVariable String username) {
        return service.getWorkouts(username);
    }

    // Get all users
    @GetMapping("/api/users")
    public List<User> getUsers() {
        return repository.findAll();
    }

    // Remove workout from {user}
    @DeleteMapping("/api/users/{user}/removeWorkout/{workout}")
    public String removeWorkout(@PathVariable String user, @PathVariable String workout) {
        return service.removeWorkout(user, workout);
    }

    // Remove exercise from {workout} from {user}
    @DeleteMapping("/api/users/{user}/workouts/{workout}/removeExercise/{exercise}")
    public String removeExerciseFromWorkout(@PathVariable String user, @PathVariable String workout,
            @PathVariable String exercise) {
        return service.removeExerciseFromWorkout(user, workout, exercise);
    }
}
