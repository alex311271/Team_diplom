package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameStoreTest {


    @Test
    public void shouldAddGame() {       //Проверка создания записи о игре в каталоге

        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldGetMostPlayer() {  //Проверка выявление игрока дольше всех игравших в игру

        GameStore store = new GameStore();
        store.addPlayTime("Ivan", 9);
        store.addPlayTime("Aleksey", 7);
        store.addPlayTime("Andrey", 10);


        String expected = "Andrey";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTime() {

        GameStore store = new GameStore();
        store.addPlayTime("Ivan", 5);
        store.addPlayTime("Aleksey", 7);
        store.addPlayTime("Ivan", 5);

        int expected = 17;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotAddGame() {
        GameStore store = new GameStore();

        assertFalse(store.containsGame(null));
    }

    @Test
    public void shouldNotMostPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Ivan", 1);
        store.addPlayTime("Andrey", 1);
        store.addPlayTime("Katrin", 1);

        String expected = null;
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
        // другие ваши тесты
    }

    @Test
    public void ShouldSumPlayedTimeAndGetMostPlayer() {
        GameStore store = new GameStore();

        store.addPlayTime("Ivan", 2);
        store.addPlayTime("Andrey", 5);
        store.addPlayTime("Katrin", 8);
        store.addPlayTime("Ivan", 7);

        String expected = "Ivan";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }
}
