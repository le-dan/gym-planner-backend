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
    public void addExercise(String username, Exercise exercise) {
        User user = getUser(username);
        user.getExercises().add(exercise);
        repository.save(user);
    }

    // Get list of all exercises from user
    public List<Exercise> getAllExercises(String username) {
        return getUser(username).getExercises();
    }

    // Gets user
    public User getUser(String username) {
        return repository.findByUsername(username);
    }
}
