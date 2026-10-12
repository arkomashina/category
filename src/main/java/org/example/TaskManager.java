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

        if (title == null || title.isBlank()) {
            throw new InvalidTaskException("Название задачи не может быть пустым");
        }

        Task task = new Task(nextId, title, description, false);
        tasks.put(task.getId(), task);
        nextId++;
    }

    public void removeTask(int id) {
        findTaskById(id);
        tasks.remove(id);
    }

    public Task findTaskById(int id) throws TaskNotFoundException {
        Task task = tasks.get(id);
        if (task == null) {
            throw new TaskNotFoundException("Задача с id=" + id + " не найдена");
        }
        return task;
    }

    public void completeTask(int id) {
        Task task = tasks.get(id);
        findTaskById(id);
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

    public void addCategory(String title) {
        category.add(title);
    }

    public Set<String> showCategory(Set<String> titles) {
        return category;
    }
}
