package ru.netology.planner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

    Todos todos = new Todos();


    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
     * Метод, проверяющий подходит ли эта задача поисковому запросу.
     * Эта логика должна быть определена в наследниках, у каждого она будет своя
     *
     * @param query Поисковый запрос
     * @return Ответ на вопрос, подходит ли эта задача под поисковый запрос
     */
    public boolean matches(String query) {
        return false;
    }


    @Test
    public void searchFewTasksTest() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOneTaskTest() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Банк");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notSearchTaskTest() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Звонок");
        Assertions.assertArrayEquals(expected, actual);
    }
}