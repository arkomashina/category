package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskManager {
    private final Map<Integer, Task> tasks = new HashMap<>();
    private final Set<String> category = new HashSet<>();
    private int nextId = 1;

    public void addTask(String title, String description) {
        Task task = new Task(nextId, title, description, false);
        tasks.put(task.getId(), task);
        nextId++;
    }

    public void deleteTask(Task task) {
        tasks.remove(task.getId());
    }

    public Task findTaskById(Task task) {
        return tasks.get(task.getId());
    }

    public void completeTask(Task task) {
        task.setCompleted(true);
    }

    public Map<Integer, Task> showAllTasks(Map<Integer, Task> tasks) {
        return tasks;
    }

    public Map<Integer, Task> showAllCompletedTasks(Map<Integer, Task> tasks) {
        return tasks.entrySet().stream()
                .filter(x -> x.getValue().isCompleted())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

    }



    //1. Добавить задачу
//2. Удалить задачу
//3. Найти задачу по ID
//4. Завершить задачу
//5. Показать все задачи
//6. Показать выполненные задачи
//7. Добавить категорию
//8. Показать категории
//0. Выход
}
