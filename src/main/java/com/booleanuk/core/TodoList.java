package com.booleanuk.core;

import java.util.List;
import java.util.Map;

public class TodoList {

    Map<String, Boolean> tasks;

    public TodoList(Map<String, Boolean> tasks) {
        this.tasks = tasks;
    }

    public Boolean addTask(String taskName) {
        return null;
    }

    public List<String> getTasks() {
        return null;
    }

    public List<String> getCompletedTasks() {
        return null;
    }

    public List<String> getIncompleteTasks() {
        return null;
    }

    public Boolean changeTaskStatus(String taskName) {
        return null;
    }

    public List<String> searchTask(String searchString) {
        return null;
    }

    public Boolean removeTask(String taskName) {
        return null;
    }

    public List<String> getAllTasksOrdered(boolean descending) {
        return null;
    }

}
