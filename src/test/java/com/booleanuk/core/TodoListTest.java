package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TodoListTest {

    Map<String, Boolean> tasks = null;

    /*
    addTask(String taskName)
     */
    @Test
    public void addTaskNotAlreadyInTaskListShouldReturnTrue() {
        this.tasks = new HashMap<>();

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(true, tl.addTask("Eat"));
        Assertions.assertEquals(true, tl.addTask("Work out"));
        Assertions.assertEquals(true, tl.addTask("Do some programming"));
    }

    @Test
    public void addTaskAlreadyInTaskListShouldReturnFalse() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", false);
        tasks.put("Work out", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(false, tl.addTask("Eat"));
        Assertions.assertEquals(false, tl.addTask("eat"));
        Assertions.assertEquals(false, tl.addTask("Work out"));
        Assertions.assertEquals(false, tl.addTask("work out"));
    }

    @Test
    public void addTaskInvalidNameShouldReturnNull() {
        this.tasks = new HashMap<>();

        TodoList tl = new TodoList(tasks);

        Assertions.assertNull(tl.addTask(" "));
        Assertions.assertNull(tl.addTask("    "));
        Assertions.assertNull(tl.addTask(""));
    }

    /*
    getTasks()
     */
    @Test
    public void getTasksTaskMapNotEmpty() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", false);
        tasks.put("Work out", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(List.of("Eat", "Work out"), tl.getTasks());
    }

    @Test
    public void getTasksWhenMapIsEmpty() {
        this.tasks = new HashMap<>();

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(List.of(), tl.getTasks());
    }

    /*
    getCompletedTasks()
     */
    @Test
    public void getCompletedTasksWhenCompletedTasksExist() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", true);
        tasks.put("Work out", true);
        tasks.put("Do some programming", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(List.of("Eat", "Work out"), tl.getCompletedTasks());
    }

    @Test
    public void getCompletedTasksWhenCompletedTasksDontExist() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", false);
        tasks.put("Work out", false);
        tasks.put("Do some programming", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(List.of(), tl.getCompletedTasks());
    }

    /*
    getIncompleteTasks
     */
    @Test
    public void getIncompleteTasksWhenCompletedTasksExist() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", true);
        tasks.put("Work out", true);
        tasks.put("Do some programming", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(List.of("Do some programming"), tl.getIncompleteTasks());
    }

    @Test
    public void getIncompleteTasksWhenCompletedTasksDontExist() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", false);
        tasks.put("Work out", false);
        tasks.put("Do some programming", true);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(List.of("Eat", "Work out"), tl.getIncompleteTasks());
    }

    /*
    changeTaskStatus(String taskName)
     */
    @Test
    public void changeTaskStatusWhenTaskExistsAndIsIncomplete() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(true, tl.changeTaskStatus("Eat"));
        Assertions.assertEquals(true, tasks.get("Eat"));
        Assertions.assertEquals(true, tl.changeTaskStatus("eat"));
        Assertions.assertEquals(false, tasks.get("Eat"));
    }

    @Test
    public void changeTaskStatusWhenTaskExistsAndIsCompleted() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", true);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(true, tl.changeTaskStatus("Eat"));
        Assertions.assertEquals(false, tasks.get("Eat"));
        Assertions.assertEquals(true, tl.changeTaskStatus("eat"));
        Assertions.assertEquals(true, tasks.get("Eat"));
    }

    @Test
    public void changeTaskStatusWhenTasksDoesNotExist() {
        this.tasks = new HashMap<>();

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(false, tl.changeTaskStatus("Eat"));
        Assertions.assertEquals(false, tl.changeTaskStatus("work out"));
    }

    /*
    searchTask(String searchString)
     */
    @Test
    public void searchTaskResultFound() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", false);
        tasks.put("Work out", false);
        tasks.put("Do some programming today", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(List.of("Eat", "Work out", "Do some programming"), tl.searchTask("t"));
        Assertions.assertEquals(List.of("Work out", "Do some programming"), tl.searchTask("o"));
        Assertions.assertEquals(List.of("Eat"), tl.searchTask("eat"));
    }

    @Test
    public void searchTaskResultNotFound() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", false);
        tasks.put("Work out", false);
        tasks.put("Do some programming today", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(List.of(), tl.searchTask("z"));
        Assertions.assertEquals(List.of(), tl.searchTask("zx"));
        Assertions.assertEquals(List.of(), tl.searchTask(":123!"));
    }

    /*
    removeTask(String taskName)
     */
    @Test
    public void removeTaskThatExists() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", false);
        tasks.put("Work out", false);
        tasks.put("Do some programming today", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(true, tl.removeTask("Eat"));
        Assertions.assertEquals(true, tl.removeTask("work out"));
        Assertions.assertEquals(true, tl.removeTask("Do some programming Today"));
    }

    @Test
    public void removeTaskThatDoesNotExist() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(false, tl.removeTask("work out"));
        Assertions.assertEquals(false, tl.removeTask("Do some programming Today"));
    }

    /*
    getAllTasksOrdered(boolean descending)
     */
    @Test
    public void getAllTasksOrderedWhenNoTasksExist() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", false);
        tasks.put("Work out", false);
        tasks.put("Do some programming today", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(List.of(), tl.getAllTasksOrdered(false));
        Assertions.assertEquals(List.of(), tl.getAllTasksOrdered(true));
    }

    @Test
    public void getAllTasksOrderedAscending() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", false);
        tasks.put("Work out", false);
        tasks.put("Do some programming today", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(List.of("Do some programming today", "Eat", "Work out"), tl.getAllTasksOrdered(false));
    }

    @Test
    public void getAllTasksOrderedDescending() {
        this.tasks = new HashMap<>();
        tasks.put("Eat", false);
        tasks.put("Work out", false);
        tasks.put("Do some programming today", false);

        TodoList tl = new TodoList(tasks);

        Assertions.assertEquals(List.of("Work out", "Eat", "Do some programming today"), tl.getAllTasksOrdered(true));
    }
}
