package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("First task", "Description");
        taskManager.addTask("Second task", "Description");
        taskManager.showAllTasks();
        taskManager.findTaskById(1);
        taskManager.addCategory("New Category");
        taskManager.showCategory();
        taskManager.completeTask(2);
        taskManager.showAllCompletedTasks();
        taskManager.removeTask(1);
        taskManager.showAllTasks();
    }

}