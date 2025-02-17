package com.todo;

public class TaskList {
}
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
