package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.util.List;

public class TodoListExtension {

    List<Task> tasks = null;

    public TodoListExtension(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String searchTaskById(int taskId) {
        return null;
    }

    public Boolean updateTaskNameById(int taskId, String newName) {
        return null;
    }

    public Boolean changeTaskStatusById(int taskId) {
        return null;
    }

    public LocalDateTime getTaskCreationDate(int taskId) {
        return null;
    }

}
