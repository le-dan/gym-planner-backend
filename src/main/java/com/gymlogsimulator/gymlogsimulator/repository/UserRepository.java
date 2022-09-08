package com.gymlogsimulator.gymlogsimulator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gymlogsimulator.gymlogsimulator.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    // Find list of all exercises given username
    // public List<Exercise> findByUsername(String username);

    // Find by username
    public User findByUsername(String username);

    // Find list of all workouts given userID
    // public List<Exercise> findByUsernameAndWorkout(String username, String
    // workout);
}
