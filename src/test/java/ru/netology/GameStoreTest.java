package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameStoreTest {


    @Test
    public void shouldAddGame() {       //Проверка создание записи о игре
        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldGetMostPlayer() {  //Проверка записи времени проведенного в игре и его суммирование
        GameStore store = new GameStore();
        store.addPlayTime("Ivan", 5);
        store.addPlayTime("Aleksey", 7);
        store.addPlayTime("Ivan", 5);

        String expected = "Ivan";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);


    }

    // другие ваши тесты
}
