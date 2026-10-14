package org.example;

import lombok.*;

@Getter
@Setter
@ToString
public class Task {

    private final int id;
    private String title;
    private String description;
    private boolean isCompleted;


    public Task(int id, String title, String description, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }


}
