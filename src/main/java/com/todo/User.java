package com.todo;

public class User {
    private String fName;

    private String lName;

    private TaskList toDoList;

    // Constructor
    public User (String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        this.toDoList = new TaskList();
    }

    // Getters/Setters
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    // Add a task
    public void addTask(String description) {
        toDoList.addTask(description);
    }

    // Mark task as completed
    public void markTaskCompleted(String description) {
        if (!toDoList.markTaskCompleted(description)) {
            System.out.println("Task not found: " + description);
        }
    }

    // Print all tasks
    public void printTasks() {
        System.out.println("Task for " + fName + " " + lName + ":");
        toDoList.printTasks();
    }
}
