package com.todo;

public class TaskList {
    private class Node {
        Task task;
        Node next;

        // Constructor
        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    // Add task to linked list
    public void addTask(String description) {
        Task newTask = new Task(description);
        Node newNode = new Node(newTask);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Mark task as completed
    public boolean markTaskCompleted(String description) {
        Node current = head;

        while (current != null) {
            if (current.task.getDescription().equals(description)) {
                current.task.markAsCompleted();
                return true;
            }
            current = current.next;
        }
        return false; // if no task with description is found
    }

    // Print all tasks
    public void printTasks() {
        Node current = head;

        if (current == null) {
            System.out.println("There are no tasks in the list");
        } else {
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }
    }
}