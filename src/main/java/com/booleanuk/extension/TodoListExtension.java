package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.util.List;

public class TodoListExtension {

    List<Task> tasks;

    public TodoListExtension(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String searchTaskById(int taskId) {
        return tasks.stream()
                .filter(t -> t.getId() == taskId)
                .findFirst()
                .map(Task::getName)
                .orElse("No task found");
    }

    public Boolean updateTaskNameById(int taskId, String newName) {
        return tasks.stream()
                .filter(t -> t.getId() == taskId)
                .findFirst()
                .map(t -> { t.setName(newName); return true;})
                .orElse(false);
    }

    public Boolean changeTaskStatusById(int taskId) {
        return tasks.stream()
                .filter(t -> t.getId() == taskId)
                .findFirst()
                .map(t -> {t.setCompleted(!t.isCompleted()); return true;})
                .orElse(false);
    }

    public LocalDateTime getTaskCreationDate(int taskId) {
        return tasks.stream()
                .filter(t -> t.getId() == taskId)
                .findFirst()
                .map(Task::getCreationDate)
                .orElse(null);
    }

}
