package com.gymlogsimulator.gymlogsimulator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gymlogsimulator.gymlogsimulator.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    // Find by username
    public User findByUsername(String username);

}
