package com.gymlogsimulator.gymlogsimulator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymlogsimulator.gymlogsimulator.entity.Exercise;
import com.gymlogsimulator.gymlogsimulator.entity.User;
import com.gymlogsimulator.gymlogsimulator.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    // Add exercise to user
    public String addExercise(String username, Exercise exercise) {
        User user = getUser(username);
        user.getExercises().add(exercise);
        repository.save(user);
        return "Added " + exercise.getExercise() + " to user: " + username;
    }

    // Add list of exercises to user
    public String addExercises(String username, List<Exercise> exercises) {
        User user = getUser(username);
        String output = "";
        for (Exercise exercise : exercises) {
            user.getExercises().add(exercise);
            output += String.format("Added %s to user: %s\n", exercise.getExercise(), username);
        }
        repository.save(user);
        return output;
    }

    // Get list of all exercises from user
    public List<Exercise> getAllExercises(String username) {
        return getUser(username).getExercises();
    }

    // Get list of exercises based on workout from user
    public List<Exercise> getExercisesFromWorkout(String username, String workout) {
        User user = getUser(username);
        return user.getExercises().stream().filter(exercise -> exercise.getWorkout().equals(workout)).toList();
    }

    // Update exercise from user
    public String updateExercise(String username, String exercise, Exercise exerciseFromUser) {
        User user = getUser(username);
        if (user.getExercises().stream()
                .anyMatch(exerciseFromList -> exerciseFromList.getExercise().equals(exercise))) {
            // remove exercise from stream
            user.getExercises().removeIf(exerciseFromList -> exerciseFromList.getExercise().equals(exercise));
            user.getExercises().add(exerciseFromUser);
            repository.save(user);
            return "Updated exercise: " + exercise + " from user: " + username;
        }
        return "Exercise: " + exercise + " not found in user: " + username;
    }

    // Delete exercise from user
    public void deleteExercise(String username, String exercise) {
        User user = getUser(username);
        user.getExercises().removeIf(exerciseFromList -> exerciseFromList.getExercise().equals(exercise));
        repository.save(user);
    }

    // Gets user
    public User getUser(String username) {
        return repository.findByUsername(username);
    }
}
