package com.todo;

public class Task {
    private String description;
    private boolean isCompleted;

    // Constructor
    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    // Getters/Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // Mark task as completed
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Display task details
    @Override
    public String toString() {
        return description + "Status: " + (isCompleted ? "Completed" : "Pending");
    }
}