package com.booleanuk.core;

import java.util.*;

public class TodoList {

    Map<String, Boolean> tasks;

    public TodoList(Map<String, Boolean> tasks) {
        this.tasks = tasks;
    }

    public Boolean addTask(String taskName) {
        taskName = taskName.strip().toLowerCase();
        if (taskName.isBlank()) {
            return null;
        }

        for (String key : tasks.keySet()) {
            if (taskName.equals(key.toLowerCase())) {
                return false;
            }
        }
        tasks.put(taskName, false); // not completed by default
        return true;
    }

    public List<String> getTasks() {
        return new ArrayList<>(tasks.keySet());
    }

    public List<String> getCompletedTasks() {
        List<String> completedTasks = new ArrayList<>();
        for (String key : tasks.keySet()) {
            if (tasks.get(key)) {
                completedTasks.add(key);
            }
        }
        return completedTasks;
    }

    public List<String> getIncompleteTasks() {
        List<String> incompleteTasks = new ArrayList<>();
        for (String key : tasks.keySet()) {
            if (!tasks.get(key)) {
                incompleteTasks.add(key);
            }
        }
        return incompleteTasks;
    }

    public Boolean changeTaskStatus(String taskName) {
        taskName = taskName.strip().toLowerCase();
        if (taskName.isBlank())
            return false;

        for (String key : tasks.keySet()) {
            if (taskName.equals(key.toLowerCase())) {
                tasks.put(key, !tasks.get(key));
                return true;
            }
        }
        return false;
    }

    public List<String> searchTask(String searchString) {
        List<String> searchResults = new ArrayList<>();

        for (String key : tasks.keySet()) {
            if (key.toLowerCase().contains(searchString)) {
                searchResults.add(key);
            }
        }

        if (searchResults.isEmpty()) {
            searchResults.add("No tasks found");
        }

        return searchResults;
    }

    public Boolean removeTask(String taskName) {
        taskName = taskName.strip().toLowerCase();
        if (taskName.isBlank()) {
            return false;
        }

        for (String key : tasks.keySet()) {
            if (taskName.equals(key.toLowerCase())) {
                tasks.remove(key);
                return true;
            }
        }
        return false;
    }

    public List<String> getAllTasksOrdered(boolean descending) {

        List<String> sortedTasks = new ArrayList<>(tasks.keySet());

        if (!descending) {
            return sortedTasks.stream().sorted().toList();
        } else {
            return sortedTasks.stream().sorted().toList().reversed();
        }
    }

}
