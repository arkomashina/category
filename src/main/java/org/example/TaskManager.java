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
        System.out.println(task);
        return task;
    }

    public void completeTask(int id) {
        Task task = findTaskById(id);
        task.setCompleted(true);
    }

    public void showAllTasks() {
        System.out.println(tasks);
    }

    public void showAllCompletedTasks() {
        System.out.println(tasks.entrySet().stream()
                .filter(x -> x.getValue().isCompleted())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                )));

    }

    public void addCategory(String title) {
        if (title == null ||  title.isBlank()) {
            throw new TaskNotFoundException("Поле titles не может быть пустым");
        }
        category.add(title);
    }

    public void showCategory() {
        System.out.println(Set.copyOf(category));
    }
}
