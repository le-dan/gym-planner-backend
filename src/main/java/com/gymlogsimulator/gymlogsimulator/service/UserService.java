package com.gymlogsimulator.gymlogsimulator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymlogsimulator.gymlogsimulator.entity.Exercise;
import com.gymlogsimulator.gymlogsimulator.entity.User;
import com.gymlogsimulator.gymlogsimulator.entity.Workout;
import com.gymlogsimulator.gymlogsimulator.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    // Add exercise to workout of user
    public String addExerciseToWorkout(String username, String workoutName, Exercise exercise) {
        User user = getUser(username);
        if (user.getWorkout(workoutName) == null) {
            return "Workout not found";
        }
        user.getWorkout(workoutName).getExercises().add(exercise);
        repository.save(user);
        return "Added " + exercise.getExerciseName() + " to workout: " + workoutName + " of user: " + username;
    }

    // Add list of exercises of workout to user
    public String addExerciseToWorkout(String username, String workoutName, List<Exercise> exercises) {
        User user = getUser(username);
        if (user.getWorkout(workoutName) == null) {
            return "Workout not found";
        }
        user.getWorkout(workoutName).getExercises().addAll(exercises);
        repository.save(user);
        return "Added " + exercises.size() + " exercises to workout: " + workoutName + " of user: " + username;
    }

    // Add workout to user
    public String addWorkout(String username, Workout newWorkout) {
        User user = getUser(username);
        user.getWorkouts().add(newWorkout);
        repository.save(user);
        return "Added " + newWorkout.getWorkoutName() + " to user: " + username;
    }

    // Get exercise from workout of user
    public Exercise getExerciseFromWorkout(String username, String workoutName, String exerciseName) {
        User user = getUser(username);
        if (user.getWorkout(workoutName) == null) {
            return null;
        }
        for (Exercise exercise : user.getWorkout(workoutName).getExercises()) {
            if (exercise.getExerciseName().equals(exerciseName)) {
                return exercise;
            }
        }
        return null;
    }

    // Get list of exercises based on workout from user
    public List<Exercise> getExercisesFromWorkout(String username, String workoutName) {
        User user = getUser(username);
        if (user.getWorkout(workoutName) == null) {
            return null;
        }
        return user.getWorkout(workoutName).getExercises();
    }

    // Get workout based on name from user
    public Workout getWorkout(String username, String workoutName) {
        User user = getUser(username);
        if (user.getWorkout(workoutName) == null) {
            return null;
        }
        return user.getWorkout(workoutName);
    }

    // Get list of workouts based on user
    public List<Workout> getWorkouts(String username) {
        User user = getUser(username);
        if (user == null) {
            return null;
        }
        return user.getWorkouts();
    }

    // Gets user
    public User getUser(String username) {
        return repository.findByUsername(username);
    }

    // Remove workout from user
    public String removeWorkout(String username, String workoutName) {
        User user = getUser(username);
        if (user.getWorkout(workoutName) == null) {
            return "Workout not found";
        }
        user.getWorkouts().remove(user.getWorkout(workoutName));
        repository.save(user);
        return "Removed " + workoutName + " from user: " + username;
    }

    // Remove exercise from workout of user
    public String removeExerciseFromWorkout(String username, String workoutName, String exerciseName) {
        User user = getUser(username);
        if (user.getWorkout(workoutName) == null) {
            return "Workout not found";
        }
        if (user.getWorkout(workoutName).getExercise(exerciseName) == null) {
            return "Exercise not found";
        }
        user.getWorkout(workoutName).getExercises().remove(user.getWorkout(workoutName).getExercise(exerciseName));
        repository.save(user);
        return "Removed " + exerciseName + " from workout: " + workoutName + " of user: " + username;
    }
}
