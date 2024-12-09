package ru.netology.planner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);
    Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
    Todos todos = new Todos();

    @Test
    public void matchesInSimpleTaskIfTrueTest() {
        todos.add(simpleTask);
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesInSimpleTaskIfFalseTest() {
        todos.add(simpleTask);
        boolean expected = false;
        boolean actual = simpleTask.matches("Звонок");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesInEpicIfTrueTest() {
        todos.add(epic);
        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesInEpicIfFalseTest() {
        todos.add(epic);
        boolean expected = false;
        boolean actual = epic.matches("молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesInMeetingIfTrueInTopicTest() {
        todos.add(meeting);
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesInMeetingIfTrueInProjectTest() {
        todos.add(meeting);
        boolean expected = true;
        boolean actual = meeting.matches("Банк");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesInMeetingIfFalseTest() {
        todos.add(meeting);
        boolean expected = false;
        boolean actual = meeting.matches("вторник");

        Assertions.assertEquals(expected, actual);
    }
}