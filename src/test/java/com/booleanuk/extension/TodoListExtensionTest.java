package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodoListExtensionTest {

    List<Task> tasks = null;

    @Test
    public void searchTaskByIdTaskNotExistsReturnsMessage() {
        tasks = new ArrayList<>();

        TodoListExtension tl = new TodoListExtension(tasks);

        Assertions.assertEquals("No task found", tl.searchTaskById(1));
    }

    @Test
    public void searchTaskByIdExistsReturnsTaskName() {
        tasks = new ArrayList<>();
        LocalDateTime taskDate = LocalDateTime.now();
        tasks.add(new Task(1, "Eat", false, taskDate));

        TodoListExtension tl = new TodoListExtension(tasks);

        Assertions.assertEquals("Eat", tl.searchTaskById(1));
    }

    @Test
    public void updateTaskNameByIdTaskNotExist() {
        tasks = new ArrayList<>();

        TodoListExtension tl = new TodoListExtension(tasks);

        Assertions.assertEquals(false, tl.updateTaskNameById(1, "New name"));
    }

    @Test
    public void updateTaskNameByIdTaskExists() {
        tasks = new ArrayList<>();
        LocalDateTime taskDate = LocalDateTime.now();
        Task t = new Task(1, "Eat", false, taskDate);
        tasks.add(t);

        TodoListExtension tl = new TodoListExtension(tasks);

        Assertions.assertEquals(true, tl.updateTaskNameById(1, "New name"));
        Assertions.assertEquals("New name", t.getName());
    }

    @Test
    public void changeTaskCompletionStatusTaskNotExist() {
        tasks = new ArrayList<>();

        TodoListExtension tl = new TodoListExtension(tasks);

        Assertions.assertEquals(false, tl.changeTaskStatusById(1));
    }

    @Test
    public void changeTaskCompletionStatusTaskExists() {
        tasks = new ArrayList<>();
        LocalDateTime taskDate = LocalDateTime.now();
        Task t = new Task(1, "Eat", false, taskDate);
        tasks.add(t);

        TodoListExtension tl = new TodoListExtension(tasks);

        Assertions.assertEquals(true, tl.changeTaskStatusById(1));
        Assertions.assertTrue(t.isCompleted());
        Assertions.assertEquals(true, tl.changeTaskStatusById(1));
        Assertions.assertFalse(t.isCompleted());
    }

    @Test
    public void getDateAndTimeByIdTaskNotExistReturnsNull() {
        tasks = new ArrayList<>();

        TodoListExtension tl = new TodoListExtension(tasks);

        Assertions.assertNull(tl.getTaskCreationDate(1));
    }

    @Test
    public void getDateAndTimeByIdTaskExists() {
        tasks = new ArrayList<>();
        LocalDateTime taskDate = LocalDateTime.now();
        Task t = new Task(1, "Eat", false, taskDate);
        tasks.add(t);

        TodoListExtension tl = new TodoListExtension(tasks);

        Assertions.assertEquals(taskDate, tl.getTaskCreationDate(1));
    }

}
