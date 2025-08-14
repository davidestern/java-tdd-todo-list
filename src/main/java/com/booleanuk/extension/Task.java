package com.booleanuk.extension;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String name;
    private boolean completed;
    private LocalDateTime creationDate;

    public Task(int id, String name, boolean completed, LocalDateTime creationDate) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completionStatus) {
        this.completed = completionStatus;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
